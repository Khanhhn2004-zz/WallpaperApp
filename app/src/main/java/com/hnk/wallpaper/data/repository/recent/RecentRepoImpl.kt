package com.hnk.wallpaper.data.repository.recent

import com.hnk.wallpaper.data.local.room.RecentDao
import com.hnk.wallpaper.data.model.Recent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecentRepoImpl @Inject constructor(
    private val recentDao: RecentDao

) : RecentRepo {
    override suspend fun insert(photo: Recent) = flow {
        val exists = recentDao.checkIfExists(photo.photoUrl)
        if (exists == 0) {
            val count = recentDao.getCount()
            if (count >= 50) {
                recentDao.deleteOldest()
            }
            emit(recentDao.insert(photo))
        } else {
            emit(-1L)
        }
    }

    override suspend fun update(photo: Recent) = flow {
        emit(recentDao.update(photo))
    }

    override suspend fun delete(photo: Recent) = flow {
        emit(recentDao.delete(photo))
    }

    override fun getAllRecent(): Flow<List<Recent>> = recentDao.getAllRecent()

}