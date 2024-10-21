package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.local.room.FavoriteDao;
import com.hnk.wallpaper.data.repository.favorite.FavoriteRepo;
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
public final class AppModule_ProvideFavoriteRepoFactory implements Factory<FavoriteRepo> {
  private final AppModule module;

  private final Provider<FavoriteDao> dbProvider;

  public AppModule_ProvideFavoriteRepoFactory(AppModule module, Provider<FavoriteDao> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public FavoriteRepo get() {
    return provideFavoriteRepo(module, dbProvider.get());
  }

  public static AppModule_ProvideFavoriteRepoFactory create(AppModule module,
      Provider<FavoriteDao> dbProvider) {
    return new AppModule_ProvideFavoriteRepoFactory(module, dbProvider);
  }

  public static FavoriteRepo provideFavoriteRepo(AppModule instance, FavoriteDao db) {
    return Preconditions.checkNotNullFromProvides(instance.provideFavoriteRepo(db));
  }
}
