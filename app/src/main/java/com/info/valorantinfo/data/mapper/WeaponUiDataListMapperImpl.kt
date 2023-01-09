package com.info.valorantinfo.data.mapper

import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.domain.model.WeaponUiData
import javax.inject.Inject

class WeaponUiDataListMapperImpl @Inject constructor() : WeaponUiDataListMapper<WeaponDto, WeaponUiData> {
    override fun map(input: List<WeaponDto>?): List<WeaponUiData> {
        return input?.map {
            WeaponUiData(
                id = it.uuid.orEmpty(),
                imageUrl = it.displayIcon.orEmpty(),
                name = it.displayName.orEmpty(),
                category = it.category.orEmpty()
            )
        } ?: emptyList()
    }

}
