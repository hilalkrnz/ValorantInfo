package com.info.valorantinfo.di

import com.info.valorantinfo.domain.usecase.getWeapon.GetWeaponsUseCase
import com.info.valorantinfo.domain.usecase.getWeapon.GetWeaponsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GetWeaponsUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetWeaponsUseCase(
        getWeaponsUseCaseImpl: GetWeaponsUseCaseImpl
    ): GetWeaponsUseCase
}