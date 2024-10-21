package com.hnk.wallpaper.ui.intro;

import com.hnk.wallpaper.data.repository.intro.IntroRepo;
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
public final class IntroVM_Factory implements Factory<IntroVM> {
  private final Provider<IntroRepo> introRepoProvider;

  public IntroVM_Factory(Provider<IntroRepo> introRepoProvider) {
    this.introRepoProvider = introRepoProvider;
  }

  @Override
  public IntroVM get() {
    return newInstance(introRepoProvider.get());
  }

  public static IntroVM_Factory create(Provider<IntroRepo> introRepoProvider) {
    return new IntroVM_Factory(introRepoProvider);
  }

  public static IntroVM newInstance(IntroRepo introRepo) {
    return new IntroVM(introRepo);
  }
}
