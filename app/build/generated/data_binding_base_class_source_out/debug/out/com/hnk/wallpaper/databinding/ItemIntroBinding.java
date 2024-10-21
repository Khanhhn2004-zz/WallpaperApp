// Generated by data binding compiler. Do not edit!
package com.hnk.wallpaper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemIntroBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imIntro;

  @NonNull
  public final TextView tvContentIntro;

  @NonNull
  public final TextView tvTitle;

  protected ItemIntroBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imIntro, TextView tvContentIntro, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imIntro = imIntro;
    this.tvContentIntro = tvContentIntro;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static ItemIntroBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_intro, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemIntroBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemIntroBinding>inflateInternal(inflater, R.layout.item_intro, root, attachToRoot, component);
  }

  @NonNull
  public static ItemIntroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_intro, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemIntroBinding>inflateInternal(inflater, R.layout.item_intro, null, false, component);
  }

  public static ItemIntroBinding bind(@NonNull View view) {
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
  public static ItemIntroBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemIntroBinding)bind(component, view, R.layout.item_intro);
  }
}
