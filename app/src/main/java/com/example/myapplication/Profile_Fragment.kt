package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.inheal.inheal.R

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

        btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profil", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
        }
    }
}