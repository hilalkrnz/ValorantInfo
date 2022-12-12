package com.info.valorantinfo.domain.mapper

import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.domain.WeaponEntity
import javax.inject.Inject

class WeaponDomainListMapperImpl @Inject constructor() : WeaponListMapper<WeaponDto, WeaponEntity> {
    override fun map(input: List<WeaponDto>?): List<WeaponEntity> {
        return input?.map {
            WeaponEntity(
                uuid = it.uuid.orEmpty(),
                displayName = it.displayName.orEmpty(),
                displayIcon = it.displayIcon.orEmpty(),
                category = it.category.orEmpty()
            )
        } ?: emptyList()
    }
}