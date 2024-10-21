package com.hnk.wallpaper.ui.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.DialogDownloadingBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.ui.main.MainVM
import com.hnk.wallpaper.utils.downloadWallpaper
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import timber.log.Timber

class DialogDownloading : BaseBindingDialogFragment<DialogDownloadingBinding>() {
    var title: String = ""
    var url: String = ""
    private var mDownloadId: Long = -1

    override val layoutId = R.layout.dialog_downloading

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        EventBus.getDefault().takeIf { !it.isRegistered(this) }?.register(this)
        context?.let { context ->
            context.downloadWallpaper(url,title).let {
                mDownloadId = it
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        EventBus.getDefault().takeIf { it.isRegistered(this) }?.unregister(this)
    }
}
