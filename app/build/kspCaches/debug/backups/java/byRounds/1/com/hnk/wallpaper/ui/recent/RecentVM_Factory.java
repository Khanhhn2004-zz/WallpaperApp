package com.hnk.wallpaper.ui.recent;

import com.hnk.wallpaper.data.repository.recent.RecentRepo;
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
public final class RecentVM_Factory implements Factory<RecentVM> {
  private final Provider<RecentRepo> recentRepoProvider;

  public RecentVM_Factory(Provider<RecentRepo> recentRepoProvider) {
    this.recentRepoProvider = recentRepoProvider;
  }

  @Override
  public RecentVM get() {
    return newInstance(recentRepoProvider.get());
  }

  public static RecentVM_Factory create(Provider<RecentRepo> recentRepoProvider) {
    return new RecentVM_Factory(recentRepoProvider);
  }

  public static RecentVM newInstance(RecentRepo recentRepo) {
    return new RecentVM(recentRepo);
  }
}
