package com.hnk.wallpaper.di;

import com.hnk.wallpaper.data.local.room.AppDatabase;
import com.hnk.wallpaper.data.local.room.CreativeDao;
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
public final class AppModule_ProvideCreativeDaoFactory implements Factory<CreativeDao> {
  private final AppModule module;

  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideCreativeDaoFactory(AppModule module, Provider<AppDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public CreativeDao get() {
    return provideCreativeDao(module, dbProvider.get());
  }

  public static AppModule_ProvideCreativeDaoFactory create(AppModule module,
      Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideCreativeDaoFactory(module, dbProvider);
  }

  public static CreativeDao provideCreativeDao(AppModule instance, AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideCreativeDao(db));
  }
}
