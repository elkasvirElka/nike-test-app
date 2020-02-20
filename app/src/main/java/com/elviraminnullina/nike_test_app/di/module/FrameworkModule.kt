package com.elviraminnullina.nike_test_app.di.module

import com.elviraminnullina.nike_test_app.BuildConfig
import com.elviraminnullina.nike_test_app.framework.OkHttpProvider
import com.elviraminnullina.nike_test_app.service.DictionaryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class FrameworkModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): DictionaryService {
        var retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(provideClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(DictionaryService::class.java)
    }


    private fun provideClient(): OkHttpClient {
        return OkHttpProvider.provideClient()
    }
}