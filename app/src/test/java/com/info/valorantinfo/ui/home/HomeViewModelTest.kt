package com.info.valorantinfo.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.info.valorantinfo.R
import com.info.valorantinfo.apiException
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.domain.usecase.GetWeaponsUseCase
import com.info.valorantinfo.weaponUiDataList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @Mock
    private lateinit var getWeaponsUseCase: GetWeaponsUseCase

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var observer: Observer<HomeUiState>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        homeViewModel = HomeViewModel(getWeaponsUseCase)
        homeViewModel.valorantHomeUiState.observeForever(observer)
    }

    @Test
    fun `when use case return downloading is live data state downloading`() {
        runBlocking {
            Mockito.`when`(getWeaponsUseCase.invoke())
                .thenReturn(flow {
                    emit(NetworkResponseState.Loading)
                })

            homeViewModel.getWeapons()

            verify(observer).onChanged(HomeUiState.Loading)
        }
    }

    @Test
    fun `when use case return downloading is live data state success`() {
        runBlocking {
            Mockito.`when`(getWeaponsUseCase.invoke())
                .thenReturn(flow {
                    emit(NetworkResponseState.Loading)
                    emit(NetworkResponseState.Success(weaponUiDataList))
                })

            homeViewModel.getWeapons()

            verify(observer).onChanged(HomeUiState.Loading)
            verify(observer).onChanged(HomeUiState.Success(weaponUiDataList))
        }
    }

    @Test
    fun `when use case return downloading is live data state error`() {
        runBlocking {
            Mockito.`when`(getWeaponsUseCase.invoke())
                .thenReturn(flow {
                    emit(NetworkResponseState.Loading)
                    emit(NetworkResponseState.Error(apiException))
                })

            homeViewModel.getWeapons()

            verify(observer).onChanged(HomeUiState.Loading)
            verify(observer).onChanged(HomeUiState.Error(R.string.error))
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun shutDown() {
        Dispatchers.resetMain()
        homeViewModel.valorantHomeUiState.removeObserver(observer)
    }
}