package com.info.valorantinfo.di.mapper

import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.domain.mapper.WeaponDomainListMapperImpl
import com.info.valorantinfo.domain.WeaponEntity
import com.info.valorantinfo.domain.mapper.WeaponListMapper
import com.info.valorantinfo.ui.home.HomeUiData
import com.info.valorantinfo.ui.home.WeaponHomeUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class WeaponMapperModule {

    @Binds
    @Singleton
    abstract fun bindWeaponDomainListMapper(
        weaponDomainListMapperImpl: WeaponDomainListMapperImpl
    ): WeaponListMapper<WeaponDto, WeaponEntity>

    @Binds
    @Singleton
    abstract fun bindWeaponHomeUiMapper(
        weaponHomeUiMapperImpl: WeaponHomeUiMapperImpl
    ): WeaponListMapper<WeaponEntity, HomeUiData>
}