package com.hnk.wallpaper.ui.main

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.data.repository.download.DownloadRepo
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM
@Inject constructor(
    private val wallpaperRepo: WallpaperRepo,
    private val downloadRepo: DownloadRepo,
) : BaseViewModel() {

    private val _isNightMode = MutableLiveData<Boolean>()
    val isNightMode: LiveData<Boolean> get() = _isNightMode

    init {
        val nightMode = SharedPreferenceHelper.getBoolean(Constant.NIGHT_MODE, false)
        _isNightMode.value = nightMode
        updateNightMode()
    }

    private val mIdScreenFirstShow: MutableLiveData<Int> = MutableLiveData()
    val idScreenFirstShow: LiveData<Int>
        get() = mIdScreenFirstShow

    private val _downloadLiveData: MutableLiveData<List<ItemDownload>> =
        MutableLiveData<List<ItemDownload>>()

    val downloadLiveData: LiveData<List<ItemDownload>>
        get() = _downloadLiveData


    fun getIdScreenFirstShow() = viewModelScope.launch(Dispatchers.Main) {
        val isShowLanguageStartScreen = SharedPreferenceHelper.getBoolean(
            Constant.KEY_SHOW_LANGUAGE_START_SCREEN, false
        )
        if (isShowLanguageStartScreen) {
            val isShowIntro = SharedPreferenceHelper.getBoolean(Constant.KEY_SHOW_INTRO, false)
            if (isShowIntro) {
                mIdScreenFirstShow.postValue(R.id.fragment_home)
            } else {
                mIdScreenFirstShow.postValue(R.id.fragment_intro)
            }
        } else {
            mIdScreenFirstShow.postValue(R.id.fragment_language_start)
        }
    }

    fun toggleNightMode() {
        val newNightMode = !(isNightMode.value ?: false)
        SharedPreferenceHelper.storeBoolean(Constant.NIGHT_MODE, newNightMode)
        _isNightMode.value = newNightMode
        updateNightMode()
    }

    private fun updateNightMode() {
        val nightMode = if (_isNightMode.value == true) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    fun addDownload(uri: String, url: String,avgColor:String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.insert(ItemDownload(photoUrl = url, photoUri = uri, avgColor = avgColor))
            .catch { it.printStackTrace() }
            .collectLatest {  }
    }

    fun removeItemDownloadById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.deleteById(id)
            .catch { it.printStackTrace() }
            .collectLatest {}
    }

    fun getAllDownload() = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.getAllDownload()
            .catch { it.printStackTrace() }
            .collectLatest {
                _downloadLiveData.postValue(it.reversed())
            }
    }

    fun downloadWallpaper(url: String, title: String) = viewModelScope.launch(Dispatchers.IO) {
        downloadRepo.downloadWallpaper(url, title)
            .catch { it.printStackTrace() }
            .collectLatest {}
    }
}
