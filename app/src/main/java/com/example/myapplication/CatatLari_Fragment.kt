package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inheal.inheal.R
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.slider.Slider
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
        val etTanggal = view.findViewById<EditText>(R.id.etTanggal)
        val etJarak = view.findViewById<EditText>(R.id.etJarak) // Hidden field for compatibility
        val etDurasi = view.findViewById<EditText>(R.id.etDurasi)
        val btnSave = view.findViewById<Button>(R.id.btnSave)
        val sliderJarak = view.findViewById<Slider>(R.id.sliderJarak)
        val tvJarakValue = view.findViewById<TextView>(R.id.tvJarakValue)

        // 2. Setup Date Picker
        etTanggal.setOnClickListener {
            showDatePicker(etTanggal)
        }

        // 3. Setup Time Picker (Alarm style) untuk Durasi
        etDurasi.setOnClickListener {
            showTimePicker(etDurasi)
        }
        
        // 4. Setup Slider Jarak
        sliderJarak.addOnChangeListener { _, value, _ ->
            val formattedValue = if (value >= 10.0) "10+ km" else String.format(Locale.getDefault(), "%.1f km", value)
            tvJarakValue.text = formattedValue
            etJarak.setText(formattedValue) // Sync with hidden field
        }

        // 5. Aksi saat tombol diklik
        btnSave.setOnClickListener {
            val tanggal = etTanggal.text.toString()
            val jarak = tvJarakValue.text.toString()
            val durasi = etDurasi.text.toString()

            if (tanggal.isEmpty() || jarak == "0 km" || durasi.isEmpty()) {
                Toast.makeText(requireContext(), "Lengkapi data larinya dulu, yuk!", Toast.LENGTH_SHORT).show()
            } else {
                val hasil = "Tersimpan: $jarak dalam $durasi pada $tanggal"
                Toast.makeText(requireContext(), hasil, Toast.LENGTH_LONG).show()

                // Navigasi kembali ke fragment sebelumnya (Beranda)
                findNavController().popBackStack()
            }
        }
    }

    private fun showDatePicker(editText: EditText) {
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

    private fun showTimePicker(editText: EditText) {
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