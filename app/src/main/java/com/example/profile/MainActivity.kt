package com.example.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Profile_Fragment
import com.inheal.inheal.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load Profile_Fragment into the container in activity_main.xml
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Profile_Fragment())
                .commit()
        }
    }
}