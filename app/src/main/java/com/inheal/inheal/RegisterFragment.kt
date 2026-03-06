package com.inheal.inheal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    private lateinit var edtNama: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtNama = view.findViewById(R.id.edt_nama)
        edtEmail = view.findViewById(R.id.edt_email)
        edtPassword = view.findViewById(R.id.edt_password)
        btnSignUp = view.findViewById(R.id.btn_sign_up)

        btnSignUp.setOnClickListener {
            val nama = edtNama.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (nama.isEmpty()) {
                edtNama.error = "Nama tidak boleh kosong"
                edtNama.requestFocus()
            } else if (email.isEmpty()) {
                edtEmail.error = "Email tidak boleh kosong"
                edtEmail.requestFocus()
            } else if (password.length < 6) {
                edtPassword.error = "Password min. 6 karakter"
                edtPassword.requestFocus()
            } else {
                Toast.makeText(requireContext(), "Registrasi berhasil! 🎉", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}