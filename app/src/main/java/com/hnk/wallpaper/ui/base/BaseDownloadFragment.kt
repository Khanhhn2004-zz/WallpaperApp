package com.hnk.wallpaper.ui.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.ui.dialog.DialogComplete
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import timber.log.Timber

abstract class BaseDownloadFragment<Binding : ViewDataBinding, VM : BaseViewModel> :
    BaseBindingFragment<Binding, VM>() {

    protected var mPhotoUrl: String? = null
    protected var mAvgColor: String? = null
    protected var mPhotoUri: String? = null
    protected var mIsDownload: Boolean = false

    private var isRegistered = false

    val mDialogComplete: DialogComplete by lazy {
        DialogComplete()
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        if (!isRegistered) {
            EventBus.getDefault().register(this)
            isRegistered = true
            Timber.d("EventBus registered")
        }
    }

    override fun onDestroy() {
        if (isRegistered) {
            EventBus.getDefault().unregister(this)
            isRegistered = false
            Timber.d("EventBus unregistered")
        }
        super.onDestroy()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        when (event.typeEvent) {
            Constant.EVENT_DOWNLOAD_COMPLETE -> handleDownloadComplete(event)
            Constant.EVENT_DOWNLOAD_FAILED -> handleDownloadFailed()
            Constant.EVENT_NETWORK_STATUS -> handleNetWorkStatus(event)
        }
    }

    protected open fun handleDownloadComplete(event: MessageEvent) {}
    protected open fun handleDownloadFailed() {}
    protected open fun handleNetWorkStatus(event: MessageEvent) {}
}
