package com.inheal.inheal

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.LoginDataSource
import com.inheal.inheal.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {
            if (validateInput()) {
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                
                // Simpan user ke in-memory storage (LoginDataSource)
                LoginDataSource.registerUser(email, password)
                
                Toast.makeText(requireContext(), "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_SHORT).show()
                
                // Arahkan ke LoginFragment
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        binding.tvLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun validateInput(): Boolean {
        val nama = binding.edtNama.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        val rePassword = binding.edtRepassword.text.toString().trim()

        if (nama.isEmpty()) {
            binding.edtNama.error = "Nama tidak boleh kosong"
            binding.edtNama.requestFocus()
            return false
        }

        if (email.isEmpty()) {
            binding.edtEmail.error = "Email tidak boleh kosong"
            binding.edtEmail.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "Format email salah"
            binding.edtEmail.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            binding.edtPassword.error = "Password tidak boleh kosong"
            binding.edtPassword.requestFocus()
            return false
        }

        if (password.length < 6) {
            binding.edtPassword.error = "Password minimal 6 karakter"
            binding.edtPassword.requestFocus()
            return false
        }

        if (rePassword.isEmpty()) {
            binding.edtRepassword.error = "Ulangi password tidak boleh kosong"
            binding.edtRepassword.requestFocus()
            return false
        }

        if (password != rePassword) {
            binding.edtRepassword.error = "Password tidak cocok"
            binding.edtRepassword.requestFocus()
            return false
        }

        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}