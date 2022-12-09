package com.info.valorantinfo.domain.usecase.getWeaponById

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.WeaponEntity
import kotlinx.coroutines.flow.Flow

interface GetWeaponByIdUseCase {

    operator fun invoke(weaponUuid: String): Flow<NetworkResponseState<List<WeaponEntity>>>
}