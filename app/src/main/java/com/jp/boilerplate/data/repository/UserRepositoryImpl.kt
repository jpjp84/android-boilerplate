package com.jp.boilerplate.data.repository

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import io.reactivex.Flowable

class UserRepositoryImpl constructor(
    private val userLocalDataSource: UserDataSource,
    private val userRemoteDataSource: UserDataSource
) : UserRepository {

    private var user: User? = null

    override fun getUser(forceUpdate: Boolean): Flowable<User> {
        return userLocalDataSource.isCached()
            .flatMapPublisher {
                if (forceUpdate || !it) {
                    userRemoteDataSource.getUser()
                } else {
                    userLocalDataSource.getUser()
                }
            }
            .flatMap {
                user = it
                userLocalDataSource.save(it).toSingle { it }.toFlowable()
            }
    }

    override fun isAdult(): Boolean {
        return user?.age!! > 19
    }
}