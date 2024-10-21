package com.hnk.wallpaper.ui.home.featured

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.FragmentFeaturedBinding
import com.hnk.wallpaper.ui.adapter.pager.BannerPagerAdapter
import com.hnk.wallpaper.ui.adapter.recyclerview.WallpaperAdapter
import com.hnk.wallpaper.ui.base.BaseDownloadFragment
import com.hnk.wallpaper.ui.base.observeWithCatch
import com.hnk.wallpaper.ui.bottomshett.SelectActionBottomSheet
import com.hnk.wallpaper.ui.dialog.NetWorkDialog
import com.hnk.wallpaper.utils.NetworkUtils.isNetworkAvailable
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.getDownloadedFileUri
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.invisible
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class FeaturedFragment : BaseDownloadFragment<FragmentFeaturedBinding, FeaturedVM>() {

    private var mSelectActionBottomSheet: SelectActionBottomSheet? = null
    private var mNetWorkDialog: NetWorkDialog? = null

    private val wallpaperAdapter: WallpaperAdapter by lazy {
        WallpaperAdapter().apply {
            onClickItem = { photoUrl, avgColor ->
                startToDetail(photoUrl, avgColor)
            }
            onLongClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
            onThreeDotsClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
        }
    }

    private val wallpaperFeaturedAdapter: WallpaperAdapter by lazy {
        WallpaperAdapter().apply {
            onClickItem = { photoUrl, avgColor ->
                startToDetail(photoUrl, avgColor)
            }
            onLongClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
            onThreeDotsClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
        }
    }
    private val wallpaperCuratedAdapter: WallpaperAdapter by lazy {
        WallpaperAdapter().apply {
            onClickItem = { photoUrl, avgColor ->
                startToDetail(photoUrl, avgColor)
            }
            onLongClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
            onThreeDotsClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
        }
    }

    private val bannerPagerAdapter: BannerPagerAdapter by lazy {
        BannerPagerAdapter().apply {
            iClickItem = { wallpaper, avgColor ->
                startToDetail(wallpaper, avgColor)
            }
        }
    }

    private fun showDialogNetWork(isConnect: Boolean) {
        childFragmentManager.findFragmentByTag(NetWorkDialog::class.java.simpleName)
            ?.let { fragment ->
                (fragment as? NetWorkDialog)?.dismiss()
                childFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
            }
        if (mNetWorkDialog == null) {
            mNetWorkDialog = NetWorkDialog()
        }
        if (isConnect) {
            if (mNetWorkDialog?.isAdded == true) {
                mNetWorkDialog?.dismiss()
            }
        } else {
            if (!mNetWorkDialog!!.isAdded) {
                mNetWorkDialog?.show(
                    childFragmentManager,
                    NetWorkDialog::class.java.simpleName
                )
            }
        }
    }

    private fun showDialogAction(photoUrl: String, avgColor: String) {
        childFragmentManager.findFragmentByTag(SelectActionBottomSheet::class.java.simpleName)
            ?.let { fragment ->
                (fragment as? SelectActionBottomSheet)?.dismiss()
                childFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
            }

        mSelectActionBottomSheet = SelectActionBottomSheet().apply {
            onClickDownload = { photo, color ->
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

    override fun getViewModel(): Class<FeaturedVM> = FeaturedVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_featured

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        super.onCreatedView(view, savedInstanceState)
        val isConnected = context?.isNetworkAvailable()
        if (isConnected != null) {
            setNetWorkStatus(isConnected)
            if (isConnected){
                initData()
            }
        }
        initView()
    }

    private fun initData() {
        viewModel.getBannerWallpaper()
        viewModel.getCuratedWallpaper()
        viewModel.getPhotoTrending()
        viewModel.getPhotoFeatured()

        viewModel.listBannerLiveData.observeWithCatch(viewLifecycleOwner) { resultState ->
            when (resultState) {
                is ResultState.Loading -> {
                    stopShimmerBanner(false)
                }

                is ResultState.Error -> {
                    stopShimmerBanner(false)
                }

                is ResultState.Success -> {
                    if (resultState.data.isNullOrEmpty()) {
                        stopShimmerBanner(false)
                        bannerPagerAdapter.submitList(emptyList())
                    } else {
                        stopShimmerBanner(true)
                        bannerPagerAdapter.submitList(resultState.data)
                    }
                }
            }
        }

        viewModel.listPhotoTrendingLiveData.observe(viewLifecycleOwner) { resultState ->
            when (resultState) {
                is ResultState.Loading -> {
                    setVisibleTrending(false)
                }

                is ResultState.Error -> {
                    setVisibleTrending(false)
                }

                is ResultState.Success -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        delay(Constant.DELAY_CONTENT)
                        if (resultState.data.isNullOrEmpty()) {
                            setVisibleTrending(false)
                            wallpaperAdapter.submitList(emptyList())
                        } else {
                            setVisibleTrending(true)
                            wallpaperAdapter.submitList(resultState.data)
                        }
                    }
                }
            }
        }

        viewModel.listPhotoFeaturedLiveData.observe(viewLifecycleOwner)
        { resultState ->
            when (resultState) {
                is ResultState.Loading -> {
                    setVisibleFeatured(false)
                }

                is ResultState.Error -> {
                    setVisibleFeatured(false)
                }

                is ResultState.Success -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        delay(Constant.DELAY_CONTENT)
                        if (resultState.data.isNullOrEmpty()) {
                            setVisibleFeatured(false)
                            wallpaperFeaturedAdapter.submitList(emptyList())
                        } else {
                            setVisibleFeatured(true)
                            wallpaperFeaturedAdapter.submitList(resultState.data)
                        }
                    }
                }
            }
        }
        viewModel.listCuratedLiveData.observe(viewLifecycleOwner) { resultState ->
            when (resultState) {
                is ResultState.Loading -> {
                    stopShimmerCurated(false)
                }

                is ResultState.Error -> {
                    stopShimmerCurated(false)
                }

                is ResultState.Success -> {
                    if (resultState.data.isNullOrEmpty()) {
                        setVisibleFeatured(false)
                        setVisibleTrending(false)
                        stopShimmerCurated(false)
                        wallpaperCuratedAdapter.submitList(emptyList())
                    } else {
                        stopShimmerCurated(true)
                        wallpaperCuratedAdapter.submitList(resultState.data)
                    }
                }
            }
        }
    }

    private fun initView() {
        binding.pgFeatured1.adapter = bannerPagerAdapter
        binding.dotsIndicator.attachTo(binding.pgFeatured1)
        binding.rclWallpaper.adapter = wallpaperAdapter
        binding.rclWallpaperFeatured.adapter = wallpaperFeaturedAdapter
        binding.rclWallpaperCurated.adapter = wallpaperCuratedAdapter
        binding.imShowMoreFeatured.setOnSafeClick {
            startToShowMore(Constant.FEATUERS_WALLPAPER, getString(R.string.featured))
        }
        binding.imShowMoreTrending.setOnSafeClick {
            startToShowMore(Constant.TRENDING_WALLPAPER, getString(R.string.trending))
        }
        binding.imShowMoreCurated.setOnSafeClick {
            startToShowMore(Constant.CURATED_WALLPAPER, getString(R.string.curated_wallpaper))
        }
    }

    private fun stopShimmerCurated(isStop: Boolean) {
        if (isStop) {
            binding.shimmerViewWallpaperCurated.stopShimmer()
            binding.shimmerViewWallpaperCurated.gone()
            binding.rclWallpaperCurated.visible()
            binding.imShowMoreCurated.visible()
        } else {
            binding.rclWallpaperCurated.gone()
            binding.imShowMoreCurated.gone()
            binding.shimmerViewWallpaperCurated.startShimmer()
            binding.shimmerViewWallpaperCurated.visible()
        }
    }

    private fun setVisibleFeatured(isShow: Boolean) {
        if (isShow) {
            binding.tvFeatured.visible()
            binding.imShowMoreFeatured.visible()
            binding.rclWallpaperFeatured.visible()
        } else {
            binding.tvFeatured.gone()
            binding.imShowMoreFeatured.gone()
            binding.rclWallpaperFeatured.gone()
        }
    }

    private fun setVisibleTrending(isShow: Boolean) {
        if (isShow) {
            binding.tvTrending.visible()
            binding.imShowMoreTrending.visible()
            binding.rclWallpaper.visible()
        } else {
            binding.tvTrending.gone()
            binding.imShowMoreTrending.gone()
            binding.rclWallpaper.gone()
        }
    }

    private fun stopShimmerBanner(isStop: Boolean) {
        if (isStop) {
            binding.shimmerBanner.stopShimmer()
            binding.shimmerBanner.invisible()
            binding.pgFeatured1.visible()
            binding.dotsIndicator.visible()
        } else {
            binding.pgFeatured1.gone()
            binding.dotsIndicator.gone()
            binding.shimmerBanner.startShimmer()
            binding.shimmerBanner.visible()
        }
    }

    private fun startToShowMore(keyWord: String, tile: String) {
        Bundle().apply {
            putString(Constant.KEY_SHOW_ALL_PHOTO, keyWord)
            putString(Constant.KEY_TITLE_SHOW_MORE, tile)
            navigateFragment(R.id.fragment_show_more, this)
        }
    }

    private fun startToDetail(photoUrl: String, avgColor: String) {
        Bundle().apply {
            putString(Constant.KEY_URL_WALLPAPER, photoUrl)
            putString(Constant.KEY_AVG_COLOR_WALLPAPER, avgColor)
            navigateFragment(R.id.fragment_detail, this)
        }
    }

    private fun setNetWorkStatus(isConnect: Boolean) {
        if (isConnect) {
            initData()
        } else {
            binding.shimmerBanner.startShimmer()
            binding.shimmerBanner.visible()
            binding.shimmerViewWallpaperCurated.startShimmer()
            binding.shimmerViewWallpaperCurated.visible()
            binding.rclWallpaper.gone()
            binding.rclWallpaperCurated.gone()
            binding.rclWallpaperFeatured.gone()
            binding.tvTrending.gone()
            binding.tvFeatured.gone()
            binding.imShowMoreFeatured.gone()
            binding.imShowMoreTrending.gone()
            binding.imShowMoreCurated.gone()
            binding.dotsIndicator.gone()
            binding.pgFeatured1.gone()
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

    override fun handleNetWorkStatus(event: MessageEvent) {
        super.handleNetWorkStatus(event)
        showDialogNetWork(event.booleanValue)
        setNetWorkStatus(event.booleanValue)
    }
}
