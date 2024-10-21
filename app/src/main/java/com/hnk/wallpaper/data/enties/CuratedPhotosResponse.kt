package com.hnk.wallpaper.data.enties

import com.google.gson.annotations.SerializedName

/**
 * Represents the response received when fetching curated photos.
 *
 * @property page The current page number of the results.
 * @property perPage The number of photos returned per page.
 * @property totalResults The total number of curated photos available.
 * @property photos The list of curated photos retrieved from the API.
 * @property nextPage The URL for the next page of results, if available.
 */
data class  CuratedPhotosResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("photos") val photos: List<Photo>,
    @SerializedName( "next_page") val nextPage: String?
)
