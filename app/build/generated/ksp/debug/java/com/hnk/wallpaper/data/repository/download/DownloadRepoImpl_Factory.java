package com.hnk.wallpaper.data.repository.download;

import android.app.Application;
import com.hnk.wallpaper.data.local.room.DownloadDao;
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
public final class DownloadRepoImpl_Factory implements Factory<DownloadRepoImpl> {
  private final Provider<DownloadDao> downloadDaoProvider;

  private final Provider<Application> applicationProvider;

  public DownloadRepoImpl_Factory(Provider<DownloadDao> downloadDaoProvider,
      Provider<Application> applicationProvider) {
    this.downloadDaoProvider = downloadDaoProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public DownloadRepoImpl get() {
    return newInstance(downloadDaoProvider.get(), applicationProvider.get());
  }

  public static DownloadRepoImpl_Factory create(Provider<DownloadDao> downloadDaoProvider,
      Provider<Application> applicationProvider) {
    return new DownloadRepoImpl_Factory(downloadDaoProvider, applicationProvider);
  }

  public static DownloadRepoImpl newInstance(DownloadDao downloadDao, Application application) {
    return new DownloadRepoImpl(downloadDao, application);
  }
}
