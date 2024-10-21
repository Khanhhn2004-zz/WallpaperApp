package com.hnk.wallpaper.data.repository.intro;

import android.app.Application;
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
public final class IntroCreativeRepoImpl_Factory implements Factory<IntroCreativeRepoImpl> {
  private final Provider<Application> applicationProvider;

  public IntroCreativeRepoImpl_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public IntroCreativeRepoImpl get() {
    return newInstance(applicationProvider.get());
  }

  public static IntroCreativeRepoImpl_Factory create(Provider<Application> applicationProvider) {
    return new IntroCreativeRepoImpl_Factory(applicationProvider);
  }

  public static IntroCreativeRepoImpl newInstance(Application application) {
    return new IntroCreativeRepoImpl(application);
  }
}
