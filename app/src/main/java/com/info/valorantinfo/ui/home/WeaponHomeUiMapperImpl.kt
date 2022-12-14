package com.info.valorantinfo.ui.home

import com.info.valorantinfo.domain.WeaponEntity
import com.info.valorantinfo.domain.mapper.WeaponListMapper
import javax.inject.Inject

class WeaponHomeUiMapperImpl @Inject constructor() : WeaponListMapper<WeaponEntity, HomeUiData> {
    override fun map(input: List<WeaponEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(it.displayName, it.displayIcon)
        } ?: emptyList()
    }
}