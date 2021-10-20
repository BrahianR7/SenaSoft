package com.example.appsenasoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
                    
            Thread.sleep(2000)
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_main)


    }
}