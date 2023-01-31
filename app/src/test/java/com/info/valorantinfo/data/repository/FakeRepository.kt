package com.info.valorantinfo.data.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapperImpl
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.domain.repository.ValorantRepository
import com.info.valorantinfo.weaponDtoList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class FakeRepository(private val mapper: WeaponUiDataListMapperImpl) : ValorantRepository {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override suspend fun getWeapons(): Flow<NetworkResponseState<List<WeaponUiData>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            if (showError) {
                emit(NetworkResponseState.Error(IOException()))
            } else {
                emit(NetworkResponseState.Success(mapper.map(weaponDtoList)))
            }
        }
    }

    override suspend fun getWeaponById(weaponUuid: String): Flow<NetworkResponseState<WeaponUiData>> {
        TODO("Not yet implemented")
    }


}