package com.elviraminnullina.nike_test_app

import android.app.Application
import android.content.Context
import com.elviraminnullina.nike_test_app.component.AppComponent
import com.elviraminnullina.nike_test_app.component.DaggerAppComponent

class MyApplication : Application() {

    private lateinit var appComponent: AppComponent

    companion object {
        fun getApp(context: Context?): MyApplication {
            return context?.applicationContext as MyApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getAppComponent(): AppComponent = appComponent
}