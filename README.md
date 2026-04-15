# Study Case: Sistem Manajemen Menu Restoran

**Tema**  
Restoran kecil / cafe kampus yang mengelola berbagai jenis menu makanan dan minuman: Makanan Utama, Minuman, dan Dessert. Sistem ini mendukung proses pemesanan, batasan jumlah pesanan per pelanggan, serta perhitungan harga yang berbeda-beda per kategori menu (termasuk pajak dan diskon).

**Tujuan pembelajaran**  
Menggabungkan semua konsep OOP yang sudah dipelajari:
- Class & Object
- Encapsulation (data private + getter/setter + validasi)
- Inheritance (superclass & subclass)
- Polymorphism (method overriding + runtime polymorphism via reference superclass)

## Struktur Folder yang Diinginkan

restoran/
├── menu/ # Inheritance + Polymorphism
│   ├── ItemMenu.java
│   ├── MakananUtama.java
│   ├── Minuman.java
│   └── Dessert.java
├── pelanggan/ # Encapsulation
│   └── Pelanggan.java
└── MainRestoran.java # Demo penggunaan semua konsep


## Spesifikasi Detail

### 1. Class `ItemMenu` (superclass)
- **Atribut** (protected):
  - `String nama`
  - `double harga`
  - `boolean tersedia` (default = `true`)
- **Constructor**:
  - Menerima `nama` dan `harga`
- **Method**:
  - `void pesan()`
    → ubah `tersedia` menjadi `false` (jika masih tersedia, jika sudah → cetak pesan)
  - `void batalkanPesanan()`
    → ubah `tersedia` menjadi `true`
  - `abstract double hitungTotal(int jumlah)`
    → subclass wajib mengimplementasikan (perhitungan harga akhir berbeda tiap kategori)
  - `void tampilkanInfo()`
    → cetak nama, harga, dan status (bisa di-override)

### 2. Subclass (Inheritance + Polymorphism)

| Class          | Atribut tambahan       | Perhitungan di `hitungTotal(int jumlah)`              | Override `tampilkanInfo()` tambahan |
|----------------|------------------------|-------------------------------------------------------|--------------------------------------|
| `MakananUtama` | `String jenisMasakan`  | `harga * jumlah` (harga normal)                      | Tampilkan jenis masakan             |
| `Minuman`      | `String ukuran`        | `harga * jumlah * 1.1` (PPN 10%)                     | Tampilkan ukuran                    |
| `Dessert`      | `int kalori`           | `harga * jumlah * 0.9` (Diskon 10%)                 | Tampilkan kalori                    |

### 3. Class `Pelanggan` (Encapsulation)
- **Atribut private**:
  - `String nama`
  - `String noMeja`
  - `int jumlahPesananSaatIni` (default = 0)
- **Getter** untuk semua atribut
- **Setter**:
  - `setNama(String nama)`
  - `setNoMeja(String noMeja)` → validasi jika nomor meja kosong
- **Method penting**:
  - `boolean bisaPesan()` → true jika `jumlahPesananSaatIni < 3`
  - `void tambahPesanan()` → jumlahPesananSaatIni++
  - `void kurangiPesanan()` → jumlahPesananSaatIni-- (minimal 0)

### 4. Di `MainRestoran.java` (Demo)
Buat simulasi berikut:
1. Buat **minimal 5–6 item** menu (campuran MakananUtama, Minuman, Dessert)  
   Simpan dalam array `ItemMenu[] menuRestoran`
2. Buat **2 pelanggan**
3. Tampilkan daftar semua menu beserta statusnya
4. Simulasi proses pemesanan:
   - Pelanggan 1 memesan 2 item
   - Pelanggan 2 mencoba memesan 3 item (salah satunya gagal karena sudah mencapai batas)
5. Tampilkan status menu setelah proses pemesanan (menggunakan polymorphism)
6. Hitung total tagihan beberapa item (demonstrasi `hitungTotal()` dengan polymorphism)
7. (Opsional bonus)
   - Tampilkan pesan jika pelanggan sudah mencapai batas pesanan
   - Fitur batalkan pesanan

## Cara Menjalankan

1. Buat folder proyek dengan struktur di atas.
2. Masukkan semua file Java sesuai nama dan package-nya.
3. Buka terminal/command prompt di folder `restoran`.
4. Compile program dengan perintah:
   
**##Jalankan program dengan perintah:**

5. java MainRestoran


<img width="190" height="388" alt="image" src="https://github.com/user-attachments/assets/b99274c7-576a-49bb-b6f0-faa1744232f1" />

