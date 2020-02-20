package com.elviraminnullina.nike_test_app.module

import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepositoryImpl
import com.elviraminnullina.nike_test_app.framework.ApiFactory
import com.elviraminnullina.nike_test_app.service.DictionaryService

object InjectorUtils {

    fun provideRepositoryViewModel() =
        DictionaryRepositoryImpl(ApiFactory.getRetrofitInstance().create((DictionaryService::class.java)))

}