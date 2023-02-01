package com.info.valorantinfo.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.info.valorantinfo.databinding.LayoutWeaponBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.utility.loadImage

class ValorantUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutWeaponBinding
        .inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setWeaponData(weaponUiData: WeaponUiData) {
        binding.weaponImage.loadImage(weaponUiData.imageUrl)
        binding.weaponName.text = weaponUiData.name
        binding.weaponCategory.text = weaponUiData.category
    }

    fun setNameTextSize(value: Float){
        binding.weaponName.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }

    fun setCategoryTextSize(value: Float){
        binding.weaponCategory.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }
}