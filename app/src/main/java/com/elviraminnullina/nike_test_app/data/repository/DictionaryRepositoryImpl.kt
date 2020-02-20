package com.elviraminnullina.nike_test_app.data.repository

import com.elviraminnullina.nike_test_app.data.model.DefinitionResponse
import com.elviraminnullina.nike_test_app.service.DictionaryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(private val dictionaryService: DictionaryService) :
    DictionaryRepository {
    override suspend fun definition(term: String): Response<DefinitionResponse> {
        return withContext(Dispatchers.IO) {
            //  RetrofitCallbackHandler.processCall {
            dictionaryService.definition(term) //}
        }
    }

}