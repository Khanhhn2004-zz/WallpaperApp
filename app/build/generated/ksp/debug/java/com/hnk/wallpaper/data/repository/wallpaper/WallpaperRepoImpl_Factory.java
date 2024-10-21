package com.hnk.wallpaper.data.repository.wallpaper;

import android.app.Application;
import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.local.room.WallpaperDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class WallpaperRepoImpl_Factory implements Factory<WallpaperRepoImpl> {
  private final Provider<PexelsApi> mPexelsApiProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<WallpaperDao> wallpaperDaoProvider;

  public WallpaperRepoImpl_Factory(Provider<PexelsApi> mPexelsApiProvider,
      Provider<Application> applicationProvider, Provider<WallpaperDao> wallpaperDaoProvider) {
    this.mPexelsApiProvider = mPexelsApiProvider;
    this.applicationProvider = applicationProvider;
    this.wallpaperDaoProvider = wallpaperDaoProvider;
  }

  @Override
  public WallpaperRepoImpl get() {
    return newInstance(mPexelsApiProvider.get(), applicationProvider.get(), wallpaperDaoProvider.get());
  }

  public static WallpaperRepoImpl_Factory create(Provider<PexelsApi> mPexelsApiProvider,
      Provider<Application> applicationProvider, Provider<WallpaperDao> wallpaperDaoProvider) {
    return new WallpaperRepoImpl_Factory(mPexelsApiProvider, applicationProvider, wallpaperDaoProvider);
  }

  public static WallpaperRepoImpl newInstance(PexelsApi mPexelsApi, Application application,
      WallpaperDao wallpaperDao) {
    return new WallpaperRepoImpl(mPexelsApi, application, wallpaperDao);
  }
}
