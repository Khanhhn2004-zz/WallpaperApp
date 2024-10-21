package com.hnk.wallpaper.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hnk.wallpaper.converters.Converters
import com.hnk.wallpaper.data.model.Creative
import com.hnk.wallpaper.data.model.ItemCollection
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.model.ItemFavorite
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.data.model.Recent

@Database(
    entities = [
        ItemDownload::class,
        Recent::class,
        ItemFavorite::class,
        ItemCollection::class,
        Creative::class,
        ItemPhoto::class],
    version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "DATABASE_NAME"
    }

    abstract fun downloadDao(): DownloadDao
    abstract fun recentDao(): RecentDao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun collectionDao(): CollectionDao
    abstract fun creativeDao(): CreativeDao
    abstract fun wallpaperDao(): WallpaperDao
}
