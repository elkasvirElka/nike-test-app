package com.elviraminnullina.nike_test_app.service

import com.elviraminnullina.nike_test_app.model.DefinitionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryService {

    @GET("define")
    suspend fun definition(@Query("term") term: String = ""): Response<DefinitionResponse>
}