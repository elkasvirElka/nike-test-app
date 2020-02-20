package com.elviraminnullina.nike_test_app.di.module

import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepository
import com.elviraminnullina.nike_test_app.data.repository.DictionaryRepositoryImpl
import com.elviraminnullina.nike_test_app.service.DictionaryService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun dictionaryRepository(service: DictionaryService): DictionaryRepository =
        DictionaryRepositoryImpl(service)

}
