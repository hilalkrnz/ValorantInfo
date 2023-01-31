package com.info.valorantinfo.data.api

import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.SAMPLE_RESPONSE_FILE_NAME
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ValorantApiTest {

    private lateinit var api: ValorantApi

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        api = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ValorantApi::class.java)
    }

    @Test
    fun `when call to get all weapons is not null`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getWeapons()
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun `when call to get all weapons that first item is expected`(){
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getWeapons()
            val firstItem = response.data!!.first()
            assertThat(firstItem.uuid).isEqualTo("63e6c2b6-4a8e-869c-3d4c-e38355226584")
        }
    }

    private fun enqueueResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDown(){
        mockWebServer.shutdown()
    }

}