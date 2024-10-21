package com.hnk.wallpaper.ui.home.featured.showmore;

import com.hnk.wallpaper.data.repository.search.SearchRepo;
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
public final class ShowMoreVM_Factory implements Factory<ShowMoreVM> {
  private final Provider<WallpaperRepo> wallpaperRepoProvider;

  private final Provider<SearchRepo> searchRepoProvider;

  public ShowMoreVM_Factory(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<SearchRepo> searchRepoProvider) {
    this.wallpaperRepoProvider = wallpaperRepoProvider;
    this.searchRepoProvider = searchRepoProvider;
  }

  @Override
  public ShowMoreVM get() {
    return newInstance(wallpaperRepoProvider.get(), searchRepoProvider.get());
  }

  public static ShowMoreVM_Factory create(Provider<WallpaperRepo> wallpaperRepoProvider,
      Provider<SearchRepo> searchRepoProvider) {
    return new ShowMoreVM_Factory(wallpaperRepoProvider, searchRepoProvider);
  }

  public static ShowMoreVM newInstance(WallpaperRepo wallpaperRepo, SearchRepo searchRepo) {
    return new ShowMoreVM(wallpaperRepo, searchRepo);
  }
}
