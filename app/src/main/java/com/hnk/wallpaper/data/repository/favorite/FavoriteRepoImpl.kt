package com.hnk.wallpaper.data.repository.favorite

import com.hnk.wallpaper.data.local.room.DownloadDao
import com.hnk.wallpaper.data.local.room.FavoriteDao
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.model.ItemFavorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoriteRepo {
    override suspend fun insert(favorite: ItemFavorite) = flow {
        emit(favoriteDao.insert(favorite))
    }

    override suspend fun update(itemFavorite: ItemFavorite) = flow {
        emit(favoriteDao.update(itemFavorite))
    }

    override suspend fun delete(itemFavorite: ItemFavorite) = flow {
        emit(favoriteDao.delete(itemFavorite))
    }

    override fun getAllItemFavorite(): Flow<List<ItemFavorite>> = favoriteDao.getAllItemFavorite()

    override suspend fun isFavorite(downloadId: Int) = flow {
        emit(favoriteDao.isFavorite(downloadId) != null)
    }

    override suspend fun deleteByDownloadId(downloadId: Int) = flow {
        emit(favoriteDao.deleteByDownloadId(downloadId))
    }

    override suspend fun getIdDownloadWithUrl(url: String): Flow<Int> = flow {
        emit(favoriteDao.getIdDownloadWithUrl(url))
    }

    override suspend fun getAllFavoriteDownloadIds() = flow {
        emit(favoriteDao.getAllFavoriteDownloadIds())
    }

}
