package com.info.valorantinfo.ui.home

import com.info.valorantinfo.databinding.AdapterValorantItemBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.ui.base.BaseViewHolder

class WeaponViewHolder(
    private val binding: AdapterValorantItemBinding,
    onItemClickListener: ((Int) -> Unit)?
) :
    BaseViewHolder<WeaponUiData>(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(adapterPosition)
        }
    }

    /* companion object {
         fun createFrom(parent: ViewGroup) =
             WeaponViewHolder(parent.inflateAdapterItem(AdapterValorantItemBinding::inflate))
     }*/

    override fun onBind(data: WeaponUiData) {
        binding.valorantComponent.setWeaponData(data)
    }
}