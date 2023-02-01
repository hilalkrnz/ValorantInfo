package com.info.valorantinfo.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any, VH : BaseViewHolder<T>> :
    RecyclerView.Adapter<VH>() {

    val list = mutableListOf<T>()


    fun updateList(newList: List<T>) {
        list.apply {
            clear()
            addAll(newList)
            notifyDataSetChanged()
        }
    }

    fun getItem(position: Int) = list[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}