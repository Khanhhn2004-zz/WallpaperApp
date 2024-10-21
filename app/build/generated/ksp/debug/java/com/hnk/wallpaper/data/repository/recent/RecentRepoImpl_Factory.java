package com.hnk.wallpaper.data.repository.recent;

import com.hnk.wallpaper.data.local.room.RecentDao;
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
public final class RecentRepoImpl_Factory implements Factory<RecentRepoImpl> {
  private final Provider<RecentDao> recentDaoProvider;

  public RecentRepoImpl_Factory(Provider<RecentDao> recentDaoProvider) {
    this.recentDaoProvider = recentDaoProvider;
  }

  @Override
  public RecentRepoImpl get() {
    return newInstance(recentDaoProvider.get());
  }

  public static RecentRepoImpl_Factory create(Provider<RecentDao> recentDaoProvider) {
    return new RecentRepoImpl_Factory(recentDaoProvider);
  }

  public static RecentRepoImpl newInstance(RecentDao recentDao) {
    return new RecentRepoImpl(recentDao);
  }
}
