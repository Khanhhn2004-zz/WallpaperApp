package com.hnk.wallpaper.ui.home.search;

import com.hnk.wallpaper.data.repository.search.SearchRepo;
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
public final class SearchVM_Factory implements Factory<SearchVM> {
  private final Provider<SearchRepo> searchRepoProvider;

  public SearchVM_Factory(Provider<SearchRepo> searchRepoProvider) {
    this.searchRepoProvider = searchRepoProvider;
  }

  @Override
  public SearchVM get() {
    return newInstance(searchRepoProvider.get());
  }

  public static SearchVM_Factory create(Provider<SearchRepo> searchRepoProvider) {
    return new SearchVM_Factory(searchRepoProvider);
  }

  public static SearchVM newInstance(SearchRepo searchRepo) {
    return new SearchVM(searchRepo);
  }
}
