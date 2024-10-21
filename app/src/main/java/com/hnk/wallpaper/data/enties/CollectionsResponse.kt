package com.hnk.wallpaper.data.enties

import com.google.gson.annotations.SerializedName

/**
 * Represents the response received when fetching a list of collections.
 *
 * @property collections The list of collections retrieved from the API.
 * @property page The current page number of the results.
 * @property perPage The number of collections returned per page.
 * @property totalResults The total number of collections available.
 * @property nextPage The URL for the next page of results, if available.
 * @property prevPage The URL for the previous page of results, if available.
 */
data class CollectionsResponse(
    @SerializedName("collections") val collections: List<Collection>,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("next_page") val nextPage: String?,
    @SerializedName("prev_page") val prevPage: String?
)