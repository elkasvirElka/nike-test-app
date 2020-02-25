package com.elviraminnullina.nike_test_app.ui

import androidx.lifecycle.*
import com.elviraminnullina.nike_test_app.data.model.DefinitionResponse
import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepository
import com.elviraminnullina.nike_test_app.save_state_factory.AssistedSavedStateViewModelFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.launch

class DictionaryViewModel @AssistedInject constructor(
    private val repository: DictionaryRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    @AssistedInject.Factory
    interface Factory :
        AssistedSavedStateViewModelFactory<DictionaryViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): DictionaryViewModel
    }

    private val responseStateHandle = savedStateHandle.getLiveData<DefinitionResponse>(
        "response", DefinitionResponse(
            ArrayList()
        )
    )
    val response: LiveData<DefinitionResponse> = responseStateHandle

    private val _term = MutableLiveData<String>()
    val term: LiveData<String> = _term

    fun setTerm(data: String) {
        _term.value = data
    }

    private val _showSpinner = MutableLiveData(false)
    val showSpinner: LiveData<Boolean> = _showSpinner

    fun getDefinition(term: String) {
        _showSpinner.value = true
        viewModelScope.launch {
            val response = repository.definition(term)
            if (response.isSuccessful) {
                responseStateHandle.value = response.body()
            } else {
                //TODO alert
            }
            //response.wait()
            _showSpinner.value = false
        }
    }
}