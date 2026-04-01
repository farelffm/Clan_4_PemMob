package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.inheal.inheal.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class CatatLari_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catatlari, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi View
        val etTanggal = view.findViewById<TextInputEditText>(R.id.etTanggal)
        val etJarak = view.findViewById<TextInputEditText>(R.id.etJarak)
        val etDurasi = view.findViewById<TextInputEditText>(R.id.etDurasi)
        val btnSave = view.findViewById<MaterialButton>(R.id.btnSave)

        // 2. Setup Date Picker
        etTanggal.setOnClickListener {
            showDatePicker(etTanggal)
        }

        // 3. Setup Time Picker (Alarm style) untuk Durasi
        etDurasi.setOnClickListener {
            showTimePicker(etDurasi)
        }

        // 4. Aksi saat tombol diklik
        btnSave.setOnClickListener {
            val tanggal = etTanggal.text.toString()
            val jarak = etJarak.text.toString()
            val durasi = etDurasi.text.toString()

            if (tanggal.isEmpty() || jarak.isEmpty() || durasi.isEmpty()) {
                Toast.makeText(requireContext(), "Isi dulu semua datanya, cuy!", Toast.LENGTH_SHORT).show()
            } else {
                val hasil = "Tersimpan: $jarak km dalam $durasi pada $tanggal"
                Toast.makeText(requireContext(), hasil, Toast.LENGTH_LONG).show()

                etTanggal.text?.clear()
                etJarak.text?.clear()
                etDurasi.text?.clear()
            }
        }
    }

    private fun showDatePicker(editText: TextInputEditText) {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Pilih Tanggal")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            sdf.timeZone = TimeZone.getTimeZone("UTC")
            val date = sdf.format(Date(selection))
            editText.setText(date)
        }

        datePicker.show(parentFragmentManager, "DATE_PICKER")
    }

    private fun showTimePicker(editText: TextInputEditText) {
        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(0)
            .setMinute(30)
            .setTitleText("Atur Durasi (Jam:Menit)")
            .build()

        timePicker.addOnPositiveButtonClickListener {
            val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", timePicker.hour, timePicker.minute)
            editText.setText(formattedTime)
        }

        timePicker.show(parentFragmentManager, "TIME_PICKER")
    }
}