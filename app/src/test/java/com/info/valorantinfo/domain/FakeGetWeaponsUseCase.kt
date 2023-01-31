package com.info.valorantinfo.domain

import com.info.valorantinfo.apiException
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.weaponUiDataList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetWeaponsUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    suspend operator fun invoke(): Flow<NetworkResponseState<List<WeaponUiData>>> =
        flow {
            emit(NetworkResponseState.Loading)
            if (showError) {
                emit(NetworkResponseState.Error(apiException))
            } else {
                emit(NetworkResponseState.Success(weaponUiDataList))
            }
        }
}