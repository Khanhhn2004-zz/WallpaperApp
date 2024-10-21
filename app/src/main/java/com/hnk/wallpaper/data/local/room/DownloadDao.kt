package com.hnk.wallpaper.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hnk.wallpaper.data.model.ItemDownload
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface for managing download-related operations
 * in the Room database. This interface provides methods for inserting, updating,
 * deleting, and querying downloaded items.
 */
@Dao
interface DownloadDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemDownload: ItemDownload): Long

    @Update
    suspend fun update(itemDownload: ItemDownload): Int

    @Delete
    suspend fun delete(itemDownload: ItemDownload): Int

    @Query("DELETE FROM ItemDownload WHERE id = :id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM ItemDownload")
    fun getAllDownload(): Flow<List<ItemDownload>>

    @Query("SELECT * FROM ItemDownload WHERE id = :id")
    suspend fun getDownloadById(id: Int): ItemDownload?

    @Query("SELECT * FROM ItemDownload WHERE photoUrl = :url")
    suspend fun getDownloadByUrl(url: String): ItemDownload?

    @Query("SELECT * FROM ItemDownload INNER JOIN ItemFavorite ON ItemDownload.id = ItemFavorite.downloadId")
    fun getAllFavoriteDownloads(): Flow<List<ItemDownload>>

    @Query("SELECT id FROM ItemDownload WHERE photoUrl = :url")
    suspend fun getIdDownload(url: String): Int

    @Query("SELECT id FROM ItemDownload WHERE photoUri = :uri")
    suspend fun getIdDownloadWithPhotoUri(uri: String): Int

    @Query("SELECT photoUri FROM ItemDownload WHERE id = :id")
    suspend fun getUriDownloadWithId(id: Int): String

    @Query("SELECT * FROM ItemDownload WHERE id IN (:downloadIds)")
    fun getDownloadsByIds(downloadIds: List<Int>): Flow<List<ItemDownload>>

}