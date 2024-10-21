package com.hnk.wallpaper.di

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.local.room.AppDatabase
import com.hnk.wallpaper.data.local.room.CollectionDao
import com.hnk.wallpaper.data.local.room.CreativeDao
import com.hnk.wallpaper.data.local.room.DownloadDao
import com.hnk.wallpaper.data.local.room.FavoriteDao
import com.hnk.wallpaper.data.local.room.RecentDao
import com.hnk.wallpaper.data.local.room.WallpaperDao
import com.hnk.wallpaper.data.repository.collections.CollectionRepo
import com.hnk.wallpaper.data.repository.collections.CollectionRepoImpl
import com.hnk.wallpaper.data.repository.creative.CreativeRepo
import com.hnk.wallpaper.data.repository.creative.CreativeRepoImpl
import com.hnk.wallpaper.data.repository.download.DownloadRepo
import com.hnk.wallpaper.data.repository.download.DownloadRepoImpl
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepoImpl
import com.hnk.wallpaper.data.repository.intro.IntroCreativeRepo
import com.hnk.wallpaper.data.repository.intro.IntroCreativeRepoImpl
import com.hnk.wallpaper.data.repository.intro.IntroRepo
import com.hnk.wallpaper.data.repository.intro.IntroRepoImpl
import com.hnk.wallpaper.data.repository.language.LanguageRepo
import com.hnk.wallpaper.data.repository.language.LanguageRepoImpl
import com.hnk.wallpaper.data.repository.photo.PhotoRepo
import com.hnk.wallpaper.data.repository.photo.PhotoRepoImpl
import com.hnk.wallpaper.data.repository.recent.RecentRepo
import com.hnk.wallpaper.data.repository.recent.RecentRepoImpl
import com.hnk.wallpaper.data.repository.search.SearchRepo
import com.hnk.wallpaper.data.repository.search.SearchRepoImpl
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module providing dependencies for the application.
 * <p>
 * This module provides various dependencies for the application, including SharedPreferences,
 * repositories, database, DAOs, and other utility classes. Dependencies are provided as singletons.
 * <p>
 * The module is annotated with {@link Module} and {@link InstallIn} to specify that the provided
 * dependencies should be installed in the {@link SingletonComponent}.
 * <p>
 * Dependencies provided by this module include:
 * - {@link SharedPreferences} for managing application preferences.
 * - Repositories such as {@link LanguageRepo}, {@link IntroRepo}, {@link ConversationRepo},
 *   {@link DataMessageRepo}, {@link ThemesRepo}, {@link MessageRepo}, {@link WallpaperRepo},
 *   {@link ColorRepo}, {@link GalleryRepo}, and {@link ContactRepo}.
 * - {@link ChatDatabase} for database operations.
 * - DAOs such as {@link ConversationDao} and {@link MessageDao}.
 * <p>
 * All dependencies are provided as singletons to ensure efficient resource management and
 * consistent behavior across the application.
 * <p>
 * This class is intended to be used with Dagger or a similar dependency injection framework.
 *
 * @see Module
 * @see InstallIn
 * @see SingletonComponent
 *
 * @author KhanhHN
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    /**
     * Provides a singleton instance of SharedPreferences.
     * <p>
     * This method provides a singleton instance of SharedPreferences for managing application preferences.
     * It uses {@link PreferenceManager#getDefaultSharedPreferences(Context)} to obtain the default
     * SharedPreferences instance associated with the provided application context.
     * <p>
     * The provided SharedPreferences instance is annotated with {@link Singleton} to ensure that only
     * one instance is created and shared throughout the application.
     *
     * @param context The application context.
     * @return A singleton instance of SharedPreferences.
     * @author KhanhHN
     */
    @Provides
    @Singleton
    fun provideSharedPreference(context: Application?): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    /**
     * Provides a singleton instance of IntroRepo.
     * <p>
     * This method provides a singleton instance of {@link IntroRepo} for managing introduction-related
     * operations in the application. It returns an instance of {@link IntroRepoImpl}, which is
     * initialized with the provided application context.
     * <p>
     * The provided IntroRepo instance is annotated with {@link Singleton} to ensure that only one
     * instance is created and shared throughout the application.
     *
     * @param application The application context.
     * @return A singleton instance of IntroRepo.
     * @author KhanhHN
     */
    @Provides
    @Singleton
    fun provideIntroRepo(application: Application): IntroRepo {
        return IntroRepoImpl()
    }

    @Provides
    @Singleton
    fun provideIntroCreativeRepo(application: Application): IntroCreativeRepo {
        return IntroCreativeRepoImpl(application)
    }

    @Provides
    @Singleton
    fun provideLanguageRepo(application: Application): LanguageRepo {
        return LanguageRepoImpl(application)
    }

    @Provides
    @Singleton
    fun providePhotoRepo(pexelsApi: PexelsApi): PhotoRepo {
        return PhotoRepoImpl(pexelsApi)
    }

    @Provides
    @Singleton
    fun provideCollectionRepo(
        db: CollectionDao,
        pexelsApi: PexelsApi,
        application: Application
    ): CollectionRepo {
        return CollectionRepoImpl(pexelsApi, db, application)
    }

    @Provides
    @Singleton
    fun provideWallpaperRepo(
        pexelsApi: PexelsApi,
        application: Application,
        db: WallpaperDao
    ): WallpaperRepo {
        return WallpaperRepoImpl(pexelsApi, application, db)
    }

    @Provides
    @Singleton
    fun provideSearchRepo(pexelsApi: PexelsApi): SearchRepo {
        return SearchRepoImpl(pexelsApi)
    }

    @Provides
    @Singleton
    fun provideDownloadRepo(db: DownloadDao, application: Application): DownloadRepo {
        return DownloadRepoImpl(db, application)
    }

    @Provides
    @Singleton
    fun provideRecentRepo(db: RecentDao): RecentRepo {
        return RecentRepoImpl(db)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepo(db: FavoriteDao): FavoriteRepo {
        return FavoriteRepoImpl(db)
    }

    @Provides
    @Singleton
    fun provideCreativeRepo(db: CreativeDao, application: Application): CreativeRepo {
        return CreativeRepoImpl(db, application)
    }

    @Provides
    @Singleton
    fun provideDownloadDao(db: AppDatabase): DownloadDao {
        return db.downloadDao()
    }

    @Provides
    @Singleton
    fun provideRecentDao(db: AppDatabase): RecentDao {
        return db.recentDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao {
        return db.favoriteDao()
    }

    @Provides
    @Singleton
    fun provideCollectionDao(db: AppDatabase): CollectionDao {
        return db.collectionDao()
    }

    @Provides
    @Singleton
    fun provideCreativeDao(db: AppDatabase): CreativeDao {
        return db.creativeDao()
    }

    @Provides
    @Singleton
    fun provideWallpaperDao(db: AppDatabase): WallpaperDao {
        return db.wallpaperDao()
    }

    @Provides
    @Singleton
    fun appDatabase(context: Application) =
        Room.databaseBuilder(
            context, AppDatabase::class.java, AppDatabase.DATABASE_NAME
        ).build()
}