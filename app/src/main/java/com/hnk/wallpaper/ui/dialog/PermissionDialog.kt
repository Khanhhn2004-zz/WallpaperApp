package com.hnk.wallpaper.ui.dialog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.DialogPermissionBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class PermissionDialog: BaseBindingDialogFragment<DialogPermissionBinding>() {
    override val layoutId = R.layout.dialog_permission

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        onClick()
    }


    private fun onClick() {
        binding.tvAllow.setOnSafeClick {
            Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).let {
                Uri.fromParts("package", context?.packageName, null).let { uri ->
                    it.data = uri
                    startActivity(it)
                    dismiss()
                }
            }
        }
        binding.viewBg.setOnClickListener{
            dismiss()
        }
    }
}