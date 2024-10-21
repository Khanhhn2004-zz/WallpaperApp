package com.hnk.wallpaper.ui.favorite;

import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo;
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
public final class FavouriteVM_Factory implements Factory<FavouriteVM> {
  private final Provider<FavoriteRepo> favoriteRepoProvider;

  public FavouriteVM_Factory(Provider<FavoriteRepo> favoriteRepoProvider) {
    this.favoriteRepoProvider = favoriteRepoProvider;
  }

  @Override
  public FavouriteVM get() {
    return newInstance(favoriteRepoProvider.get());
  }

  public static FavouriteVM_Factory create(Provider<FavoriteRepo> favoriteRepoProvider) {
    return new FavouriteVM_Factory(favoriteRepoProvider);
  }

  public static FavouriteVM newInstance(FavoriteRepo favoriteRepo) {
    return new FavouriteVM(favoriteRepo);
  }
}
