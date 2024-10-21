package com.hnk.wallpaper.data.repository.search

import androidx.paging.PagingSource
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.enties.toPhotoEntity
import com.hnk.wallpaper.data.model.ItemPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class SearchRepoImpl @Inject constructor(
    private val mPexelsApi: PexelsApi
) : SearchRepo {
    override fun searchPhotos(
        query: String,
        orientation: String?,
        size: String?,
        color: String?,
        locale: String?
    ): PagingSource<Int, ItemPhoto> {
        return SearchPhotoPagingSource(mPexelsApi, query, orientation, size, color, locale)
    }

    override fun searchTrendingPhotos(
        query: String,
        orientation: String?,
        size: String?,
        color: String?,
        locale: String?
    ): PagingSource<Int, ItemPhoto> {
        return SearchPhotoPagingSource(mPexelsApi, query, orientation, size, color, locale)
    }
}