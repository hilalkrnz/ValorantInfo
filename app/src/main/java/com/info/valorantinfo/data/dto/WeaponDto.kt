package com.info.valorantinfo.data.dto


import com.google.gson.annotations.SerializedName

data class WeaponDto(
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String?,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("killStreamIcon")
    val killStreamIcon: String?,
    @SerializedName("shopData")
    val shopData: ShopData?,
    @SerializedName("skins")
    val skins: List<Skin>?,
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStats?
)