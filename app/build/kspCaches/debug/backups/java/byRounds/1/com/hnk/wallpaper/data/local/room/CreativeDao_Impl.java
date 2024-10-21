package com.hnk.wallpaper.data.local.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hnk.wallpaper.data.model.Creative;
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
public final class CreativeDao_Impl implements CreativeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Creative> __insertionAdapterOfCreative;

  private final EntityDeletionOrUpdateAdapter<Creative> __deletionAdapterOfCreative;

  private final EntityDeletionOrUpdateAdapter<Creative> __updateAdapterOfCreative;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public CreativeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCreative = new EntityInsertionAdapter<Creative>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `Creative` (`photoUrl`,`photoUri`,`average_color`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Creative entity) {
        statement.bindString(1, entity.getPhotoUrl());
        statement.bindString(2, entity.getPhotoUri());
        if (entity.getAvgColor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAvgColor());
        }
        statement.bindLong(4, entity.getId());
      }
    };
    this.__deletionAdapterOfCreative = new EntityDeletionOrUpdateAdapter<Creative>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Creative` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Creative entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCreative = new EntityDeletionOrUpdateAdapter<Creative>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Creative` SET `photoUrl` = ?,`photoUri` = ?,`average_color` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Creative entity) {
        statement.bindString(1, entity.getPhotoUrl());
        statement.bindString(2, entity.getPhotoUri());
        if (entity.getAvgColor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAvgColor());
        }
        statement.bindLong(4, entity.getId());
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM Creative WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Creative creative, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCreative.insertAndReturnId(creative);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Creative creative, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __deletionAdapterOfCreative.handle(creative);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Creative creative, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __updateAdapterOfCreative.handle(creative);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteById(final int id, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Creative>> getAllCreative() {
    final String _sql = "SELECT * FROM Creative";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Creative"}, new Callable<List<Creative>>() {
      @Override
      @NonNull
      public List<Creative> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfAvgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "average_color");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Creative> _result = new ArrayList<Creative>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Creative _item;
            final String _tmpPhotoUrl;
            _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            final String _tmpPhotoUri;
            _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            final String _tmpAvgColor;
            if (_cursor.isNull(_cursorIndexOfAvgColor)) {
              _tmpAvgColor = null;
            } else {
              _tmpAvgColor = _cursor.getString(_cursorIndexOfAvgColor);
            }
            _item = new Creative(_tmpPhotoUrl,_tmpPhotoUri,_tmpAvgColor);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
