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

    public SiswaTPA() {
        
        //default constructor
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
    
        
}
