package com.hnk.wallpaper.data.repository.collections;

import android.app.Application;
import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.local.room.CollectionDao;
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
public final class CollectionRepoImpl_Factory implements Factory<CollectionRepoImpl> {
  private final Provider<PexelsApi> mPexelsApiProvider;

  private final Provider<CollectionDao> collectionDaoProvider;

  private final Provider<Application> applicationProvider;

  public CollectionRepoImpl_Factory(Provider<PexelsApi> mPexelsApiProvider,
      Provider<CollectionDao> collectionDaoProvider, Provider<Application> applicationProvider) {
    this.mPexelsApiProvider = mPexelsApiProvider;
    this.collectionDaoProvider = collectionDaoProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CollectionRepoImpl get() {
    return newInstance(mPexelsApiProvider.get(), collectionDaoProvider.get(), applicationProvider.get());
  }

  public static CollectionRepoImpl_Factory create(Provider<PexelsApi> mPexelsApiProvider,
      Provider<CollectionDao> collectionDaoProvider, Provider<Application> applicationProvider) {
    return new CollectionRepoImpl_Factory(mPexelsApiProvider, collectionDaoProvider, applicationProvider);
  }

  public static CollectionRepoImpl newInstance(PexelsApi mPexelsApi, CollectionDao collectionDao,
      Application application) {
    return new CollectionRepoImpl(mPexelsApi, collectionDao, application);
  }
}
