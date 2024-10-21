package com.hnk.wallpaper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "src")
data class ItemSrc(
    @PrimaryKey(autoGenerate = true) val id: Long? = null, // Thêm auto-generate cho ID nếu cần
    @ColumnInfo(name = "original") val original: String,
    @ColumnInfo(name = "large2x") val large2x: String,
    @ColumnInfo(name = "large") val large: String,
    @ColumnInfo(name = "medium") val medium: String,
    @ColumnInfo(name = "small") val small: String,
    @ColumnInfo(name = "portrait") val portrait: String,
    @ColumnInfo(name = "landscape") val landscape: String,
    @ColumnInfo(name = "tiny") val tiny: String
)
