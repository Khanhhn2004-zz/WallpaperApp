package com.hnk.wallpaper.ui.bottomshett

import android.os.Bundle
import android.view.View
import com.example.myapplication.base.BaseBottomSheetDialogFragment
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.BottomSheetActionItemDownloadBinding
import com.hnk.wallpaper.utils.setOnSafeClick
import timber.log.Timber

class SelectActionItemDownload :
    BaseBottomSheetDialogFragment<BottomSheetActionItemDownloadBinding>() {
    companion object {
        const val KEY_ID_DOWNLOAD = "key_id_download"
        const val KEY_PHOTO_URL = "key_photo_url"
        const val KEY_PHOTO_URI = "key_photo_uri"
        const val KEY_AVG_COLOR = "key_avg_color"
    }

    private var mPhotoUrl: String = ""
    private var mPhotoUri: String = ""
    private var mDownloadId: Int = -1
    private var mAvgColor: String = ""

    var onClickSetWallpaper: ((String, Int, String, String) -> Unit) = { _, _, _, _ -> }
    var onClickDelete: ((Int) -> Unit) = { _ -> }
    var onClickShareWallpaper: ((String) -> Unit) = { _ -> }

    override val layoutId = R.layout.bottom_sheet_action_item_download

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initAction()
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
            tvDelete.setOnSafeClick {
                onClickDelete(mDownloadId)
                dismiss()
            }
            tvSetWallpaper.setOnSafeClick {
                onClickSetWallpaper(mPhotoUrl, mDownloadId, mPhotoUri, mAvgColor)
                dismiss()
            }
            tvShare.setOnSafeClick {
                onClickShareWallpaper(mPhotoUri)
                dismiss()
            }
        }
    }
}
