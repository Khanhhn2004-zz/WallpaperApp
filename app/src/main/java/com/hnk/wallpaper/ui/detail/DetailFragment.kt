package com.hnk.wallpaper.ui.detail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.FragmentDetailBinding
import com.hnk.wallpaper.ui.base.BaseDownloadFragment
import com.hnk.wallpaper.ui.base.observeWithCatch
import com.hnk.wallpaper.ui.dialog.DialogLoadingSetWallpaper
import com.hnk.wallpaper.ui.dialog.DialogSetWallpaper
import com.hnk.wallpaper.ui.dialog.DialogSetWallpaperScreen
import com.hnk.wallpaper.utils.getDownloadedFileUri
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import com.yalantis.ucrop.UCrop
import timber.log.Timber
import java.io.File

class DetailFragment : BaseDownloadFragment<FragmentDetailBinding, DetailVM>() {

    private lateinit var cropResultLauncher: ActivityResultLauncher<Intent>
    private var mIdDownload: Int = -1
    private var mIsFavorite: Boolean = false

    private val mDialogSetWallpaper: DialogSetWallpaper by lazy {
        DialogSetWallpaper().apply {
            onClickSetWallpaper = {
                if (checkUriFormat(mPhotoUrl!!)) {
                    if (mPhotoUri.isNullOrEmpty()) {
                        mIsDownload = false
                        mPhotoUrl?.let {
                            mainViewModel.downloadWallpaper(it, it)
                        }
                        mShowDialogLoadingSetWallpaper.show(
                            parentFragmentManager,
                            mDialogSetWallpaperScreen.tag
                        )
                    } else {
                        mDialogSetWallpaperScreen.show(
                            parentFragmentManager,
                            mDialogSetWallpaperScreen.tag
                        )
                    }
                } else {
                    mPhotoUri = mPhotoUrl
                    viewModel.addDownload(mPhotoUrl!!, mPhotoUri!!, mAvgColor!!)
                    mDialogSetWallpaperScreen.show(
                        parentFragmentManager,
                        mDialogSetWallpaperScreen.tag
                    )
                }
            }
            onClickCropWallpaper = {
                mPhotoUrl?.let { uri ->
                    startCropWallpaper(Uri.parse(uri))
                }
            }
        }
    }

    private val mDialogSetWallpaperScreen: DialogSetWallpaperScreen by lazy {
        DialogSetWallpaperScreen().apply {
            onClickHomeScreen = { mPhotoUri?.let { viewModel.setWallpaperHomeScreen(it) } }
            onClickLockScreen = { mPhotoUri?.let { viewModel.setWallpaperLockScreen(it) } }
            onClickBoth = { mPhotoUri?.let { viewModel.setWallpaperBoth(it) } }
        }
    }

    private val mShowDialogLoadingSetWallpaper: DialogLoadingSetWallpaper by lazy {
        DialogLoadingSetWallpaper()
    }

    override fun getViewModel() = DetailVM::class.java

