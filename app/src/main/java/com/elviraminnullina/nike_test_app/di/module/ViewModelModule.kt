package com.elviraminnullina.nike_test_app.di.module

import androidx.lifecycle.ViewModel
import com.elviraminnullina.nike_test_app.save_state_factory.AssistedSavedStateViewModelFactory
import com.elviraminnullina.nike_test_app.ui.DictionaryViewModel
import com.example.testappua.di.ViewModelKey
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//@Module
@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DictionaryViewModel::class)
    abstract fun provideDictionaryViewModel(f: DictionaryViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}