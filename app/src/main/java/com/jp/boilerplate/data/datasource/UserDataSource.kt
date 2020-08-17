package com.jp.boilerplate.data.datasource

import androidx.lifecycle.LiveData
import com.jp.boilerplate.data.entity.User

interface UserDataSource : BaseDataSource<User> {

    fun observeUser(): LiveData<User>

}
