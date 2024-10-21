package com.hnk.wallpaper.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class ApiModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<OkHttpClient> clientProvider;

  public ApiModule_ProvideRetrofitFactory(ApiModule module, Provider<OkHttpClient> clientProvider) {
    this.module = module;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, clientProvider.get());
  }

  public static ApiModule_ProvideRetrofitFactory create(ApiModule module,
      Provider<OkHttpClient> clientProvider) {
    return new ApiModule_ProvideRetrofitFactory(module, clientProvider);
  }

  public static Retrofit provideRetrofit(ApiModule instance, OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(client));
  }
}
