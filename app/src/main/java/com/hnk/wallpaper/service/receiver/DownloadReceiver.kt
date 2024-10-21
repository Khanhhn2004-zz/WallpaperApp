package com.hnk.wallpaper.service.receiver

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

class DownloadReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        Timber.e("khanh  :intent.action ${intent.action}")

        if (action == DownloadManager.ACTION_DOWNLOAD_COMPLETE) {
            val downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

            EventBus.getDefault().post(
                MessageEvent(
                    typeEvent = Constant.EVENT_DOWNLOAD_COMPLETE,
                    longValue = downloadId)
            )
        }
    }
}
