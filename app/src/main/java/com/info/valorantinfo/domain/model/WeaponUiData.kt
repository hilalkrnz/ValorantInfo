package com.info.valorantinfo.domain.model

import android.os.Parcelable
import com.info.valorantinfo.data.dto.WeaponStats
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class WeaponUiData(
    val id: String?,
    val imageUrl: String?,
    val name: String?,
    val category: String?,
    val weaponStats: @RawValue WeaponStats?
) : Parcelable


