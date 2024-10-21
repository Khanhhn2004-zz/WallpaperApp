package com.hnk.wallpaper.data.repository.photo;

import com.hnk.wallpaper.data.api.PexelsApi;
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
public final class PhotoRepoImpl_Factory implements Factory<PhotoRepoImpl> {
  private final Provider<PexelsApi> pexelsApiProvider;

  public PhotoRepoImpl_Factory(Provider<PexelsApi> pexelsApiProvider) {
    this.pexelsApiProvider = pexelsApiProvider;
  }

  @Override
  public PhotoRepoImpl get() {
    return newInstance(pexelsApiProvider.get());
  }

  public static PhotoRepoImpl_Factory create(Provider<PexelsApi> pexelsApiProvider) {
    return new PhotoRepoImpl_Factory(pexelsApiProvider);
  }

  public static PhotoRepoImpl newInstance(PexelsApi pexelsApi) {
    return new PhotoRepoImpl(pexelsApi);
  }
}
