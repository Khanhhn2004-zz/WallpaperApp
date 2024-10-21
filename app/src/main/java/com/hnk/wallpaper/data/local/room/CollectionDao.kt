package com.hnk.wallpaper.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hnk.wallpaper.data.model.ItemCollection

@Dao
interface CollectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: ItemCollection): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollections(collections: List<ItemCollection>): List<Long>

    @Query("SELECT * FROM collections LIMIT :pageSize OFFSET :offset")
    fun getAllCollections(pageSize:Int, offset:Int): List<ItemCollection>

    @Query("SELECT * FROM collections WHERE id = :collectionId")
    suspend fun getCollectionById(collectionId: String): ItemCollection?

    @Query("SELECT EXISTS ( SELECT 1 FROM collections WHERE title =:title)")
    suspend fun isExistCollectionByTitle(title: String): Int

    @Query("SELECT COUNT(*) FROM collections")
    suspend fun getItemCountCollection(): Int

    @Query("""
    UPDATE collections 
    SET title = :title,
        description = :description,
        is_private = :isPrivate,
        media_count = :mediaCount,
        photos_count = :photosCount,
        cover = :cover
    WHERE id = :id
    """)
    suspend fun updateCollection(
        id: String,
        title: String,
        description: String?,
        isPrivate: Boolean,
        mediaCount: Int,
        photosCount: Int,
        cover: String?
    ): Int

    @Delete
    suspend fun deleteCollection(collection: ItemCollection): Int

    @Query("DELETE FROM collections")
    suspend fun deleteAllCollections(): Int
}
