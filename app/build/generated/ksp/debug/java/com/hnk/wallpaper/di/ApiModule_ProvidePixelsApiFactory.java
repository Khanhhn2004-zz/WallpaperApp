package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.api.PexelsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class ApiModule_ProvidePixelsApiFactory implements Factory<PexelsApi> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvidePixelsApiFactory(ApiModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public PexelsApi get() {
    return providePixelsApi(module, retrofitProvider.get());
  }

  public static ApiModule_ProvidePixelsApiFactory create(ApiModule module,
      Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvidePixelsApiFactory(module, retrofitProvider);
  }

  public static PexelsApi providePixelsApi(ApiModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.providePixelsApi(retrofit));
  }
}
