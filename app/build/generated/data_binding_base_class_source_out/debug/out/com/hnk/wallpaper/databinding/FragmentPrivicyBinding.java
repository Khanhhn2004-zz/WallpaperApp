// Generated by data binding compiler. Do not edit!
package com.hnk.wallpaper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPrivicyBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imBack;

  @NonNull
  public final WebView webView;

  protected FragmentPrivicyBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imBack, WebView webView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imBack = imBack;
    this.webView = webView;
  }

  @NonNull
  public static FragmentPrivicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_privicy, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPrivicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPrivicyBinding>inflateInternal(inflater, R.layout.fragment_privicy, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPrivicyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_privicy, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPrivicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPrivicyBinding>inflateInternal(inflater, R.layout.fragment_privicy, null, false, component);
  }

  public static FragmentPrivicyBinding bind(@NonNull View view) {
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
  public static FragmentPrivicyBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPrivicyBinding)bind(component, view, R.layout.fragment_privicy);
  }
}
