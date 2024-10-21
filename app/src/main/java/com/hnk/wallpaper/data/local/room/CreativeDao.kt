package com.hnk.wallpaper.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hnk.wallpaper.data.model.Creative
import kotlinx.coroutines.flow.Flow

@Dao
interface CreativeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(creative: Creative): Long

    @Update
    suspend fun update(creative: Creative): Int

    @Delete
    suspend fun delete(creative: Creative): Int

    @Query("DELETE FROM Creative WHERE id = :id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM Creative")
    fun getAllCreative(): Flow<List<Creative>>
}