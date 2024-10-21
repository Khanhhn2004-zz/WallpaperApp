package com.hnk.wallpaper.utils

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.view.inputmethod.InputMethodManager
import androidx.core.content.FileProvider
import com.hnk.wallpaper.service.receiver.DownloadReceiver
import timber.log.Timber
import java.io.File
import android.graphics.Color
import android.view.View


val receiver = DownloadReceiver()

fun Context.downloadWallpaper(url: String, title: String): Long {
    val imageUri = Uri.parse(url)
    if (imageUri.scheme.isNullOrEmpty() || imageUri.host.isNullOrEmpty()) {
        return -1
    }

    val file = File(
        getExternalFilesDir(Environment.DIRECTORY_PICTURES),
        "Download_Wallpaper_${System.currentTimeMillis()}.jpg"
    )
    val fileUri = Uri.fromFile(file)

    val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    val request = DownloadManager.Request(imageUri).apply {
        setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE
        )
            .setMimeType("image/*")
            .setAllowedOverRoaming(true)
            .setTitle(title)
            .setDescription("Downloading image from $url")
            .setDestinationUri(fileUri)
    }

    val intentFilter = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        registerReceiver(receiver, intentFilter, Context.RECEIVER_EXPORTED)
    } else {
        registerReceiver(receiver, intentFilter)
    }
    return downloadManager.enqueue(request)
}

fun Context.getDownloadedFileUri(downloadId: Long): Uri? {
    try {
        val downloadManager =
            getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val query = DownloadManager.Query().setFilterById(downloadId)
        val cursor = downloadManager.query(query)
        if (cursor.moveToFirst()) {
            val uriIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI)
            cursor.getString(uriIndex)?.let { uriString ->

                return Uri.parse(uriString)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun Context.shareContent(content: String) {
    if (content.startsWith("http")) {
        shareUrl(content)
    } else {
        shareImage(content)
    }
}

private fun Context.shareImage(uriString: String) {
    val uri = Uri.parse(uriString)
    val file = File(uri.path ?: return)

    val fileUri = FileProvider.getUriForFile(
        this,
        "${packageName}.fileprovider",
        file
    )

    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_STREAM, fileUri)
        type = "image/*"
        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
    }

    val chooser = Intent.createChooser(shareIntent, "Share Image")
    startActivity(chooser)
}

private fun Context.shareUrl(url: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, url)
        type = "text/plain"
    }

    val chooser = Intent.createChooser(shareIntent, "Share URL")
    startActivity(chooser)
}

fun Activity.hideKeyboard() {
    if (currentFocus != null) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            0
        )
    }
}
fun Activity.showKeyboard(view: View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
        view,
        InputMethodManager.SHOW_IMPLICIT
    )
}


fun Uri.toBitmap(context: Context): Bitmap? {
    return try {
        val inputStream = context.contentResolver.openInputStream(this)
        BitmapFactory.decodeStream(inputStream)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


fun Bitmap.getAverageColor(): Int {
    var red = 0
    var green = 0
    var blue = 0
    var pixelCount = 0

    for (x in 0 until width) {
        for (y in 0 until height) {
            val pixel = getPixel(x, y)
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
