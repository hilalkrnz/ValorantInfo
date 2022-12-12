package com.info.valorantinfo.domain.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto

interface ValorantRepository {
    suspend fun getWeapons(): NetworkResponseState<List<WeaponDto>>
    suspend fun getWeaponById(weaponUuid: String): NetworkResponseState<List<WeaponDto>>
}