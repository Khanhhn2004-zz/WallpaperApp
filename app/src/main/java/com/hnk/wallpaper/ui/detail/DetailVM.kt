package com.hnk.wallpaper.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.model.ItemFavorite
import com.hnk.wallpaper.data.model.Recent
import com.hnk.wallpaper.data.repository.download.DownloadRepo
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo
import com.hnk.wallpaper.data.repository.recent.RecentRepo
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(
    private val recentRepo: RecentRepo,
    private val favoriteRepo: FavoriteRepo,
    private val downloadRepo: DownloadRepo,
    private val wallpaperRepo: WallpaperRepo,
) : BaseViewModel() {


    private val _isDownloadSuccessful = MutableLiveData<Boolean>()
    val isDownloadSuccessful: LiveData<Boolean> get() = _isDownloadSuccessful

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    private val _isSuccess = MutableLiveData<Event<Boolean>>()
    val isSuccess: LiveData<Event<Boolean>> get() = _isSuccess

    private val _idDownloadAddedMutableLiveData = MutableLiveData<Int>()
    val idDownloadAddedLiveData: LiveData<Int> get() = _idDownloadAddedMutableLiveData

    private val _uriDownloadMutableLiveData = MutableLiveData<String>()
    val uriDownloadLiveData: LiveData<String> get() = _uriDownloadMutableLiveData

    fun addRecent(url: String, avgColor: String) = viewModelScope.launch(Dispatchers.IO) {
        recentRepo.insert(Recent(photoUrl = url, avgColor = avgColor))
            .catch { it.printStackTrace() }
            .collectLatest {}
    }


    private fun removeFavorite(downloadId: Int) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepo.deleteByDownloadId(downloadId)
            .catch { it.printStackTrace() }
            .collectLatest {}
    }

    fun checkIsFavorite(downloadId: Int) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepo.isFavorite(downloadId)
            .catch { it.printStackTrace() }
            .collectLatest { result ->
                _isFavorite.postValue(result)
            }
    }

    private fun addFavorite(downloadId: Int, photoUrl: String, photoUri: String, avgColor: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val itemFavorite =
                ItemFavorite(
                    downloadId = downloadId,
                    photoUrl = photoUrl,
                    photoUri = photoUri,
                    avgColor = avgColor
                )
            favoriteRepo.insert(itemFavorite)
                .catch { it.printStackTrace() }
                .collectLatest {}
        }

    fun addDownload(uri: String, url: String, avgColor: String) =
        viewModelScope.launch(Dispatchers.IO) {
            downloadRepo.insert(ItemDownload(photoUrl = url, photoUri = uri, avgColor = avgColor))
                .catch { it.printStackTrace() }
                .collectLatest { idDownload ->
                    _idDownloadAddedMutableLiveData.postValue(idDownload.toInt())
                }
        }

    fun downloadWallpaper(url: String, title: String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.downloadWallpaper(url, title)
            .catch {
                Timber.e(it)
                _isDownloadSuccessful.postValue(false)
            }
            .collectLatest { id ->
                _isDownloadSuccessful.postValue(true)
                _idDownloadAddedMutableLiveData.postValue(id.toInt())
            }
    }

    fun getIdDownload(url: String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.getIdDownloadWithUrl(url)
            .catch { it.printStackTrace() }
            .collectLatest {
                _idDownloadAddedMutableLiveData.postValue(it)
            }
    }

    fun getUriDownload(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.getUriDownloadWithId(id)
            .catch { it.printStackTrace() }
            .collectLatest {
                _uriDownloadMutableLiveData.postValue(it)
            }
    }

    fun setFavorite(downloadId: Int, photoUrl: String, photoUri: String, avgColor: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isCurrentlyFavorite = _isFavorite.value ?: false
            if (isCurrentlyFavorite) {
                removeFavorite(downloadId)
                _isFavorite.postValue(false)
            } else {
                addFavorite(downloadId, photoUrl, photoUri, avgColor = avgColor)
                _isFavorite.postValue(true)
            }
        }
    }

    fun setWallpaperHomeScreen(photoUriString: String) = viewModelScope.launch {
        wallpaperRepo.setWallpaperHomeScreen(photoUriString)
            .catch { it.printStackTrace() }
            .collectLatest { isSuccess ->
                _isSuccess.postValue(Event(isSuccess))
            }
    }

    fun setWallpaperLockScreen(photoUriString: String) = viewModelScope.launch {
        wallpaperRepo.setWallpaperLockScreen(photoUriString)
            .catch { it.printStackTrace() }
            .collectLatest { isSuccess ->
                _isSuccess.postValue(Event(isSuccess))
            }
    }

    fun setWallpaperBoth(photoUriString: String) = viewModelScope.launch {
        wallpaperRepo.setWallpaperBoth(photoUriString)
            .catch { it.printStackTrace() }
            .collectLatest { isSuccess ->
                _isSuccess.postValue(Event(isSuccess))
            }
    }

}
