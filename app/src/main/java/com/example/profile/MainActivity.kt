package com.example.profile


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var btnEdit: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEdit = findViewById(R.id.btnEdit)
        btnLogout = findViewById(R.id.btnLogout)

        btnEdit.setOnClickListener {
            // aksi edit profil
        }

        btnLogout.setOnClickListener {
            // aksi logout
        }
    }
}