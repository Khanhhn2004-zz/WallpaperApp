package com.hnk.wallpaper.data.repository.intro

import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Intro
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IntroRepoImpl @Inject constructor() : IntroRepo {
    override suspend fun getAllIntro(listContent: List<String>,listTitle: List<String>): Flow<List<Intro>> {
        return flow {
            val listIntro: MutableList<Intro> = mutableListOf()
            val listImage =
                listOf(R.drawable.im_intro_1, R.drawable.im_intro_2, R.drawable.im_intro_3)

            for (index in listImage.indices) {
                val title = listTitle.getOrNull(index) ?: ""
                val content = listContent.getOrNull(index) ?: ""
                listIntro.add(Intro(listImage[index], title, content))
            }
            emit(listIntro)
        }
    }
}
