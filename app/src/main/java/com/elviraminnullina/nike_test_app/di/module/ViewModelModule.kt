package com.elviraminnullina.nike_test_app.di.module

import androidx.lifecycle.ViewModel
import com.elviraminnullina.nike_test_app.ui.DictionaryViewModel
import com.example.testappua.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DictionaryViewModel::class)
    abstract fun provideDictionaryViewModel(viewModel: DictionaryViewModel): ViewModel
}