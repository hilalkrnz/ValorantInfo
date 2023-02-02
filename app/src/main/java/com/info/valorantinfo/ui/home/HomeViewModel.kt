package com.info.valorantinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.valorantinfo.R
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.usecase.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeaponsUseCase: GetWeaponsUseCase
) : ViewModel() {

    //Backing field & encapsulation
    private val _valorantHomeUiState = MutableLiveData<HomeUiState>()
    val valorantHomeUiState: LiveData<HomeUiState> get() = _valorantHomeUiState

    init {
        getWeapons()
    }

    fun getWeapons() {
        viewModelScope.launch {
            getWeaponsUseCase().collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _valorantHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _valorantHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _valorantHomeUiState.postValue(HomeUiState.Success(it.result!!))
                    }
                }
            }
        }
    }

}