package com.elviraminnullina.nike_test_app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elviraminnullina.nike_test_app.data.model.DefinitionResponse
import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DictionaryViewModel @Inject constructor(private val repository: DictionaryRepository) :
    ViewModel() {

    private val _response = MutableLiveData<DefinitionResponse>()
    val response: LiveData<DefinitionResponse> = _response

    fun getDefinition(term: String) {
        viewModelScope.launch {
            val response = repository.definition(term)
            if (response.isSuccessful) {
                _response.value = response.body()
            }
        }
    }
}