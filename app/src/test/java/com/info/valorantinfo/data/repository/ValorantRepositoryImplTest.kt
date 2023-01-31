package com.info.valorantinfo.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapperImpl
import com.info.valorantinfo.data.source.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ValorantRepositoryImplTest {

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    private lateinit var valorantRepositoryImpl: ValorantRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        valorantRepositoryImpl =
            ValorantRepositoryImpl(
                remoteDataSource,
                weaponUiDataMapper = WeaponUiDataListMapperImpl(),
                ioDispatcher = Dispatchers.Unconfined
            )
    }

    @Test
    fun `when RemoteDataSource return Success is return downloading`() {
        runBlocking {
            valorantRepositoryImpl.getWeapons().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                //assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }


}