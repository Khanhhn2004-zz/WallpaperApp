package com.hnk.wallpaper.data.repository.favorite

import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.model.ItemFavorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepo {
    suspend fun insert(favorite: ItemFavorite): Flow<Long>

    suspend fun update(itemFavorite: ItemFavorite): Flow<Int>

    suspend fun delete(itemFavorite: ItemFavorite): Flow<Int>

    fun getAllItemFavorite(): Flow<List<ItemFavorite>>

    suspend fun isFavorite(downloadId: Int): Flow<Boolean>

    suspend fun deleteByDownloadId(downloadId: Int): Flow<Int>

    suspend fun getIdDownloadWithUrl(url: String): Flow<Int>

    suspend fun getAllFavoriteDownloadIds(): Flow<List<Int>>
}