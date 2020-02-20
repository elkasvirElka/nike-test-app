package com.elviraminnullina.nike_test_app.framework

import okhttp3.OkHttpClient

class OkHttpProvider {
    companion object {
        fun provideClient(): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
        }
    }
}