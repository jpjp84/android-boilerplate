package com.jp.boilerplate.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result
import com.jp.boilerplate.data.meta.db.UserDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class UserLocalDataSource constructor(
    private val userDao: UserDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UserDataSource {

    override fun observeUser(): LiveData<Result<User>> {
        return userDao.observable().map { Result.Success(it) }
    }

    override suspend fun get(): User {
        return userDao.select()
    }

    override suspend fun isCached(): Boolean = try {
        get()
        true
    } catch (e: Exception) {
        false
    }

    override suspend fun set(it: User): User {
        userDao.insert(it)
        return it
    }
}
