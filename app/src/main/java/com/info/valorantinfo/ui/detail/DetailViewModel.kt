package com.info.valorantinfo.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.valorantinfo.R
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.usecase.GetWeaponByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getWeaponByIdUseCase: GetWeaponByIdUseCase
) : ViewModel() {

    private val _valorantDetailUiState = MutableLiveData<DetailUiState>()
    val valorantDetailUiState: LiveData<DetailUiState> get() = _valorantDetailUiState


    fun getWeaponById(weaponUuid: String) {
        viewModelScope.launch {
            getWeaponByIdUseCase(weaponUuid).collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _valorantDetailUiState.postValue(DetailUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _valorantDetailUiState.postValue(DetailUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _valorantDetailUiState.postValue(DetailUiState.Success(it.result!!))
                    }
                }
            }
        }
    }


}