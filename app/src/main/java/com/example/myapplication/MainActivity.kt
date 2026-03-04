package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.catat_lari)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Inisialisasi View
        val etTanggal = findViewById<TextInputEditText>(R.id.etTanggal)
        val etJarak = findViewById<TextInputEditText>(R.id.etJarak)
        val etDurasi = findViewById<TextInputEditText>(R.id.etDurasi)
        val btnSave = findViewById<MaterialButton>(R.id.btnSave)

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
                Toast.makeText(this, "Isi dulu semua datanya, cuy!", Toast.LENGTH_SHORT).show()
            } else {
                val hasil = "Tersimpan: $jarak km dalam $durasi pada $tanggal"
                Toast.makeText(this, hasil, Toast.LENGTH_LONG).show()

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

        datePicker.show(supportFragmentManager, "DATE_PICKER")
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

        timePicker.show(supportFragmentManager, "TIME_PICKER")
    }
}