package com.hnk.wallpaper.data.enties

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the response from the API when fetching media collection data.
 *
 * @property id Unique identifier for the media collection.
 * @property media List of [Photo] objects representing the media items in the collection.
 * @property page The current page number of the results.
 * @property perPage The number of items per page in the results.
 * @property totalResults The total number of results available.
 * @property nextPage URL of the next page of results, or null if there are no more pages.
 * @property prevPage URL of the previous page of results, or null if there is no previous page.
 */
data class CollectionMediaResponse(
    @SerializedName("id") val id: String,
    @SerializedName("media") val media: List<Photo>,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("next_page") val nextPage: String?,
    @SerializedName("prev_page") val prevPage: String?
)
