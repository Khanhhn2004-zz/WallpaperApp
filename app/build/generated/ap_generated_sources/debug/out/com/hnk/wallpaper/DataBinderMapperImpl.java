package com.hnk.wallpaper;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.hnk.wallpaper.databinding.ActivityMainBindingImpl;
import com.hnk.wallpaper.databinding.ActivitySplashBindingImpl;
import com.hnk.wallpaper.databinding.ActivitySplashBindingNightImpl;
import com.hnk.wallpaper.databinding.BottomSheetActionFavoriteBindingImpl;
import com.hnk.wallpaper.databinding.BottomSheetActionItemCreativeBindingImpl;
import com.hnk.wallpaper.databinding.BottomSheetActionItemDownloadBindingImpl;
import com.hnk.wallpaper.databinding.BottomSheetSelectedActionBindingImpl;
import com.hnk.wallpaper.databinding.DialogDownloadCompleteBindingImpl;
import com.hnk.wallpaper.databinding.DialogDownloadErrorBindingImpl;
import com.hnk.wallpaper.databinding.DialogDownloadingBindingImpl;
import com.hnk.wallpaper.databinding.DialogLoadingSetWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.DialogLoadingSetWallpaperBindingNightImpl;
import com.hnk.wallpaper.databinding.DialogNetworkBindingImpl;
import com.hnk.wallpaper.databinding.DialogPermissionBindingImpl;
import com.hnk.wallpaper.databinding.DialogRateUsOneBindingImpl;
import com.hnk.wallpaper.databinding.DialogRemoveItemBindingImpl;
import com.hnk.wallpaper.databinding.DialogSetWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.DialogSetWallpaperScrenBindingImpl;
import com.hnk.wallpaper.databinding.FragmentAuthorBindingImpl;
import com.hnk.wallpaper.databinding.FragmentCategoryBindingImpl;
import com.hnk.wallpaper.databinding.FragmentCollectionsBindingImpl;
import com.hnk.wallpaper.databinding.FragmentCreativeWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.FragmentDetailBindingImpl;
import com.hnk.wallpaper.databinding.FragmentDetailCollectionsBindingImpl;
import com.hnk.wallpaper.databinding.FragmentDownloadBindingImpl;
import com.hnk.wallpaper.databinding.FragmentFavouritesBindingImpl;
import com.hnk.wallpaper.databinding.FragmentFeaturedBindingImpl;
import com.hnk.wallpaper.databinding.FragmentFilterBindingImpl;
import com.hnk.wallpaper.databinding.FragmentHomeBindingImpl;
import com.hnk.wallpaper.databinding.FragmentIntroBindingImpl;
import com.hnk.wallpaper.databinding.FragmentIntroCreateWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.FragmentIntroCreateWallpaperBindingNightImpl;
import com.hnk.wallpaper.databinding.FragmentLanguageBindingImpl;
import com.hnk.wallpaper.databinding.FragmentNotificationBindingImpl;
import com.hnk.wallpaper.databinding.FragmentPermissionBindingImpl;
import com.hnk.wallpaper.databinding.FragmentPhotoBindingImpl;
import com.hnk.wallpaper.databinding.FragmentPrivicyBindingImpl;
import com.hnk.wallpaper.databinding.FragmentRecentBindingImpl;
import com.hnk.wallpaper.databinding.FragmentSearchBindingImpl;
import com.hnk.wallpaper.databinding.FragmentSettingBindingImpl;
import com.hnk.wallpaper.databinding.FragmentShowMoreBindingImpl;
import com.hnk.wallpaper.databinding.FragmentShowMoreCollectionsBindingImpl;
import com.hnk.wallpaper.databinding.ItemBannerBindingImpl;
import com.hnk.wallpaper.databinding.ItemBannerShimmerBindingImpl;
import com.hnk.wallpaper.databinding.ItemCollectionShimerBindingImpl;
import com.hnk.wallpaper.databinding.ItemCollectionsBindingImpl;
import com.hnk.wallpaper.databinding.ItemIntroBindingImpl;
import com.hnk.wallpaper.databinding.ItemIntroCreativeWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.ItemLanguageBindingImpl;
import com.hnk.wallpaper.databinding.ItemWallpaperBindingImpl;
import com.hnk.wallpaper.databinding.ItemWallpaperShimmerBindingImpl;
import com.hnk.wallpaper.databinding.NavHeaderBindingImpl;
import com.hnk.wallpaper.databinding.SimpleListItemCheckedBindingImpl;
import com.hnk.wallpaper.databinding.SpinnerItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYSPLASH = 2;

  private static final int LAYOUT_BOTTOMSHEETACTIONFAVORITE = 3;

  private static final int LAYOUT_BOTTOMSHEETACTIONITEMCREATIVE = 4;

  private static final int LAYOUT_BOTTOMSHEETACTIONITEMDOWNLOAD = 5;

  private static final int LAYOUT_BOTTOMSHEETSELECTEDACTION = 6;

  private static final int LAYOUT_DIALOGDOWNLOADCOMPLETE = 7;

  private static final int LAYOUT_DIALOGDOWNLOADERROR = 8;

  private static final int LAYOUT_DIALOGDOWNLOADING = 9;

  private static final int LAYOUT_DIALOGLOADINGSETWALLPAPER = 10;

  private static final int LAYOUT_DIALOGNETWORK = 11;

  private static final int LAYOUT_DIALOGPERMISSION = 12;

  private static final int LAYOUT_DIALOGRATEUSONE = 13;

  private static final int LAYOUT_DIALOGREMOVEITEM = 14;

  private static final int LAYOUT_DIALOGSETWALLPAPER = 15;

  private static final int LAYOUT_DIALOGSETWALLPAPERSCREN = 16;

  private static final int LAYOUT_FRAGMENTAUTHOR = 17;

  private static final int LAYOUT_FRAGMENTCATEGORY = 18;

  private static final int LAYOUT_FRAGMENTCOLLECTIONS = 19;

  private static final int LAYOUT_FRAGMENTCREATIVEWALLPAPER = 20;

  private static final int LAYOUT_FRAGMENTDETAIL = 21;

  private static final int LAYOUT_FRAGMENTDETAILCOLLECTIONS = 22;

  private static final int LAYOUT_FRAGMENTDOWNLOAD = 23;

  private static final int LAYOUT_FRAGMENTFAVOURITES = 24;

  private static final int LAYOUT_FRAGMENTFEATURED = 25;

  private static final int LAYOUT_FRAGMENTFILTER = 26;

  private static final int LAYOUT_FRAGMENTHOME = 27;

  private static final int LAYOUT_FRAGMENTINTRO = 28;

  private static final int LAYOUT_FRAGMENTINTROCREATEWALLPAPER = 29;

  private static final int LAYOUT_FRAGMENTLANGUAGE = 30;

  private static final int LAYOUT_FRAGMENTNOTIFICATION = 31;

  private static final int LAYOUT_FRAGMENTPERMISSION = 32;

  private static final int LAYOUT_FRAGMENTPHOTO = 33;

  private static final int LAYOUT_FRAGMENTPRIVICY = 34;

  private static final int LAYOUT_FRAGMENTRECENT = 35;

  private static final int LAYOUT_FRAGMENTSEARCH = 36;

  private static final int LAYOUT_FRAGMENTSETTING = 37;

  private static final int LAYOUT_FRAGMENTSHOWMORE = 38;

  private static final int LAYOUT_FRAGMENTSHOWMORECOLLECTIONS = 39;

  private static final int LAYOUT_ITEMBANNER = 40;

  private static final int LAYOUT_ITEMBANNERSHIMMER = 41;

  private static final int LAYOUT_ITEMCOLLECTIONSHIMER = 42;

  private static final int LAYOUT_ITEMCOLLECTIONS = 43;

  private static final int LAYOUT_ITEMINTRO = 44;

  private static final int LAYOUT_ITEMINTROCREATIVEWALLPAPER = 45;

  private static final int LAYOUT_ITEMLANGUAGE = 46;

  private static final int LAYOUT_ITEMWALLPAPER = 47;

  private static final int LAYOUT_ITEMWALLPAPERSHIMMER = 48;

  private static final int LAYOUT_NAVHEADER = 49;

  private static final int LAYOUT_SIMPLELISTITEMCHECKED = 50;

  private static final int LAYOUT_SPINNERITEM = 51;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(51);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.bottom_sheet_action_favorite, LAYOUT_BOTTOMSHEETACTIONFAVORITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.bottom_sheet_action_item_creative, LAYOUT_BOTTOMSHEETACTIONITEMCREATIVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.bottom_sheet_action_item_download, LAYOUT_BOTTOMSHEETACTIONITEMDOWNLOAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.bottom_sheet_selected_action, LAYOUT_BOTTOMSHEETSELECTEDACTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_download_complete, LAYOUT_DIALOGDOWNLOADCOMPLETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_download_error, LAYOUT_DIALOGDOWNLOADERROR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_downloading, LAYOUT_DIALOGDOWNLOADING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_loading_set_wallpaper, LAYOUT_DIALOGLOADINGSETWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_network, LAYOUT_DIALOGNETWORK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_permission, LAYOUT_DIALOGPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_rate_us_one, LAYOUT_DIALOGRATEUSONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_remove_item, LAYOUT_DIALOGREMOVEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_set_wallpaper, LAYOUT_DIALOGSETWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.dialog_set_wallpaper_scren, LAYOUT_DIALOGSETWALLPAPERSCREN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_author, LAYOUT_FRAGMENTAUTHOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_category, LAYOUT_FRAGMENTCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_collections, LAYOUT_FRAGMENTCOLLECTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_creative_wallpaper, LAYOUT_FRAGMENTCREATIVEWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_detail, LAYOUT_FRAGMENTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_detail_collections, LAYOUT_FRAGMENTDETAILCOLLECTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_download, LAYOUT_FRAGMENTDOWNLOAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_favourites, LAYOUT_FRAGMENTFAVOURITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_featured, LAYOUT_FRAGMENTFEATURED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_filter, LAYOUT_FRAGMENTFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_intro, LAYOUT_FRAGMENTINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_intro_create_wallpaper, LAYOUT_FRAGMENTINTROCREATEWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_language, LAYOUT_FRAGMENTLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_notification, LAYOUT_FRAGMENTNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_permission, LAYOUT_FRAGMENTPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_photo, LAYOUT_FRAGMENTPHOTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_privicy, LAYOUT_FRAGMENTPRIVICY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_recent, LAYOUT_FRAGMENTRECENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_search, LAYOUT_FRAGMENTSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_setting, LAYOUT_FRAGMENTSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_show_more, LAYOUT_FRAGMENTSHOWMORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.fragment_show_more_collections, LAYOUT_FRAGMENTSHOWMORECOLLECTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_banner, LAYOUT_ITEMBANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_banner_shimmer, LAYOUT_ITEMBANNERSHIMMER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_collection_shimer, LAYOUT_ITEMCOLLECTIONSHIMER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_collections, LAYOUT_ITEMCOLLECTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_intro, LAYOUT_ITEMINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_intro_creative_wallpaper, LAYOUT_ITEMINTROCREATIVEWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_language, LAYOUT_ITEMLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_wallpaper, LAYOUT_ITEMWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.item_wallpaper_shimmer, LAYOUT_ITEMWALLPAPERSHIMMER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.nav_header, LAYOUT_NAVHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.simple_list_item_checked, LAYOUT_SIMPLELISTITEMCHECKED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.hnk.wallpaper.R.layout.spinner_item, LAYOUT_SPINNERITEM);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYMAIN: {
        if ("layout/activity_main_0".equals(tag)) {
          return new ActivityMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout-night/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingNightImpl(component, view);
        }
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETACTIONFAVORITE: {
        if ("layout/bottom_sheet_action_favorite_0".equals(tag)) {
          return new BottomSheetActionFavoriteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_action_favorite is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETACTIONITEMCREATIVE: {
        if ("layout/bottom_sheet_action_item_creative_0".equals(tag)) {
          return new BottomSheetActionItemCreativeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_action_item_creative is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETACTIONITEMDOWNLOAD: {
        if ("layout/bottom_sheet_action_item_download_0".equals(tag)) {
          return new BottomSheetActionItemDownloadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_action_item_download is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETSELECTEDACTION: {
        if ("layout/bottom_sheet_selected_action_0".equals(tag)) {
          return new BottomSheetSelectedActionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_selected_action is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGDOWNLOADCOMPLETE: {
        if ("layout/dialog_download_complete_0".equals(tag)) {
          return new DialogDownloadCompleteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_download_complete is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGDOWNLOADERROR: {
        if ("layout/dialog_download_error_0".equals(tag)) {
          return new DialogDownloadErrorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_download_error is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGDOWNLOADING: {
        if ("layout/dialog_downloading_0".equals(tag)) {
          return new DialogDownloadingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_downloading is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGLOADINGSETWALLPAPER: {
        if ("layout-night/dialog_loading_set_wallpaper_0".equals(tag)) {
          return new DialogLoadingSetWallpaperBindingNightImpl(component, view);
        }
        if ("layout/dialog_loading_set_wallpaper_0".equals(tag)) {
          return new DialogLoadingSetWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_loading_set_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGNETWORK: {
        if ("layout/dialog_network_0".equals(tag)) {
          return new DialogNetworkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_network is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGPERMISSION: {
        if ("layout/dialog_permission_0".equals(tag)) {
          return new DialogPermissionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_permission is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGRATEUSONE: {
        if ("layout/dialog_rate_us_one_0".equals(tag)) {
          return new DialogRateUsOneBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_rate_us_one is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGREMOVEITEM: {
        if ("layout/dialog_remove_item_0".equals(tag)) {
          return new DialogRemoveItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_remove_item is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSETWALLPAPER: {
        if ("layout/dialog_set_wallpaper_0".equals(tag)) {
          return new DialogSetWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_set_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSETWALLPAPERSCREN: {
        if ("layout/dialog_set_wallpaper_scren_0".equals(tag)) {
          return new DialogSetWallpaperScrenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_set_wallpaper_scren is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTAUTHOR: {
        if ("layout/fragment_author_0".equals(tag)) {
          return new FragmentAuthorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_author is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCATEGORY: {
        if ("layout/fragment_category_0".equals(tag)) {
          return new FragmentCategoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_category is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCOLLECTIONS: {
        if ("layout/fragment_collections_0".equals(tag)) {
          return new FragmentCollectionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_collections is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATIVEWALLPAPER: {
        if ("layout/fragment_creative_wallpaper_0".equals(tag)) {
          return new FragmentCreativeWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_creative_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDETAIL: {
        if ("layout/fragment_detail_0".equals(tag)) {
          return new FragmentDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDETAILCOLLECTIONS: {
        if ("layout/fragment_detail_collections_0".equals(tag)) {
          return new FragmentDetailCollectionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_detail_collections is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDOWNLOAD: {
        if ("layout/fragment_download_0".equals(tag)) {
          return new FragmentDownloadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_download is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFAVOURITES: {
        if ("layout/fragment_favourites_0".equals(tag)) {
          return new FragmentFavouritesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_favourites is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFEATURED: {
        if ("layout/fragment_featured_0".equals(tag)) {
          return new FragmentFeaturedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_featured is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFILTER: {
        if ("layout/fragment_filter_0".equals(tag)) {
          return new FragmentFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOME: {
        if ("layout/fragment_home_0".equals(tag)) {
          return new FragmentHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTINTRO: {
        if ("layout/fragment_intro_0".equals(tag)) {
          return new FragmentIntroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_intro is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTINTROCREATEWALLPAPER: {
        if ("layout-night/fragment_intro_create_wallpaper_0".equals(tag)) {
          return new FragmentIntroCreateWallpaperBindingNightImpl(component, view);
        }
        if ("layout/fragment_intro_create_wallpaper_0".equals(tag)) {
          return new FragmentIntroCreateWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_intro_create_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLANGUAGE: {
        if ("layout/fragment_language_0".equals(tag)) {
          return new FragmentLanguageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_language is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNOTIFICATION: {
        if ("layout/fragment_notification_0".equals(tag)) {
          return new FragmentNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPERMISSION: {
        if ("layout/fragment_permission_0".equals(tag)) {
          return new FragmentPermissionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_permission is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPHOTO: {
        if ("layout/fragment_photo_0".equals(tag)) {
          return new FragmentPhotoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_photo is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPRIVICY: {
        if ("layout/fragment_privicy_0".equals(tag)) {
          return new FragmentPrivicyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_privicy is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECENT: {
        if ("layout/fragment_recent_0".equals(tag)) {
          return new FragmentRecentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_recent is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEARCH: {
        if ("layout/fragment_search_0".equals(tag)) {
          return new FragmentSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_search is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSETTING: {
        if ("layout/fragment_setting_0".equals(tag)) {
          return new FragmentSettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSHOWMORE: {
        if ("layout/fragment_show_more_0".equals(tag)) {
          return new FragmentShowMoreBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_show_more is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSHOWMORECOLLECTIONS: {
        if ("layout/fragment_show_more_collections_0".equals(tag)) {
          return new FragmentShowMoreCollectionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_show_more_collections is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBANNER: {
        if ("layout/item_banner_0".equals(tag)) {
          return new ItemBannerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_banner is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBANNERSHIMMER: {
        if ("layout/item_banner_shimmer_0".equals(tag)) {
          return new ItemBannerShimmerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_banner_shimmer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCOLLECTIONSHIMER: {
        if ("layout/item_collection_shimer_0".equals(tag)) {
          return new ItemCollectionShimerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_collection_shimer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCOLLECTIONS: {
        if ("layout/item_collections_0".equals(tag)) {
          return new ItemCollectionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_collections is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMINTRO: {
        if ("layout/item_intro_0".equals(tag)) {
          return new ItemIntroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_intro is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMINTROCREATIVEWALLPAPER: {
        if ("layout/item_intro_creative_wallpaper_0".equals(tag)) {
          return new ItemIntroCreativeWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_intro_creative_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLANGUAGE: {
        if ("layout/item_language_0".equals(tag)) {
          return new ItemLanguageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_language is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWALLPAPER: {
        if ("layout/item_wallpaper_0".equals(tag)) {
          return new ItemWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWALLPAPERSHIMMER: {
        if ("layout/item_wallpaper_shimmer_0".equals(tag)) {
          return new ItemWallpaperShimmerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_wallpaper_shimmer is invalid. Received: " + tag);
      }
      case  LAYOUT_NAVHEADER: {
        if ("layout/nav_header_0".equals(tag)) {
          return new NavHeaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for nav_header is invalid. Received: " + tag);
      }
      case  LAYOUT_SIMPLELISTITEMCHECKED: {
        if ("layout/simple_list_item_checked_0".equals(tag)) {
          return new SimpleListItemCheckedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for simple_list_item_checked is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_SPINNERITEM: {
        if ("layout/spinner_item_0".equals(tag)) {
          return new SpinnerItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for spinner_item is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(54);

    static {
      sKeys.put("layout/activity_main_0", com.hnk.wallpaper.R.layout.activity_main);
      sKeys.put("layout-night/activity_splash_0", com.hnk.wallpaper.R.layout.activity_splash);
      sKeys.put("layout/activity_splash_0", com.hnk.wallpaper.R.layout.activity_splash);
      sKeys.put("layout/bottom_sheet_action_favorite_0", com.hnk.wallpaper.R.layout.bottom_sheet_action_favorite);
      sKeys.put("layout/bottom_sheet_action_item_creative_0", com.hnk.wallpaper.R.layout.bottom_sheet_action_item_creative);
      sKeys.put("layout/bottom_sheet_action_item_download_0", com.hnk.wallpaper.R.layout.bottom_sheet_action_item_download);
      sKeys.put("layout/bottom_sheet_selected_action_0", com.hnk.wallpaper.R.layout.bottom_sheet_selected_action);
      sKeys.put("layout/dialog_download_complete_0", com.hnk.wallpaper.R.layout.dialog_download_complete);
      sKeys.put("layout/dialog_download_error_0", com.hnk.wallpaper.R.layout.dialog_download_error);
      sKeys.put("layout/dialog_downloading_0", com.hnk.wallpaper.R.layout.dialog_downloading);
      sKeys.put("layout-night/dialog_loading_set_wallpaper_0", com.hnk.wallpaper.R.layout.dialog_loading_set_wallpaper);
      sKeys.put("layout/dialog_loading_set_wallpaper_0", com.hnk.wallpaper.R.layout.dialog_loading_set_wallpaper);
      sKeys.put("layout/dialog_network_0", com.hnk.wallpaper.R.layout.dialog_network);
      sKeys.put("layout/dialog_permission_0", com.hnk.wallpaper.R.layout.dialog_permission);
      sKeys.put("layout/dialog_rate_us_one_0", com.hnk.wallpaper.R.layout.dialog_rate_us_one);
      sKeys.put("layout/dialog_remove_item_0", com.hnk.wallpaper.R.layout.dialog_remove_item);
      sKeys.put("layout/dialog_set_wallpaper_0", com.hnk.wallpaper.R.layout.dialog_set_wallpaper);
      sKeys.put("layout/dialog_set_wallpaper_scren_0", com.hnk.wallpaper.R.layout.dialog_set_wallpaper_scren);
      sKeys.put("layout/fragment_author_0", com.hnk.wallpaper.R.layout.fragment_author);
      sKeys.put("layout/fragment_category_0", com.hnk.wallpaper.R.layout.fragment_category);
      sKeys.put("layout/fragment_collections_0", com.hnk.wallpaper.R.layout.fragment_collections);
      sKeys.put("layout/fragment_creative_wallpaper_0", com.hnk.wallpaper.R.layout.fragment_creative_wallpaper);
      sKeys.put("layout/fragment_detail_0", com.hnk.wallpaper.R.layout.fragment_detail);
      sKeys.put("layout/fragment_detail_collections_0", com.hnk.wallpaper.R.layout.fragment_detail_collections);
      sKeys.put("layout/fragment_download_0", com.hnk.wallpaper.R.layout.fragment_download);
      sKeys.put("layout/fragment_favourites_0", com.hnk.wallpaper.R.layout.fragment_favourites);
      sKeys.put("layout/fragment_featured_0", com.hnk.wallpaper.R.layout.fragment_featured);
      sKeys.put("layout/fragment_filter_0", com.hnk.wallpaper.R.layout.fragment_filter);
      sKeys.put("layout/fragment_home_0", com.hnk.wallpaper.R.layout.fragment_home);
      sKeys.put("layout/fragment_intro_0", com.hnk.wallpaper.R.layout.fragment_intro);
      sKeys.put("layout-night/fragment_intro_create_wallpaper_0", com.hnk.wallpaper.R.layout.fragment_intro_create_wallpaper);
      sKeys.put("layout/fragment_intro_create_wallpaper_0", com.hnk.wallpaper.R.layout.fragment_intro_create_wallpaper);
      sKeys.put("layout/fragment_language_0", com.hnk.wallpaper.R.layout.fragment_language);
      sKeys.put("layout/fragment_notification_0", com.hnk.wallpaper.R.layout.fragment_notification);
      sKeys.put("layout/fragment_permission_0", com.hnk.wallpaper.R.layout.fragment_permission);
      sKeys.put("layout/fragment_photo_0", com.hnk.wallpaper.R.layout.fragment_photo);
      sKeys.put("layout/fragment_privicy_0", com.hnk.wallpaper.R.layout.fragment_privicy);
      sKeys.put("layout/fragment_recent_0", com.hnk.wallpaper.R.layout.fragment_recent);
      sKeys.put("layout/fragment_search_0", com.hnk.wallpaper.R.layout.fragment_search);
      sKeys.put("layout/fragment_setting_0", com.hnk.wallpaper.R.layout.fragment_setting);
      sKeys.put("layout/fragment_show_more_0", com.hnk.wallpaper.R.layout.fragment_show_more);
      sKeys.put("layout/fragment_show_more_collections_0", com.hnk.wallpaper.R.layout.fragment_show_more_collections);
      sKeys.put("layout/item_banner_0", com.hnk.wallpaper.R.layout.item_banner);
      sKeys.put("layout/item_banner_shimmer_0", com.hnk.wallpaper.R.layout.item_banner_shimmer);
      sKeys.put("layout/item_collection_shimer_0", com.hnk.wallpaper.R.layout.item_collection_shimer);
      sKeys.put("layout/item_collections_0", com.hnk.wallpaper.R.layout.item_collections);
      sKeys.put("layout/item_intro_0", com.hnk.wallpaper.R.layout.item_intro);
      sKeys.put("layout/item_intro_creative_wallpaper_0", com.hnk.wallpaper.R.layout.item_intro_creative_wallpaper);
      sKeys.put("layout/item_language_0", com.hnk.wallpaper.R.layout.item_language);
      sKeys.put("layout/item_wallpaper_0", com.hnk.wallpaper.R.layout.item_wallpaper);
      sKeys.put("layout/item_wallpaper_shimmer_0", com.hnk.wallpaper.R.layout.item_wallpaper_shimmer);
      sKeys.put("layout/nav_header_0", com.hnk.wallpaper.R.layout.nav_header);
      sKeys.put("layout/simple_list_item_checked_0", com.hnk.wallpaper.R.layout.simple_list_item_checked);
      sKeys.put("layout/spinner_item_0", com.hnk.wallpaper.R.layout.spinner_item);
    }
  }
}
