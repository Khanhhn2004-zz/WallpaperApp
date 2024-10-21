package com.hnk.wallpaper.ui.dialog

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.DialogDownloadCompleteBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class DialogError : BaseBindingDialogFragment<DialogDownloadCompleteBinding>() {
    override val layoutId: Int
    get() = R.layout.dialog_download_complete

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initView()
    }
    private fun initView(){
        binding.vBackground.setOnSafeClick {
            dismiss()
        }
    }
}
