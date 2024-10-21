package com.hnk.wallpaper.ui.home.collections.showmore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.data.repository.download.DownloadRepo
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ShowMoreCollectionsVM @Inject constructor(
    private val wallpaperRepo: WallpaperRepo,
    private val downloadRepo: DownloadRepo
) : BaseViewModel() {

    private var _listWallpaperLiveData: MutableLiveData<ResultState<PagingData<ItemPhoto>?>> =
        MutableLiveData<ResultState<PagingData<ItemPhoto>?>>()
    val photos: LiveData<ResultState<PagingData<ItemPhoto>?>>
        get() = _listWallpaperLiveData

    private val _idDownloadAddedMutableLiveData = MutableLiveData<ResultState<Int>>()
    val idDownloadAddedLiveData: LiveData<ResultState<Int>> get() = _idDownloadAddedMutableLiveData


    fun getCollectionPhotos(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Pager(
                config = PagingConfig(
                    pageSize = Constant.PAGE_SIZE,
                    enablePlaceholders = false,
                    prefetchDistance = 5,
                    initialLoadSize = Constant.PAGE_SIZE
                )
            ) {
                wallpaperRepo.getCollectionPhotos(id)
            }.flow
                .cachedIn(viewModelScope)
                .collectLatest { listWallpaper ->
                    _listWallpaperLiveData.postValue(ResultState.Success(listWallpaper))
                }
        }
    }

    fun addDownload(uri: String, url: String,avgColor:String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.insert(ItemDownload(photoUrl = url, photoUri = uri, avgColor = avgColor))
            .catch { it.printStackTrace() }
            .collectLatest { idDownload ->
                Timber.e("khanh  _idDownloadAddedMutableLiveData:$idDownload ")
                _idDownloadAddedMutableLiveData.postValue(ResultState.Success(idDownload.toInt()))
            }
    }

    fun downloadWallpaper(url: String, title: String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.downloadWallpaper(url, title)
            .catch {
                it.printStackTrace()
                _idDownloadAddedMutableLiveData.postValue(ResultState.Error(it))
            }
            .collectLatest {
                _idDownloadAddedMutableLiveData.postValue(ResultState.Success(it.toInt()))
            }
    }
}