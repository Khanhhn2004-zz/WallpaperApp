package com.hnk.wallpaper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ItemFavorite",
    foreignKeys = [ForeignKey(
        entity = ItemDownload::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("downloadId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class ItemFavorite(
    @ColumnInfo
    var downloadId: Int,
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
