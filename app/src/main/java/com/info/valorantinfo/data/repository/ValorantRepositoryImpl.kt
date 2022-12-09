package com.info.valorantinfo.data.repository

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.Data
import com.info.valorantinfo.data.source.RemoteDataSource
import com.info.valorantinfo.di.coroutine.IoDispatcher
import com.info.valorantinfo.domain.repository.ValorantRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
   @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ValorantRepository {

    override suspend fun getWeapons(): NetworkResponseState<List<Data>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getWepons()
            }catch (e: Exception){
                NetworkResponseState.Error(e)
            }
            }

    override suspend fun getWeaponById(weaponUuid: String): NetworkResponseState<List<Data>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getWeaaponById(weaponUuid)
            }catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }
}