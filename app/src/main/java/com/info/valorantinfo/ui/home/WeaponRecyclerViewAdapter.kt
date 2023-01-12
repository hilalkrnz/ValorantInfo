package com.info.valorantinfo.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.info.valorantinfo.databinding.AdapterValorantItemBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.utility.inflateAdapterItem

class WeaponRecyclerViewAdapter :
    RecyclerView.Adapter<WeaponRecyclerViewAdapter.WeaponViewHolder>() {

    private val weaponList = mutableListOf<WeaponUiData>()

    fun update(newList: List<WeaponUiData>) {
        weaponList.apply {
            clear()
            addAll(newList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        return WeaponViewHolder.createFrom(parent)
    }

    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        holder.bind(weaponList[position])
    }

    override fun getItemCount() = weaponList.size

    class WeaponViewHolder(private val binding: AdapterValorantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun createFrom(parent: ViewGroup) =
                WeaponViewHolder(parent.inflateAdapterItem(AdapterValorantItemBinding::inflate))
        }

        fun bind(weaponUiData: WeaponUiData) {
            binding.valorantComponent.setPokeData(weaponUiData)
        }

    }

}

