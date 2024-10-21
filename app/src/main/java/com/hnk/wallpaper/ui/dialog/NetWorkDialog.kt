package com.hnk.wallpaper.ui.dialog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.DialogNetworkBinding
import com.hnk.wallpaper.databinding.DialogPermissionBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class NetWorkDialog: BaseBindingDialogFragment<DialogNetworkBinding>() {
    override val layoutId = R.layout.dialog_network

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        onClick()
    }

    private fun onClick() {
        binding.tvGoToSetting.setOnSafeClick {
            val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS) // Mở cài đặt mạng tổng quát
            context?.startActivity(intent)
        }
        binding.tvUseOffline.setOnSafeClick {
            dismiss()
        }
    }
}