    override fun getLayoutId() = R.layout.fragment_detail

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        super.onCreatedView(view, savedInstanceState)
        registerCropResult()
        initData()
        initView()
    }

    private fun initData() {
        arguments?.let { arguments ->
            mAvgColor = arguments.getString(Constant.KEY_AVG_COLOR_WALLPAPER).orEmpty()
            mPhotoUrl = arguments.getString(Constant.KEY_URL_WALLPAPER).orEmpty()
        }
        mAvgColor?.let {
            binding.imWallpaper.setBackgroundColor(android.graphics.Color.parseColor(it))
        }
        mPhotoUrl?.let { photoUrl ->
            viewModel.addRecent(photoUrl, mAvgColor!!)
            Glide.with(this).load(photoUrl).into(binding.imWallpaper)
            viewModel.getIdDownload(photoUrl)
        }
        viewModel.idDownloadAddedLiveData.observeWithCatch(viewLifecycleOwner) { id ->
            mIdDownload = id
            if (mIdDownload > 0) {
                binding.imDownload.gone()
                viewModel.getUriDownload(mIdDownload)
                viewModel.checkIsFavorite(mIdDownload)
                checkFavorite()

            } else {
                binding.imDownload.visible()
            }
        }
        viewModel.uriDownloadLiveData.observe(viewLifecycleOwner) { uri ->
            mPhotoUri = uri
        }
        viewModel.isSuccess.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { isSuccess ->
                if (isSuccess) {
                    showToast(getString(R.string.wallpaper_set_success))
                } else {
                    showToast(getString(R.string.wallpaper_set_failure))
                }
            }
        }
    }

    private fun initView() {
        with(binding) {
            imBack.setOnSafeClick { popBackStack() }
            imDownload.setOnSafeClick {
                mIsDownload = true
                mPhotoUrl?.let {
                    if (checkUriFormat(it)) {
                        viewModel.downloadWallpaper(it, it)
                    } else {
                        showToast(getString(R.string.download_success))
                        viewModel.addDownload(it, it, mAvgColor!!)
                        viewModel.getIdDownload(it)
                    }
                }
            }
            imSetWallpaper.setOnSafeClick {
                mDialogSetWallpaper.show(parentFragmentManager, mDialogSetWallpaperScreen.tag)
            }
            imHeart.setOnClickListener {
                if (mIdDownload > 0) {
                    val photoUrl = mPhotoUrl
                    val photoUri = mPhotoUri
                    if (photoUrl != null && photoUri != null) {
                        viewModel.setFavorite(mIdDownload, photoUrl, photoUri, mAvgColor!!)
                    }
                } else {
                    showToast(getString(R.string.please_download_wallpaper_first))
                }
            }
            imShare.setOnSafeClick {
                if (mIdDownload > 0) {
                    context?.shareContent(mPhotoUrl!!)
                } else {
                    showToast(getString(R.string.please_download_wallpaper_first))
                }
            }

        }
    }

    private fun checkFavorite() {
        viewModel.isFavorite.observe(viewLifecycleOwner) { isFavorite ->
            mIsFavorite = isFavorite
            if (mIsFavorite) {
                binding.imHeart.setImageResource(R.drawable.ic_heart__fill)
            } else {
                binding.imHeart.setImageResource(R.drawable.ic_heart)
            }
        }
    }


    private fun startCropWallpaper(uri: Uri) {
        val destinationUri = Uri.fromFile(
            File(
                context?.cacheDir,
                System.currentTimeMillis().toString() + "IMG_CROPPED.jpg"
            )
        )
        context?.let {
            val intent = UCrop.of(uri, destinationUri)
                .withAspectRatio(9f, 16f)
                .withMaxResultSize(1920, 1080)
                .getIntent(it)
            cropResultLauncher.launch(intent)
        }
    }

    private fun registerCropResult() {
        cropResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                result.data?.let { intent ->
                    when (result.resultCode) {
                        Activity.RESULT_OK -> {
                            UCrop.getOutput(intent)?.let { resultUri ->
                                mPhotoUri = resultUri.toString()
                                mDialogSetWallpaperScreen.show(
                                    parentFragmentManager,
                                    mDialogSetWallpaperScreen.tag
                                )
                            }
                        }

                        UCrop.REQUEST_CROP -> {
                            UCrop.getOutput(intent)?.let { resultUri ->
                                mPhotoUri = resultUri.toString()
                                Bundle().apply {
                                    putString(Constant.KEY_URL_WALLPAPER, mPhotoUri)
                                    navigateFragment(R.id.fragment_detail, this)
                                }
                            }
                        }

                        UCrop.RESULT_ERROR -> {
                            val cropError = UCrop.getError(intent)
                            cropError?.printStackTrace()
                        }
                    }
                }

            }
    }

    override fun handleDownloadComplete(event: MessageEvent) {
        super.handleDownloadComplete(event)
        mPhotoUri = context?.getDownloadedFileUri(event.longValue).toString()
        if (mIsDownload) {
            if (mPhotoUri.isNullOrEmpty()) return
            if (mPhotoUrl.isNullOrEmpty()) return
            viewModel.addDownload(url = mPhotoUrl!!, uri = mPhotoUri!!, avgColor = mAvgColor!!)
            showToast(getString(R.string.download_success))
        } else {
            binding.imDownload.gone()
            viewModel.addDownload(url = mPhotoUrl!!, uri = mPhotoUri!!, avgColor = mAvgColor!!)
            mDialogSetWallpaperScreen.show(
                parentFragmentManager,
                mDialogSetWallpaperScreen.tag
            )
        }
    }

    private fun setStatusNetWork(isConnect: Boolean) {
        if (isConnect) {
            binding.imShare.visible()
            binding.imDownload.visible()
            binding.imSetWallpaper.visible()
            binding.imHeart.visible()
            binding.imWallpaper.visible()
            binding.tvNoDownload.gone()
            binding.imNoDownload.gone()
        } else {
            binding.imShare.gone()
            binding.imDownload.gone()
            binding.imSetWallpaper.gone()
            binding.imHeart.gone()
            binding.imWallpaper.gone()
            binding.tvNoDownload.visible()
            binding.imNoDownload.visible()
        }
    }

    override fun handleDownloadFailed() {
        super.handleDownloadFailed()
        showToast(getString(androidx.media3.exoplayer.R.string.exo_download_failed))
    }

    override fun handleNetWorkStatus(event: MessageEvent) {
        super.handleNetWorkStatus(event)
        setStatusNetWork(event.booleanValue)
    }

    private fun checkUriFormat(uriString: String): Boolean {
        return when {
            uriString.startsWith("https://") -> true
            uriString.startsWith("file://") -> false
            else -> true
        }
    }
}
