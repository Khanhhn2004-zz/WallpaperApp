package com.hnk.wallpaper.data.repository.wallpaper

import android.app.Application
import android.app.WallpaperManager
import android.net.Uri
import androidx.paging.PagingSource
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.enties.toPhotoEntity
import com.hnk.wallpaper.data.local.room.WallpaperDao
import com.hnk.wallpaper.data.model.ItemPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class WallpaperRepoImpl @Inject constructor(
    private val mPexelsApi: PexelsApi,
    private val application: Application,
    private val wallpaperDao: WallpaperDao
) : WallpaperRepo {

    override fun getCuratedPhotosPagingSource(): PagingSource<Int, ItemPhoto> {
        return WallpaperPagingSource(mPexelsApi)
    }

    override fun getCollectionPhotos(collectionId: String): PagingSource<Int, ItemPhoto> {
        return CollectionPhotoPagingSource(mPexelsApi, collectionId)
    }

    override suspend fun getBannerPhotos(page: Int, perPage: Int) = flow {
        val localPhotos = wallpaperDao.getWallpapersByType(Constant.BANNER_WALLPAPER).first()

        if (localPhotos.isNotEmpty()) {
            emit(localPhotos)
        } else {
            val response = mPexelsApi.getPopularPhotos(page, perPage)
            if (response.isSuccessful) {
                val photoList = response.body()?.photos

                val itemPhotoList = photoList?.let { photos ->
                    withContext(Dispatchers.IO) {
                        coroutineScope {
                            photos.map { photo ->
                                async {
                                    photo.toPhotoEntity().copy(type = Constant.BANNER_WALLPAPER)
                                }
                            }.awaitAll()
                        }
                    }
                }
                itemPhotoList?.let {
                    wallpaperDao.insertWallpapers(it)
                }

                emit(itemPhotoList ?: emptyList())
            } else {
                Timber.e("API call failed: ${response.code()} - ${response.message()}")
                Timber.e("Error body: ${response.errorBody()?.string()}")
                emit(emptyList())
            }
        }
    }.catch {
        it.printStackTrace()
        emit(emptyList())
    }

    override suspend fun getCuratedPhotos(page: Int, perPage: Int) = flow {
        val localPhotos = wallpaperDao.getWallpapersByType(Constant.CURATED_WALLPAPER).first()

        if (localPhotos.isNotEmpty()) {
            emit(localPhotos)
        } else {
            val response = mPexelsApi.getCuratedPhotos(page, perPage)
            if (response.isSuccessful) {
                val photoList = response.body()?.photos

                val itemPhotoList = photoList?.let { photos ->
                    withContext(Dispatchers.IO) {
                        coroutineScope {
                            photos.map { photo ->
                                async {
                                    photo.toPhotoEntity().copy(type = Constant.CURATED_WALLPAPER)
                                }
                            }.awaitAll()
                        }
                    }
                }
                itemPhotoList?.let {
                    wallpaperDao.insertWallpapers(it)
                }

                emit(itemPhotoList ?: emptyList())
            } else {
                Timber.e("API call failed: ${response.code()} - ${response.message()}")
                Timber.e("Error body: ${response.errorBody()?.string()}")
                emit(emptyList())
            }
        }
    }.catch {
        it.printStackTrace()
        emit(emptyList())
    }

    override suspend fun getTrendingPhotos(query: String, page: Int, perPage: Int) = flow {
        val localPhotos = wallpaperDao.getWallpapersByType(Constant.TRENDING_WALLPAPER).first()
        if (localPhotos.isNotEmpty()) {
            emit(localPhotos)
        } else {
            val response = mPexelsApi.searchPhotos(query = query, page = page, perPage = perPage)
            if (response.isSuccessful) {
                val photoList = response.body()?.photos

                val itemPhotoList = photoList?.let { photos ->
                    withContext(Dispatchers.IO) {
                        coroutineScope {
                            photos.map { photo ->
                                async {
                                    photo.toPhotoEntity().copy(type = Constant.TRENDING_WALLPAPER)
                                }
                            }.awaitAll()
                        }
                    }
                }
                itemPhotoList?.let {
                    wallpaperDao.insertWallpapers(it)
                }

                emit(itemPhotoList ?: emptyList())
            } else {
                Timber.e("API call failed: ${response.code()} - ${response.message()}")
                Timber.e("Error body: ${response.errorBody()?.string()}")
                emit(emptyList())
            }
        }
    }.catch {
        it.printStackTrace()
        emit(emptyList())
    }

    override suspend fun getFeaturedPhotos(query: String, page: Int, perPage: Int) = flow {
        val localPhotos = wallpaperDao.getWallpapersByType(Constant.FEATUERS_WALLPAPER).first()
        if (localPhotos.isNotEmpty()) {
            emit(localPhotos)
        } else {
            val response = mPexelsApi.searchPhotos(query = query, page = page, perPage = perPage)
            if (response.isSuccessful) {
                val photoList = response.body()?.photos

                val itemPhotoList = photoList?.let { photos ->
                    withContext(Dispatchers.IO) {
                        coroutineScope {
                            photos.map { photo ->
                                async {
                                    photo.toPhotoEntity().copy(type = Constant.FEATUERS_WALLPAPER)
                                }
                            }.awaitAll()
                        }
                    }
                }
                itemPhotoList?.let {
                    wallpaperDao.insertWallpapers(it)
                }

                emit(itemPhotoList ?: emptyList())
            } else {
                Timber.e("API call failed: ${response.code()} - ${response.message()}")
                Timber.e("Error body: ${response.errorBody()?.string()}")
                emit(emptyList())
            }
        }
    }.catch {
        it.printStackTrace()
        emit(emptyList())
    }

    override suspend fun setWallpaperHomeScreen(photoUriString: String) = flow {
        val wallpaperManager = WallpaperManager.getInstance(application)
        val photoUri = Uri.parse(photoUriString)
        val inputStream = application.contentResolver.openInputStream(photoUri)

        if (inputStream != null) {
            wallpaperManager.setStream(
                inputStream,
                null,
                true,
                WallpaperManager.FLAG_SYSTEM
            )
            emit(true)
        } else {
            emit(false)
        }
    }

    override suspend fun setWallpaperLockScreen(photoUriString: String) = flow {
        val wallpaperManager = WallpaperManager.getInstance(application)
        val photoUri = Uri.parse(photoUriString)
        val inputStream = application.contentResolver.openInputStream(photoUri)

        if (inputStream != null) {
            wallpaperManager.setStream(
                inputStream,
                null,
                true,
                WallpaperManager.FLAG_LOCK
            )
            emit(true)
        } else {
            emit(false)
        }
    }

    override suspend fun setWallpaperBoth(photoUriString: String) = flow {
        val wallpaperManager = WallpaperManager.getInstance(application)
        val photoUri = Uri.parse(photoUriString)
        val inputStream = application.contentResolver.openInputStream(photoUri)

        if (inputStream != null) {
            wallpaperManager.setStream(
                inputStream,
                null,
                true,
                WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK
            )
            emit(true)
        } else {
            emit(false)
        }
    }
}
