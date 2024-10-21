package com.hnk.wallpaper.data.repository.language;

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
public final class LanguageRepoImpl_Factory implements Factory<LanguageRepoImpl> {
  private final Provider<Application> applicationProvider;

  public LanguageRepoImpl_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LanguageRepoImpl get() {
    return newInstance(applicationProvider.get());
  }

  public static LanguageRepoImpl_Factory create(Provider<Application> applicationProvider) {
    return new LanguageRepoImpl_Factory(applicationProvider);
  }

  public static LanguageRepoImpl newInstance(Application application) {
    return new LanguageRepoImpl(application);
  }
}
