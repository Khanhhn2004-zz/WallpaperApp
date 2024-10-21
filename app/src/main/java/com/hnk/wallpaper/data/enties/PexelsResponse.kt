package com.hnk.wallpaper.data.enties
/**
 * Represents the response received from the Pixel API when fetching photos.
 *
 * @property photos The list of photos retrieved from the API.
 */
data class PexelsResponse(
    val photos: List<Photo>
)
