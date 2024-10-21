package com.hnk.wallpaper.data.repository.creative

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import com.hnk.wallpaper.data.local.room.CreativeDao
import com.hnk.wallpaper.data.model.Creative
import kotlinx.coroutines.flow.flow
import java.io.InputStream
import javax.inject.Inject

class CreativeRepoImpl @Inject constructor(
    private val creativeDao: CreativeDao,
    private val application: Application
) : CreativeRepo {
    override suspend fun insert(creative: Creative) = flow {
        emit(creativeDao.insert(creative))
    }

    override suspend fun update(creative: Creative) = flow {
        emit(creativeDao.update(creative))
    }

    override suspend fun delete(creative: Creative) = flow {
        emit(creativeDao.delete(creative))
    }

    override suspend fun deleteById(id: Int) = flow {
        emit(creativeDao.deleteById(id))
    }

    override fun getAllCreative() = creativeDao.getAllCreative()

    override suspend fun getAverageColorFromUri(uri: Uri): Int {
        val bitmap = getBitmapFromUri(uri)
        return bitmap?.let { calculateAverageColor(it) } ?: Color.BLACK
    }

    private fun getBitmapFromUri(uri: Uri): Bitmap? {
        return try {
            val inputStream: InputStream? = application.contentResolver.openInputStream(uri)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun calculateAverageColor(bitmap: Bitmap): Int {
        var red = 0
        var green = 0
        var blue = 0
        var pixelCount = 0

        for (x in 0 until bitmap.width) {
            for (y in 0 until bitmap.height) {
                val pixel = bitmap.getPixel(x, y)
                red += Color.red(pixel)
                green += Color.green(pixel)
                blue += Color.blue(pixel)
                pixelCount++
            }
        }

        red /= pixelCount
        green /= pixelCount
        blue /= pixelCount

        return Color.rgb(red, green, blue)
    }
}