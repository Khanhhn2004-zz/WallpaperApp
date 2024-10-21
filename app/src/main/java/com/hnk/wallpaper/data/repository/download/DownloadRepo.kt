package com.hnk.wallpaper.data.repository.download

import android.net.Uri
import com.hnk.wallpaper.data.model.ItemDownload
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the Download repository.
 * This interface defines the contract for handling download-related operations
 * including inserting, updating, deleting, and retrieving downloaded items,
 * as well as downloading wallpapers.
 */
interface DownloadRepo {

    /**
     * Inserts a downloaded photo record into the database.
     *
     * @param photo The ItemDownload object representing the downloaded photo.
     * @return A Flow that emits the ID of the inserted record.
     */
    suspend fun insert(photo: ItemDownload): Flow<Long>

    /**
     * Updates an existing downloaded photo record in the database.
     *
     * @param photo The ItemDownload object with updated data.
     * @return A Flow that emits the number of rows affected by the update.
     */
    suspend fun update(photo: ItemDownload): Flow<Int>

    /**
     * Deletes a downloaded photo record from the database.
     *
     * @param photo The ItemDownload object to be deleted.
     * @return A Flow that emits the number of rows affected by the deletion.
     */
    suspend fun delete(photo: ItemDownload): Flow<Int>

    suspend fun deleteById(id: Int): Flow<Int>

    /**
     * Retrieves all downloaded photo records from the database.
     *
     * @return A Flow that emits a list of ItemDownload objects representing all downloaded photos.
     */
    fun getAllDownload(): Flow<List<ItemDownload>>

    fun getDownloadById(id: Int): Flow<ItemDownload?>

    fun getDownloadByUrl(url: String): Flow<ItemDownload?>

    /**
     * Retrieves all favorite downloaded photos from the database.
     *
     * @return A Flow that emits a list of ItemDownload objects representing all favorite downloaded photos.
     */
    fun getAllFavoriteDownloads(): Flow<List<ItemDownload>>

    /**
     * Downloads a wallpaper from the specified URL and saves it with the given title.
     *
     * @param url The URL of the wallpaper to be downloaded.
     * @param title The title to be used when saving the wallpaper.
     * @return A Flow that emits the ID of the download operation.
     */
    suspend fun downloadWallpaper(url: String, title: String): Flow<Long>

    suspend fun getDownloadedFileUri(downloadId: Long): Flow<Uri?>

    fun getDownloadsByIds(downloadIds: List<Int>): Flow<List<ItemDownload>>

    suspend fun getIdDownloadWithUri(uri: String): Flow<Int>
    suspend fun getIdDownloadWithUrl(url: String): Flow<Int>
    suspend fun getUriDownloadWithId(id: Int): Flow<String>

}
