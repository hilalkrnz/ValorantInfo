package com.info.valorantinfo.domain.usecase.getWeapon


import com.info.valorantinfo.data.repository.ValorantRepositoryImpl
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(
    private val valorantRepositoryImpl: ValorantRepositoryImpl
) {

    suspend operator fun invoke() = valorantRepositoryImpl.getWeapons()
}