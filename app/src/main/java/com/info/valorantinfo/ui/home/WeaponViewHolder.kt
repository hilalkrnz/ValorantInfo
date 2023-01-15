package com.info.valorantinfo.ui.home

import android.view.ViewGroup
import com.info.valorantinfo.databinding.AdapterValorantItemBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.ui.base.BaseViewHolder
import com.info.valorantinfo.utility.inflateAdapterItem

class WeaponViewHolder(private val binding: AdapterValorantItemBinding) :
    BaseViewHolder<WeaponUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup) =
            WeaponViewHolder(parent.inflateAdapterItem(AdapterValorantItemBinding::inflate))
    }

    override fun onBind(data: WeaponUiData) {
        binding.valorantComponent.setWeaponData(data)
    }
}