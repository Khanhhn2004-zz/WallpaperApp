package com.hnk.wallpaper.utils

import android.content.Context
import android.content.res.Configuration
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

object LanguageUtil {
    private var myLocale: Locale? = null
    const val KEY_LANGUAGE = "KEY_LANGUAGE"

    fun Context.setLocale() {
        kotlin.runCatching {
            val language = getPreLanguage()
            if (language == "") {
                Locale.getDefault().apply {
                    Locale.setDefault(this)
                    Configuration().let { config ->
                        config.locale = this
                        resources.updateConfiguration(config, resources.displayMetrics)
                    }
                }
            } else {
                this.changeLang(language)
            }
        }.onFailure { it.printStackTrace() }
    }

    fun Context.changeLang(lang: String) {
        kotlin.runCatching {
            if (lang.equals("", ignoreCase = true)) return
            myLocale = Locale(lang)
            lang.saveKeyLanguageToSharedPreferences()
            myLocale?.let { Locale.setDefault(it) }
            Configuration().apply {
                locale = myLocale
                resources.updateConfiguration(this, resources.displayMetrics)
            }
        }.onFailure { it.printStackTrace() }
    }

    fun Context.getPreLanguage(): String {
        var language = SharedPreferenceHelper.getStringWithDefault(KEY_LANGUAGE, "")
        if (language.isEmpty()) {
            language = getDeviceLanguage()
        }
        if (language.isEmpty()) language = "en"
        else {
            if (!listCode().contains(language)) language = "en"
        }
        return language
    }

    private fun Context.listCode() = listOf("en", "vi", "it", "pt", "hi", "fr")

    private fun Context.getDeviceLanguage(): String {
        val locale = resources.configuration.locales
        if (locale.isEmpty) {
            return ""
        }
        return resources.configuration.locales[0].language
    }

    private fun String.saveKeyLanguageToSharedPreferences() {
        if (this == "") return
        CoroutineScope(Dispatchers.IO).launch {
            SharedPreferenceHelper.storeString(
                KEY_LANGUAGE,
                this@saveKeyLanguageToSharedPreferences
            )
        }
    }
}