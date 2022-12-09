package com.info.valorantinfo.data.api

import com.info.valorantinfo.data.dto.DataCardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantApi {

    @GET("/v1/weapons")
    suspend fun getWeapons(): DataCardResponse

    @GET("/v1/weapons/{weaponUuid}")
    suspend fun getWeaponById(@Path("weaponUuid") weaponUuid: String): DataCardResponse
}