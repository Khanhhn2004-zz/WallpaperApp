package com.hnk.wallpaper.ui.privicy

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.FragmentPrivicyBinding
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class PrivacyFragment:BaseBindingFragment<FragmentPrivicyBinding,PrivacyVM>() {
    override fun getViewModel(): Class<PrivacyVM> = PrivacyVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_privicy

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initView()
    }
    private fun initView(){
        binding.imBack.setOnSafeClick {
            popBackStack()
        }
        binding.webView.apply {
            loadUrl("https://sites.google.com/view/wallpaperappprivacypolicy/home")
        }
    }
}