package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.api.ApiKeyManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ApiModule_ProvideApiKeyManagerFactory implements Factory<ApiKeyManager> {
  private final ApiModule module;

  public ApiModule_ProvideApiKeyManagerFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public ApiKeyManager get() {
    return provideApiKeyManager(module);
  }

  public static ApiModule_ProvideApiKeyManagerFactory create(ApiModule module) {
    return new ApiModule_ProvideApiKeyManagerFactory(module);
  }

  public static ApiKeyManager provideApiKeyManager(ApiModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideApiKeyManager());
  }
}
