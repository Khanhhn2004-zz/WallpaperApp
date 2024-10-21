package com.hnk.wallpaper.ui.download;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class DownloadVM_Factory implements Factory<DownloadVM> {
  @Override
  public DownloadVM get() {
    return newInstance();
  }

  public static DownloadVM_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DownloadVM newInstance() {
    return new DownloadVM();
  }

  private static final class InstanceHolder {
    private static final DownloadVM_Factory INSTANCE = new DownloadVM_Factory();
  }
}
