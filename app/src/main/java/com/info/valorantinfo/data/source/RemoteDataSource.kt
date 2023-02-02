package com.info.valorantinfo.data.source

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto

interface RemoteDataSource {

    suspend fun getWeapons() : NetworkResponseState<List<WeaponDto>>
    suspend fun getWeaponById(weaponUuid: String) : NetworkResponseState<WeaponDto>
}