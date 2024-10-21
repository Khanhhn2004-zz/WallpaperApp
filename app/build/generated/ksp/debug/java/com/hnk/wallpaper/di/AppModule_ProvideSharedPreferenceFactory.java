package com.hnk.wallpaper.di;

import android.app.Application;
import android.content.SharedPreferences;
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
public final class AppModule_ProvideSharedPreferenceFactory implements Factory<SharedPreferences> {
  private final AppModule module;

  private final Provider<Application> contextProvider;

  public AppModule_ProvideSharedPreferenceFactory(AppModule module,
      Provider<Application> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreference(module, contextProvider.get());
  }

  public static AppModule_ProvideSharedPreferenceFactory create(AppModule module,
      Provider<Application> contextProvider) {
    return new AppModule_ProvideSharedPreferenceFactory(module, contextProvider);
  }

  public static SharedPreferences provideSharedPreference(AppModule instance, Application context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreference(context));
  }
}
