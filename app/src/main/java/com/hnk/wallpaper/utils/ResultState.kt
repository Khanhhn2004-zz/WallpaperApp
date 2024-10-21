package com.hnk.wallpaper.utils

sealed class ResultState<out T> {
    data object Loading : ResultState<Nothing>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val cause: Throwable, val description: String? = null) : ResultState<Nothing>()
}