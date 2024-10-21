package com.hnk.wallpaper.data.repository.creative

import android.net.Uri
import com.hnk.wallpaper.data.model.Creative
import kotlinx.coroutines.flow.Flow

interface CreativeRepo {

    suspend fun insert(creative: Creative): Flow<Long>

    suspend fun update(creative: Creative): Flow<Int>

    suspend fun delete(creative: Creative): Flow<Int>

    suspend fun deleteById(id: Int): Flow<Int>

    fun getAllCreative(): Flow<List<Creative>>

    suspend fun getAverageColorFromUri(uri: Uri): Int  // Thêm phương thức này

}