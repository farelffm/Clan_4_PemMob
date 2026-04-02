package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inheal.inheal.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Profile_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val bottomNavigation = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // 1. Setup Navigation Bar
        // Gunakan post agar seleksi item terjadi setelah view benar-benar siap
        bottomNavigation.post {
            bottomNavigation.selectedItemId = R.id.profile_Fragment
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.berandaFragment -> {
                    findNavController().navigate(R.id.action_profile_Fragment_to_berandaFragment)
                    true
                }
                R.id.profile_Fragment -> true
                else -> false
            }
        }

        // 2. Setup Edit Button
        btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profil", Toast.LENGTH_SHORT).show()
        }

        // 3. Setup Logout Button (Kembali ke Welcome)
        btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profile_Fragment_to_welcomeFragment)
        }
    }
}