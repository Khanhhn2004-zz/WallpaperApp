package com.hnk.wallpaper.ui.dialog

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.enties.Photo
import com.hnk.wallpaper.databinding.DialogSetWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class DialogSetWallpaper : BaseBindingDialogFragment<DialogSetWallpaperBinding>() {

    var onClickSetWallpaper: (() -> Unit) = { }
    var onClickCropWallpaper: (() -> Unit) = { }

    override val layoutId: Int
        get() = R.layout.dialog_set_wallpaper

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAction()
    }

    private fun initAction() {
        with(binding) {
            tvQuickApply.setOnClickListener {
                onClickSetWallpaper()
                dismiss()
            }
            tvCropWallpaper.setOnClickListener {
                onClickCropWallpaper()
                dismiss()
            }
            vBackground.setOnSafeClick {
                dismiss()
            }
        }
    }
}