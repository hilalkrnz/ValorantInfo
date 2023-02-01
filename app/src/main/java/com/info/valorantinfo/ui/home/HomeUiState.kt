package com.info.valorantinfo.ui.home

import androidx.annotation.StringRes
import com.info.valorantinfo.domain.model.WeaponUiData

sealed class HomeUiState {
    object Loading: HomeUiState()
    data class Success(val data: List<WeaponUiData>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()

}