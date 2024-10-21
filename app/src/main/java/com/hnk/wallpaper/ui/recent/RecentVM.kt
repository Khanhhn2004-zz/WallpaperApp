package com.hnk.wallpaper.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.data.model.Recent
import com.hnk.wallpaper.data.repository.recent.RecentRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentVM @Inject constructor(
    private val recentRepo: RecentRepo
) : BaseViewModel() {

    private val _recentLiveData: MutableLiveData<List<Recent>> =
        MutableLiveData<List<Recent>>()

    val recentLiveData: LiveData<List<Recent>>
        get() = _recentLiveData

    fun getAllDownload() = viewModelScope.launch(Dispatchers.IO) {
        recentRepo.getAllRecent()
            .catch { it.printStackTrace() }
            .collectLatest {
                _recentLiveData.postValue(it.reversed())
            }
    }
}