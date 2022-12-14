package com.info.valorantinfo.data.dto


import com.google.gson.annotations.SerializedName

data class Level(
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("levelItem")
    val levelItem: String?,
    @SerializedName("streamedVideo")
    val streamedVideo: String?,
    @SerializedName("uuid")
    val uuid: String?
)