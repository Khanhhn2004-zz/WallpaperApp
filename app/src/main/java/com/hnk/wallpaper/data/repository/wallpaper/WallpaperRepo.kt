package com.hnk.wallpaper.data.repository.wallpaper

import androidx.paging.PagingSource
import com.hnk.wallpaper.data.enties.Photo
import com.hnk.wallpaper.data.model.ItemPhoto
import kotlinx.coroutines.flow.Flow

interface WallpaperRepo {
    fun getCuratedPhotosPagingSource(): PagingSource<Int, ItemPhoto>
    fun getCollectionPhotos(collectionId: String): PagingSource<Int,ItemPhoto>
    suspend fun getBannerPhotos(page: Int, perPage: Int): Flow<List<ItemPhoto>?>
    suspend fun getCuratedPhotos(page: Int, perPage: Int): Flow<List<ItemPhoto>?>
    suspend fun getTrendingPhotos(query: String, page: Int, perPage: Int): Flow<List<ItemPhoto>?>
    suspend fun getFeaturedPhotos(query: String, page: Int, perPage: Int): Flow<List<ItemPhoto>?>
    suspend fun setWallpaperHomeScreen(photoUriString: String): Flow<Boolean>
    suspend fun setWallpaperLockScreen(photoUriString: String): Flow<Boolean>
    suspend fun setWallpaperBoth(photoUriString: String): Flow<Boolean>
}