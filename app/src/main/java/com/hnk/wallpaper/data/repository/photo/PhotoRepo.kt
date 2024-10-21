package com.hnk.wallpaper.data.repository.photo

import kotlinx.coroutines.flow.Flow
import com.hnk.wallpaper.data.enties.Photo

interface PhotoRepo {
    /**
     * Fetches a photo by its ID and returns it as a Flow.
     *
     * @param photoId The ID of the photo to fetch.
     * @return A Flow emitting the Photo object or null if not found.
     */
    fun fetchPhotoById(photoId: Long): Flow<Photo?>
}
