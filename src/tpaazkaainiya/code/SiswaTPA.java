/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

import java.util.Date;

/**
 *
 * @author WIN10
 */
public class SiswaTPA {
    
    private String noInduk;
    private String nama;
    private String jenisKelamin;
    private String tempatLahir;
    private Date tanggalLahir;
    private String namaAyah;
    private String namaIbu;
    private String alamat;
    private String namaPembelajaran;
    private Double biayaPembelajaran;
    private Date tanggalTerakhirPembayaran;
    private Double nilaiRataRata;
    private Date tanggalPembelajaran;
    private String halamanPembelajaran;
    private int aspekNilai1;
    private int aspekNilai2;
    private int aspekNilai3;
    private int aspekNilai4;
    private int aspekNilai5;
    private int aspekNilai6;
    private int aspekNilai7;
    private int aspekNilai8;
    private String rataRata;
    private String keterangan;
    private String totalSPP;
    private String kodePembelajaran;
    private String deskripsiPembelajaran;

   

    //Constructor untuk tabel daftar pembelajaran siswa
    public SiswaTPA(String kodePembelajaran, String namaPembelajaran, Double biayaPembelajaran) {
        this.namaPembelajaran = namaPembelajaran;
        this.biayaPembelajaran = biayaPembelajaran;
        this.kodePembelajaran = kodePembelajaran;
    }

    

    
    public SiswaTPA() {
        
        //default constructor
    }

    public SiswaTPA(String noInduk, String nama, String namaPembelajaran) {
        this.noInduk = noInduk;
        this.nama = nama;
        this.namaPembelajaran = namaPembelajaran;
    }  

    public SiswaTPA(String noInduk, String nama, String namaPembelajaran, Double biayaPembelajaran, Date tanggalTerakhirPembayaran) {
        this.noInduk = noInduk;
        this.nama = nama;
        this.namaPembelajaran = namaPembelajaran;
        this.biayaPembelajaran = biayaPembelajaran;
        this.tanggalTerakhirPembayaran = tanggalTerakhirPembayaran;
    }
    
    
    public SiswaTPA(String noInduk, String nama, String jenisKelamin, String tempatLahir, Date tanggalLahir, String namaAyah, String namaIbu) {
        this.noInduk = noInduk;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.namaAyah = namaAyah;
        this.namaIbu = namaIbu;
    }
    
    

    public SiswaTPA(String noInduk, String nama, String jenisKelamin, String tempatLahir, Date tanggalLahir, String namaAyah, String namaIbu, String alamat) {
        this.noInduk = noInduk;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.namaAyah = namaAyah;
        this.namaIbu = namaIbu;
        this.alamat = alamat;
    }

    public String getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(String noInduk) {
        this.noInduk = noInduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getNamaPembelajaran() {
        return namaPembelajaran;
    }

    public void setNamaPembelajaran(String namaPembelajaran) {
        this.namaPembelajaran = namaPembelajaran;
    } 
    public Double getBiayaPembelajaran() {
        return biayaPembelajaran;
    }

    public void setBiayaPembelajaran(Double biayaPembelajaran) {
        this.biayaPembelajaran = biayaPembelajaran;
    }

    public Date getTanggalTerakhirPembayaran() {
        return tanggalTerakhirPembayaran;
    }

    public void setTanggalTerakhirPembayaran(Date tanggalTerakhirPembayaran) {
        this.tanggalTerakhirPembayaran = tanggalTerakhirPembayaran;
    }
    
    public Double getNilaiRataRata() {
        return nilaiRataRata;
    }

    public void setNilaiRataRata(Double nilaiRataRata) {
        this.nilaiRataRata = nilaiRataRata;
    }  
    
    public Date getTanggalPembelajaran() {
        return tanggalPembelajaran;
    }

    public void setTanggalPembelajaran(Date tanggalPembelajaran) {
        this.tanggalPembelajaran = tanggalPembelajaran;
    }

    public String getHalamanPembelajaran() {
        return halamanPembelajaran;
    }

    public void setHalamanPembelajaran(String halamanPembelajaran) {
        this.halamanPembelajaran = halamanPembelajaran;
    }

    public int getAspekNilai1() {
        return aspekNilai1;
    }

    public void setAspekNilai1(int aspekNilai1) {
        this.aspekNilai1 = aspekNilai1;
    }

    public int getAspekNilai2() {
        return aspekNilai2;
    }

    public void setAspekNilai2(int aspekNilai2) {
        this.aspekNilai2 = aspekNilai2;
    }

    public int getAspekNilai3() {
        return aspekNilai3;
    }

    public void setAspekNilai3(int aspekNilai3) {
        this.aspekNilai3 = aspekNilai3;
    }

    public int getAspekNilai4() {
        return aspekNilai4;
    }

    public void setAspekNilai4(int aspekNilai4) {
        this.aspekNilai4 = aspekNilai4;
    }

    public int getAspekNilai5() {
        return aspekNilai5;
    }

    public void setAspekNilai5(int aspekNilai5) {
        this.aspekNilai5 = aspekNilai5;
    }

    public int getAspekNilai6() {
        return aspekNilai6;
    }

    public void setAspekNilai6(int aspekNilai6) {
        this.aspekNilai6 = aspekNilai6;
    }

    public int getAspekNilai7() {
        return aspekNilai7;
    }

    public void setAspekNilai7(int aspekNilai7) {
        this.aspekNilai7 = aspekNilai7;
    }

    public int getAspekNilai8() {
        return aspekNilai8;
    }

    public void setAspekNilai8(int aspekNilai8) {
        this.aspekNilai8 = aspekNilai8;
    }

    public String getRataRata() {
        return rataRata;
    }

    public void setRataRata(String rataRata) {
        this.rataRata = rataRata;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public String getTotalSPP() {
        return totalSPP;
    }

    public void setTotalSPP(String totalSPP) {
        this.totalSPP = totalSPP;
    }
    
     public String getKodePembelajaran() {
        return kodePembelajaran;
    }

    public void setKodePembelajaran(String kodePembelajaran) {
        this.kodePembelajaran = kodePembelajaran;
    }

    public String getDeskripsiPembelajaran() {
        return deskripsiPembelajaran;
    }

    public void setDeskripsiPembelajaran(String deskripsiPembelajaran) {
        this.deskripsiPembelajaran = deskripsiPembelajaran;
    }
}
