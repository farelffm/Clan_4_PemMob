# Project Pencatatan Lari - Android Fragment Base

Project ini merupakan tugas kolaborasi Clan untuk memenuhi kriteria pembuatan interface aplikasi pencatatan lari menggunakan **Fragment** di Android Studio.

## 📝 Informasi Clan
| Peran | Nama Lengkap | NPM |
| :--- | :--- | :--- |
| **Captain** | [Ahmad Taufik Hayaza] | [24082010136] |
| **Hustler** | [Kharenina Rizqy Putri Nugroho] | [24082010144] |
| **Hipster** | [Ima Muhimmah Falasifa] | [24082010148] |
| **Hecker** | [Farel Fazriel Marbella] | [24082010159] |

---

## 🛠️ Pembagian Pengerjaan Interface
Setiap anggota clan bertanggung jawab atas satu interface yang diimplementasikan dalam bentuk **Fragment**:

| No | Halaman (Interface) | Penanggung Jawab | Deskripsi |
| :-- | :--- | :--- | :--- |
| 1 | **Welcome & Beranda** | [Ahmad Taufik] | Halaman sambutan awal dan ringkasan aktivitas lari. |
| 2 | **Registrasi Akun** | [Kharenina Rizqy] | Form pendaftaran user baru. |
| 3 | **Profil User** | [Ima Muhimmah] | Menampilkan informasi pengguna dan statistik. |
| 4 | **Form Pencatatan Lari** | [Farel Fazriel] | Input data tanggal, jarak (km), dan durasi lari. |

---

## 🚀 Fitur & Implementasi
- **Fragment-Based:** Seluruh halaman dibuat menggunakan `androidx.fragment.app.Fragment` untuk mendukung arsitektur *Single Activity*.
- **Material Design 3:** Menggunakan komponen `TextInputLayout` dan `MaterialButton` untuk tampilan yang modern.
- **ConstraintLayout:** Implementasi layout yang responsif untuk berbagai ukuran layar.
- **Input Validation:** Form dilengkapi dengan validasi input sederhana (cek kolom kosong) menggunakan `Toast`.

---

## 🎯 THR (Tugas Hari Raya) — Quest Lanjutan

Pengembangan lebih lanjut dari aplikasi, meliputi penambahan ikon, penyesuaian tampilan, navigasi antar fragment, dan implementasi data class.

### 📋 Pembagian Pengerjaan

| No | Tugas | Penanggung Jawab | Deskripsi |
| :-- | :--- | :--- | :--- |
| 1 | **Desain Logo / Icon Aplikasi** | [Kharenina Rizqy] | Membuat icon aplikasi dan icon menu (bisa dari free source atau buatan sendiri). |
| 2 | **Ubah Tampilan Fragment Welcome** | [Ahmad Taufik] | Menyesuaikan tampilan halaman Welcome agar konsisten dengan tema fragment Login/Registrasi. |
| 3 | **Ubah Tampilan Fragment Beranda** | [Ima Muhimmah] | Menyesuaikan tampilan halaman Beranda agar konsisten dengan tema fragment Login/Registrasi. |
| 4 | **Navigasi, Data Class & Bug Fix** | [Farel Fazriel] | Mengimplementasikan navigasi antar fragment/activity, pembuatan data class pada halaman Registrasi & Add Run, serta perbaikan error keseluruhan. |

### ✅ Kriteria Tambahan yang Dipenuhi
- **Data Class:** Menampung semua isian form pada halaman Registrasi dan halaman Pencatatan Lari (Add Run).
- **Icon Aplikasi & Menu:** Icon ditambahkan pada launcher aplikasi dan item navigasi menu.
- **Konsistensi Tema:** Tampilan fragment Welcome dan Beranda diselaraskan dengan desain fragment Login/Registrasi.
- **Navigasi Objek Antar Fragment/Activity:** Implementasi perpindahan objek antar fragment dan/atau activity.

---
