package com.hnk.wallpaper.data.repository.language

import com.hnk.wallpaper.data.model.Language
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for managing language data.
 *
 * Provides methods for fetching language information.
 */
interface LanguageRepo {

    /**
     * Retrieves a flow of all available languages.
     *
     * The returned [Flow] emits a [List] of [Language] objects, representing all the languages.
     * This allows for reactive data handling and updates as the data changes.
     *
     * @return A [Flow] that emits a list of [Language] objects.
     */
    fun getAllLanguage(): Flow<List<Language>>
}
