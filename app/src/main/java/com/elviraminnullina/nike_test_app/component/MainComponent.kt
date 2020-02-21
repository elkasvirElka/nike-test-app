package com.elviraminnullina.nike_test_app.component

import com.elviraminnullina.nike_test_app.MainActivity
import com.elviraminnullina.nike_test_app.ui.DictionaryFragment
import dagger.Subcomponent

@Subcomponent(modules = [])
interface MainComponent {

    fun injectMainActivity(activity: MainActivity)

    fun injectDictionaryFragment(fragment: DictionaryFragment)
}