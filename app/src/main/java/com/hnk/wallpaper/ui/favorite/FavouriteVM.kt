package com.hnk.wallpaper.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.data.model.ItemFavorite
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo
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
class FavouriteVM @Inject constructor(
    private val favoriteRepo: FavoriteRepo
) : BaseViewModel() {

    private val _favoriteLiveData: MutableLiveData<ResultState<List<ItemFavorite>>> =
        MutableLiveData<ResultState<List<ItemFavorite>>>()

    val favoriteLiveData: LiveData<ResultState<List<ItemFavorite>>>
        get() = _favoriteLiveData

    fun getAllFavorite() = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepo.getAllItemFavorite()
            .catch {
                it.printStackTrace()
                _favoriteLiveData.postValue(ResultState.Error(it))
            }
            .collectLatest {
                _favoriteLiveData.postValue(ResultState.Success(it))
            }
    }

    fun removeFavorite(downloadId: Int) = viewModelScope.launch(Dispatchers.IO) {
        favoriteRepo.deleteByDownloadId(downloadId)
            .catch { it.printStackTrace() }
            .collectLatest {}
    }
}
