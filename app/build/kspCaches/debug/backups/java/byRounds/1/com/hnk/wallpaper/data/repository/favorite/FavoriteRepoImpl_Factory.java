package com.hnk.wallpaper.data.repository.favorite;

import com.hnk.wallpaper.data.local.room.FavoriteDao;
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
public final class FavoriteRepoImpl_Factory implements Factory<FavoriteRepoImpl> {
  private final Provider<FavoriteDao> favoriteDaoProvider;

  public FavoriteRepoImpl_Factory(Provider<FavoriteDao> favoriteDaoProvider) {
    this.favoriteDaoProvider = favoriteDaoProvider;
  }

  @Override
  public FavoriteRepoImpl get() {
    return newInstance(favoriteDaoProvider.get());
  }

  public static FavoriteRepoImpl_Factory create(Provider<FavoriteDao> favoriteDaoProvider) {
    return new FavoriteRepoImpl_Factory(favoriteDaoProvider);
  }

  public static FavoriteRepoImpl newInstance(FavoriteDao favoriteDao) {
    return new FavoriteRepoImpl(favoriteDao);
  }
}
