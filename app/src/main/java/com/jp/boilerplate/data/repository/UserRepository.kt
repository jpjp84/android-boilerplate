package com.jp.boilerplate.data.repository

import androidx.lifecycle.LiveData
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result

interface UserRepository {

    fun observable(): LiveData<User>

    fun refreshUser(forceUpdate: Boolean): LiveData<Result<Void>>

    suspend fun setUser(user: User)
}
