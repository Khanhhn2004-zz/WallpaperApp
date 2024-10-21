package com.hnk.wallpaper.ui.detail;

import com.hnk.wallpaper.data.repository.download.DownloadRepo;
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo;
import com.hnk.wallpaper.data.repository.recent.RecentRepo;
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
public final class DetailVM_Factory implements Factory<DetailVM> {
  private final Provider<RecentRepo> recentRepoProvider;

  private final Provider<FavoriteRepo> favoriteRepoProvider;

  private final Provider<DownloadRepo> downloadRepoProvider;

  private final Provider<WallpaperRepo> wallpaperRepoProvider;

  public DetailVM_Factory(Provider<RecentRepo> recentRepoProvider,
      Provider<FavoriteRepo> favoriteRepoProvider, Provider<DownloadRepo> downloadRepoProvider,
      Provider<WallpaperRepo> wallpaperRepoProvider) {
    this.recentRepoProvider = recentRepoProvider;
    this.favoriteRepoProvider = favoriteRepoProvider;
    this.downloadRepoProvider = downloadRepoProvider;
    this.wallpaperRepoProvider = wallpaperRepoProvider;
  }

  @Override
  public DetailVM get() {
    return newInstance(recentRepoProvider.get(), favoriteRepoProvider.get(), downloadRepoProvider.get(), wallpaperRepoProvider.get());
  }

  public static DetailVM_Factory create(Provider<RecentRepo> recentRepoProvider,
      Provider<FavoriteRepo> favoriteRepoProvider, Provider<DownloadRepo> downloadRepoProvider,
      Provider<WallpaperRepo> wallpaperRepoProvider) {
    return new DetailVM_Factory(recentRepoProvider, favoriteRepoProvider, downloadRepoProvider, wallpaperRepoProvider);
  }

  public static DetailVM newInstance(RecentRepo recentRepo, FavoriteRepo favoriteRepo,
      DownloadRepo downloadRepo, WallpaperRepo wallpaperRepo) {
    return new DetailVM(recentRepo, favoriteRepo, downloadRepo, wallpaperRepo);
  }
}
