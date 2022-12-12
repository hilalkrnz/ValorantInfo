package com.info.valorantinfo.domain.usecase.getWeapon

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.WeaponEntity
import kotlinx.coroutines.flow.Flow
interface GetWeaponsUseCase {

    operator fun invoke(): Flow<NetworkResponseState<List<WeaponEntity>>>
}