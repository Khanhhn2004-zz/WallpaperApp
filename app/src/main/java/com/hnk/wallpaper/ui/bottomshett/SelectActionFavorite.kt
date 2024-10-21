package com.hnk.wallpaper.ui.bottomshett

import android.os.Bundle
import android.view.View
import com.example.myapplication.base.BaseBottomSheetDialogFragment
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.BottomSheetActionFavoriteBinding
import com.hnk.wallpaper.utils.setOnSafeClick

class SelectActionFavorite : BaseBottomSheetDialogFragment<BottomSheetActionFavoriteBinding>() {
    companion object{
        const val KEY_ID_DOWNLOAD = "key_id_download"
        const val KEY_PHOTO_URL = "key_photo_url"
        const val KEY_PHOTO_URI = "key_photo_uri"
        const val KEY_AVG_COLOR = "key_avg_color"
    }

    private var mPhotoUrl: String = ""
    private var mPhotoUri: String = ""
    private var mDownloadId: Int = -1
    private var mAvgColor: String = ""

    var onClickSetFavorite: ((Int) -> Unit) = { _ -> }
    var onClickSetWallpaper: ((String,String) -> Unit) = { _,_ -> }
    var onClickShareWallpaper: ((String) -> Unit) = { _ -> }

    override val layoutId = R.layout.bottom_sheet_action_favorite

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAction()
        initData()
    }

    private fun initData() {
        arguments?.let {
            mPhotoUrl = it.getString(KEY_PHOTO_URL, mPhotoUrl)
            mDownloadId = it.getInt(KEY_ID_DOWNLOAD, mDownloadId)
            mPhotoUri = it.getString(KEY_PHOTO_URI, mPhotoUri)
            mAvgColor = it.getString(KEY_AVG_COLOR, mAvgColor)
        }
    }

    private fun initAction() {
        with(binding) {
            tvSetWallpaper.setOnSafeClick {
                onClickSetWallpaper(mPhotoUrl,mAvgColor)
                dismiss()
            }
            tvDelete.setOnSafeClick {
                onClickSetFavorite(mDownloadId)
                dismiss()
            }
            tvShare.setOnSafeClick {
                onClickShareWallpaper(mPhotoUri)
                dismiss()
            }
        }
    }
}