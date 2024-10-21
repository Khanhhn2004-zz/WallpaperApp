package com.hnk.wallpaper.ui.home.collections;

import android.app.Application;
import com.hnk.wallpaper.data.repository.collections.CollectionRepo;
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
public final class CollectionsVM_Factory implements Factory<CollectionsVM> {
  private final Provider<CollectionRepo> collectionRepoProvider;

  private final Provider<Application> applicationProvider;

  public CollectionsVM_Factory(Provider<CollectionRepo> collectionRepoProvider,
      Provider<Application> applicationProvider) {
    this.collectionRepoProvider = collectionRepoProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CollectionsVM get() {
    return newInstance(collectionRepoProvider.get(), applicationProvider.get());
  }

  public static CollectionsVM_Factory create(Provider<CollectionRepo> collectionRepoProvider,
      Provider<Application> applicationProvider) {
    return new CollectionsVM_Factory(collectionRepoProvider, applicationProvider);
  }

  public static CollectionsVM newInstance(CollectionRepo collectionRepo, Application application) {
    return new CollectionsVM(collectionRepo, application);
  }
}
