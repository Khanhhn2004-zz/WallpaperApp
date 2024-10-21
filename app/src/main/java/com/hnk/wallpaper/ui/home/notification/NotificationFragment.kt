package com.hnk.wallpaper.ui.home.notification

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.FragmentNotificationBinding
import com.hnk.wallpaper.ui.base.BaseBindingFragment

class NotificationFragment:BaseBindingFragment<FragmentNotificationBinding,NotificationVM>() {
    override fun getViewModel(): Class<NotificationVM> = NotificationVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_notification

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
    }
}