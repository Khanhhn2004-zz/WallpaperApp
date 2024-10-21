package com.hnk.wallpaper.ui.favorite

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.databinding.FragmentFavouritesBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.FavoriteAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.bottomshett.SelectActionFavorite
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import timber.log.Timber

class FavouriteFragment : BaseBindingFragment<FragmentFavouritesBinding, FavouriteVM>() {

    private val favoriteAdapter: FavoriteAdapter by lazy {
        FavoriteAdapter().apply {
            iClickItem = { photoUrl, color ->
                startToDetail(photoUrl, color)
            }
            iLongClickItem = { photoUrl, downloadId, photoUri, color ->
                showDialogActionFavourite(photoUrl, downloadId, photoUri, color)
            }
            threeDotsClickItem = { photoUrl, downloadId, photoUri, color ->
                showDialogActionFavourite(photoUrl, downloadId, photoUri, color)
            }
        }
    }

    private var mSelectActionFavorite: SelectActionFavorite? = null

    override fun getViewModel(): Class<FavouriteVM> = FavouriteVM::class.java
    override fun getLayoutId(): Int = R.layout.fragment_favourites

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rclFavorite.adapter = favoriteAdapter
        initData()
    }

    private fun initData() {
        viewModel.getAllFavorite()
        viewModel.favoriteLiveData.observe(viewLifecycleOwner) { resultState ->
            when (resultState) {
                is ResultState.Loading -> {

                }

                is ResultState.Error -> {

                }

                is ResultState.Success -> {
                    val listFavorite = resultState.data
                    if (listFavorite.isEmpty()) {
                        binding.imNoFavorite.visible()
                        binding.tvNoFavorite.visible()
                        favoriteAdapter.submitList(emptyList())
                    } else {
                        binding.imNoFavorite.gone()
                        binding.tvNoFavorite.gone()
                        favoriteAdapter.submitList(listFavorite)
                    }
                }
            }
        }
    }

    private fun showDialogActionFavourite(
        photoUrl: String,
        downloadId: Int,
        photoUri: String,
        avgColor: String
    ) {
        mSelectActionFavorite?.tag?.let { tag ->
            childFragmentManager.findFragmentByTag(tag)?.let { fragment ->
                if (fragment is SelectActionFavorite) {
                    mSelectActionFavorite = fragment
                }
            }
        }
        if (mSelectActionFavorite == null) {
            mSelectActionFavorite = SelectActionFavorite().apply {
                onClickSetFavorite = { downloadId ->
                    viewModel.removeFavorite(downloadId)
                }
                onClickSetWallpaper = { photoUrl, avgColor ->
                    startToDetail(photoUrl, avgColor)
                }
                onClickShareWallpaper = { photoUri ->
                    context?.shareContent(photoUri)
                }
            }
        }
        Bundle().apply {
            putInt(SelectActionFavorite.KEY_ID_DOWNLOAD, downloadId)
            putString(SelectActionFavorite.KEY_PHOTO_URL, photoUrl)
            putString(SelectActionFavorite.KEY_PHOTO_URI, photoUri)
            putString(SelectActionFavorite.KEY_AVG_COLOR, avgColor)
            mSelectActionFavorite!!.arguments = this
            mSelectActionFavorite!!.show(childFragmentManager, mSelectActionFavorite!!.tag)
        }
    }

    private fun startToDetail(url: String, color: String) {
        Bundle().apply {
            putString(Constant.KEY_URL_WALLPAPER, url)
            putString(Constant.KEY_AVG_COLOR_WALLPAPER, color)
            navigateFragment(R.id.fragment_detail, this)
        }
    }
}