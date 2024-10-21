package com.hnk.wallpaper.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hnk.wallpaper.data.model.Recent
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recent: Recent): Long

    @Update
    suspend fun update(recent: Recent): Int

    @Delete
    suspend fun delete(recent: Recent): Int

    @Query("SELECT * FROM Recent")
    fun getAllRecent(): Flow<List<Recent>>

    @Query("SELECT COUNT(*) FROM Recent")
    suspend fun getCount(): Int

    @Query("DELETE FROM Recent WHERE id IN (SELECT id FROM Recent ORDER BY id ASC LIMIT 1)")
    suspend fun deleteOldest(): Int

    @Query("SELECT COUNT(*) FROM Recent WHERE photoUrl = :photoUrl")
    suspend fun checkIfExists(photoUrl: String): Int
}