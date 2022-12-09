package com.info.valorantinfo.di

import com.info.valorantinfo.domain.usecase.getWeaponById.GetWeaponByIdUseCase
import com.info.valorantinfo.domain.usecase.getWeaponById.GetWeaponByIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GetWeaponByIdUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetWeaponByIdUseCase(
        getWeaponByIdUseCaseImpl: GetWeaponByIdUseCaseImpl
    ): GetWeaponByIdUseCase
}