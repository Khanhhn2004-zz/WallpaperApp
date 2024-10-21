package com.hnk.wallpaper.data.model

/**
 * Represents a language option within the application, typically used for localization or language selection.
 *
 * @property code The language code (e.g., "en" for English, "es" for Spanish).
 * @property name The name of the language as displayed in the application.
 * @property avatar The resource ID of the image or icon representing the language.
 * @property isSelected A boolean indicating whether the language is currently selected by the user. Defaults to false.
 */
data class Language(
    var code: String,
    var name: String,
    var avatar: Int,
    var isSelected: Boolean = false
)