package com.hnk.wallpaper.data.local.room

import androidx.room.*
import com.hnk.wallpaper.data.model.ItemPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpaper(wallpaper: ItemPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpapers(wallpapers: List<ItemPhoto>)

    @Query("SELECT * FROM wallpaper")
    fun getAllWallpapers(): Flow<List<ItemPhoto>>

    @Query("SELECT * FROM wallpaper WHERE wallpaper_type = :type ORDER BY photo_id DESC")
    fun getWallpapersByType(type: String): Flow<List<ItemPhoto>>

    @Query("SELECT * FROM wallpaper WHERE photo_id = :wallpaperId")
    suspend fun getWallpaperById(wallpaperId: Int): ItemPhoto?

    @Update
    suspend fun updateWallpaper(wallpaper: ItemPhoto)

    @Delete
    suspend fun deleteWallpaper(wallpaper: ItemPhoto)

    @Query("DELETE FROM wallpaper")
    suspend fun deleteAllWallpapers()

    @Query("DELETE FROM wallpaper WHERE wallpaper_type = :type")
    suspend fun deletePhotosByType(type: String)
}
