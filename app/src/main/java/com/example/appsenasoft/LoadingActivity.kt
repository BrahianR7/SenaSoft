package com.example.appsenasoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)






        intent = Intent( this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}