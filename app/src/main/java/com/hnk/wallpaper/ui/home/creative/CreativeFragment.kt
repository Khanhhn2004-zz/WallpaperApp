package com.hnk.wallpaper.ui.home.creative

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.databinding.FragmentCreativeWallpaperBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.CreativeAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.bottomshett.SelectActionItemCreative
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import com.yalantis.ucrop.UCrop
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File


class CreativeFragment : BaseBindingFragment<FragmentCreativeWallpaperBinding, CreativeVM>() {
    private var resultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                selectedImageUri = result.data?.data ?: return@registerForActivityResult
                startCropWallpaper(selectedImageUri)
            }
        }
    private lateinit var cropResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var selectedImageUri: Uri
    private lateinit var mPhotoUri: String
    private var mAvgColor: String = "#FFFFFF"


    private val creativeAdapter: CreativeAdapter by lazy {
        CreativeAdapter().apply {
            iClickItem = { wallpaper ->
                wallpaper.avgColor?.let { startToDetail(wallpaper.photoUrl, it) }
            }
            iLongClickItem = { photo ->
                mSelectActionBottomSheet.showBottomSheet(photo)
                mSelectActionBottomSheet.show(childFragmentManager, mSelectActionBottomSheet.tag)
            }
            threeDotsClickItem = { photo ->
                mSelectActionBottomSheet.showBottomSheet(photo)
                mSelectActionBottomSheet.show(childFragmentManager, mSelectActionBottomSheet.tag)
            }
        }
    }


    private val mSelectActionBottomSheet: SelectActionItemCreative by lazy {
        SelectActionItemCreative().apply {
            onClickSetWallpaper = { photo ->
                photo.avgColor?.let { startToDetail(photo.photoUrl, it) }
            }
            onClickDelete = { photo ->
                viewModel.deleteCreative(photo.id)
            }
            onClickShareWallpaper = { photo ->
                context?.shareContent(photo.photoUrl)
            }
        }
    }

    override fun getViewModel(): Class<CreativeVM> = CreativeVM::class.java
    override fun getLayoutId(): Int = R.layout.fragment_creative_wallpaper

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        registerCropResult()
        initData()
        initView()
    }

    private fun initData() {
        viewModel.getAllCreative()
        viewModel.creativeLiveData.observe(viewLifecycleOwner) { resultState ->
            lifecycleScope.launch {
                when (resultState) {
                    is ResultState.Loading -> {
                    }

                    is ResultState.Error -> {
                    }

                    is ResultState.Success -> {
                        if (resultState.data.isEmpty()) {
                            binding.imNoCreative.visible()
                            binding.tvNoCreative.visible()
                            creativeAdapter.submitList(emptyList())
                        } else {
                            binding.imNoCreative.gone()
                            binding.tvNoCreative.gone()
                            creativeAdapter.submitList(resultState.data)
                        }
                    }
                }
            }
        }
    }

    private fun initView() {
        binding.rclCreative.adapter = creativeAdapter
        binding.imPickPhoto.setOnSafeClick {
            Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
                resultLauncher.launch(this)
            }
        }
    }

    private fun registerCropResult() {
        cropResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                result.data?.let { intent ->
                    when (result.resultCode) {
                        Activity.RESULT_OK -> {
                            UCrop.getOutput(intent)?.let { resultUri ->
                                viewModel.getAverageColorFromUri(resultUri) { avgColorHex ->
                                    mAvgColor = avgColorHex
                                }
                                mPhotoUri = resultUri.toString()
                                viewModel.addCreative(mPhotoUri, mPhotoUri, mAvgColor)
                                Bundle().apply {
                                    putString(Constant.KEY_URL_WALLPAPER, mPhotoUri)
                                    putString(Constant.KEY_AVG_COLOR_WALLPAPER, mAvgColor)
                                    navigateFragment(R.id.fragment_detail, this)
                                }
                            }
                        }

                        UCrop.REQUEST_CROP -> {
                            UCrop.getOutput(intent)?.let { resultUri ->
                                viewModel.getAverageColorFromUri(resultUri) { avgColorHex ->
                                    mAvgColor = avgColorHex
                                }
                                mPhotoUri = resultUri.toString()
                                viewModel.addCreative(
                                    mPhotoUri,
                                    mPhotoUri,
                                    avgColor = mAvgColor
                                )
                                Bundle().apply {
                                    putString(Constant.KEY_URL_WALLPAPER, mPhotoUri)
                                    putString(Constant.KEY_AVG_COLOR_WALLPAPER, mAvgColor)
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

    private fun startCropWallpaper(uri: Uri) {
        Timber.e("khanh  : $uri")
        val destinationUri = Uri.fromFile(
            File(
                context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "Crop_" + System.currentTimeMillis().toString() + ".png"
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

    private fun startToDetail(urI: String, avgColor: String) {
        Bundle().apply {
            putString(Constant.KEY_URL_WALLPAPER, urI)
            putString(Constant.KEY_AVG_COLOR_WALLPAPER, avgColor)
            navigateFragment(R.id.fragment_detail, this)
        }
    }

}

