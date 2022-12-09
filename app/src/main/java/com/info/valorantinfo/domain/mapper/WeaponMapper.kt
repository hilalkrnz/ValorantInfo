package com.info.valorantinfo.domain.mapper

interface WeaponMapper<I, O> {
    fun map(input: I?): O
}