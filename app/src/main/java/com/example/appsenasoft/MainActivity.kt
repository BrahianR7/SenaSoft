package com.example.appsenasoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}