package com.hnk.wallpaper.ui.home.featured.showmore

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.FragmentShowMoreBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.WallpaperPagingAdapter
import com.hnk.wallpaper.ui.base.BaseDownloadFragment
import com.hnk.wallpaper.ui.base.observeWithCatch
import com.hnk.wallpaper.ui.bottomshett.SelectActionBottomSheet
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.getDownloadedFileUri
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class ShowMoreFragment : BaseDownloadFragment<FragmentShowMoreBinding, ShowMoreVM>() {
    private val wallpaperPagingAdapter: WallpaperPagingAdapter by lazy {
        WallpaperPagingAdapter().apply {
            onClickItem = { photoUrl,avgColor ->
                startToDetail(photoUrl,avgColor)
            }
            onLongClickItem = { photoUrl ,color->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
            onThreeDotsClickItem = { photoUrl ,color->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
        }
    }

    private var mSelectActionBottomSheet: SelectActionBottomSheet? = null

    private fun showDialogAction(photoUrl: String,avgColor: String) {
        Timber.e("khanh  showDialogAction: ")

        childFragmentManager.findFragmentByTag(SelectActionBottomSheet::class.java.simpleName)
            ?.let { fragment ->
                (fragment as? SelectActionBottomSheet)?.dismiss()
                childFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
            }

        mSelectActionBottomSheet = SelectActionBottomSheet().apply {
            onClickDownload = { photo ,color->
                mPhotoUrl = photo
                mAvgColor = color
                mIsDownload = true
                mainViewModel.downloadWallpaper(photo, photo)
            }
            onClickSetWallpaper = { photo, avgColor ->
                startToDetail(photoUrl = photo, avgColor = avgColor)
            }
            onClickShareWallpaper = { photo ->
                context?.shareContent(photo)
            }
        }

        val bundle = Bundle().apply {
            putString(SelectActionBottomSheet.KEY_PHOTO_URL, photoUrl)
            putString(SelectActionBottomSheet.KEY_AVG_COLOR, avgColor)
        }
        mSelectActionBottomSheet!!.arguments = bundle
        mSelectActionBottomSheet!!.show(
            childFragmentManager,
            SelectActionBottomSheet::class.java.simpleName
        )
    }


    override fun getViewModel(): Class<ShowMoreVM> = ShowMoreVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_show_more

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        super.onCreatedView(view, savedInstanceState)
        initData()
        initView()
    }

    private fun initData() {
        binding.rclWallpaper.adapter = wallpaperPagingAdapter
        binding.tvTitle.text = arguments?.getString(Constant.KEY_TITLE_SHOW_MORE)
        when (val keyWord = arguments?.getString(Constant.KEY_SHOW_ALL_PHOTO)) {
            Constant.CURATED_WALLPAPER -> {
                viewModel.getCuratedPhotos()
                viewModel.photos.observe(viewLifecycleOwner) { resultState ->
                    lifecycleScope.launch {
                        when (resultState) {
                            is ResultState.Loading -> {
                                stopShimmer(false)
                            }

                            is ResultState.Error -> {
                                stopShimmer(false)
                            }

                            is ResultState.Success -> {
                                lifecycleScope.launch(Dispatchers.Main) {
                                    delay(Constant.DELAY_CONTENT)
                                    resultState.data?.let {
                                        stopShimmer(true)
                                        wallpaperPagingAdapter.submitData(it)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Constant.TRENDING_WALLPAPER -> {
                viewModel.searchPhotos(keyWord)
                viewModel.searchResults.observe(viewLifecycleOwner) { resultState ->
                    lifecycleScope.launch {
                        when (resultState) {
                            is ResultState.Loading -> {
                                stopShimmer(false)

                            }

                            is ResultState.Error -> {
                                stopShimmer(false)

                            }

                            is ResultState.Success -> {
                                lifecycleScope.launch(Dispatchers.Main) {
                                    delay(Constant.DELAY_CONTENT)
                                    resultState.data?.let {
                                        stopShimmer(true)
                                        wallpaperPagingAdapter.submitData(it)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Constant.FEATUERS_WALLPAPER -> {
                viewModel.searchPhotos(keyWord)
                viewModel.searchResults.observeWithCatch(viewLifecycleOwner) { resultState ->
                    lifecycleScope.launch {
                        when (resultState) {
                            is ResultState.Loading -> {
                                stopShimmer(false)

                            }

                            is ResultState.Error -> {
                                stopShimmer(false)
                            }

                            is ResultState.Success -> {
                                lifecycleScope.launch(Dispatchers.Main) {
                                    delay(Constant.DELAY_CONTENT)
                                    resultState.data?.let {
                                        stopShimmer(true)
                                        wallpaperPagingAdapter.submitData(it)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initView() {
        with(binding) {
            imBack.setOnSafeClick {
                popBackStack()
            }
            imFilter.setOnSafeClick {
                navigateFragment(R.id.fragment_filter)
            }
        }
    }

    private fun stopShimmer(isStop: Boolean) {
        if (isStop) {
            binding.shimmerViewWallpaper.stopShimmer()
            binding.shimmerViewWallpaper.gone()
        } else {
            binding.shimmerViewWallpaper.visible()
            binding.shimmerViewWallpaper.startShimmer()
        }
    }

    private fun startToDetail(photoUrl: String,avgColor: String) {
        Bundle().apply {
            putString(
                Constant.KEY_URL_WALLPAPER, photoUrl
            )
            putString(
                Constant.KEY_AVG_COLOR_WALLPAPER, avgColor
            )
            navigateFragment(R.id.fragment_detail, this)
        }
    }

    override fun handleDownloadComplete(event: MessageEvent) {
        super.handleDownloadComplete(event)
        if (mIsDownload) {
            mPhotoUri = context?.getDownloadedFileUri(event.longValue).toString()
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
}