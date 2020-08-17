package com.jp.boilerplate.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.db.UserDao

class UserLocalDataSource constructor(
    private val userDao: UserDao
) : UserDataSource {

    override fun observeUser(): LiveData<User> {
        return userDao.observable().map { it }
    }

    override suspend fun get(): User {
        return userDao.select()
    }

    override suspend fun set(it: User): User {
        userDao.insert(it)
        return it
    }
}
