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
import com.hnk.wallpaper.data.model.ItemCollection;
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

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CollectionDao_Impl implements CollectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemCollection> __insertionAdapterOfItemCollection;

  private final EntityDeletionOrUpdateAdapter<ItemCollection> __deletionAdapterOfItemCollection;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCollection;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCollections;

  public CollectionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemCollection = new EntityInsertionAdapter<ItemCollection>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `collections` (`id`,`title`,`description`,`is_private`,`media_count`,`photos_count`,`cover`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemCollection entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        final int _tmp = entity.isPrivate() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.getMediaCount());
        statement.bindLong(6, entity.getPhotosCount());
        if (entity.getCover() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCover());
        }
      }
    };
    this.__deletionAdapterOfItemCollection = new EntityDeletionOrUpdateAdapter<ItemCollection>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `collections` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemCollection entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateCollection = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "    UPDATE collections \n"
                + "    SET title = ?,\n"
                + "        description = ?,\n"
                + "        is_private = ?,\n"
                + "        media_count = ?,\n"
                + "        photos_count = ?,\n"
                + "        cover = ?\n"
                + "    WHERE id = ?\n"
                + "    ";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCollections = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM collections";
        return _query;
      }
    };
  }

  @Override
  public Object insertCollection(final ItemCollection collection,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfItemCollection.insertAndReturnId(collection);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertCollections(final List<ItemCollection> collections,
      final Continuation<? super List<Long>> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<List<Long>>() {
      @Override
      @NonNull
      public List<Long> call() throws Exception {
        __db.beginTransaction();
        try {
          final List<Long> _result = __insertionAdapterOfItemCollection.insertAndReturnIdsList(collections);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteCollection(final ItemCollection collection,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __deletionAdapterOfItemCollection.handle(collection);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCollection(final String id, final String title, final String description,
      final boolean isPrivate, final int mediaCount, final int photosCount, final String cover,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCollection.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, title);
        _argIndex = 2;
        if (description == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, description);
        }
        _argIndex = 3;
        final int _tmp = isPrivate ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, mediaCount);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, photosCount);
        _argIndex = 6;
        if (cover == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, cover);
        }
        _argIndex = 7;
        _stmt.bindString(_argIndex, id);
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
          __preparedStmtOfUpdateCollection.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllCollections(final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCollections.acquire();
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
          __preparedStmtOfDeleteAllCollections.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public List<ItemCollection> getAllCollections(final int pageSize, final int offset) {
    final String _sql = "SELECT * FROM collections LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pageSize);
    _argIndex = 2;
    _statement.bindLong(_argIndex, offset);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "is_private");
      final int _cursorIndexOfMediaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "media_count");
      final int _cursorIndexOfPhotosCount = CursorUtil.getColumnIndexOrThrow(_cursor, "photos_count");
      final int _cursorIndexOfCover = CursorUtil.getColumnIndexOrThrow(_cursor, "cover");
      final List<ItemCollection> _result = new ArrayList<ItemCollection>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final ItemCollection _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final boolean _tmpIsPrivate;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPrivate);
        _tmpIsPrivate = _tmp != 0;
        final int _tmpMediaCount;
        _tmpMediaCount = _cursor.getInt(_cursorIndexOfMediaCount);
        final int _tmpPhotosCount;
        _tmpPhotosCount = _cursor.getInt(_cursorIndexOfPhotosCount);
        final String _tmpCover;
        if (_cursor.isNull(_cursorIndexOfCover)) {
          _tmpCover = null;
        } else {
          _tmpCover = _cursor.getString(_cursorIndexOfCover);
        }
        _item = new ItemCollection(_tmpId,_tmpTitle,_tmpDescription,_tmpIsPrivate,_tmpMediaCount,_tmpPhotosCount,_tmpCover);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getCollectionById(final String collectionId,
      final Continuation<? super ItemCollection> $completion) {
    final String _sql = "SELECT * FROM collections WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, collectionId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ItemCollection>() {
      @Override
      @Nullable
      public ItemCollection call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "is_private");
          final int _cursorIndexOfMediaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "media_count");
          final int _cursorIndexOfPhotosCount = CursorUtil.getColumnIndexOrThrow(_cursor, "photos_count");
          final int _cursorIndexOfCover = CursorUtil.getColumnIndexOrThrow(_cursor, "cover");
          final ItemCollection _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpIsPrivate;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp != 0;
            final int _tmpMediaCount;
            _tmpMediaCount = _cursor.getInt(_cursorIndexOfMediaCount);
            final int _tmpPhotosCount;
            _tmpPhotosCount = _cursor.getInt(_cursorIndexOfPhotosCount);
            final String _tmpCover;
            if (_cursor.isNull(_cursorIndexOfCover)) {
              _tmpCover = null;
            } else {
              _tmpCover = _cursor.getString(_cursorIndexOfCover);
            }
            _result = new ItemCollection(_tmpId,_tmpTitle,_tmpDescription,_tmpIsPrivate,_tmpMediaCount,_tmpPhotosCount,_tmpCover);
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
  public Object isExistCollectionByTitle(final String title,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT EXISTS ( SELECT 1 FROM collections WHERE title =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, title);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
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
  public Object getItemCountCollection(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM collections";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
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
