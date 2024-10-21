package com.hnk.wallpaper.data.repository.search

import androidx.paging.PagingSource
import com.hnk.wallpaper.data.model.ItemPhoto
import kotlinx.coroutines.flow.Flow

/**
 * SearchRepo is responsible for providing methods to search and retrieve photos based on different criteria,
 * including query, orientation, size, and other optional parameters. It manages photo pagination
 * and flows for returning the results.
 */
interface SearchRepo {

    /**
     * Searches for photos based on the provided query and optional filters like orientation, size, color, and locale.
     *
     * @param query The search query to find photos.
     * @param orientation Optional filter for photo orientation (landscape, portrait, or square).
     * @param size Optional filter for the size of the photo.
     * @param color Optional filter for the predominant color in the photo.
     * @param locale Optional filter for the locale or language.
     *
     * @return A PagingSource that handles pagination for the searched photos.
     */
    fun searchPhotos(
        query: String,
        orientation: String? = null,
        size: String? = null,
        color: String? = null,
        locale: String? = null
    ): PagingSource<Int, ItemPhoto>  

    /**
     * Searches for trending photos based on the provided query and optional filters.
     * This method allows for filtering trending photos in the same way as general photo searches.
     *
     * @param query The search query to find trending photos.
     * @param orientation Optional filter for photo orientation.
     * @param size Optional filter for the size of the photo.
     * @param color Optional filter for the predominant color in the photo.
     * @param locale Optional filter for the locale or language.
     *
     * @return A PagingSource that handles pagination for trending photos.
     */
    fun searchTrendingPhotos(
        query: String,
        orientation: String? = null,
        size: String? = null,
        color: String? = null,
        locale: String? = null
    ): PagingSource<Int, ItemPhoto>  

}
