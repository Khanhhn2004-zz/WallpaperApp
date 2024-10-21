package com.hnk.wallpaper.di

import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.Constant.BASE_URL
import com.hnk.wallpaper.data.api.ApiKeyInterceptor
import com.hnk.wallpaper.data.api.ApiKeyManager
import com.hnk.wallpaper.data.api.PexelsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideApiKeyManager(): ApiKeyManager {
        return ApiKeyManager(Constant.API_KEYS)
    }

    @Provides
    @Singleton
    fun provideOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(apiKeyManager))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePixelsApi(retrofit: Retrofit): PexelsApi {
        return retrofit.create(PexelsApi::class.java)
    }
}
