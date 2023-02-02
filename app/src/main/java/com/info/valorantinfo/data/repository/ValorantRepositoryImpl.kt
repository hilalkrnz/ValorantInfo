package com.info.valorantinfo.data.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.data.dto.toWeapon
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapperImpl
import com.info.valorantinfo.data.source.RemoteDataSource
import com.info.valorantinfo.di.coroutine.IoDispatcher
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.domain.repository.ValorantRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val weaponUiDataMapper: WeaponUiDataListMapperImpl,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ValorantRepository {
    override suspend fun getWeapons(): Flow<NetworkResponseState<List<WeaponUiData>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getWeapons()) {
                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(mapWeaponDto(response.result)))
                }
                else -> {}
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun getWeaponById(weaponUuid: String): Flow<NetworkResponseState<WeaponUiData>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getWeaponById(weaponUuid)) {
                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(response.result?.toWeapon()))
                }
                else -> {}
            }
        }.flowOn(ioDispatcher)
    }


    private fun mapWeaponDto(mapWeapon: List<WeaponDto>?): List<WeaponUiData> {
        return weaponUiDataMapper.map(mapWeapon)
    }
}