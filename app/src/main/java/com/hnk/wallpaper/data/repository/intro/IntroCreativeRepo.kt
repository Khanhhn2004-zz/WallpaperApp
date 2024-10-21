package com.hnk.wallpaper.data.repository.intro

import com.hnk.wallpaper.data.model.Intro
import kotlinx.coroutines.flow.Flow

interface IntroCreativeRepo {
    /**
     * Fetches all introductory data.
     *
     * @return A Flow that emits a list of Intro objects.
     */
    suspend fun getAllIntro(): Flow<List<Intro>>

}