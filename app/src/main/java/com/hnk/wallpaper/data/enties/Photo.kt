package com.hnk.wallpaper.data.enties

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hnk.wallpaper.data.model.ItemPhoto

/**
 * Represents a photo entity that is stored in the local database and retrieved from the Pixel API.
 *
 * @property id The unique identifier of the photo.
 * @property width The width of the photo in pixels.
 * @property height The height of the photo in pixels.
 * @property url The URL to the photo's page on the Pixel platform.
 * @property photographer The name of the photographer who took the photo.
 * @property photographerUrl The URL to the photographer's profile on the Pixel platform.
 * @property photographerId The unique identifier of the photographer.
 * @property avgColor The average color of the photo, typically used for color-coding or background purposes.
 * @property src An object containing various URLs for different sizes of the photo.
 * @property liked A boolean indicating whether the photo has been marked as liked by the user.
 * @property alt A textual description of the photo, often used for accessibility or as an alternative text.
 */
data class Photo(
    @PrimaryKey
    @SerializedName("id") val id: Long?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("url") val url: String?,
    @SerializedName("photographer") val photographer: String?,
    @SerializedName("photographer_url") val photographerUrl: String?,
    @SerializedName("photographer_id") val photographerId: Int?,
    @SerializedName("avg_color") val avgColor: String?,
    @SerializedName("src") val src: Src?,
    @SerializedName("liked") var liked: Boolean?,
    @SerializedName("alt") val alt: String?,
)

fun Photo.toPhotoEntity() = ItemPhoto(id,width, height, url, photographer, photographerUrl, photographerId, avgColor, src, liked, alt,null)
