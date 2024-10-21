package com.hnk.wallpaper.ui.intro

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.data.model.Intro
import com.hnk.wallpaper.data.repository.intro.IntroRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroVM @Inject constructor(
    private val introRepo: IntroRepo
) : BaseViewModel() {
    private var _listIntroMutableLiveData: MutableLiveData<List<Intro>> = MutableLiveData()

    val listIntro: LiveData<List<Intro>>
        get() = _listIntroMutableLiveData

    fun getAllIntro(listContent: List<String>, listTitle: List<String>) =
        viewModelScope.launch(Dispatchers.IO) {
            introRepo.getAllIntro(listContent = listContent, listTitle = listTitle)
                .collectLatest { listIntro ->
                    _listIntroMutableLiveData.postValue(listIntro)
                }
        }
}