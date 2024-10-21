package com.hnk.wallpaper.ui.main;

import com.hnk.wallpaper.data.repository.download.DownloadRepo;
import com.hnk.wallpaper.data.repository.wallpaper.WallpaperRepo;
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
public final class MainVM_Factory implements Factory<MainVM> {
  private final Provider<WallpaperRepo> wallpaperRepoProvider;

  private final Provider<DownloadRepo> downloadRepoProvider;

  public MainVM_Factory(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<DownloadRepo> downloadRepoProvider) {
    this.wallpaperRepoProvider = wallpaperRepoProvider;
    this.downloadRepoProvider = downloadRepoProvider;
  }

  @Override
  public MainVM get() {
    return newInstance(wallpaperRepoProvider.get(), downloadRepoProvider.get());
  }

  public static MainVM_Factory create(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<DownloadRepo> downloadRepoProvider) {
    return new MainVM_Factory(wallpaperRepoProvider, downloadRepoProvider);
  }

  public static MainVM newInstance(WallpaperRepo wallpaperRepo, DownloadRepo downloadRepo) {
    return new MainVM(wallpaperRepo, downloadRepo);
  }
}
