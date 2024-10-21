package com.hnk.wallpaper.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hnk.wallpaper.data.model.ItemFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite: ItemFavorite): Long

    @Update
    suspend fun update(itemFavorite: ItemFavorite): Int

    @Delete
    suspend fun delete(itemFavorite: ItemFavorite): Int

    @Query("SELECT * FROM ItemFavorite Order by id DESC")
    fun getAllItemFavorite(): Flow<List<ItemFavorite>>

    @Query("SELECT * FROM ItemFavorite WHERE downloadId = :downloadId")
    suspend fun isFavorite(downloadId: Int): ItemFavorite?

    @Query("DELETE FROM ItemFavorite WHERE downloadId = :downloadId")
    suspend fun deleteByDownloadId(downloadId: Int): Int

    @Query("SELECT id FROM ItemDownload WHERE photoUrl = :url")
    fun getIdDownloadWithUrl(url: String): Int

    @Query("SELECT downloadId FROM ItemFavorite")
    suspend fun getAllFavoriteDownloadIds(): List<Int>
}
