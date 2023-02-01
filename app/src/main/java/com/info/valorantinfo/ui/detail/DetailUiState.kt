package com.info.valorantinfo.ui.detail

import androidx.annotation.StringRes
import com.info.valorantinfo.domain.model.WeaponUiData

sealed class DetailUiState {

    object Loading : DetailUiState()
    data class Success(val data: WeaponUiData) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()

}
