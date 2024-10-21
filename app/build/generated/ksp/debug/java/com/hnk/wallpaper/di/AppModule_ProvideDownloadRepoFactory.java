package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.local.room.DownloadDao;
import com.hnk.wallpaper.data.repository.download.DownloadRepo;
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
public final class AppModule_ProvideDownloadRepoFactory implements Factory<DownloadRepo> {
  private final AppModule module;

  private final Provider<DownloadDao> dbProvider;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideDownloadRepoFactory(AppModule module, Provider<DownloadDao> dbProvider,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public DownloadRepo get() {
    return provideDownloadRepo(module, dbProvider.get(), applicationProvider.get());
  }

  public static AppModule_ProvideDownloadRepoFactory create(AppModule module,
      Provider<DownloadDao> dbProvider, Provider<Application> applicationProvider) {
    return new AppModule_ProvideDownloadRepoFactory(module, dbProvider, applicationProvider);
  }

  public static DownloadRepo provideDownloadRepo(AppModule instance, DownloadDao db,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideDownloadRepo(db, application));
  }
}
