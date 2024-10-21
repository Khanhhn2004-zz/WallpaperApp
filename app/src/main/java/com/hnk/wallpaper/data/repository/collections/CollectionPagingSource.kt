package com.hnk.wallpaper.data.repository.collections

import android.app.Application
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.enties.Photo
import com.hnk.wallpaper.data.enties.toCollectionEntity
import com.hnk.wallpaper.data.enties.toPhotoEntity
import com.hnk.wallpaper.data.local.room.CollectionDao
import com.hnk.wallpaper.data.model.ItemCollection
import com.hnk.wallpaper.utils.NetworkUtils.isNetworkAvailable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import timber.log.Timber

class CollectionPagingSource(
    private val api: PexelsApi,
    private val collectionDao: CollectionDao,
    private val application: Application
) : PagingSource<Int, ItemCollection>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemCollection> =
        withContext(
            Dispatchers.IO
        ) {
            val page = params.key ?: 1
            return@withContext try {
                val offset = page * params.loadSize
                var list: List<ItemCollection> =
                    collectionDao.getAllCollections(params.loadSize, offset)?: mutableListOf()
                val maxSizeRoomDB = collectionDao.getItemCountCollection()
                if (list.isEmpty() || ((offset + params.loadSize) > maxSizeRoomDB)) {

                        val response = api.getFeaturedCollections(page, params.loadSize)
                        if (response.isSuccessful) {
                            val collections = response.body()?.collections.orEmpty()
                            list = coroutineScope {
                                collections.map { collection ->
                                    async {
                                        val coverPhoto =
                                            getFirstPhotoFromCollection(collection.id)?.toPhotoEntity()
                                        val itemCollection = collection.toCollectionEntity().copy(
                                            cover = coverPhoto?.src?.landscape
                                        )
                                        val isExist =
                                            collectionDao.isExistCollectionByTitle(itemCollection.title)
                                        if (isExist == 0) {
                                            collectionDao.insertCollection(itemCollection)
                                        }
                                        itemCollection
                                    }
                                }.awaitAll()
                            }
                            LoadResult.Page(
                                data = list,
                                prevKey = if (page == 1) null else page - 1,
                                nextKey = if (list.isEmpty() || offset ==30) null else page + 1
                            )
                        } else{
                            LoadResult.Error(Throwable("No network connection"))
                        }
                } else {
                    LoadResult.Page(
                        data = list,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (list.isEmpty() || offset ==30) null else page + 1
                    )
                }

            } catch (e: Exception) {
                Timber.e("Error loading collections: $e")
                LoadResult.Error(e)
            }
        }

    private suspend fun getFirstPhotoFromCollection(collectionId: String): Photo? {
        return try {
            val response = api.getCollectionPhotos(
                collectionId = collectionId,
                page = 0,
                perPage = 1
            )
            if (response.isSuccessful) {
                response.body()?.media?.firstOrNull()
            } else {
                Timber.e("Failed to fetch photos for collection $collectionId: ${response.code()} - ${response.errorBody()}")
                null
            }
        } catch (e: Exception) {
            Timber.e(e, "Error fetching first photo for collection $collectionId")
            null
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ItemCollection>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
