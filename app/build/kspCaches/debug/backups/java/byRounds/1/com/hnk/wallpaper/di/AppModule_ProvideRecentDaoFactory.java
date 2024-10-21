package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.local.room.AppDatabase;
import com.hnk.wallpaper.data.local.room.RecentDao;
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
public final class AppModule_ProvideRecentDaoFactory implements Factory<RecentDao> {
  private final AppModule module;

  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideRecentDaoFactory(AppModule module, Provider<AppDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public RecentDao get() {
    return provideRecentDao(module, dbProvider.get());
  }

  public static AppModule_ProvideRecentDaoFactory create(AppModule module,
      Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideRecentDaoFactory(module, dbProvider);
  }

  public static RecentDao provideRecentDao(AppModule instance, AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideRecentDao(db));
  }
}
