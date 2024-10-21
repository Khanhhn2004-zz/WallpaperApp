package com.hnk.wallpaper.data.repository.collections

import androidx.paging.PagingSource
import com.hnk.wallpaper.data.model.ItemCollection
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the Collection repository.
 * This interface defines the contract for accessing collection data, specifically
 * for retrieving featured collections.
 */
interface CollectionRepo {

    /**
     * Retrieves a list of featured collections from a data source.
     *
     * @param page The page number to retrieve, useful for pagination.
     * @param perPage The number of collections to retrieve per page.
     * @return A Flow that emits a list of Collection objects or null if no data is available.
     *         The use of Flow allows for asynchronous and reactive data handling.
     */
    fun getFeaturedCollections(): PagingSource<Int, ItemCollection>

    suspend fun insertCollection(collection: ItemCollection): Flow<Long>

    suspend fun insertCollections(collections: List<ItemCollection>): Flow<List<Long>>

    suspend fun getCollectionById(collectionId: String): Flow<ItemCollection?>

    suspend fun updateCollection(collection: ItemCollection): Flow<Int>

    suspend fun deleteCollection(collection: ItemCollection): Flow<Int>

    suspend fun deleteAllCollections(): Flow<Int>
}