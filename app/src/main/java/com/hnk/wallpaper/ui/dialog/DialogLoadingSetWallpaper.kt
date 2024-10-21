package com.hnk.wallpaper.ui.dialog

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.DialogLoadingSetWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.getDownloadedFileUri
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import timber.log.Timber

class DialogLoadingSetWallpaper : BaseBindingDialogFragment<DialogLoadingSetWallpaperBinding>() {
    override val layoutId: Int
        get() = R.layout.dialog_loading_set_wallpaper

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {

    }
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        when (event.typeEvent) {
            Constant.EVENT_DOWNLOAD_COMPLETE -> {
                dismiss()
            }
        }
    }
}