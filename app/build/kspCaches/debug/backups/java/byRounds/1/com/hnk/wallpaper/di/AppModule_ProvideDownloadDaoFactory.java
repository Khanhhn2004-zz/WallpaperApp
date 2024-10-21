package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.local.room.AppDatabase;
import com.hnk.wallpaper.data.local.room.DownloadDao;
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
public final class AppModule_ProvideDownloadDaoFactory implements Factory<DownloadDao> {
  private final AppModule module;

  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideDownloadDaoFactory(AppModule module, Provider<AppDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public DownloadDao get() {
    return provideDownloadDao(module, dbProvider.get());
  }

  public static AppModule_ProvideDownloadDaoFactory create(AppModule module,
      Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideDownloadDaoFactory(module, dbProvider);
  }

  public static DownloadDao provideDownloadDao(AppModule instance, AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideDownloadDao(db));
  }
}
