package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.repository.search.SearchRepo;
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
public final class AppModule_ProvideSearchRepoFactory implements Factory<SearchRepo> {
  private final AppModule module;

  private final Provider<PexelsApi> pexelsApiProvider;

  public AppModule_ProvideSearchRepoFactory(AppModule module,
      Provider<PexelsApi> pexelsApiProvider) {
    this.module = module;
    this.pexelsApiProvider = pexelsApiProvider;
  }

  @Override
  public SearchRepo get() {
    return provideSearchRepo(module, pexelsApiProvider.get());
  }

  public static AppModule_ProvideSearchRepoFactory create(AppModule module,
      Provider<PexelsApi> pexelsApiProvider) {
    return new AppModule_ProvideSearchRepoFactory(module, pexelsApiProvider);
  }

  public static SearchRepo provideSearchRepo(AppModule instance, PexelsApi pexelsApi) {
    return Preconditions.checkNotNullFromProvides(instance.provideSearchRepo(pexelsApi));
  }
}
