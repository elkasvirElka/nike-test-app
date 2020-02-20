package com.elviraminnullina.nike_test_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApplication.getApp(this).getAppComponent().createMainComponent().injectMainActivity(this)
    }
}
