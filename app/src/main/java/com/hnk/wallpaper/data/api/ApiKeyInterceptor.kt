package com.hnk.wallpaper.data.api

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 * Interceptor to add API key to every request.
 *
 * This interceptor attaches an "Authorization" header to each request.
 */
class ApiKeyInterceptor(private val apiKeyManager: ApiKeyManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        var request = originalRequest.newBuilder()
            .addHeader("Authorization", apiKeyManager.getCurrentKey()) // Gắn API key
            .build()

        var response = chain.proceed(request)

        when (response.code) {
            401, 429 -> {
                response.close()

                apiKeyManager.switchKey()

                request = originalRequest.newBuilder()
                    .addHeader("Authorization", apiKeyManager.getCurrentKey()) // Gắn API key mới
                    .build()

                response = chain.proceed(request)
            }
        }
        return response
    }
}

