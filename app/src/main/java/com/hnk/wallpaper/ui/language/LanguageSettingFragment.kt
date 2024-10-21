package com.hnk.wallpaper.ui.language

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.ui.base.BaseLanguageFragment
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.visible

class LanguageSettingFragment : BaseLanguageFragment() {

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        super.onCreatedView(view, savedInstanceState)
        binding.imBack.visible()
    }

    override fun initListener() {
        super.initListener()
        binding.imBack.setOnSafeClick {
            popBackStack()
        }
    }
}