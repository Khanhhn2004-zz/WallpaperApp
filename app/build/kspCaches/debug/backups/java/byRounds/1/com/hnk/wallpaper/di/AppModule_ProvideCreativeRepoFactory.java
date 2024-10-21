package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.local.room.CreativeDao;
import com.hnk.wallpaper.data.repository.creative.CreativeRepo;
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
public final class AppModule_ProvideCreativeRepoFactory implements Factory<CreativeRepo> {
  private final AppModule module;

  private final Provider<CreativeDao> dbProvider;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideCreativeRepoFactory(AppModule module, Provider<CreativeDao> dbProvider,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CreativeRepo get() {
    return provideCreativeRepo(module, dbProvider.get(), applicationProvider.get());
  }

  public static AppModule_ProvideCreativeRepoFactory create(AppModule module,
      Provider<CreativeDao> dbProvider, Provider<Application> applicationProvider) {
    return new AppModule_ProvideCreativeRepoFactory(module, dbProvider, applicationProvider);
  }

  public static CreativeRepo provideCreativeRepo(AppModule instance, CreativeDao db,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideCreativeRepo(db, application));
  }
}
