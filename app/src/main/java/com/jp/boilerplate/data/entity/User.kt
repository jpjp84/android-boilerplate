package com.jp.boilerplate.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User constructor(
    @PrimaryKey(autoGenerate = false) var id: String = "",
    val name: String,
    val age: Int
)
