package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.api.PexelsApi;
import com.hnk.wallpaper.data.repository.photo.PhotoRepo;
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
public final class AppModule_ProvidePhotoRepoFactory implements Factory<PhotoRepo> {
  private final AppModule module;

  private final Provider<PexelsApi> pexelsApiProvider;

  public AppModule_ProvidePhotoRepoFactory(AppModule module,
      Provider<PexelsApi> pexelsApiProvider) {
    this.module = module;
    this.pexelsApiProvider = pexelsApiProvider;
  }

  @Override
  public PhotoRepo get() {
    return providePhotoRepo(module, pexelsApiProvider.get());
  }

  public static AppModule_ProvidePhotoRepoFactory create(AppModule module,
      Provider<PexelsApi> pexelsApiProvider) {
    return new AppModule_ProvidePhotoRepoFactory(module, pexelsApiProvider);
  }

  public static PhotoRepo providePhotoRepo(AppModule instance, PexelsApi pexelsApi) {
    return Preconditions.checkNotNullFromProvides(instance.providePhotoRepo(pexelsApi));
  }
}
