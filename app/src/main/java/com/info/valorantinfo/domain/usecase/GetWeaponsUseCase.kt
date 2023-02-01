package com.info.valorantinfo.domain.usecase


import com.info.valorantinfo.domain.repository.ValorantRepository
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
     suspend operator fun invoke() = valorantRepository.getWeapons()
}