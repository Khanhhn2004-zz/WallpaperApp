package com.hnk.wallpaper.ui.bottomshett

import android.os.Bundle
import android.view.View
import com.example.myapplication.base.BaseBottomSheetDialogFragment
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.BottomSheetSelectedActionBinding
import com.hnk.wallpaper.utils.setOnSafeClick

class SelectActionBottomSheet : BaseBottomSheetDialogFragment<BottomSheetSelectedActionBinding>() {

    companion object {
        const val KEY_PHOTO_URL = "key_photo_url"
        const val KEY_AVG_COLOR = "key_avg_color"
    }

    private var mPhotoUrl: String = ""
    private var mAvgColor: String = ""

    var onClickSetWallpaper: ((String, String) -> Unit) = { _, _ -> }
    var onClickDownload: ((String,String) -> Unit) = { _ ,_-> }
    var onClickShareWallpaper: ((String) -> Unit) = { _ -> }
    var onClickFavoriteWallpaper: ((String) -> Unit) = { _ -> }

    override val layoutId = R.layout.bottom_sheet_selected_action
    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAction()
        initData()
    }

    private fun initData() {
        arguments?.let {
            mPhotoUrl = it.getString(KEY_PHOTO_URL, mPhotoUrl)
            mAvgColor = it.getString(KEY_AVG_COLOR, mAvgColor)
        }
    }


    private fun initAction() {
        with(binding) {
            tvSetWallpaper.setOnSafeClick {
                onClickSetWallpaper(mPhotoUrl,mAvgColor)
                dismiss()
            }
            tvDownload.setOnSafeClick {
                onClickDownload(mPhotoUrl,mAvgColor)
                dismiss()
            }
            tvFavorite.setOnSafeClick {
                onClickFavoriteWallpaper(mPhotoUrl)
                dismiss()
            }
            tvShare.setOnSafeClick {
                onClickShareWallpaper(mPhotoUrl)
                dismiss()
            }
        }
    }
}
