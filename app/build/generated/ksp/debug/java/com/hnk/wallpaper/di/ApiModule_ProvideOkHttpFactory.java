package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.api.ApiKeyManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class ApiModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public ApiModule_ProvideOkHttpFactory(ApiModule module,
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.module = module;
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttp(module, apiKeyManagerProvider.get());
  }

  public static ApiModule_ProvideOkHttpFactory create(ApiModule module,
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new ApiModule_ProvideOkHttpFactory(module, apiKeyManagerProvider);
  }

  public static OkHttpClient provideOkHttp(ApiModule instance, ApiKeyManager apiKeyManager) {
    return Preconditions.checkNotNullFromProvides(instance.provideOkHttp(apiKeyManager));
  }
}
