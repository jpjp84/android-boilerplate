package com.jp.boilerplate.data.datasource

import androidx.lifecycle.LiveData
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result

interface UserDataSource : BaseDataSource<User> {

    fun observeUser(): LiveData<Result<User>>

}
