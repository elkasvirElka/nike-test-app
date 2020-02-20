package com.elviraminnullina.nike_test_app.component

import com.elviraminnullina.nike_test_app.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [])
interface MainComponent {
    fun injectMainActivity(activity: MainActivity)
}