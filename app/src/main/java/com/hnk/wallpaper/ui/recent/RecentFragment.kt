package com.hnk.wallpaper.ui.recent

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.data.model.Recent
import com.hnk.wallpaper.databinding.FragmentRecentBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.RecentAdapter
import com.hnk.wallpaper.ui.base.BaseDownloadFragment
import com.hnk.wallpaper.ui.bottomshett.SelectActionBottomSheet
import com.hnk.wallpaper.ui.bottomshett.SelectActionItemDownload
import com.hnk.wallpaper.utils.getDownloadedFileUri
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

class RecentFragment : BaseDownloadFragment<FragmentRecentBinding, RecentVM>() {

    private val recentAdapter: RecentAdapter by lazy {
        RecentAdapter().apply {
            iClickItem = { wallpaper, avgColor ->
                startToDetail(wallpaper, avgColor)
            }
            iLongClickItem = { photo ->
                mPhotoUrl = photo.photoUrl
                showActionBottomSheet(photo)
            }
            threeDotsClickItem = { photo ->
                mPhotoUrl = photo.photoUrl
                showActionBottomSheet(photo)
            }
        }
    }
    private var mSelectActionBottomSheet: SelectActionBottomSheet? = null

    private fun showActionBottomSheet(photo: Recent) {
        mSelectActionBottomSheet?.tag?.let { tag ->
            childFragmentManager.findFragmentByTag(tag)?.let { fragment ->
                if (fragment is SelectActionBottomSheet) {
                    mSelectActionBottomSheet = fragment
                }
            }
        }
        if (mSelectActionBottomSheet == null) {
            mSelectActionBottomSheet = SelectActionBottomSheet().apply {
                onClickDownload = { photo, color ->
                    mIsDownload = true
                    mPhotoUrl?.let {
                        if (checkUriFormat(it)) {
                            mainViewModel.downloadWallpaper(it, it)
                        } else {
                            mainViewModel.addDownload(it, it, color)
                            showToast(getString(R.string.download_success))
                        }
                    }
                }
                onClickSetWallpaper = { photo, avgColor ->
                    startToDetail(photo, avgColor)
                }
                onClickShareWallpaper = { photoUrl ->
                    context?.shareContent(photoUrl)
                }
            }
        }
        Bundle().apply {
            putString(SelectActionBottomSheet.KEY_PHOTO_URL, photo.photoUrl)
            putString(SelectActionBottomSheet.KEY_AVG_COLOR, photo.avgColor)
            mSelectActionBottomSheet!!.arguments = this
            mSelectActionBottomSheet!!.show(childFragmentManager, mSelectActionBottomSheet!!.tag)
        }

    }

    override fun getViewModel() = RecentVM::class.java
    override fun getLayoutId() = R.layout.fragment_recent

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initView()
    }

    private fun initData() {
        viewModel.getAllDownload()
        viewModel.recentLiveData.observe(viewLifecycleOwner) { listRecent ->
            if (listRecent.isNullOrEmpty()) {
                binding.imNoDownload.visible()
                binding.tvNoDownload.visible()
                recentAdapter.submitList(emptyList())
            } else {
                binding.imNoDownload.gone()
                binding.tvNoDownload.gone()
                recentAdapter.submitList(listRecent)
            }
        }
    }

    private fun initView() {
        binding.rclFavorite.adapter = recentAdapter
        binding.imBack.setOnSafeClick {
            popBackStack()
        }
    }

    private fun startToDetail(urI: String, avgColor: String) {
        Bundle().apply {
            putString(Constant.KEY_URL_WALLPAPER, urI)
            putString(Constant.KEY_AVG_COLOR_WALLPAPER, avgColor)
            navigateFragment(R.id.fragment_detail, this)
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun handleDownloadComplete(event: MessageEvent) {
        super.handleDownloadComplete(event)
        if (mIsDownload) {
            mPhotoUri = context?.getDownloadedFileUri(event.longValue).toString()
            Timber.e("khanh  : $mPhotoUri")
            Timber.e("khanh  : $mPhotoUrl")
            mPhotoUrl?.let { url ->
                mPhotoUri?.let { uri ->
                    mAvgColor?.let { color ->
                        mainViewModel.addDownload(url = url, uri = uri, avgColor = color)
                    }
                }
            }
            showToast(getString(R.string.download_success))
        }
    }

    private fun checkUriFormat(uriString: String): Boolean {
        return when {
            uriString.startsWith("https://") -> true
            uriString.startsWith("file://") -> false
            else -> true
        }
    }
}