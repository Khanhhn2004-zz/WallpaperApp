package com.hnk.wallpaper.common

/**
 * This object holds constant values used throughout the application.
 */
object Constant {

    val API_KEYS = listOf(
        "49k0JOQabg5bWKnW6NRwECzB4bHhPQzH5eGd4LulkacdEwQWTPldKBDp",
        "P4hTxHpi03MTUxJoU55j2k1d87RWgBRAlb01qfTmStoY3q0DAybczgxm",
        "ySF61bFS6Vwq5EEotC5gtFfupvygCx0HuVKccMP96jXzBp358iHcD9VK",
        "kqACl8S5ErNaO9wANK1psNZz4GVZJkmGsCmN3nA2sFPPcUhl9w6SyqIg",
        "xTVHfMNNZgA5lL8cMKkLJR9RJ3EaP8Ewypto8ciuU1qr0dhjm8lYKR4v",
        "6pxj4kSCtwI6izgAQlCtQimMGA21bjOfrZfe3YBv5gbFTxY7f0NW4feD",
        "NmIrP9lhci0pCSBJQFUuZry4kVBN0Z8EYCAOJ0NAnvQhphYZKJCNEJid",
        "RK23Rus84QL8K5GxRpmq6K2Crlh6LKsVuQs4UPpkhINqgrN0MQfXMq2G",
        "h18HF5CMSdOliFsLXZN8jdKWR3dOGXbvXr9PTO6TL49AecqSUU8ZwUw9",
        "9EXl3f3R2t9IBsUztzurWCjTwdWoOvLAw95PM5K2uYwqHlWR2VMYG0cw",
        "qduqbjZMSlKFYFWLAKxXQrU4iToyjntbO9pTovCyuJZ0JJmGxEOpF7Xt",
        "CLrYrOAOrIdeSWHB51Qdzemjmise2d2JosaDkMiJhyCi4ufxZdLQjJfF",
        "MgXpIS9gxR4y43xxGQ82jVbcU2mA3UlsFtrMyVZyhKyUNFQFuhlfyZK1",
        "jAsvpS8c8FqDAIOGk9BR6Cc6pmTGEsaZnlI2kF2JnDt59pzBP5mpTamm",
        "ulfQdfFLQisjgQv4JIse0MWq2qA6aDMWYAfL1HJLOefW9NelgcTmsb59",
        "Fanzi4h4cRPznWvNSHWcj6eEfpkRQQUHcgjQSvD3PVE9XrMsjpRkNhcz"
    )

    // Base URL for the Pexels API
    const val BASE_URL = "https://api.pexels.com/"

    // Size limits for various configurations
    const val MAX_SIZE = 22
    const val MIN_SIZE = 8

    // Paging configuration
    const val PAGE_SIZE = 16
    const val PAGE_START = 1

    // Other keys and constants
    const val KEY_LANGUAGE = "KEY_LANGUAGE"
    const val KEY_ID_WALLPAPER = "KEY_ID_WALLPAPER"
    const val KEY_URL_WALLPAPER = "KEY_URL_WALLPAPER"
    const val KEY_AVG_COLOR_WALLPAPER = "KEY_AVG_COLOR_WALLPAPER"
    const val KEY_URI_WALLPAPER = "KEY_URI_WALLPAPER"
    const val KEY_ID_COLLECTION = "KEY_ID_COLLECTION"
    const val KEY_DESCRIPTION_COLLECTION = "KEY_DESCRIPTION_COLLECTION"
    const val KEY_TITLE_COLLECTION = "KEY_TITLE_COLLECTION"
    const val KEY_COUNT_WALLPAPER = "KEY_COUNT_WALLPAPER"
    const val KEY_TITLE_SHOW_MORE = "KEY_TITLE_SHOW_MORE"
    const val KEY_SHOW_ALL_PHOTO = "KEY_SHOW_ALL_PHOTO"
    const val KEY_GET_COLLECTION = "KEY_GET_COLLECTION"

    //Keys event
    const val EVENT_DOWNLOAD_COMPLETE = 12
    const val EVENT_DOWNLOAD_FAILED = 13
    const val EVENT_WALLPAPER_SET_SUCCESS = 14
    const val EVENT_NETWORK_STATUS = 15

    //Key theme
    const val NIGHT_MODE = "NIGHT_MODE"
    const val DARK_MODE = "DARK_MODE"

    //Key delay
    const val DELAY_SPLASH = 500L
    const val DELAY_CONTENT = 500L

    //Key fist show screen
    const val KEY_SHOW_INTRO = "KEY_SHOW_INTRO"
    const val KEY_SHOW_LANGUAGE_START_SCREEN = "key_show_language_start_screen"
    const val KEY_SHOW_INTRO_CREATIVE = "key_show_intro_creative"

    //
    const val TRENDING_WALLPAPER ="Trending"
    const val CURATED_WALLPAPER = "Curated Wallpaper"
    const val FEATUERS_WALLPAPER ="Featured"
    const val BANNER_WALLPAPER ="Banner"

}
