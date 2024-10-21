package com.hnk.wallpaper.data.enties

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Represents various URLs for different sizes and orientations of a photo.
 *
 * @property original The URL to the original size of the photo, typically the highest resolution available.
 * @property large2x The URL to a larger version of the photo with double resolution, often used for high-definition displays.
 * @property large The URL to a large-sized version of the photo, suitable for most screens.
 * @property medium The URL to a medium-sized version of the photo, balancing quality and loading speed.
 * @property small The URL to a small-sized version of the photo, ideal for mobile devices or previews.
 * @property portrait The URL to a portrait-oriented version of the photo, optimized for vertical viewing.
 * @property landscape The URL to a landscape-oriented version of the photo, optimized for horizontal viewing.
 * @property tiny The URL to a tiny-sized version of the photo, often used for thumbnails or icons.
 */
data class Src(
    @SerializedName("original") val original: String,
    @SerializedName("large2x") val large2x: String,
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("small") val small: String,
    @SerializedName("portrait") val portrait: String,
    @SerializedName("landscape") val landscape: String,
    @SerializedName("tiny") val tiny: String
)
