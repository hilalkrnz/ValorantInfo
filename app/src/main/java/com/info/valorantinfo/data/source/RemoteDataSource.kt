package com.info.valorantinfo.data.source

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto

interface RemoteDataSource {

    suspend fun getWepons() : NetworkResponseState<List<WeaponDto>>
    suspend fun getWeaaponById(weaponUuid: String) : NetworkResponseState<WeaponDto>
}