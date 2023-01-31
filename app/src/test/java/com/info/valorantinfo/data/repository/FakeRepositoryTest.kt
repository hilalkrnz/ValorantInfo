package com.info.valorantinfo.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.data.NetworkResponseState
import com.info.valorantinfo.data.mapper.WeaponUiDataListMapperImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class FakeRepositoryTest {

    private lateinit var mapper: WeaponUiDataListMapperImpl

    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setup() {
        mapper = WeaponUiDataListMapperImpl()
        fakeRepository = FakeRepository(mapper)
    }

    @Test
    fun `when FakeRepository return downloading`() {
        runBlocking {
            fakeRepository.getWeapons().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when FakeRepository return downloading and success together`() {
        runBlocking {
            fakeRepository.getWeapons().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `when FakeRepository return downloading and error together`() {
        runBlocking {
            fakeRepository.updateShowError(true)
            fakeRepository.getWeapons().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }

}