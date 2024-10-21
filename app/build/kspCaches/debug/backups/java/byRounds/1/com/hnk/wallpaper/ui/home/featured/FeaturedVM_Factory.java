package com.hnk.wallpaper.ui.home.featured;

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
public final class FeaturedVM_Factory implements Factory<FeaturedVM> {
  private final Provider<WallpaperRepo> wallpaperRepoProvider;

  public FeaturedVM_Factory(Provider<WallpaperRepo> wallpaperRepoProvider) {
    this.wallpaperRepoProvider = wallpaperRepoProvider;
  }

  @Override
  public FeaturedVM get() {
    return newInstance(wallpaperRepoProvider.get());
  }

  public static FeaturedVM_Factory create(Provider<WallpaperRepo> wallpaperRepoProvider) {
    return new FeaturedVM_Factory(wallpaperRepoProvider);
  }

  public static FeaturedVM newInstance(WallpaperRepo wallpaperRepo) {
    return new FeaturedVM(wallpaperRepo);
  }
}
