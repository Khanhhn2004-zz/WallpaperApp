package com.hnk.wallpaper.ui.home.collections

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.model.ItemCollection
import com.hnk.wallpaper.data.repository.collections.CollectionRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.NetworkUtils.isNetworkAvailable
import com.hnk.wallpaper.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CollectionsVM @Inject constructor(
    private val collectionRepo: CollectionRepo,
    private val application: Application
) :
    BaseViewModel() {

    private var _lisCollectionLiveData: MutableLiveData<ResultState<PagingData<ItemCollection>>> =
        MutableLiveData<ResultState<PagingData<ItemCollection>>>()
    val collectionLiveData: LiveData<ResultState<PagingData<ItemCollection>>> get() = _lisCollectionLiveData

     fun getFeaturedCollections() = viewModelScope.launch(Dispatchers.IO) {
         _lisCollectionLiveData.postValue(ResultState.Loading)
         if (!application.isNetworkAvailable()) {
             _lisCollectionLiveData.postValue(ResultState.Error(Exception("No internet connection")))
             return@launch
         }
        Pager(
            config = PagingConfig(
                pageSize = Constant.PAGE_SIZE,
                enablePlaceholders = false,
                prefetchDistance = 5,
                initialLoadSize = Constant.PAGE_SIZE
            )
        ) {
            collectionRepo.getFeaturedCollections()
        }.flow
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .catch {
                _lisCollectionLiveData.postValue(ResultState.Error(it))
            }
            .collectLatest {
                _lisCollectionLiveData.postValue(ResultState.Success(it))
            }
    }
}
