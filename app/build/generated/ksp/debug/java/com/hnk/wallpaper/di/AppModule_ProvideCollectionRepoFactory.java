package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.local.room.CollectionDao;
import com.hnk.wallpaper.data.repository.collections.CollectionRepo;
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
public final class AppModule_ProvideCollectionRepoFactory implements Factory<CollectionRepo> {
  private final AppModule module;

  private final Provider<CollectionDao> dbProvider;

  private final Provider<PexelsApi> pexelsApiProvider;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideCollectionRepoFactory(AppModule module,
      Provider<CollectionDao> dbProvider, Provider<PexelsApi> pexelsApiProvider,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
    this.pexelsApiProvider = pexelsApiProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CollectionRepo get() {
    return provideCollectionRepo(module, dbProvider.get(), pexelsApiProvider.get(), applicationProvider.get());
  }

  public static AppModule_ProvideCollectionRepoFactory create(AppModule module,
      Provider<CollectionDao> dbProvider, Provider<PexelsApi> pexelsApiProvider,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideCollectionRepoFactory(module, dbProvider, pexelsApiProvider, applicationProvider);
  }

  public static CollectionRepo provideCollectionRepo(AppModule instance, CollectionDao db,
      PexelsApi pexelsApi, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideCollectionRepo(db, pexelsApi, application));
  }
}
