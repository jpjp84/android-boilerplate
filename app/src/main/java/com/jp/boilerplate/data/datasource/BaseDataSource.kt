package com.jp.boilerplate.data.datasource

import com.jp.boilerplate.data.entity.User

interface BaseDataSource<T> {

    suspend fun get(): T

    suspend fun isCached(): Boolean

    suspend fun set(it: T): User
}
