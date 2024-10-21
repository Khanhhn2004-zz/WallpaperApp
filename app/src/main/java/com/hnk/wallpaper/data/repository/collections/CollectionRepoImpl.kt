package com.hnk.wallpaper.data.repository.collections

import android.app.Application
import androidx.paging.PagingSource
import com.hnk.wallpaper.data.api.PexelsApi
import com.hnk.wallpaper.data.local.room.CollectionDao
import com.hnk.wallpaper.data.model.ItemCollection
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CollectionRepoImpl @Inject constructor(
    private val mPexelsApi: PexelsApi,
    private val collectionDao: CollectionDao,
    private val application: Application
) : CollectionRepo {

    override fun getFeaturedCollections(): PagingSource<Int, ItemCollection> {
        return CollectionPagingSource(mPexelsApi, collectionDao, application)
    }

    override suspend fun insertCollection(collection: ItemCollection) = flow {
        emit(collectionDao.insertCollection(collection))
    }

    override suspend fun insertCollections(collections: List<ItemCollection>) = flow {
        emit(collectionDao.insertCollections(collections))
    }

    override suspend fun getCollectionById(collectionId: String) = flow {
        emit(collectionDao.getCollectionById(collectionId))
    }

    override suspend fun updateCollection(collection: ItemCollection) = flow {
        emit(
            collectionDao.updateCollection(
                id = collection.id,
                title = collection.title,
                description = collection.description,
                isPrivate = collection.isPrivate,
                mediaCount = collection.mediaCount,
                photosCount = collection.photosCount,
                cover = collection.cover
            )
        )
    }

    override suspend fun deleteCollection(collection: ItemCollection) = flow {
        emit(collectionDao.deleteCollection(collection))
    }

    override suspend fun deleteAllCollections() = flow {
        emit(collectionDao.deleteAllCollections())
    }
}
