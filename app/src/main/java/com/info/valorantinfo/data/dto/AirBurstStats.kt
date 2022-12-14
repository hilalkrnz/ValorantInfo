package com.info.valorantinfo.data.dto


import com.google.gson.annotations.SerializedName

data class AirBurstStats(
    @SerializedName("burstDistance")
    val burstDistance: Double?,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int?
)