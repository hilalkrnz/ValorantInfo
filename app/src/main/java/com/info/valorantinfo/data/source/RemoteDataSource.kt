package com.info.valorantinfo.data.source

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.Data

interface RemoteDataSource {

    suspend fun getWepons() : NetworkResponseState<List<Data>>
    suspend fun getWeaaponById(weaponUuid: String) : NetworkResponseState<List<Data>>
}