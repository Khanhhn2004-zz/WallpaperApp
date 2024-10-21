package com.hnk.wallpaper.data.repository.recent

import com.hnk.wallpaper.data.model.Recent
import kotlinx.coroutines.flow.Flow

interface RecentRepo {
    suspend fun insert(photo: Recent): Flow<Long>
    suspend fun update(photo: Recent): Flow<Int>
    suspend fun delete(photo: Recent): Flow<Int>
    fun getAllRecent(): Flow<List<Recent>>
}