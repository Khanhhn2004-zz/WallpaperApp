package com.hnk.wallpaper.data.api


class ApiKeyManager(private val apiKeys: List<String>) {
    private var currentKeyIndex = 0

    fun getCurrentKey(): String {
        return apiKeys[currentKeyIndex]
    }

    fun switchKey() {
        currentKeyIndex = (currentKeyIndex + 1) % apiKeys.size
    }
}
