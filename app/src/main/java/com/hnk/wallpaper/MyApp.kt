package com.hnk.wallpaper

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.Network
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.data.local.room.AppDatabase
import com.hnk.wallpaper.utils.LanguageUtil.setLocale
import com.hnk.wallpaper.utils.timber.MyDebugTree
import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        lateinit var instance: MyApp
        lateinit var database: AppDatabase
    }

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLog()
        monitorNetworkConnection()
    }


    private fun initLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(MyDebugTree())
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        this.setLocale()
    }

    private fun monitorNetworkConnection() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                EventBus.getDefault().post(
                    MessageEvent(
                        typeEvent = Constant.EVENT_NETWORK_STATUS, booleanValue = true
                    )
                )
            }

            override fun onLost(network: Network) {
                EventBus.getDefault().post(
                    MessageEvent(
                        typeEvent = Constant.EVENT_NETWORK_STATUS, booleanValue = false
                    )
                )
            }
        })
    }
}