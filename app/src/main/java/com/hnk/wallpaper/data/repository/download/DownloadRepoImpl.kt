package com.hnk.wallpaper.data.repository.download

import android.app.Application
import android.net.Uri
import android.widget.Toast
import com.hnk.wallpaper.data.local.room.DownloadDao
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.utils.downloadWallpaper
import com.hnk.wallpaper.utils.getDownloadedFileUri
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.File
import javax.inject.Inject

/**
 * Implementation of the DownloadRepo interface.
 * This class handles database operations related to downloads and the actual downloading of wallpapers.
 *
 * @property downloadDao Data Access Object for download operations.
 * @property application The Application instance, used for accessing context-dependent utilities.
 */
class DownloadRepoImpl @Inject constructor(
    private val downloadDao: DownloadDao,
    private val application: Application
) : DownloadRepo {

    override suspend fun insert(photo: ItemDownload) = flow {
        emit(downloadDao.insert(photo))
    }

    override suspend fun update(photo: ItemDownload) = flow {
        emit(downloadDao.update(photo))
    }

    override suspend fun delete(photo: ItemDownload) = flow {
        emit(downloadDao.delete(photo))
    }

    override suspend fun deleteById(id: Int) = flow {
        val uriString: String = downloadDao.getUriDownloadWithId(id)
        val fileUri: Uri? =  Uri.parse(uriString)
        emit(downloadDao.deleteById(id))
        fileUri?.let { uri ->
            deleteFileFromStorage(uri)
        }
    }

    private fun deleteFileFromStorage(uri: Uri) {
        val file = File(uri.path ?: "")
        if (file.exists()) {
            val deleted = file.delete()
            if (deleted) {
                Timber.d("Đã xóa tệp: $deleted, đường dẫn: ${file.path}")
            } else {
                Toast.makeText(application, "Không thể xóa tệp: ${file.path}", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(application, "Tệp không tồn tại: ${file.path}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getAllDownload(): Flow<List<ItemDownload>> = downloadDao.getAllDownload()
    override fun getDownloadById(id: Int): Flow<ItemDownload?> = flow {
        emit(downloadDao.getDownloadById(id))
    }

    override fun getDownloadByUrl(url: String) = flow {
        emit(downloadDao.getDownloadByUrl(url))
    }

    override fun getAllFavoriteDownloads() = downloadDao.getAllFavoriteDownloads()

    override suspend fun downloadWallpaper(url: String, title: String): Flow<Long> = flow {
        emit(
            application.downloadWallpaper(url, title)
        )
    }

    override suspend fun getDownloadedFileUri(downloadId: Long) = flow {
        emit(application.getDownloadedFileUri(downloadId))
    }

    override fun getDownloadsByIds(downloadIds: List<Int>) =
        downloadDao.getDownloadsByIds(downloadIds)

    override suspend fun getIdDownloadWithUrl(url: String) = flow {
        emit(downloadDao.getIdDownload(url))
    }

    override suspend fun getUriDownloadWithId(id: Int) = flow {
        emit(downloadDao.getUriDownloadWithId(id))
    }

    override suspend fun getIdDownloadWithUri(uri: String) = flow {
        emit(downloadDao.getIdDownloadWithPhotoUri(uri))
    }
}