package com.elviraminnullina.nike_test_app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.elviraminnullina.nike_test_app.data.model.DefinitionModel
import com.elviraminnullina.nike_test_app.data.model.DefinitionResponse
import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepository
import com.elviraminnullina.nike_test_app.ui.DictionaryViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class DictionaryViewModelUnitTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DictionaryViewModel

    private var mockDictionaryRepository: DictionaryRepository = mock()
    private val savedStateHandle: SavedStateHandle = mock()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        viewModel = DictionaryViewModel(mockDictionaryRepository, savedStateHandle)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testServer() {
        val data = ArrayList<DefinitionModel>()
        val response = DefinitionResponse(data)

        runBlocking {
            whenever(mockDictionaryRepository.definition("cat")).thenReturn(
                Response.success(
                    response
                )
            )
            launch(Dispatchers.Main) {
                viewModel.getDefinition("cat")
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}