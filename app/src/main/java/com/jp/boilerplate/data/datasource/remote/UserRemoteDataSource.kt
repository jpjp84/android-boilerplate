package com.jp.boilerplate.data.datasource.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.api.UserAPI
import com.jp.boilerplate.util.NetworkUtil

class UserRemoteDataSource : UserDataSource {

    override fun observeUser(): LiveData<User> {
        throw UnsupportedOperationException()
    }

    override suspend fun get(): User =
        NetworkUtil.getAPI(UserAPI::class.java).getUser()

    override suspend fun set(it: User) {
        val result = NetworkUtil.getAPI(UserAPI::class.java).setUser(it)
        it.id = result.id
    }
}
