package com.hnk.wallpaper.ui.home.creative

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.data.model.Creative
import com.hnk.wallpaper.data.repository.creative.CreativeRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreativeVM @Inject constructor(private val creativeRepo: CreativeRepo) : BaseViewModel() {
    private val _creativeLiveData: MutableLiveData<ResultState<List<Creative>>> =
        MutableLiveData<ResultState<List<Creative>>>()

    val creativeLiveData: LiveData<ResultState<List<Creative>>>
        get() = _creativeLiveData


    fun addCreative(uri: String, url: String,avgColor: String) = viewModelScope.launch(Dispatchers.IO) {
        creativeRepo.insert(Creative(photoUrl = url, photoUri = uri,avgColor = avgColor))
            .catch { it.printStackTrace() }
            .collectLatest {
            }
    }
    fun getAllCreative() = viewModelScope.launch(Dispatchers.IO) {
        creativeRepo.getAllCreative()
            .catch { it.printStackTrace() }
            .collectLatest {
                _creativeLiveData.postValue(ResultState.Success(it))
            }
    }
    fun deleteCreative(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        creativeRepo.deleteById(id)
            .catch { it.printStackTrace() }
            .collectLatest {
            }
    }
    fun getAverageColorFromUri(uri: Uri, callback: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val averageColor = creativeRepo.getAverageColorFromUri(uri)
            val averageColorHex = String.format("#%06X", 0xFFFFFF and averageColor)
            callback(averageColorHex) // Gọi callback với màu trung bình
        }
    }
}