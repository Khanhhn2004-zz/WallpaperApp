package com.hnk.wallpaper.data.local.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hnk.wallpaper.converters.Converters;
import com.hnk.wallpaper.data.enties.Src;
import com.hnk.wallpaper.data.model.ItemPhoto;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WallpaperDao_Impl implements WallpaperDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemPhoto> __insertionAdapterOfItemPhoto;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ItemPhoto> __deletionAdapterOfItemPhoto;

  private final EntityDeletionOrUpdateAdapter<ItemPhoto> __updateAdapterOfItemPhoto;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllWallpapers;

  private final SharedSQLiteStatement __preparedStmtOfDeletePhotosByType;

  public WallpaperDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemPhoto = new EntityInsertionAdapter<ItemPhoto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `wallpaper` (`photo_id`,`photo_width`,`photo_height`,`photo_url`,`photographer_name`,`photographer_url`,`photographer_id`,`average_color`,`source`,`is_liked`,`photo_alt`,`wallpaper_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemPhoto entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getWidth() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getWidth());
        }
        if (entity.getHeight() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getHeight());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUrl());
        }
        if (entity.getPhotographer() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhotographer());
        }
        if (entity.getPhotographerUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPhotographerUrl());
        }
        if (entity.getPhotographerId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getPhotographerId());
        }
        if (entity.getAvgColor() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getAvgColor());
        }
        final String _tmp = __converters.fromSrc(entity.getSrc());
        if (_tmp == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmp);
        }
        final Integer _tmp_1 = entity.getLiked() == null ? null : (entity.getLiked() ? 1 : 0);
        if (_tmp_1 == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, _tmp_1);
        }
        if (entity.getAlt() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAlt());
        }
        if (entity.getType() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getType());
        }
      }
    };
    this.__deletionAdapterOfItemPhoto = new EntityDeletionOrUpdateAdapter<ItemPhoto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `wallpaper` WHERE `photo_id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemPhoto entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfItemPhoto = new EntityDeletionOrUpdateAdapter<ItemPhoto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `wallpaper` SET `photo_id` = ?,`photo_width` = ?,`photo_height` = ?,`photo_url` = ?,`photographer_name` = ?,`photographer_url` = ?,`photographer_id` = ?,`average_color` = ?,`source` = ?,`is_liked` = ?,`photo_alt` = ?,`wallpaper_type` = ? WHERE `photo_id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemPhoto entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getWidth() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getWidth());
        }
        if (entity.getHeight() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getHeight());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUrl());
        }
        if (entity.getPhotographer() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhotographer());
        }
        if (entity.getPhotographerUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPhotographerUrl());
        }
        if (entity.getPhotographerId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getPhotographerId());
        }
        if (entity.getAvgColor() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getAvgColor());
        }
        final String _tmp = __converters.fromSrc(entity.getSrc());
        if (_tmp == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmp);
        }
        final Integer _tmp_1 = entity.getLiked() == null ? null : (entity.getLiked() ? 1 : 0);
        if (_tmp_1 == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, _tmp_1);
        }
        if (entity.getAlt() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAlt());
        }
        if (entity.getType() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getType());
        }
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindLong(13, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllWallpapers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM wallpaper";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePhotosByType = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM wallpaper WHERE wallpaper_type = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWallpaper(final ItemPhoto wallpaper,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemPhoto.insert(wallpaper);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertWallpapers(final List<ItemPhoto> wallpapers,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemPhoto.insert(wallpapers);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWallpaper(final ItemPhoto wallpaper,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfItemPhoto.handle(wallpaper);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWallpaper(final ItemPhoto wallpaper,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfItemPhoto.handle(wallpaper);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllWallpapers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllWallpapers.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllWallpapers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePhotosByType(final String type,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePhotosByType.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, type);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeletePhotosByType.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ItemPhoto>> getAllWallpapers() {
    final String _sql = "SELECT * FROM wallpaper";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wallpaper"}, new Callable<List<ItemPhoto>>() {
      @Override
      @NonNull
      public List<ItemPhoto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_id");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_height");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_url");
          final int _cursorIndexOfPhotographer = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_name");
          final int _cursorIndexOfPhotographerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_url");
          final int _cursorIndexOfPhotographerId = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_id");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "average_color");
          final int _cursorIndexOfSrc = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "is_liked");
          final int _cursorIndexOfAlt = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_alt");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "wallpaper_type");
          final List<ItemPhoto> _result = new ArrayList<ItemPhoto>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemPhoto _item;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Integer _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getInt(_cursorIndexOfWidth);
            }
            final Integer _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpPhotographer;
            if (_cursor.isNull(_cursorIndexOfPhotographer)) {
              _tmpPhotographer = null;
            } else {
              _tmpPhotographer = _cursor.getString(_cursorIndexOfPhotographer);
            }
            final String _tmpPhotographerUrl;
            if (_cursor.isNull(_cursorIndexOfPhotographerUrl)) {
              _tmpPhotographerUrl = null;
            } else {
              _tmpPhotographerUrl = _cursor.getString(_cursorIndexOfPhotographerUrl);
            }
            final Integer _tmpPhotographerId;
            if (_cursor.isNull(_cursorIndexOfPhotographerId)) {
              _tmpPhotographerId = null;
            } else {
              _tmpPhotographerId = _cursor.getInt(_cursorIndexOfPhotographerId);
            }
            final String _tmpAvgColor;
            if (_cursor.isNull(_cursorIndexOfAvgColor)) {
              _tmpAvgColor = null;
            } else {
              _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            }
            final Src _tmpSrc;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSrc)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSrc);
            }
            _tmpSrc = __converters.toSrc(_tmp);
            final Boolean _tmpLiked;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLiked)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfLiked);
            }
            _tmpLiked = _tmp_1 == null ? null : _tmp_1 != 0;
            final String _tmpAlt;
            if (_cursor.isNull(_cursorIndexOfAlt)) {
              _tmpAlt = null;
            } else {
              _tmpAlt = _cursor.getString(_cursorIndexOfAlt);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _item = new ItemPhoto(_tmpId,_tmpWidth,_tmpHeight,_tmpUrl,_tmpPhotographer,_tmpPhotographerUrl,_tmpPhotographerId,_tmpAvgColor,_tmpSrc,_tmpLiked,_tmpAlt,_tmpType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ItemPhoto>> getWallpapersByType(final String type) {
    final String _sql = "SELECT * FROM wallpaper WHERE wallpaper_type = ? ORDER BY photo_id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wallpaper"}, new Callable<List<ItemPhoto>>() {
      @Override
      @NonNull
      public List<ItemPhoto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_id");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_height");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_url");
          final int _cursorIndexOfPhotographer = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_name");
          final int _cursorIndexOfPhotographerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_url");
          final int _cursorIndexOfPhotographerId = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_id");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "average_color");
          final int _cursorIndexOfSrc = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "is_liked");
          final int _cursorIndexOfAlt = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_alt");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "wallpaper_type");
          final List<ItemPhoto> _result = new ArrayList<ItemPhoto>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemPhoto _item;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Integer _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getInt(_cursorIndexOfWidth);
            }
            final Integer _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpPhotographer;
            if (_cursor.isNull(_cursorIndexOfPhotographer)) {
              _tmpPhotographer = null;
            } else {
              _tmpPhotographer = _cursor.getString(_cursorIndexOfPhotographer);
            }
            final String _tmpPhotographerUrl;
            if (_cursor.isNull(_cursorIndexOfPhotographerUrl)) {
              _tmpPhotographerUrl = null;
            } else {
              _tmpPhotographerUrl = _cursor.getString(_cursorIndexOfPhotographerUrl);
            }
            final Integer _tmpPhotographerId;
            if (_cursor.isNull(_cursorIndexOfPhotographerId)) {
              _tmpPhotographerId = null;
            } else {
              _tmpPhotographerId = _cursor.getInt(_cursorIndexOfPhotographerId);
            }
            final String _tmpAvgColor;
            if (_cursor.isNull(_cursorIndexOfAvgColor)) {
              _tmpAvgColor = null;
            } else {
              _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            }
            final Src _tmpSrc;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSrc)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSrc);
            }
            _tmpSrc = __converters.toSrc(_tmp);
            final Boolean _tmpLiked;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLiked)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfLiked);
            }
            _tmpLiked = _tmp_1 == null ? null : _tmp_1 != 0;
            final String _tmpAlt;
            if (_cursor.isNull(_cursorIndexOfAlt)) {
              _tmpAlt = null;
            } else {
              _tmpAlt = _cursor.getString(_cursorIndexOfAlt);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _item = new ItemPhoto(_tmpId,_tmpWidth,_tmpHeight,_tmpUrl,_tmpPhotographer,_tmpPhotographerUrl,_tmpPhotographerId,_tmpAvgColor,_tmpSrc,_tmpLiked,_tmpAlt,_tmpType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getWallpaperById(final int wallpaperId,
      final Continuation<? super ItemPhoto> $completion) {
    final String _sql = "SELECT * FROM wallpaper WHERE photo_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, wallpaperId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ItemPhoto>() {
      @Override
      @Nullable
      public ItemPhoto call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_id");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_height");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_url");
          final int _cursorIndexOfPhotographer = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_name");
          final int _cursorIndexOfPhotographerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_url");
          final int _cursorIndexOfPhotographerId = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer_id");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "average_color");
          final int _cursorIndexOfSrc = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "is_liked");
          final int _cursorIndexOfAlt = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_alt");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "wallpaper_type");
          final ItemPhoto _result;
          if (_cursor.moveToFirst()) {
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Integer _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getInt(_cursorIndexOfWidth);
            }
            final Integer _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpPhotographer;
            if (_cursor.isNull(_cursorIndexOfPhotographer)) {
              _tmpPhotographer = null;
            } else {
              _tmpPhotographer = _cursor.getString(_cursorIndexOfPhotographer);
            }
            final String _tmpPhotographerUrl;
            if (_cursor.isNull(_cursorIndexOfPhotographerUrl)) {
              _tmpPhotographerUrl = null;
            } else {
              _tmpPhotographerUrl = _cursor.getString(_cursorIndexOfPhotographerUrl);
            }
            final Integer _tmpPhotographerId;
            if (_cursor.isNull(_cursorIndexOfPhotographerId)) {
              _tmpPhotographerId = null;
            } else {
              _tmpPhotographerId = _cursor.getInt(_cursorIndexOfPhotographerId);
            }
            final String _tmpAvgColor;
            if (_cursor.isNull(_cursorIndexOfAvgColor)) {
              _tmpAvgColor = null;
            } else {
              _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            }
            final Src _tmpSrc;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSrc)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSrc);
            }
            _tmpSrc = __converters.toSrc(_tmp);
            final Boolean _tmpLiked;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLiked)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfLiked);
            }
            _tmpLiked = _tmp_1 == null ? null : _tmp_1 != 0;
            final String _tmpAlt;
            if (_cursor.isNull(_cursorIndexOfAlt)) {
              _tmpAlt = null;
            } else {
              _tmpAlt = _cursor.getString(_cursorIndexOfAlt);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _result = new ItemPhoto(_tmpId,_tmpWidth,_tmpHeight,_tmpUrl,_tmpPhotographer,_tmpPhotographerUrl,_tmpPhotographerId,_tmpAvgColor,_tmpSrc,_tmpLiked,_tmpAlt,_tmpType);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
