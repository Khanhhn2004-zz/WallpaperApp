// Generated by data binding compiler. Do not edit!
package com.hnk.wallpaper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hnk.wallpaper.R;
import java.lang.Deprecated;
import java.lang.Object;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final CardView cvBottomNavigation;

  @NonNull
  public final DuoDrawerLayout drawerLayout;

  @NonNull
  public final ImageView imBack;

  @NonNull
  public final ImageView imMenu;

  @NonNull
  public final ImageView imSearch;

  @NonNull
  public final DuoMenuView menu;

  @NonNull
  public final TextView tvDarkTheme;

  @NonNull
  public final TextView tvDownload;

  @NonNull
  public final TextView tvEnableNotifications;

  @NonNull
  public final TextView tvHome;

  @NonNull
  public final TextView tvLanguage;

  @NonNull
  public final TextView tvPrivicy;

  @NonNull
  public final TextView tvRateThisApp;

  @NonNull
  public final TextView tvRecent;

  @NonNull
  public final TextView tvShareWithFriend;

  @NonNull
  public final ViewPager2 viewPager2;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BottomNavigationView bottomNavigation, CardView cvBottomNavigation,
      DuoDrawerLayout drawerLayout, ImageView imBack, ImageView imMenu, ImageView imSearch,
      DuoMenuView menu, TextView tvDarkTheme, TextView tvDownload, TextView tvEnableNotifications,
      TextView tvHome, TextView tvLanguage, TextView tvPrivicy, TextView tvRateThisApp,
      TextView tvRecent, TextView tvShareWithFriend, ViewPager2 viewPager2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomNavigation = bottomNavigation;
    this.cvBottomNavigation = cvBottomNavigation;
    this.drawerLayout = drawerLayout;
    this.imBack = imBack;
    this.imMenu = imMenu;
    this.imSearch = imSearch;
    this.menu = menu;
    this.tvDarkTheme = tvDarkTheme;
    this.tvDownload = tvDownload;
    this.tvEnableNotifications = tvEnableNotifications;
    this.tvHome = tvHome;
    this.tvLanguage = tvLanguage;
    this.tvPrivicy = tvPrivicy;
    this.tvRateThisApp = tvRateThisApp;
    this.tvRecent = tvRecent;
    this.tvShareWithFriend = tvShareWithFriend;
    this.viewPager2 = viewPager2;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
