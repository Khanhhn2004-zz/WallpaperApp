package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.repository.intro.IntroRepo;
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
public final class AppModule_ProvideIntroRepoFactory implements Factory<IntroRepo> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideIntroRepoFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public IntroRepo get() {
    return provideIntroRepo(module, applicationProvider.get());
  }

  public static AppModule_ProvideIntroRepoFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideIntroRepoFactory(module, applicationProvider);
  }

  public static IntroRepo provideIntroRepo(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideIntroRepo(application));
  }
}
