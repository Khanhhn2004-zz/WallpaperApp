package com.hnk.wallpaper.ui.intro;

import com.hnk.wallpaper.data.repository.intro.IntroCreativeRepo;
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
public final class IntroCreateWallppaperVM_Factory implements Factory<IntroCreateWallppaperVM> {
  private final Provider<IntroCreativeRepo> introCreateRepoProvider;

  public IntroCreateWallppaperVM_Factory(Provider<IntroCreativeRepo> introCreateRepoProvider) {
    this.introCreateRepoProvider = introCreateRepoProvider;
  }

  @Override
  public IntroCreateWallppaperVM get() {
    return newInstance(introCreateRepoProvider.get());
  }

  public static IntroCreateWallppaperVM_Factory create(
      Provider<IntroCreativeRepo> introCreateRepoProvider) {
    return new IntroCreateWallppaperVM_Factory(introCreateRepoProvider);
  }

  public static IntroCreateWallppaperVM newInstance(IntroCreativeRepo introCreateRepo) {
    return new IntroCreateWallppaperVM(introCreateRepo);
  }
}
