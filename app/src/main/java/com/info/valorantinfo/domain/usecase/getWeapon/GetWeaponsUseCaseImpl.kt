package com.info.valorantinfo.domain.usecase.getWeapon

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.domain.WeaponEntity
import com.info.valorantinfo.domain.mapper.WeaponListMapper
import com.info.valorantinfo.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeaponsUseCaseImpl @Inject constructor(
    private val valorantRepository: ValorantRepository,
    private val weaponListMapper: WeaponListMapper<WeaponDto, WeaponEntity>
): GetWeaponsUseCase {

    override fun invoke(): Flow<NetworkResponseState<List<WeaponEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = valorantRepository.getWeapons()) {
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        weaponListMapper.map(
                            response.result
                        )
                    )
                )
            }
        }

}