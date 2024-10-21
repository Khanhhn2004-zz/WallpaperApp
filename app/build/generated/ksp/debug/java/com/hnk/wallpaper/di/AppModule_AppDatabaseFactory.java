package com.hnk.wallpaper.di;

import android.app.Application;
import com.hnk.wallpaper.data.local.room.AppDatabase;
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
public final class AppModule_AppDatabaseFactory implements Factory<AppDatabase> {
  private final AppModule module;

  private final Provider<Application> contextProvider;

  public AppModule_AppDatabaseFactory(AppModule module, Provider<Application> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDatabase get() {
    return appDatabase(module, contextProvider.get());
  }

  public static AppModule_AppDatabaseFactory create(AppModule module,
      Provider<Application> contextProvider) {
    return new AppModule_AppDatabaseFactory(module, contextProvider);
  }

  public static AppDatabase appDatabase(AppModule instance, Application context) {
    return Preconditions.checkNotNullFromProvides(instance.appDatabase(context));
  }
}
