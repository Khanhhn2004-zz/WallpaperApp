package com.hnk.wallpaper.ui.home.featured

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeaturedVM @Inject constructor(
    private val wallpaperRepo: WallpaperRepo
) : BaseViewModel() {

    private var _listBannerLiveData: MutableLiveData<ResultState<List<ItemPhoto>?>> =
        MutableLiveData<ResultState<List<ItemPhoto>?>>()

    val listBannerLiveData: LiveData<ResultState<List<ItemPhoto>?>>
        get() = _listBannerLiveData

    private var _listPhotoTrendingLiveData: MutableLiveData<ResultState<List<ItemPhoto>?>> =
        MutableLiveData<ResultState<List<ItemPhoto>?>>()
    val listPhotoTrendingLiveData: LiveData<ResultState<List<ItemPhoto>?>>
        get() = _listPhotoTrendingLiveData

    private var _listPhotoFeaturedLiveData: MutableLiveData<ResultState<List<ItemPhoto>?>> =
        MutableLiveData<ResultState<List<ItemPhoto>?>>()

    val listPhotoFeaturedLiveData: LiveData<ResultState<List<ItemPhoto>?>>
        get() = _listPhotoFeaturedLiveData

    private var _listCuratedLiveData: MutableLiveData<ResultState<List<ItemPhoto>?>> =
        MutableLiveData<ResultState<List<ItemPhoto>?>>()
    val listCuratedLiveData: LiveData<ResultState<List<ItemPhoto>?>>
        get() = _listCuratedLiveData


    fun getBannerWallpaper() = viewModelScope.launch(Dispatchers.IO) {
        wallpaperRepo.getBannerPhotos(Constant.PAGE_START, 8)
            .catch {
                it.printStackTrace()
                _listBannerLiveData.postValue(ResultState.Error(it))
            }
            .collectLatest {
                _listBannerLiveData.postValue(ResultState.Success(it))
            }
    }

    fun getCuratedWallpaper() = viewModelScope.launch {
        wallpaperRepo.getCuratedPhotos(
            Constant.PAGE_START, Constant.PAGE_SIZE
        ).catch {
            it.printStackTrace()
            _listCuratedLiveData.postValue(ResultState.Error(it))
        }.collectLatest {
            _listCuratedLiveData.postValue(ResultState.Success(it))
        }
    }

    fun getPhotoTrending() = viewModelScope.launch(Dispatchers.IO) {
        wallpaperRepo.getTrendingPhotos(
            Constant.TRENDING_WALLPAPER,
            page = Constant.PAGE_START,
            perPage = Constant.PAGE_SIZE
        ).catch {
            it.printStackTrace()
            _listPhotoTrendingLiveData.postValue(ResultState.Error(it))
        }
            .collectLatest {
                _listPhotoTrendingLiveData.postValue(ResultState.Success(it))
            }
    }

    fun getPhotoFeatured() = viewModelScope.launch(Dispatchers.IO) {
        wallpaperRepo.getFeaturedPhotos(
            Constant.FEATUERS_WALLPAPER,
            page = Constant.PAGE_START,
            perPage = Constant.PAGE_SIZE
        )
            .catch {
                it.printStackTrace()
                _listPhotoFeaturedLiveData.postValue(ResultState.Error(it))
            }
            .collectLatest {
                _listPhotoFeaturedLiveData.postValue(ResultState.Success(it))
            }
    }
}