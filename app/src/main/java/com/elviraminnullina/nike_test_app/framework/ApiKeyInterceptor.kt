package com.elviraminnullina.nike_test_app.framework

import com.elviraminnullina.nike_test_app.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val request = original.newBuilder()
            .addHeader("x-rapidapi-host", BuildConfig.API_HOST)
            .addHeader("x-rapidapi-key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(request)
    }

}