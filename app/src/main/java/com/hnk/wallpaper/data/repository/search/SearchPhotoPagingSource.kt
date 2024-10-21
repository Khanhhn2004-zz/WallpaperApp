package com.hnk.wallpaper.data.repository.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.enties.toPhotoEntity
import com.hnk.wallpaper.data.model.ItemPhoto
import timber.log.Timber

class SearchPhotoPagingSource(
    private val api: PexelsApi,
    private val query: String,
    private val orientation: String? = null,
    private val size: String? = null,
    private val color: String? = null,
    private val locale: String? = null
) : PagingSource<Int, ItemPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemPhoto> {
        val page = params.key ?: 1
        return try {
            val response =
                api.searchPhotos(query, orientation, size, color, locale, page, params.loadSize)
            if (response.isSuccessful) {
                val photos = response.body()?.photos ?: emptyList()


                Timber.e("khanh  : ")
                if (photos.isEmpty()) {
                    return  LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                }

                val itemPhotos = photos.map { it.toPhotoEntity() }

                return LoadResult.Page(
                    data = itemPhotos,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (itemPhotos.isEmpty()) null else page + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
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
