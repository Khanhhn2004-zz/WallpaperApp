package com.hnk.wallpaper.data.repository.intro

import com.hnk.wallpaper.data.model.Intro
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining the repository for handling Intro data and user introduction state.
 */
interface IntroRepo {

    /**
     * Fetches all introductory data.
     *
     * @return A Flow that emits a list of Intro objects.
     */
    suspend fun getAllIntro(listContent: List<String>,listTitle: List<String>): Flow<List<Intro>>

}
