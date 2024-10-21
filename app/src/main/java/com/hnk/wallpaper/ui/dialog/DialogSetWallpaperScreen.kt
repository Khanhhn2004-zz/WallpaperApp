package com.hnk.wallpaper.ui.dialog

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.DialogSetWallpaperScrenBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class DialogSetWallpaperScreen : BaseBindingDialogFragment<DialogSetWallpaperScrenBinding>() {

    var onClickHomeScreen: (() -> Unit) = { }
    var onClickLockScreen: (() -> Unit) = { }
    var onClickBoth: (() -> Unit) = { }

    override val layoutId: Int
        get() = R.layout.dialog_set_wallpaper_scren

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAction()

    }

    private fun initAction() {
        with(binding) {
            tvHomeScreen.setOnSafeClick {
                onClickHomeScreen()
                dismiss()
            }
            tvLockScreen.setOnSafeClick {
                onClickLockScreen()
                dismiss()
            }
            tvBoth.setOnSafeClick {
                onClickBoth()
                dismiss()
            }
            vBackground.setOnSafeClick {
                dismiss()
            }
        }
    }

}