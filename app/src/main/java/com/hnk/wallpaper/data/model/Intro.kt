package com.hnk.wallpaper.data.model

/**
 * Represents an introduction slide or screen within the application, typically used for onboarding or showcasing features.
 *
 * @property imageIntro The resource ID of the image to be displayed in the introduction.
 * @property titleIntro The title of the introduction slide, providing a brief headline or focus point.
 * @property contentIntro The content or description of the introduction slide, offering more details or explanation.
 */
data class Intro(
    val imageIntro: Int,
    val titleIntro: String,
    val contentIntro: String
)
