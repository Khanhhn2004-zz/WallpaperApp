package com.hnk.wallpaper.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.databinding.ActivitySplashBinding
import com.hnk.wallpaper.ui.base.BaseBindingActivity
import com.hnk.wallpaper.ui.main.MainActivity
import com.hnk.wallpaper.utils.setStatusBarColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseBindingActivity<ActivitySplashBinding, SplashVM>() {
    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun getViewModel(): Class<SplashVM> = SplashVM::class.java
    override fun setupView(savedInstanceState: Bundle?) {
        setStatusBarColor(R.color.transparent)
        startToMain()
    }

    override fun setupData() {
    }

    private fun startToMain() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(Constant.DELAY_SPLASH)
            Intent(this@SplashActivity, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}