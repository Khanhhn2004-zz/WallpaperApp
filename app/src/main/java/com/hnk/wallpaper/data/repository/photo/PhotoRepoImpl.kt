package com.hnk.wallpaper.data.repository.photo

import com.hnk.wallpaper.data.api.PexelsApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class PhotoRepoImpl @Inject constructor(
    private val pexelsApi: PexelsApi
) : PhotoRepo {
    override fun fetchPhotoById(photoId: Long) = flow {
        val response = pexelsApi.getPhotoById(photoId)
        if (response.isSuccessful) {
            emit(response.body())
        } else {
            Timber.e("API call failed: ${response.code()} - ${response.message()}")
            emit(null)
        }
    }.catch {
        it.printStackTrace()
        emit(null)
    }
}

