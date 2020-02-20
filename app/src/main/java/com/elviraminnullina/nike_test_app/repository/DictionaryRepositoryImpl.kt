package com.elviraminnullina.nike_test_app.repository

import com.elviraminnullina.nike_test_app.model.DefinitionResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DictionaryRepositoryImpl : DictionaryRepository {
    override suspend fun definition(term: String): Response<DefinitionResponse> {
        return withContext(Dispatchers.IO) {
            // RetrofitCallbackHandler.processCall { bookingService.airportNearby(queryMap) }
        }
    }

}