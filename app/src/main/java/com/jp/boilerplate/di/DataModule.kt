package com.jp.boilerplate.di

import android.content.Context
import com.jp.boilerplate.data.repository.UserRepositoryImpl
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.datasource.local.UserLocalDataSource
import com.jp.boilerplate.data.datasource.remote.UserRemoteDataSource
import com.jp.boilerplate.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    @AppModule.LocalDataSource
    fun bindLocalUserDataSource(@ApplicationContext context: Context): UserDataSource =
        UserLocalDataSource(context)

    @Singleton
    @Provides
    @AppModule.RemoteDataSource
    fun bindRemoteUserDataSource(): UserDataSource = UserRemoteDataSource()
}

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryBindModule {

    @Singleton
    @Provides
    fun bindRepository(
        @AppModule.LocalDataSource userLocalDataSource: UserDataSource,
        @AppModule.RemoteDataSource userRemoteDataSource: UserDataSource
    ): UserRepository = UserRepositoryImpl(userLocalDataSource, userRemoteDataSource)
}