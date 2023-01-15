package com.info.valorantinfo.ui.home

import android.view.ViewGroup
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.ui.base.BaseRecyclerViewAdapter

class WeaponRecyclerViewAdapter : BaseRecyclerViewAdapter<WeaponUiData, WeaponViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        return WeaponViewHolder.createFrom(parent)
    }

}

