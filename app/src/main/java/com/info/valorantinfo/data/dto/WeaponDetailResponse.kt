package com.info.valorantinfo.data.dto

import com.google.gson.annotations.SerializedName

class WeaponDetailResponse(
    @SerializedName("data")
    val `data`: WeaponDto?,
    @SerializedName("status")
    val status: Int
)