package com.inheal.inheal

/**
 * Data class untuk proses Registrasi
 */
data class UserRegister(
    val nama: String,
    val email: String,
    val kataSandi: String
)

/**
 * Data class untuk proses Login
 */
data class UserLogin(
    val email: String,
    val kataSandi: String
)

/**
 * Data class untuk mencatat aktivitas lari
 * (Digunakan saat berpindah dari Beranda ke CatatLari)
 */
data class CatatLari(
    val tanggal: String,
    val jarak: Float, // dalam km
    val durasi: String, // format HH:mm
    val catatan: String? = null
)