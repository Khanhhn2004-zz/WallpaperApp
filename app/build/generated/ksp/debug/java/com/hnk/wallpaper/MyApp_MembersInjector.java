package com.hnk.wallpaper;

import com.hnk.wallpaper.data.local.SharedPreferenceHelper;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MyApp_MembersInjector implements MembersInjector<MyApp> {
  private final Provider<SharedPreferenceHelper> sharedPreferenceHelperProvider;

  public MyApp_MembersInjector(Provider<SharedPreferenceHelper> sharedPreferenceHelperProvider) {
    this.sharedPreferenceHelperProvider = sharedPreferenceHelperProvider;
  }

  public static MembersInjector<MyApp> create(
      Provider<SharedPreferenceHelper> sharedPreferenceHelperProvider) {
    return new MyApp_MembersInjector(sharedPreferenceHelperProvider);
  }

  @Override
  public void injectMembers(MyApp instance) {
    injectSharedPreferenceHelper(instance, sharedPreferenceHelperProvider.get());
  }

  @InjectedFieldSignature("com.hnk.wallpaper.MyApp.sharedPreferenceHelper")
  public static void injectSharedPreferenceHelper(MyApp instance,
      SharedPreferenceHelper sharedPreferenceHelper) {
    instance.sharedPreferenceHelper = sharedPreferenceHelper;
  }
}
