package com.info.valorantinfo.data.source

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.api.ValorantApi
import com.info.valorantinfo.data.dto.Data
import javax.inject.Inject

class RemoteDatSourceImpl @Inject constructor(private val valorantApi: ValorantApi) : RemoteDataSource {

    override suspend fun getWepons(): NetworkResponseState<List<Data>> =
        try {
            val response = valorantApi.getWeapons()
            NetworkResponseState.Success(response.data)
        }catch (e: Exception) {
            NetworkResponseState.Error(e)
        }

    override suspend fun getWeaaponById(weaponUuid: String): NetworkResponseState<List<Data>> =
        try {
            val response = valorantApi.getWeaponById(weaponUuid)
            NetworkResponseState.Success(response.data)
        }catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
}