package com.hnk.wallpaper.data.repository.search;

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
public final class SearchRepoImpl_Factory implements Factory<SearchRepoImpl> {
  private final Provider<PexelsApi> mPexelsApiProvider;

  public SearchRepoImpl_Factory(Provider<PexelsApi> mPexelsApiProvider) {
    this.mPexelsApiProvider = mPexelsApiProvider;
  }

  @Override
  public SearchRepoImpl get() {
    return newInstance(mPexelsApiProvider.get());
  }

  public static SearchRepoImpl_Factory create(Provider<PexelsApi> mPexelsApiProvider) {
    return new SearchRepoImpl_Factory(mPexelsApiProvider);
  }

  public static SearchRepoImpl newInstance(PexelsApi mPexelsApi) {
    return new SearchRepoImpl(mPexelsApi);
  }
}
