package com.info.valorantinfo.domain.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.model.WeaponUiData
import kotlinx.coroutines.flow.Flow

interface ValorantRepository {
    suspend fun getWeapons(): Flow<NetworkResponseState<List<WeaponUiData>>>
    suspend fun getWeaponById(weaponUuid: String): Flow<NetworkResponseState<WeaponUiData>>
}