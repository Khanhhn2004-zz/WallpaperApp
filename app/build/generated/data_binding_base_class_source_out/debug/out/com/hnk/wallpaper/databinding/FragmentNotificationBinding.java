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
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentNotificationBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvNameCollection;

  @NonNull
  public final TextView tvSizeResult;

  protected FragmentNotificationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView tvNameCollection, TextView tvSizeResult) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvNameCollection = tvNameCollection;
    this.tvSizeResult = tvSizeResult;
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_notification, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentNotificationBinding>inflateInternal(inflater, R.layout.fragment_notification, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_notification, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentNotificationBinding>inflateInternal(inflater, R.layout.fragment_notification, null, false, component);
  }

  public static FragmentNotificationBinding bind(@NonNull View view) {
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
  public static FragmentNotificationBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentNotificationBinding)bind(component, view, R.layout.fragment_notification);
  }
}
