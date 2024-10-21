package com.hnk.wallpaper.ui.home.creative;

import com.hnk.wallpaper.data.repository.creative.CreativeRepo;
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
public final class CreativeVM_Factory implements Factory<CreativeVM> {
  private final Provider<CreativeRepo> creativeRepoProvider;

  public CreativeVM_Factory(Provider<CreativeRepo> creativeRepoProvider) {
    this.creativeRepoProvider = creativeRepoProvider;
  }

  @Override
  public CreativeVM get() {
    return newInstance(creativeRepoProvider.get());
  }

  public static CreativeVM_Factory create(Provider<CreativeRepo> creativeRepoProvider) {
    return new CreativeVM_Factory(creativeRepoProvider);
  }

  public static CreativeVM newInstance(CreativeRepo creativeRepo) {
    return new CreativeVM(creativeRepo);
  }
}
