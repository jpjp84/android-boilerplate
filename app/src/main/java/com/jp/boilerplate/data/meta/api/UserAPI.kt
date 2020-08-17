package com.jp.boilerplate.data.meta.api

import com.jp.boilerplate.data.entity.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAPI {

    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    @GET("user/-MEfQyRUF3JqAuipDMHh.json")
    suspend fun getUser(): User

    @POST("user.json")
    suspend fun setUser(@Body user: User): FirebaseResult
}
