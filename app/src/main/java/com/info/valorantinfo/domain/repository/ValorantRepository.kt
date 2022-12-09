package com.info.valorantinfo.domain.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.Data

interface ValorantRepository {
    suspend fun getWeapons(): NetworkResponseState<List<Data>>
    suspend fun getWeaponById(weaponUuid: String): NetworkResponseState<List<Data>>
}