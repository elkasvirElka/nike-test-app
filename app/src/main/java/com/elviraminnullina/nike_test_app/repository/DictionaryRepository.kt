package com.elviraminnullina.nike_test_app.repository

import com.elviraminnullina.nike_test_app.model.DefinitionResponse
import retrofit2.Response

interface DictionaryRepository {
    suspend fun definition(term: String = ""): Response<DefinitionResponse>
}