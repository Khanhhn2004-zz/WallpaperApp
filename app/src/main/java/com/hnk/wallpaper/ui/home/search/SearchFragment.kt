package com.hnk.wallpaper.ui.home.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.FragmentSearchBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.WallpaperPagingAdapter
import com.hnk.wallpaper.ui.base.BaseDownloadFragment
import com.hnk.wallpaper.ui.bottomshett.SelectActionBottomSheet
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.getDownloadedFileUri
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.hideKeyboard
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.showKeyboard
import com.hnk.wallpaper.utils.visible
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchFragment : BaseDownloadFragment<FragmentSearchBinding, SearchVM>() {
    private val wallpaperPagingAdapter: WallpaperPagingAdapter by lazy {
        WallpaperPagingAdapter().apply {
            addLoadStateListener(loadState)
            onClickItem = { photoUrl, avgCpolor ->
                startToDetail(photoUrl, avgCpolor)
            }
            onLongClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)

            }
            onThreeDotsClickItem = { photoUrl, color ->
                showDialogAction(photoUrl = photoUrl, avgColor = color)
            }
        }
    }
    private var mSelectActionBottomSheet: SelectActionBottomSheet? = null

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

    override fun getViewModel(): Class<SearchVM> = SearchVM::class.java
    override fun getLayoutId(): Int = R.layout.fragment_search


    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        super.onCreatedView(view, savedInstanceState)
        initData()
        initView()
    }

    private val loadState: (CombinedLoadStates) -> Unit = { loadState ->
        when (loadState.refresh) {
            is LoadState.NotLoading -> {
            }

            is LoadState.Loading -> {
                showEmptyView(false)
            }

            is LoadState.Error -> {
                showEmptyView(true)
            }
        }
    }

    private fun initView() {
        with(binding) {
            binding.edtSearch.requestFocus() // Focus vào EditText tìm kiếm
            activity?.showKeyboard(binding.edtSearch)
            binding.layout.setOnSafeClick {
                activity?.hideKeyboard()
            }
            binding.rclPhoto.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                        activity?.hideKeyboard()
                    }
                }
            })
            edtSearch.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE || event?.keyCode == KeyEvent.KEYCODE_ENTER) {
                    val text = v.text.toString()
                    if (text.isNotEmpty()) {
                        viewModel.searchPhotos(text)
                    }
                    true
                } else {
                    false
                }
            }
            edtSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s.isNullOrEmpty()) {
                        imGo.gone()
                    } else {
                        imGo.visible()
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
            icCancel.setOnSafeClick {
                activity?.hideKeyboard()
                popBackStack()
            }
            imGo.setOnSafeClick {
                val text = edtSearch.text.toString()
                if (text.isNotEmpty()) {
                    activity?.hideKeyboard()
                    viewModel.searchPhotos(text)
                }
            }
        }
    }

    private fun initData() {
        stopShimmer(true)
        binding.rclPhoto.adapter = wallpaperPagingAdapter
        viewModel.searchResults.observe(viewLifecycleOwner) { resultState ->
            lifecycleScope.launch {
                when (resultState) {
                    is ResultState.Loading -> {
                    }

                    is ResultState.Error -> {
                    }

                    is ResultState.Success -> {
                        resultState.data?.let {
                            stopShimmer(true)
                            wallpaperPagingAdapter.submitData(it)
                            wallpaperPagingAdapter.addLoadStateListener { loadState ->
                                if (loadState.refresh is LoadState.NotLoading) {
                                    if (wallpaperPagingAdapter.itemCount == 0) {
                                        showEmptyView(true)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showEmptyView(isNull: Boolean) {
        if (isNull) {
            binding.imNoResult.visible()
            binding.tvNoResult.visible()
        } else {
            binding.imNoResult.gone()
            binding.tvNoResult.gone()
        }
    }

    private fun stopShimmer(isStop: Boolean) {
        if (isStop) {
            binding.shimmerView.stopShimmer()
            binding.shimmerView.gone()
        } else {
            binding.shimmerView.startShimmer()
            binding.shimmerView.visible()
        }
    }

    private fun startToDetail(photoUrl: String, avgColor: String) {
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