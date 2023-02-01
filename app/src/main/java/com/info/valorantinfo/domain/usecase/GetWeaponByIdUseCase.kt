package com.info.valorantinfo.domain.usecase

import com.info.valorantinfo.domain.repository.ValorantRepository
import javax.inject.Inject

class GetWeaponByIdUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {

    suspend operator fun invoke(weaponUuid: String) = valorantRepository.getWeaponById(weaponUuid)
}