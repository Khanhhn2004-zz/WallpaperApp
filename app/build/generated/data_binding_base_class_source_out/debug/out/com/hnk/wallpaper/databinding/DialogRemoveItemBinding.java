// Generated by data binding compiler. Do not edit!
package com.hnk.wallpaper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogRemoveItemBinding extends ViewDataBinding {
  @NonNull
  public final CardView cvImWallpaper;

  @NonNull
  public final ImageView imWallpaper;

  @NonNull
  public final TextView tvContent;

  @NonNull
  public final TextView tvNo;

  @NonNull
  public final TextView tvRemoveItem;

  @NonNull
  public final TextView tvSure;

  @NonNull
  public final FrameLayout viewBg;

  protected DialogRemoveItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cvImWallpaper, ImageView imWallpaper, TextView tvContent, TextView tvNo,
      TextView tvRemoveItem, TextView tvSure, FrameLayout viewBg) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvImWallpaper = cvImWallpaper;
    this.imWallpaper = imWallpaper;
    this.tvContent = tvContent;
    this.tvNo = tvNo;
    this.tvRemoveItem = tvRemoveItem;
    this.tvSure = tvSure;
    this.viewBg = viewBg;
  }

  @NonNull
  public static DialogRemoveItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_remove_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogRemoveItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogRemoveItemBinding>inflateInternal(inflater, R.layout.dialog_remove_item, root, attachToRoot, component);
  }

  @NonNull
  public static DialogRemoveItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_remove_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogRemoveItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogRemoveItemBinding>inflateInternal(inflater, R.layout.dialog_remove_item, null, false, component);
  }

  public static DialogRemoveItemBinding bind(@NonNull View view) {
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
  public static DialogRemoveItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogRemoveItemBinding)bind(component, view, R.layout.dialog_remove_item);
  }
}
