package com.info.valorantinfo.domain

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.data.NetworkResponseState
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class FakeGetWeaponsUseCaseImplTest {

    private lateinit var getWeaponsUseCase: FakeGetWeaponsUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getWeaponsUseCase = FakeGetWeaponsUseCase()
    }

    @Test
    fun `when FakeGetWeaponsUseCase return downloading`() {
        runBlocking {
            getWeaponsUseCase().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when FakeGetWeaponsUseCase return downloading and success together`() {
        runBlocking {
            getWeaponsUseCase().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `when FakeGetWeaponsUseCase return downloading and error together`() {
        runBlocking {
            getWeaponsUseCase.updateShowError(true)
            getWeaponsUseCase().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }
}