package com.hnk.wallpaper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "ItemDownload",
    indices = [Index(value = ["photoUrl"], unique = true)] // Unique index for photoUrl
)
data class ItemDownload(
    @ColumnInfo
    var photoUrl: String,
    @ColumnInfo
    var photoUri: String,
    @ColumnInfo
    var avgColor: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
