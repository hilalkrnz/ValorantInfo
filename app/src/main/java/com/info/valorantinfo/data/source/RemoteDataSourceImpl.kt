package com.info.valorantinfo.data.source

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.api.ValorantApi
import com.info.valorantinfo.data.dto.WeaponDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val valorantApi: ValorantApi) : RemoteDataSource {

    override suspend fun getWeapons(): NetworkResponseState<List<WeaponDto>> =
        try {
            val response = valorantApi.getWeapons()
            NetworkResponseState.Success(response.data)
        }catch (e: Exception) {
            NetworkResponseState.Error(e)
        }

    override suspend fun getWeaponById(weaponUuid: String): NetworkResponseState<WeaponDto> =
        try {
            val response = valorantApi.getWeaponById(weaponUuid)
            NetworkResponseState.Success(response.data)
        }catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
}