package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.local.room.WallpaperDao;
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideWallpaperRepoFactory implements Factory<WallpaperRepo> {
  private final AppModule module;

  private final Provider<PexelsApi> pexelsApiProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<WallpaperDao> dbProvider;

  public AppModule_ProvideWallpaperRepoFactory(AppModule module,
      Provider<PexelsApi> pexelsApiProvider, Provider<Application> applicationProvider,
      Provider<WallpaperDao> dbProvider) {
    this.module = module;
    this.pexelsApiProvider = pexelsApiProvider;
    this.applicationProvider = applicationProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public WallpaperRepo get() {
    return provideWallpaperRepo(module, pexelsApiProvider.get(), applicationProvider.get(), dbProvider.get());
  }

  public static AppModule_ProvideWallpaperRepoFactory create(AppModule module,
      Provider<PexelsApi> pexelsApiProvider, Provider<Application> applicationProvider,
      Provider<WallpaperDao> dbProvider) {
    return new AppModule_ProvideWallpaperRepoFactory(module, pexelsApiProvider, applicationProvider, dbProvider);
  }

  public static WallpaperRepo provideWallpaperRepo(AppModule instance, PexelsApi pexelsApi,
      Application application, WallpaperDao db) {
    return Preconditions.checkNotNullFromProvides(instance.provideWallpaperRepo(pexelsApi, application, db));
  }
}
