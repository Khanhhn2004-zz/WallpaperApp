package com.hnk.wallpaper.ui.language;

import com.hnk.wallpaper.data.repository.language.LanguageRepo;
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
public final class LanguageVM_Factory implements Factory<LanguageVM> {
  private final Provider<LanguageRepo> languageRepoProvider;

  public LanguageVM_Factory(Provider<LanguageRepo> languageRepoProvider) {
    this.languageRepoProvider = languageRepoProvider;
  }

  @Override
  public LanguageVM get() {
    return newInstance(languageRepoProvider.get());
  }

  public static LanguageVM_Factory create(Provider<LanguageRepo> languageRepoProvider) {
    return new LanguageVM_Factory(languageRepoProvider);
  }

  public static LanguageVM newInstance(LanguageRepo languageRepo) {
    return new LanguageVM(languageRepo);
  }
}
