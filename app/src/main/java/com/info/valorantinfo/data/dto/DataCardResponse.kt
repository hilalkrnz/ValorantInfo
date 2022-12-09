package com.info.valorantinfo.data.dto


import com.google.gson.annotations.SerializedName

data class DataCardResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int
)