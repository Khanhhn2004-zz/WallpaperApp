package com.hnk.wallpaper.ui.language

import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.ui.base.BaseLanguageFragment

class LanguageStartScreenFragment : BaseLanguageFragment() {

    override fun actionDone() {
        super.actionDone()
        SharedPreferenceHelper.storeBoolean(Constant.KEY_SHOW_LANGUAGE_START_SCREEN, true)
    }
}
