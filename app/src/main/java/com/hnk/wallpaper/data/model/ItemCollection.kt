package com.hnk.wallpaper.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collections")
data class ItemCollection(
    @PrimaryKey val id: String,
    val title: String,
    val description: String?,
    @ColumnInfo(name = "is_private") val isPrivate: Boolean,
    @ColumnInfo(name = "media_count") val mediaCount: Int,
    @ColumnInfo(name = "photos_count") val photosCount: Int,
    val cover: String?
)
