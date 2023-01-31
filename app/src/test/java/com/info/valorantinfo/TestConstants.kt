package com.info.valorantinfo

import androidx.annotation.VisibleForTesting
import com.info.valorantinfo.data.dto.WeaponDto

const val SAMPLE_RESPONSE_FILE_NAME = "ValorantResponse.json"

@VisibleForTesting
val weaponDto = WeaponDto(
    null,
    "EEquippableCategory::Heavy",
    null,
    "https://media.valorant-api.com/weapons/63e6c2b6-4a8e-869c-3d4c-e38355226584/displayicon.png",
    "Odin",
    null,
    null,
    null,
    "63e6c2b6-4a8e-869c-3d4c-e38355226584",
    null
)

@VisibleForTesting
val weaponDtoList = mutableListOf(weaponDto)

@VisibleForTesting
val apiException = Exception("Something went wrong")