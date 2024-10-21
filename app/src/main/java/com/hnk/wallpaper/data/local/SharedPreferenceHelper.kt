package com.hnk.wallpaper.data.local

import android.content.SharedPreferences
import org.json.JSONArray
import org.json.JSONException
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(sharedPreferences: SharedPreferences) {
    companion object {
        private const val DEFAULT_NUM = -1
        private const val DEFAULT_STRING = ""
        lateinit var sharedPreferences: SharedPreferences

        private fun getEditor() = sharedPreferences.edit()

        fun storeString(key: String?, value: String?) = getEditor().putString(key, value).apply()

        fun getString(key: String?) = sharedPreferences.getString(key, DEFAULT_STRING)

        fun getStringWithDefault(key: String?, default: String) =
            sharedPreferences.getString(key, default) ?: default

        fun storeInt(key: String?, value: Int) = getEditor().putInt(key, value)?.apply()

        fun getInt(key: String?) = sharedPreferences.getInt(key, DEFAULT_NUM)

        fun getInt(key: String?, default: Int) = sharedPreferences.getInt(key, default)

        fun getIntWithDefault(key: String?, default: Int) = sharedPreferences.getInt(key, default)

        fun storeLong(key: String?, value: Long) = getEditor().putLong(key, value).apply()

        fun getLong(key: String?) = sharedPreferences.getLong(key, DEFAULT_NUM.toLong())

        fun storeBoolean(key: String?, value: Boolean) = getEditor().putBoolean(key, value).apply()

        fun getBoolean(key: String?, default: Boolean) = sharedPreferences.getBoolean(key, default)

        fun storeFloat(key: String?, value: Float) = getEditor().putFloat(key, value)?.apply()

        fun getFloat(key: String?) = sharedPreferences.getFloat(key, 0f)

        fun setStringArrayPref(key: String?, values: List<String?>) {
            val editor = getEditor()
            val a = JSONArray(values)
            editor.putString(key, if (values.isNotEmpty()) a.toString() else DEFAULT_STRING)
            editor.apply()
        }

        fun getStringArrayPref(key: String?): List<String> {
            val json = sharedPreferences.getString(key, null) ?: return emptyList()
            return try {
                val a = JSONArray(json)
                List(a.length()) { a.optString(it) }
            } catch (e: JSONException) {
                e.printStackTrace()
                emptyList()
            }
        }

        fun setIntArray(key: String?, values: List<Int?>) {
            val editor = getEditor()
            val a = JSONArray(values)
            editor.putString(key, if (values.isNotEmpty()) a.toString() else "")
            editor.apply()
        }

        fun getIntArray(key: String?): List<Int> {
            val json = sharedPreferences.getString(key, null) ?: return emptyList()
            return try {
                val a = JSONArray(json)
                List(a.length()) { a.optInt(it) }
            } catch (e: JSONException) {
                e.printStackTrace()
                emptyList()
            }
        }

        fun removeKey(key: String?) = getEditor().remove(key)?.apply()

        fun resetAll() = getEditor().clear()?.apply()

        fun containKey(key: String?) = sharedPreferences.contains(key)

    }

    init {
        Companion.sharedPreferences = sharedPreferences
    }
}