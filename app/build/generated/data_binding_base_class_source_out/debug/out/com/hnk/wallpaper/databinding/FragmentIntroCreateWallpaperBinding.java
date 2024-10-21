// Generated by data binding compiler. Do not edit!
package com.hnk.wallpaper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.hnk.wallpaper.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentIntroCreateWallpaperBinding extends ViewDataBinding {
  @NonNull
  public final DotsIndicator dotsIndicator;

  @NonNull
  public final TextView tvNext;

  @NonNull
  public final TextView tvSkip;

  @NonNull
  public final ViewPager2 viewPager2;

  protected FragmentIntroCreateWallpaperBinding(Object _bindingComponent, View _root,
      int _localFieldCount, DotsIndicator dotsIndicator, TextView tvNext, TextView tvSkip,
      ViewPager2 viewPager2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dotsIndicator = dotsIndicator;
    this.tvNext = tvNext;
    this.tvSkip = tvSkip;
    this.viewPager2 = viewPager2;
  }

  @NonNull
  public static FragmentIntroCreateWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_intro_create_wallpaper, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIntroCreateWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentIntroCreateWallpaperBinding>inflateInternal(inflater, R.layout.fragment_intro_create_wallpaper, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIntroCreateWallpaperBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_intro_create_wallpaper, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIntroCreateWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentIntroCreateWallpaperBinding>inflateInternal(inflater, R.layout.fragment_intro_create_wallpaper, null, false, component);
  }

  public static FragmentIntroCreateWallpaperBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentIntroCreateWallpaperBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentIntroCreateWallpaperBinding)bind(component, view, R.layout.fragment_intro_create_wallpaper);
  }
}
