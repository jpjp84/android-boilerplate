package com.jp.boilerplate.data.meta.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jp.boilerplate.data.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDB() : RoomDatabase() {

    abstract fun userDao(): UserDao
}