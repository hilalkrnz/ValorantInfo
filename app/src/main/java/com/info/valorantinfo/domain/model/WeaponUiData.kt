package com.info.valorantinfo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeaponUiData(
    val id: String?,
    val imageUrl: String?,
    val name: String?,
    val category: String?
) : Parcelable