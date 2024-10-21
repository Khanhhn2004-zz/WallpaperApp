package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.local.room.RecentDao;
import com.hnk.wallpaper.data.repository.recent.RecentRepo;
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
public final class AppModule_ProvideRecentRepoFactory implements Factory<RecentRepo> {
  private final AppModule module;

  private final Provider<RecentDao> dbProvider;

  public AppModule_ProvideRecentRepoFactory(AppModule module, Provider<RecentDao> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public RecentRepo get() {
    return provideRecentRepo(module, dbProvider.get());
  }

  public static AppModule_ProvideRecentRepoFactory create(AppModule module,
      Provider<RecentDao> dbProvider) {
    return new AppModule_ProvideRecentRepoFactory(module, dbProvider);
  }

  public static RecentRepo provideRecentRepo(AppModule instance, RecentDao db) {
    return Preconditions.checkNotNullFromProvides(instance.provideRecentRepo(db));
  }
}
