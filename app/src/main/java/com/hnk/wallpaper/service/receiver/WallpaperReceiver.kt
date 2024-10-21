package com.hnk.wallpaper.service.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

class WallpaperReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_WALLPAPER_CHANGED) {
            EventBus.getDefault().post(
                MessageEvent(
                    typeEvent = Constant.EVENT_WALLPAPER_SET_SUCCESS,
                )
            )
        }
    }
}


