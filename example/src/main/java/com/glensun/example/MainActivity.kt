package com.glensun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glensun.example.R

private const val TAG = "MainActivity"

/**
 * Activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}