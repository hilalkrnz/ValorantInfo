package com.info.valorantinfo.ui.home

import android.view.ViewGroup
import com.info.valorantinfo.databinding.AdapterValorantItemBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.ui.base.BaseRecyclerViewAdapter
import com.info.valorantinfo.utility.inflateAdapterItem

class WeaponRecyclerViewAdapter : BaseRecyclerViewAdapter<WeaponUiData, WeaponViewHolder>() {

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Int) -> Unit)?) {
        this.onItemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        return WeaponViewHolder(
            parent.inflateAdapterItem(AdapterValorantItemBinding::inflate),
            onItemClickListener
        )
    }

}

