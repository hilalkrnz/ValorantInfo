package com.info.valorantinfo.di.repository

import com.info.valorantinfo.data.repository.ValorantRepositoryImpl
import com.info.valorantinfo.domain.repository.ValorantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ValorantRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindValorantRepository(
        valorantRepositoryImpl: ValorantRepositoryImpl
    ): ValorantRepository
}