package com.jp.boilerplate.data.datasource

interface BaseDataSource<T> {

    suspend fun get(): T

    suspend fun set(it: T)
}
