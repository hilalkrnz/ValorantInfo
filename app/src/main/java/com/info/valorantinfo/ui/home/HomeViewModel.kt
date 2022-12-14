package com.info.valorantinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.valorantinfo.R
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.WeaponEntity
import com.info.valorantinfo.domain.mapper.WeaponListMapper
import com.info.valorantinfo.domain.usecase.getWeapon.GetWeaponsUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val getWeaponsUseCase: GetWeaponsUseCase,
    private val weaponListMapper: WeaponListMapper<WeaponEntity, HomeUiData>
    ) : ViewModel() {

    //Backing field & encapsulation
    private val _valorantHomeUiState = MutableLiveData<HomeUiState>()
    val valorantHomeUistate: LiveData<HomeUiState> get() = _valorantHomeUiState

    fun getWeapons(){
        viewModelScope.launch {
            getWeaponsUseCase().onEach {
                when(it) {
                    is NetworkResponseState.Error -> {
                        _valorantHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _valorantHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _valorantHomeUiState.postValue(HomeUiState.Success(weaponListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}