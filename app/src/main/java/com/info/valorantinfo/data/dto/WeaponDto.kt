package com.info.valorantinfo.data.dto


import com.google.gson.annotations.SerializedName
import com.info.valorantinfo.domain.model.WeaponUiData

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

fun WeaponDto.toWeapon() : WeaponUiData {
    return WeaponUiData(
        id = uuid,
        imageUrl = displayIcon,
        name = displayName,
        category = category?.replace("EEquippableCategory::", ""),
        weaponStats = weaponStats
    )
}