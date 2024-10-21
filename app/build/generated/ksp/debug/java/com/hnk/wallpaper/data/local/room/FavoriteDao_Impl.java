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
import com.hnk.wallpaper.data.model.ItemFavorite;
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
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemFavorite> __insertionAdapterOfItemFavorite;

  private final EntityDeletionOrUpdateAdapter<ItemFavorite> __deletionAdapterOfItemFavorite;

  private final EntityDeletionOrUpdateAdapter<ItemFavorite> __updateAdapterOfItemFavorite;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByDownloadId;

  public FavoriteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemFavorite = new EntityInsertionAdapter<ItemFavorite>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `ItemFavorite` (`downloadId`,`photoUrl`,`photoUri`,`avgColor`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemFavorite entity) {
        statement.bindLong(1, entity.getDownloadId());
        statement.bindString(2, entity.getPhotoUrl());
        statement.bindString(3, entity.getPhotoUri());
        statement.bindString(4, entity.getAvgColor());
        statement.bindLong(5, entity.getId());
      }
    };
    this.__deletionAdapterOfItemFavorite = new EntityDeletionOrUpdateAdapter<ItemFavorite>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `ItemFavorite` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemFavorite entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfItemFavorite = new EntityDeletionOrUpdateAdapter<ItemFavorite>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `ItemFavorite` SET `downloadId` = ?,`photoUrl` = ?,`photoUri` = ?,`avgColor` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemFavorite entity) {
        statement.bindLong(1, entity.getDownloadId());
        statement.bindString(2, entity.getPhotoUrl());
        statement.bindString(3, entity.getPhotoUri());
        statement.bindString(4, entity.getAvgColor());
        statement.bindLong(5, entity.getId());
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteByDownloadId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ItemFavorite WHERE downloadId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ItemFavorite favorite, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfItemFavorite.insertAndReturnId(favorite);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final ItemFavorite itemFavorite,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __deletionAdapterOfItemFavorite.handle(itemFavorite);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final ItemFavorite itemFavorite,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __updateAdapterOfItemFavorite.handle(itemFavorite);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteByDownloadId(final int downloadId,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByDownloadId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, downloadId);
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByDownloadId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ItemFavorite>> getAllItemFavorite() {
    final String _sql = "SELECT * FROM ItemFavorite Order by id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ItemFavorite"}, new Callable<List<ItemFavorite>>() {
      @Override
      @NonNull
      public List<ItemFavorite> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDownloadId = CursorUtil.getColumnIndexOrThrow(_cursor, "downloadId");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avgColor");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<ItemFavorite> _result = new ArrayList<ItemFavorite>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemFavorite _item;
            final int _tmpDownloadId;
            _tmpDownloadId = _cursor.getInt(_cursorIndexOfDownloadId);
            final String _tmpPhotoUrl;
            _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            final String _tmpPhotoUri;
            _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            final String _tmpAvgColor;
            _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            _item = new ItemFavorite(_tmpDownloadId,_tmpPhotoUrl,_tmpPhotoUri,_tmpAvgColor);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
  public Object isFavorite(final int downloadId,
      final Continuation<? super ItemFavorite> $completion) {
    final String _sql = "SELECT * FROM ItemFavorite WHERE downloadId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, downloadId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ItemFavorite>() {
      @Override
      @Nullable
      public ItemFavorite call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDownloadId = CursorUtil.getColumnIndexOrThrow(_cursor, "downloadId");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "avgColor");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final ItemFavorite _result;
          if (_cursor.moveToFirst()) {
            final int _tmpDownloadId;
            _tmpDownloadId = _cursor.getInt(_cursorIndexOfDownloadId);
            final String _tmpPhotoUrl;
            _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            final String _tmpPhotoUri;
            _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            final String _tmpAvgColor;
            _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            _result = new ItemFavorite(_tmpDownloadId,_tmpPhotoUrl,_tmpPhotoUri,_tmpAvgColor);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
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

  @Override
  public int getIdDownloadWithUrl(final String url) {
    final String _sql = "SELECT id FROM ItemDownload WHERE photoUrl = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, url);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getAllFavoriteDownloadIds(final Continuation<? super List<Integer>> $completion) {
    final String _sql = "SELECT downloadId FROM ItemFavorite";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Integer>>() {
      @Override
      @NonNull
      public List<Integer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Integer _item;
            _item = _cursor.getInt(0);
            _result.add(_item);
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
