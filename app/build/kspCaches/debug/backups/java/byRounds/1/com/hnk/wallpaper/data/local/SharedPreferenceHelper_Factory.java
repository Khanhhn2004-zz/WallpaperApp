package com.hnk.wallpaper.data.local;

import android.content.SharedPreferences;
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
public final class SharedPreferenceHelper_Factory implements Factory<SharedPreferenceHelper> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public SharedPreferenceHelper_Factory(Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public SharedPreferenceHelper get() {
    return newInstance(sharedPreferencesProvider.get());
  }

  public static SharedPreferenceHelper_Factory create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new SharedPreferenceHelper_Factory(sharedPreferencesProvider);
  }

  public static SharedPreferenceHelper newInstance(SharedPreferences sharedPreferences) {
    return new SharedPreferenceHelper(sharedPreferences);
  }
}
