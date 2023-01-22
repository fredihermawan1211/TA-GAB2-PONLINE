
# Pedoman Menjalankan Program

Berikut ini adalah pedoman untuk menjalankan program

## Persyaratan Sistem
### Umum
1. Koneksi Internet
2. Port 8080(tomcat), 3306(mysql), 587(smtp) tidak di tutup
### Khusus Server
1. JDK 17 atau lebih tinggi
Cek versi jdk (windows :: cmd)
```bash
  java --version
```
2. Maven 3.8 atau lebih tinggi
Cek versi maven (windows :: cmd)
```bash
  mvn --version
```
3. Apache Tomcat 8.5 atau lebih tinggi<br />
Cek versi tomcat (windows :: cmd)<br />
Masuk ke direktori tomcat/lib<br />
Pastikan ada file catalina.jar<br />
lalu jalankan perintah :
```bash
  java -cp catalina.jar org.apache.catalina.util.ServerInfo
```
4. Mysql direkomendasikan menggunakan versi (10.4.24-MariaDB)<br />
Cek versi mysql (windows :: cmd)
Jalankan Query
```bash
  SELECT @@version;
```
### Khusus Client
1. Android Studio Electric EEL//2022.1.1
2. AGP versi 7.4.0

## Menjalankan Program
### Server
1. Buka folder server di terminal
2. Import database yang telah di sediakan di dalam folder database
```bash
  server/database/datbset_ponline.sql
```
3. Pastikan file credentials(application.yml) tersedia di direktori src/main/resource :
```bash
  server/src/main/resource/application.yml
```
4. Ubah value properti datasource (ex. username/password database) yang ada di file credentials sesuai dengan konfigurasi perangkat
```bash
  url: jdbc:mysql://namaHost:port/namaDatabase?useSSL=(true / false)
  username: username_koneksi_mysql
  password: password_koneksi_mysql
```
5. Jalankan perintah
```bash
  mvn spring-boot:run
```
6. Pastikan di log terminal sudah sampai 
```bash
  ......
  ...Completed initialization in ... ms
```
7. Buka browser dan akses server dengan url untuk memastikan program telah berjalan 
```bash
  http://localhost:8080
```
Jika Berhasil, Tampilan akan di alihkan ke halaman dokumentasi
#### Server Online
1. Untuk mengakses server online, bisa menghubungi ketua tim (fredy hermawan) untuk mendapatkan informasi IP public server yang dapat di akses secara online.
2. note : Port tomcat yang digunakan dalam server online adalah 9999 bukan 8080.
### Client
1. Buka project client di Android Studio.
2. Pastikan import library telah selesai (progress bar di bawah kanan)
3. Ubah alamat server(API_BASE_URL) di file gradle sesuai dengan alamat IP server.
note : Tidak bisa menggunakan "localhost". Jika program server dijalankan di lokal, maka ganti dengan alamat IP lokal.
Cara cek ip lokal (windows :: cmd)
```bash
  ipconfig
  ......
  IPv4 Address... : ip lokal (ex. 192.168.43.155)
```
3. Jalankan program dengan klik icon play di atas kanan
