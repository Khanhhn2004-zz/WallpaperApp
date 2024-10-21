package com.hnk.wallpaper.data.repository.intro;

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
public final class IntroRepoImpl_Factory implements Factory<IntroRepoImpl> {
  @Override
  public IntroRepoImpl get() {
    return newInstance();
  }

  public static IntroRepoImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IntroRepoImpl newInstance() {
    return new IntroRepoImpl();
  }

  private static final class InstanceHolder {
    private static final IntroRepoImpl_Factory INSTANCE = new IntroRepoImpl_Factory();
  }
}
