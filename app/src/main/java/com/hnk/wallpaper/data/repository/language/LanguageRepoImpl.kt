package com.hnk.wallpaper.data.repository.language

import android.app.Application
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Language
import com.hnk.wallpaper.utils.LanguageUtil.getPreLanguage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject


class LanguageRepoImpl @Inject constructor(
    private val application: Application,
) : LanguageRepo {

    override fun getAllLanguage(): Flow<List<Language>> {
        return flow {
            val selectedLanguageCode = application.getPreLanguage()
            val listLanguage: MutableList<Language> = mutableListOf()
            val listCode = listOf("en", "vi", "it", "pt", "hi", "fr")
            val listImage = listOf(
                R.drawable.eng_img,
                R.drawable.vie_img,
                R.drawable.ita_img,
                R.drawable.portugal_img,
                R.drawable.india_img,
                R.drawable.france_img
            )
            application.resources.getStringArray(R.array.list_language)
                .forEachIndexed { index, languageName ->
                    val code = listCode[index]
                    val isSelectedCode = code == selectedLanguageCode
                    if (isSelectedCode) {
                        Timber.e("KhanhHN: Current Language: $languageName")
                    }
                    listLanguage.add(
                        Language(
                            code,
                            languageName,
                            listImage[index],
                            isSelectedCode
                        )
                    )
                }
            emit(listLanguage)
        }
    }
}
