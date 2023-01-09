package com.info.valorantinfo.data.mapper

interface WeaponMapper<I, O> {
    fun map(input: I?): O
}