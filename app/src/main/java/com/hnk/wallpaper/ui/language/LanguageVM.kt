package com.hnk.wallpaper.ui.language

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.data.model.Language
import com.hnk.wallpaper.data.repository.language.LanguageRepo
import com.hnk.wallpaper.ui.base.BaseViewModel
import com.hnk.wallpaper.ui.base.toMutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LanguageVM @Inject constructor(
    private val languageRepo: LanguageRepo
) : BaseViewModel() {

    private var _listLanguageMutableLiveData: MutableLiveData<List<Language>> = MutableLiveData()

    val listLanguage: LiveData<List<Language>>
        get() = _listLanguageMutableLiveData

    private val _selectedLanguageCode = MutableLiveData<String?>()

    private fun getValueThreadLanguageLiveData() =
        _listLanguageMutableLiveData.toMutableList { it.copy() }

    fun getAllLanguage() = viewModelScope.launch(Dispatchers.IO) {
        languageRepo.getAllLanguage()
            .collectLatest { listLanguage ->
                _listLanguageMutableLiveData.postValue(listLanguage)
            }
    }

    fun selectItemThreadLanguage(position: Int) = viewModelScope.launch(Dispatchers.IO) {
        getValueThreadLanguageLiveData()?.let { list ->
            list.forEach { it.isSelected = false }
            list[position].isSelected = true
            val selectedLanguageCode = list[position].code
            _selectedLanguageCode.postValue(selectedLanguageCode)
            _listLanguageMutableLiveData.postValue(list)

        }
    }

    fun checkLanguageSelected() = getValueThreadLanguageLiveData()?.firstOrNull { it.isSelected }?.code
}
