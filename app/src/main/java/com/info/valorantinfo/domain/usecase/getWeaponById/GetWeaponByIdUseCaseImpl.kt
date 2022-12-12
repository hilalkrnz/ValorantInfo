package com.info.valorantinfo.domain.usecase.getWeaponById

import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.dto.WeaponDto
import com.info.valorantinfo.domain.WeaponEntity
import com.info.valorantinfo.domain.mapper.WeaponListMapper
import com.info.valorantinfo.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeaponByIdUseCaseImpl @Inject constructor(
    private val valorantRepository: ValorantRepository,
    private val weaponListMapper: WeaponListMapper<WeaponDto, WeaponEntity>
): GetWeaponByIdUseCase {
    override fun invoke(weaponUuid: String): Flow<NetworkResponseState<List<WeaponEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = valorantRepository.getWeaponById(weaponUuid)) {
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