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
import androidx.recyclerview.widget.RecyclerView;
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentDownloadBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imBack;

  @NonNull
  public final ImageView imNoDownload;

  @NonNull
  public final RecyclerView rclFavorite;

  @NonNull
  public final TextView tvNoDownload;

  @NonNull
  public final TextView tvSizeResult;

  @NonNull
  public final TextView tvTitle;

  protected FragmentDownloadBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imBack, ImageView imNoDownload, RecyclerView rclFavorite, TextView tvNoDownload,
      TextView tvSizeResult, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imBack = imBack;
    this.imNoDownload = imNoDownload;
    this.rclFavorite = rclFavorite;
    this.tvNoDownload = tvNoDownload;
    this.tvSizeResult = tvSizeResult;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_download, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentDownloadBinding>inflateInternal(inflater, R.layout.fragment_download, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_download, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentDownloadBinding>inflateInternal(inflater, R.layout.fragment_download, null, false, component);
  }

  public static FragmentDownloadBinding bind(@NonNull View view) {
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
  public static FragmentDownloadBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentDownloadBinding)bind(component, view, R.layout.fragment_download);
  }
}
