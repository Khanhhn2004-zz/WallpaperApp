package com.hnk.wallpaper.ui.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.hnk.wallpaper.utils.getHeightStatusBar
import com.hnk.wallpaper.utils.getScreenHeight
import com.hnk.wallpaper.utils.lockPortraitOrientation

abstract class BaseBindingActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {
    lateinit var binding: B
    lateinit var viewModel: VM
    private var isDispatchTouchEvent = true

    abstract val layoutId: Int
    abstract fun getViewModel(): Class<VM>
    abstract fun setupView(savedInstanceState: Bundle?)
    abstract fun setupData()

    private var toast: Toast? = null
    private var handlerToast = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        this.lockPortraitOrientation()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = ViewModelProvider(this)[getViewModel()]
        showSystemUI()
        window.setLightStatusBars(false)
        setupView(savedInstanceState)
        setupData()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        toast?.cancel()
        handlerToast.removeCallbacksAndMessages(null)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return !isDispatchTouchEvent || super.dispatchTouchEvent(ev)
    }

    protected fun isDispatchTouchEvent(time: Int) {
        isDispatchTouchEvent = false
        Handler(Looper.getMainLooper()).postDelayed({ isDispatchTouchEvent = true }, time.toLong())
    }

    fun toast(text: String) {
        toast?.cancel()
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast?.show()

        handlerToast.postDelayed({
            toast?.cancel()
        }, 1500)
    }

    private fun Window.setLightStatusBars(b: Boolean) {
        WindowCompat.getInsetsController(this, decorView).isAppearanceLightStatusBars = b
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }

    fun setMarginStatusBar(textView: View, marginTop: Int) {
        val params = textView.layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = getHeightStatusBar() + dpToPx(marginTop) * getScreenHeight() / 2400
    }

    fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true) // Cho phép hệ thống xử lý giao diện
        val controller = WindowInsetsControllerCompat(window, binding.root) // Sử dụng root view của binding
        controller.show(WindowInsetsCompat.Type.navigationBars())
    }
}
