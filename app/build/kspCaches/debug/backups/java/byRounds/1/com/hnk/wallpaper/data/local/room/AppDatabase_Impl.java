package com.hnk.wallpaper.data.local.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DownloadDao _downloadDao;

  private volatile RecentDao _recentDao;

  private volatile FavoriteDao _favoriteDao;

  private volatile CollectionDao _collectionDao;

  private volatile CreativeDao _creativeDao;

  private volatile WallpaperDao _wallpaperDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `ItemDownload` (`photoUrl` TEXT NOT NULL, `photoUri` TEXT NOT NULL, `avgColor` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ItemDownload_photoUrl` ON `ItemDownload` (`photoUrl`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Recent` (`photoUrl` TEXT NOT NULL, `average_color` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ItemFavorite` (`downloadId` INTEGER NOT NULL, `photoUrl` TEXT NOT NULL, `photoUri` TEXT NOT NULL, `avgColor` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`downloadId`) REFERENCES `ItemDownload`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `collections` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT, `is_private` INTEGER NOT NULL, `media_count` INTEGER NOT NULL, `photos_count` INTEGER NOT NULL, `cover` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Creative` (`photoUrl` TEXT NOT NULL, `photoUri` TEXT NOT NULL, `average_color` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `wallpaper` (`photo_id` INTEGER, `photo_width` INTEGER, `photo_height` INTEGER, `photo_url` TEXT, `photographer_name` TEXT, `photographer_url` TEXT, `photographer_id` INTEGER, `average_color` TEXT, `source` TEXT, `is_liked` INTEGER, `photo_alt` TEXT, `wallpaper_type` TEXT, PRIMARY KEY(`photo_id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '435ba6be872bb8c30ca8e6e7c1421647')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `ItemDownload`");
        db.execSQL("DROP TABLE IF EXISTS `Recent`");
        db.execSQL("DROP TABLE IF EXISTS `ItemFavorite`");
        db.execSQL("DROP TABLE IF EXISTS `collections`");
        db.execSQL("DROP TABLE IF EXISTS `Creative`");
        db.execSQL("DROP TABLE IF EXISTS `wallpaper`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsItemDownload = new HashMap<String, TableInfo.Column>(4);
        _columnsItemDownload.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDownload.put("photoUri", new TableInfo.Column("photoUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDownload.put("avgColor", new TableInfo.Column("avgColor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemDownload.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemDownload = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemDownload = new HashSet<TableInfo.Index>(1);
        _indicesItemDownload.add(new TableInfo.Index("index_ItemDownload_photoUrl", true, Arrays.asList("photoUrl"), Arrays.asList("ASC")));
        final TableInfo _infoItemDownload = new TableInfo("ItemDownload", _columnsItemDownload, _foreignKeysItemDownload, _indicesItemDownload);
        final TableInfo _existingItemDownload = TableInfo.read(db, "ItemDownload");
        if (!_infoItemDownload.equals(_existingItemDownload)) {
          return new RoomOpenHelper.ValidationResult(false, "ItemDownload(com.hnk.wallpaper.data.model.ItemDownload).\n"
                  + " Expected:\n" + _infoItemDownload + "\n"
                  + " Found:\n" + _existingItemDownload);
        }
        final HashMap<String, TableInfo.Column> _columnsRecent = new HashMap<String, TableInfo.Column>(3);
        _columnsRecent.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecent.put("average_color", new TableInfo.Column("average_color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecent = new TableInfo("Recent", _columnsRecent, _foreignKeysRecent, _indicesRecent);
        final TableInfo _existingRecent = TableInfo.read(db, "Recent");
        if (!_infoRecent.equals(_existingRecent)) {
          return new RoomOpenHelper.ValidationResult(false, "Recent(com.hnk.wallpaper.data.model.Recent).\n"
                  + " Expected:\n" + _infoRecent + "\n"
                  + " Found:\n" + _existingRecent);
        }
        final HashMap<String, TableInfo.Column> _columnsItemFavorite = new HashMap<String, TableInfo.Column>(5);
        _columnsItemFavorite.put("downloadId", new TableInfo.Column("downloadId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemFavorite.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemFavorite.put("photoUri", new TableInfo.Column("photoUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemFavorite.put("avgColor", new TableInfo.Column("avgColor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemFavorite.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemFavorite = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysItemFavorite.add(new TableInfo.ForeignKey("ItemDownload", "CASCADE", "NO ACTION", Arrays.asList("downloadId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemFavorite = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemFavorite = new TableInfo("ItemFavorite", _columnsItemFavorite, _foreignKeysItemFavorite, _indicesItemFavorite);
        final TableInfo _existingItemFavorite = TableInfo.read(db, "ItemFavorite");
        if (!_infoItemFavorite.equals(_existingItemFavorite)) {
          return new RoomOpenHelper.ValidationResult(false, "ItemFavorite(com.hnk.wallpaper.data.model.ItemFavorite).\n"
                  + " Expected:\n" + _infoItemFavorite + "\n"
                  + " Found:\n" + _existingItemFavorite);
        }
        final HashMap<String, TableInfo.Column> _columnsCollections = new HashMap<String, TableInfo.Column>(7);
        _columnsCollections.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("is_private", new TableInfo.Column("is_private", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("media_count", new TableInfo.Column("media_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("photos_count", new TableInfo.Column("photos_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollections.put("cover", new TableInfo.Column("cover", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCollections = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCollections = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCollections = new TableInfo("collections", _columnsCollections, _foreignKeysCollections, _indicesCollections);
        final TableInfo _existingCollections = TableInfo.read(db, "collections");
        if (!_infoCollections.equals(_existingCollections)) {
          return new RoomOpenHelper.ValidationResult(false, "collections(com.hnk.wallpaper.data.model.ItemCollection).\n"
                  + " Expected:\n" + _infoCollections + "\n"
                  + " Found:\n" + _existingCollections);
        }
        final HashMap<String, TableInfo.Column> _columnsCreative = new HashMap<String, TableInfo.Column>(4);
        _columnsCreative.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreative.put("photoUri", new TableInfo.Column("photoUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreative.put("average_color", new TableInfo.Column("average_color", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreative.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreative = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreative = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreative = new TableInfo("Creative", _columnsCreative, _foreignKeysCreative, _indicesCreative);
        final TableInfo _existingCreative = TableInfo.read(db, "Creative");
        if (!_infoCreative.equals(_existingCreative)) {
          return new RoomOpenHelper.ValidationResult(false, "Creative(com.hnk.wallpaper.data.model.Creative).\n"
                  + " Expected:\n" + _infoCreative + "\n"
                  + " Found:\n" + _existingCreative);
        }
        final HashMap<String, TableInfo.Column> _columnsWallpaper = new HashMap<String, TableInfo.Column>(12);
        _columnsWallpaper.put("photo_id", new TableInfo.Column("photo_id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photo_width", new TableInfo.Column("photo_width", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photo_height", new TableInfo.Column("photo_height", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photo_url", new TableInfo.Column("photo_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photographer_name", new TableInfo.Column("photographer_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photographer_url", new TableInfo.Column("photographer_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photographer_id", new TableInfo.Column("photographer_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("average_color", new TableInfo.Column("average_color", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("source", new TableInfo.Column("source", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("is_liked", new TableInfo.Column("is_liked", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("photo_alt", new TableInfo.Column("photo_alt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWallpaper.put("wallpaper_type", new TableInfo.Column("wallpaper_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWallpaper = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWallpaper = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWallpaper = new TableInfo("wallpaper", _columnsWallpaper, _foreignKeysWallpaper, _indicesWallpaper);
        final TableInfo _existingWallpaper = TableInfo.read(db, "wallpaper");
        if (!_infoWallpaper.equals(_existingWallpaper)) {
          return new RoomOpenHelper.ValidationResult(false, "wallpaper(com.hnk.wallpaper.data.model.ItemPhoto).\n"
                  + " Expected:\n" + _infoWallpaper + "\n"
                  + " Found:\n" + _existingWallpaper);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "435ba6be872bb8c30ca8e6e7c1421647", "bda9a9c3d59e34da28e59f7e0b7fc8f1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ItemDownload","Recent","ItemFavorite","collections","Creative","wallpaper");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `ItemDownload`");
      _db.execSQL("DELETE FROM `Recent`");
      _db.execSQL("DELETE FROM `ItemFavorite`");
      _db.execSQL("DELETE FROM `collections`");
      _db.execSQL("DELETE FROM `Creative`");
      _db.execSQL("DELETE FROM `wallpaper`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DownloadDao.class, DownloadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RecentDao.class, RecentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FavoriteDao.class, FavoriteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CollectionDao.class, CollectionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CreativeDao.class, CreativeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WallpaperDao.class, WallpaperDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public DownloadDao downloadDao() {
    if (_downloadDao != null) {
      return _downloadDao;
    } else {
      synchronized(this) {
        if(_downloadDao == null) {
          _downloadDao = new DownloadDao_Impl(this);
        }
        return _downloadDao;
      }
    }
  }

  @Override
  public RecentDao recentDao() {
    if (_recentDao != null) {
      return _recentDao;
    } else {
      synchronized(this) {
        if(_recentDao == null) {
          _recentDao = new RecentDao_Impl(this);
        }
        return _recentDao;
      }
    }
  }

  @Override
  public FavoriteDao favoriteDao() {
    if (_favoriteDao != null) {
      return _favoriteDao;
    } else {
      synchronized(this) {
        if(_favoriteDao == null) {
          _favoriteDao = new FavoriteDao_Impl(this);
        }
        return _favoriteDao;
      }
    }
  }

  @Override
  public CollectionDao collectionDao() {
    if (_collectionDao != null) {
      return _collectionDao;
    } else {
      synchronized(this) {
        if(_collectionDao == null) {
          _collectionDao = new CollectionDao_Impl(this);
        }
        return _collectionDao;
      }
    }
  }

  @Override
  public CreativeDao creativeDao() {
    if (_creativeDao != null) {
      return _creativeDao;
    } else {
      synchronized(this) {
        if(_creativeDao == null) {
          _creativeDao = new CreativeDao_Impl(this);
        }
        return _creativeDao;
      }
    }
  }

  @Override
  public WallpaperDao wallpaperDao() {
    if (_wallpaperDao != null) {
      return _wallpaperDao;
    } else {
      synchronized(this) {
        if(_wallpaperDao == null) {
          _wallpaperDao = new WallpaperDao_Impl(this);
        }
        return _wallpaperDao;
      }
    }
  }
}
