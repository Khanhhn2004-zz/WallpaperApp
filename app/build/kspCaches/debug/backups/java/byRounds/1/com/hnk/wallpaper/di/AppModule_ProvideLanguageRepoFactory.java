package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.repository.language.LanguageRepo;
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
public final class AppModule_ProvideLanguageRepoFactory implements Factory<LanguageRepo> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideLanguageRepoFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LanguageRepo get() {
    return provideLanguageRepo(module, applicationProvider.get());
  }

  public static AppModule_ProvideLanguageRepoFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideLanguageRepoFactory(module, applicationProvider);
  }

  public static LanguageRepo provideLanguageRepo(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideLanguageRepo(application));
  }
}
