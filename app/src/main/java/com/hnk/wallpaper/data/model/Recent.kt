package com.hnk.wallpaper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recent")
data class Recent(
    @ColumnInfo
    var photoUrl: String,
    @ColumnInfo(name = "average_color") val avgColor: String

    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
