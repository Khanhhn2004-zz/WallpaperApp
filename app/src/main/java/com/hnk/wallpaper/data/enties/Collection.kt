package com.hnk.wallpaper.data.enties

import com.google.gson.annotations.SerializedName
import com.hnk.wallpaper.data.model.ItemCollection

/**
 * Represents a collection of media items, such as photos, within the Pixel platform.
 *
 * @property id The unique identifier of the collection.
 * @property title The title of the collection.
 * @property description A brief description of the collection, which may be null if not provided.
 * @property isPrivate A boolean indicating whether the collection is private (true) or public (false).
 * @property mediaCount The total number of media items in the collection, including photos and other types of media.
 * @property photosCount The total number of photos in the collection.
 */
data class Collection(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("media_count") val mediaCount: Int,
    @SerializedName("photos_count") val photosCount: Int
)

fun Collection.toCollectionEntity() = ItemCollection(id = id, title = title, description = description, isPrivate = isPrivate, mediaCount = mediaCount, photosCount = photosCount, cover = null)

