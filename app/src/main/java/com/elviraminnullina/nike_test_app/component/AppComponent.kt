package com.elviraminnullina.nike_test_app.component

import com.elviraminnullina.nike_test_app.di.module.DataModule
import com.elviraminnullina.nike_test_app.di.module.FrameworkModule
import com.elviraminnullina.nike_test_app.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, FrameworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun createMainComponent(): MainComponent

}
