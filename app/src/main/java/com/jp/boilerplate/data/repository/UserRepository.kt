package com.jp.boilerplate.data.repository

import androidx.lifecycle.LiveData
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result

interface UserRepository {

    fun observable(): LiveData<Result<User>>

    fun getUser(forceUpdate: Boolean): LiveData<User>

    suspend fun updateUser()

    suspend fun setUser(user: User)
}
