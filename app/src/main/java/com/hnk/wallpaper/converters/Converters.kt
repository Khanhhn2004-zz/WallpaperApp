package com.hnk.wallpaper.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hnk.wallpaper.data.enties.Src

class Converters {

    @TypeConverter
    fun fromSrc(src: Src?): String? {
        return Gson().toJson(src)
    }

    @TypeConverter
    fun toSrc(srcString: String?): Src? {
        return if (srcString == null) null else Gson().fromJson(srcString, object : TypeToken<Src>() {}.type)
    }
}
