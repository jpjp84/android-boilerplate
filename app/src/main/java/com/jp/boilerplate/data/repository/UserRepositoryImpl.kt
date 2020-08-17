package com.jp.boilerplate.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result
import kotlinx.coroutines.Dispatchers

class UserRepositoryImpl constructor(
    private val userLocalDataSource: UserDataSource,
    private val userRemoteDataSource: UserDataSource
) : UserRepository {

    override fun observable(): LiveData<User> = userLocalDataSource.observeUser().distinctUntilChanged().map { it }

    override fun refreshUser(forceUpdate: Boolean): LiveData<Result<Void>> = liveData(Dispatchers.IO) {
        try {
            if (forceUpdate) {
                emit(Result.loading())
                updateUserByRemote()
            }
            emit(Result.success())
        } catch (e: Exception) {
            emit(Result.error(e.message!!))
        }
    }

    private suspend fun updateUserByRemote() {
        userRemoteDataSource.get().also {
            userLocalDataSource.set(it)
        }
    }

    override suspend fun setUser(user: User) {
        userRemoteDataSource.set(user)
    }
}
