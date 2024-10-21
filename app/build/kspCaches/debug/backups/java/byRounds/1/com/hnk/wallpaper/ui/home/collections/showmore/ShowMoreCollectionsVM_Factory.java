package com.hnk.wallpaper.ui.home.collections.showmore;

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
public final class ShowMoreCollectionsVM_Factory implements Factory<ShowMoreCollectionsVM> {
  private final Provider<WallpaperRepo> wallpaperRepoProvider;

  private final Provider<DownloadRepo> downloadRepoProvider;

  public ShowMoreCollectionsVM_Factory(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<DownloadRepo> downloadRepoProvider) {
    this.wallpaperRepoProvider = wallpaperRepoProvider;
    this.downloadRepoProvider = downloadRepoProvider;
  }

  @Override
  public ShowMoreCollectionsVM get() {
    return newInstance(wallpaperRepoProvider.get(), downloadRepoProvider.get());
  }

  public static ShowMoreCollectionsVM_Factory create(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<DownloadRepo> downloadRepoProvider) {
    return new ShowMoreCollectionsVM_Factory(wallpaperRepoProvider, downloadRepoProvider);
  }

  public static ShowMoreCollectionsVM newInstance(WallpaperRepo wallpaperRepo,
      DownloadRepo downloadRepo) {
    return new ShowMoreCollectionsVM(wallpaperRepo, downloadRepo);
  }
}
