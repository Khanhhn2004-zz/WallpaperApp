package com.hnk.wallpaper.data.repository.creative;

import android.app.Application;
import com.hnk.wallpaper.data.local.room.CreativeDao;
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
public final class CreativeRepoImpl_Factory implements Factory<CreativeRepoImpl> {
  private final Provider<CreativeDao> creativeDaoProvider;

  private final Provider<Application> applicationProvider;

  public CreativeRepoImpl_Factory(Provider<CreativeDao> creativeDaoProvider,
      Provider<Application> applicationProvider) {
    this.creativeDaoProvider = creativeDaoProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CreativeRepoImpl get() {
    return newInstance(creativeDaoProvider.get(), applicationProvider.get());
  }

  public static CreativeRepoImpl_Factory create(Provider<CreativeDao> creativeDaoProvider,
      Provider<Application> applicationProvider) {
    return new CreativeRepoImpl_Factory(creativeDaoProvider, applicationProvider);
  }

  public static CreativeRepoImpl newInstance(CreativeDao creativeDao, Application application) {
    return new CreativeRepoImpl(creativeDao, application);
  }
}
