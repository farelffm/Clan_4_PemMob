package com.inheal.inheal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inheal.inheal.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set item Home sebagai yang terpilih saat awal
        binding.bottomNavigation.selectedItemId = R.id.berandaFragment

        // Menangani navigasi bottom bar
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.berandaFragment -> {
                    // Sudah di Home, tidak perlu pindah
                    true
                }
                R.id.profile_Fragment -> {
                    // Pindah ke Profil
                    findNavController().navigate(R.id.action_berandaFragment_to_profile_Fragment)
                    true
                }
                else -> false
            }
        }

        // Tombol lari (FAB)
        binding.fabStartRun.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_catatLari_Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}