package com.info.valorantinfo.di

import com.info.valorantinfo.data.source.RemoteDatSourceImpl
import com.info.valorantinfo.data.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDatSourceImpl
    ) : RemoteDataSource
}