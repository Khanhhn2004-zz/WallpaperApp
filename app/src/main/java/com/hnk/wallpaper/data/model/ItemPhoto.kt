package com.hnk.wallpaper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hnk.wallpaper.data.enties.Src

@Entity(tableName = "wallpaper")
data class ItemPhoto(
    @PrimaryKey
    @ColumnInfo(name = "photo_id") val id: Long?,
    @ColumnInfo(name = "photo_width") val width: Int?,
    @ColumnInfo(name = "photo_height") val height: Int?,
    @ColumnInfo(name = "photo_url") val url: String?,
    @ColumnInfo(name = "photographer_name") val photographer: String?,
    @ColumnInfo(name = "photographer_url") val photographerUrl: String?,
    @ColumnInfo(name = "photographer_id") val photographerId: Int?,
    @ColumnInfo(name = "average_color") val avgColor: String?,
    @ColumnInfo(name = "source") val src: Src?,
    @ColumnInfo(name = "is_liked") var liked: Boolean?,
    @ColumnInfo(name = "photo_alt") val alt: String?,
    @ColumnInfo(name = "wallpaper_type") val type: String?
)
