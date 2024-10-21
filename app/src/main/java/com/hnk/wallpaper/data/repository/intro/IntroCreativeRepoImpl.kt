package com.hnk.wallpaper.data.repository.intro

import android.app.Application
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.data.model.Intro
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IntroCreativeRepoImpl @Inject constructor(private val application: Application) :
    IntroCreativeRepo {
    override suspend fun getAllIntro(): Flow<List<Intro>> {
        return flow {
            val listIntro: MutableList<Intro> = mutableListOf()
            val isDarkMode = (application.resources.configuration.uiMode and
                    android.content.res.Configuration.UI_MODE_NIGHT_MASK) ==
                    android.content.res.Configuration.UI_MODE_NIGHT_YES

            val listImage = if (isDarkMode) {
                listOf(
                    R.drawable.im_creative,
                    R.drawable.im_creative_2,
                    R.drawable.im_creative_3
                )
            } else {
                listOf(R.drawable.im_creative, R.drawable.im_creative_2, R.drawable.im_creative_3)
            }

            val listTitles = application.resources.getStringArray(R.array.list_intro_bottom)
            val listContents = application.resources.getStringArray(R.array.list_intro_top)
            for (index in listImage.indices) {
                val title = listTitles.getOrNull(index) ?: ""
                val content = listContents.getOrNull(index) ?: ""
                listIntro.add(Intro(listImage[index], title, content))
            }
            emit(listIntro)
        }
    }
}