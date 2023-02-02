package com.info.valorantinfo.data.source

import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.api.ValorantApi
import com.info.valorantinfo.data.dto.WeaponsResponse
import com.info.valorantinfo.weaponDtoList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteDataSourceImplTest {

    @Mock
    private lateinit var api: ValorantApi

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl = RemoteDataSourceImpl(api)
    }

    @Test
    fun `when weapon data list return is state success`() {
        runBlocking {
            Mockito.`when`(api.getWeapons())
                .thenReturn(
                    WeaponsResponse(weaponDtoList)
                )
            val response = remoteDataSourceImpl.getWeapons()
            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun `when weapon data list return null is state error`() {
        runBlocking {
            Mockito.`when`(api.getWeapons())
                .thenReturn(
                    null
                )

            val response = remoteDataSourceImpl.getWeapons()
            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

}