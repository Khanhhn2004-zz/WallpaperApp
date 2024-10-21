package com.hnk.wallpaper.ui.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.data.model.Intro
import com.hnk.wallpaper.data.repository.intro.IntroCreativeRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroCreateWallppaperVM @Inject constructor(
    private val introCreateRepo: IntroCreativeRepo
) : BaseViewModel() {
    private var _listIntroMutableLiveData: MutableLiveData<List<Intro>> = MutableLiveData()

    val listIntro: LiveData<List<Intro>>
        get() = _listIntroMutableLiveData

    fun getAllIntro() = viewModelScope.launch(Dispatchers.IO) {
        introCreateRepo.getAllIntro()
            .collectLatest { listIntro ->
                _listIntroMutableLiveData.postValue(listIntro)
            }
    }
}