package com.hnk.wallpaper.data.repository.wallpaper

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.enties.Photo
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.data.enties.toPhotoEntity

class CollectionPhotoPagingSource(
    private val api: PexelsApi,
    private val collectionId: String
) : PagingSource<Int, ItemPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemPhoto> {
        val page = params.key ?: 1
        return try {
            val response = api.getCollectionPhotos(
                collectionId = collectionId,
                type = "photos",
                sort = "asc",
                page = page,
                perPage = params.loadSize
            )

            if (response.isSuccessful) {
                val photos = response.body()?.media ?: emptyList()
                val itemPhotos = photos.map { it.toPhotoEntity() }
                LoadResult.Page(
                    data = itemPhotos,  // Trả về danh sách ItemPhoto
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (itemPhotos.isEmpty()) null else page + 1
                )
            } else {
                LoadResult.Error(Exception("API call failed with code ${response.code()}"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ItemPhoto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
