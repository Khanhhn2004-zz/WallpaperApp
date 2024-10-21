package com.hnk.wallpaper.ui.home.featured.showmore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.data.repository.search.SearchRepo
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ShowMoreVM @Inject constructor(
    private val wallpaperRepo: WallpaperRepo,
    private val searchRepo: SearchRepo
) : BaseViewModel() {
    private var _listWallpaperLiveData: MutableLiveData<ResultState<PagingData<ItemPhoto>?>> =
        MutableLiveData<ResultState<PagingData<ItemPhoto>?>>()
    val photos: LiveData<ResultState<PagingData<ItemPhoto>?>>
        get() = _listWallpaperLiveData


    private val _searchResults = MutableLiveData<ResultState<PagingData<ItemPhoto>?>>()
    val searchResults: LiveData<ResultState<PagingData<ItemPhoto>?>>
        get() = _searchResults

    fun getCuratedPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            Pager(
                config = PagingConfig(
                    pageSize = Constant.PAGE_SIZE,
                    enablePlaceholders = false,
                    prefetchDistance = 5,
                    initialLoadSize = Constant.PAGE_SIZE
                )
            ) {
                wallpaperRepo.getCuratedPhotosPagingSource()
            }.flow
                .cachedIn(viewModelScope)
                .collectLatest { listWallpaper ->
                    _listWallpaperLiveData.postValue(ResultState.Success(listWallpaper))
                }
        }
    }


    fun searchPhotos(query: String) = viewModelScope.launch(Dispatchers.IO) {
        Pager(
            config = PagingConfig(
                pageSize = Constant.PAGE_SIZE,
                enablePlaceholders = false,
                prefetchDistance = 5,
                initialLoadSize = 15
            )
        ) {
            searchRepo.searchPhotos(query)
        }.flow
            .cachedIn(viewModelScope)
            .collectLatest { listWallpaper ->
                _searchResults.postValue(ResultState.Success(listWallpaper))
            }
    }
}