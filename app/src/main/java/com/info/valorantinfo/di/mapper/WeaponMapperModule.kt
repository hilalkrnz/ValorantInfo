package com.info.valorantinfo.di.mapper

import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapper
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapperImpl
import com.info.valorantinfo.domain.model.WeaponUiData
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
    abstract fun bindWeaponDomainMapper(
       weaponUiDataListMapperImpl: WeaponUiDataListMapperImpl
    ): WeaponUiDataListMapper<WeaponDto, WeaponUiData>

}