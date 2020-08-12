package com.jp.boilerplate.data.meta.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jp.boilerplate.data.entity.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user")
    fun observable(): LiveData<User>

    @Query("SELECT * FROM user")
    fun select(): User
}
