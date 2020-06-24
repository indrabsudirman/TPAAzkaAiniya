-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24 Jun 2020 pada 10.59
-- Versi Server: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `azkaainiya`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelajaran`
--

CREATE TABLE `pembelajaran` (
  `kodePembelajaran` varchar(50) NOT NULL,
  `namaPembelajaran` varchar(100) NOT NULL,
  `biayaPembelajaran` decimal(13,2) NOT NULL,
  `deskripsiPembelajaran` varchar(255) NOT NULL,
  `user` varchar(100) NOT NULL,
  `tanggalDibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userMadeEdit` varchar(100) DEFAULT NULL,
  `tanggalDiedit` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelajaran`
--

INSERT INTO `pembelajaran` (`kodePembelajaran`, `namaPembelajaran`, `biayaPembelajaran`, `deskripsiPembelajaran`, `user`, `tanggalDibuat`, `userMadeEdit`, `tanggalDiedit`) VALUES
('BL 001', 'Iqra I', '100000.00', 'Iqra I', 'Username', '2020-05-20 09:09:08', NULL, NULL),
('BL 002', 'Iqra II', '110000.00', 'Iqra II', 'Username', '2020-05-19 15:26:31', NULL, NULL),
('BL 003', 'Iqra III', '120000.00', 'Iqra III', 'Username', '2020-05-20 09:10:27', NULL, NULL),
('BL 004', 'Iqra IV', '130000.00', 'Iqra IV', 'Username', '2020-05-31 01:12:24', NULL, NULL),
('BL 005', 'Iqra V', '140000.00', 'Iqra V', 'Username', '2020-05-20 12:06:48', NULL, NULL),
('BL 006', 'Iqra VI', '150000.00', 'Iqra VI', 'Username', '2020-05-31 01:50:54', 'Username', '2020-05-31 23:19:32');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelajaran_siswa`
--

CREATE TABLE `pembelajaran_siswa` (
  `id` int(100) NOT NULL,
  `noPembelajaranSiswa` varchar(50) NOT NULL,
  `noInduk` varchar(20) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `kodePembelajaran` varchar(50) NOT NULL,
  `namaPembelajaran` varchar(100) NOT NULL,
  `halamanPembelajaran` varchar(5) DEFAULT NULL,
  `nilaiPembelajaran` varchar(100) DEFAULT NULL,
  `catatanPembelajaran` varchar(100) DEFAULT NULL,
  `tanggalPembelajaran` timestamp NULL DEFAULT NULL,
  `userMadeNilaiSiswa` varchar(100) DEFAULT NULL,
  `tanggalNilai` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `biayaPembelajaran` decimal(13,2) NOT NULL,
  `userMadePembelajaranSiswa` varchar(100) NOT NULL,
  `tanggalDibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelajaran_siswa`
--

INSERT INTO `pembelajaran_siswa` (`id`, `noPembelajaranSiswa`, `noInduk`, `namaLengkap`, `kodePembelajaran`, `namaPembelajaran`, `halamanPembelajaran`, `nilaiPembelajaran`, `catatanPembelajaran`, `tanggalPembelajaran`, `userMadeNilaiSiswa`, `tanggalNilai`, `biayaPembelajaran`, `userMadePembelajaranSiswa`, `tanggalDibuat`) VALUES
(1, 'PS 001', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 002', 'Iqra II', NULL, NULL, NULL, NULL, '', '2020-06-01 06:52:34', '110000.00', 'Username', '2020-05-31 13:08:15'),
(2, 'PS 002', '2021 003', 'Afanin Azka Ainiya Analwi', 'BL 002', 'Iqra I', '1', '85 90 90', 'Lanjut', '2020-06-03 06:50:11', 'Username', '2020-06-01 06:52:34', '110000.00', 'Username', '2020-05-31 22:07:53'),
(3, 'PS 003', '2021 001', 'Nuryati', 'BL 001', 'Iqra I', '1', '100 100 100', 'Lanjut', '2020-06-24 08:52:45', 'Username', '2020-06-01 06:52:34', '100000.00', 'Username', '2020-05-31 23:12:54'),
(4, 'PS 004', '2021 001', 'Nuryati', 'BL 005', 'Iqra V', NULL, NULL, NULL, NULL, '', '2020-06-01 06:52:34', '140000.00', 'Username', '2020-05-31 23:38:31');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelajaran_siswa1`
--

CREATE TABLE `pembelajaran_siswa1` (
  `noPembelajaranSiswa` varchar(50) NOT NULL,
  `noInduk` varchar(20) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `kodePembelajaran` varchar(50) NOT NULL,
  `namaPembelajaran` varchar(100) NOT NULL,
  `halamanPembelajaran` int(11) NOT NULL,
  `nilaiPembelajaran` double(3,2) NOT NULL,
  `catatanPembelajaran` varchar(255) DEFAULT NULL,
  `tanggalPembelajaran` date NOT NULL,
  `biayaPembelajaran` decimal(13,2) NOT NULL,
  `userMadePembelajaranSiswa` varchar(100) NOT NULL,
  `tanggalDibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelajaran_siswa1`
--

INSERT INTO `pembelajaran_siswa1` (`noPembelajaranSiswa`, `noInduk`, `namaLengkap`, `kodePembelajaran`, `namaPembelajaran`, `halamanPembelajaran`, `nilaiPembelajaran`, `catatanPembelajaran`, `tanggalPembelajaran`, `biayaPembelajaran`, `userMadePembelajaranSiswa`, `tanggalDibuat`) VALUES
('PS 001', '2021 001', 'Nuryati', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100.00', 'Username', '2020-05-16 08:59:40'),
('PS 002', '2021 001', 'Nuryati', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100000.00', 'Username', '2020-05-16 15:09:24'),
('PS 003', '2021 003', 'Afanin Azka Ainiya Analwi', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100000.00', 'Username', '2020-05-16 15:19:42'),
('PS 004', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100000.00', 'Username', '2020-05-16 15:21:36'),
('PS 005', '2021 003', 'Afanin Azka Ainiya Analwi', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100000.00', 'Username', '2020-05-16 15:27:35'),
('PS 006', '2021 001', 'Nuryati', 'BL 002', 'Iqra II', 0, 0.00, NULL, '0000-00-00', '110000.00', 'Username', '2020-05-16 15:48:53'),
('PS 007', '2021 003', 'Afanin Azka Ainiya Analwi', 'BL 001', 'Iqra I', 0, 0.00, NULL, '0000-00-00', '100000.00', 'Username', '2020-05-16 15:49:20'),
('PS 008', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 002', 'Iqra II', 0, 0.00, NULL, '0000-00-00', '110000.00', 'Username', '2020-05-20 11:58:12'),
('PS 009', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 003', 'Iqra III', 0, 0.00, NULL, '0000-00-00', '120000.00', 'Username', '2020-05-20 11:59:19'),
('PS 010', '2021 003', 'Afanin Azka Ainiya Analwi', 'BL 005', 'Iqra V', 0, 0.00, NULL, '0000-00-00', '140000.00', 'Username', '2020-05-30 05:45:55'),
('PS 011', '2021 004', 'Karmutiara Sudirman', 'BL 004', 'Iqra IV', 0, 0.00, NULL, '0000-00-00', '130000.00', 'Username', '2020-05-31 01:12:43'),
('PS 012', '2021 004', 'Karmutiara Sudirman', 'BL 002', 'Iqra II', 0, 0.00, NULL, '0000-00-00', '110000.00', 'Username', '2020-05-31 01:14:02'),
('PS 013', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 004', 'Iqra IV', 0, 0.00, NULL, '0000-00-00', '130000.00', 'Username', '2020-05-31 01:14:54'),
('PS 014', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 004', 'Iqra IV', 0, 0.00, NULL, '0000-00-00', '130000.00', 'Username', '2020-05-31 01:15:46'),
('PS 015', '2021 002', 'Siti Nurlubna Indra Sudirman', 'BL 006', 'Iqra VI', 0, 0.00, NULL, '0000-00-00', '140000.00', 'Username', '2020-05-31 01:52:54');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelajaran_terhapus`
--

CREATE TABLE `pembelajaran_terhapus` (
  `kodePembelajaran` varchar(50) NOT NULL,
  `namaPembelajaran` varchar(100) NOT NULL,
  `biayaPembelajaran` decimal(13,0) NOT NULL,
  `deskripsiPembelajaran` varchar(255) NOT NULL,
  `user` varchar(100) NOT NULL,
  `tanggalDibuat` timestamp NULL DEFAULT NULL,
  `userMadeDelete` varchar(100) DEFAULT NULL,
  `tanggalDelete` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelajaran_terhapus`
--

INSERT INTO `pembelajaran_terhapus` (`kodePembelajaran`, `namaPembelajaran`, `biayaPembelajaran`, `deskripsiPembelajaran`, `user`, `tanggalDibuat`, `userMadeDelete`, `tanggalDelete`) VALUES
('QN 001', 'Al Quran', '150000', 'Membaca Al Quran', 'Username', '2020-04-23 04:00:16', 'Username', '2020-04-26 05:01:05'),
('BL 004', 'Iqra IV', '100000', 'Belajar Iqra IV', 'Username', '2020-04-25 22:18:30', 'IndraSudirman', '2020-05-25 07:53:04'),
('BL 003', 'Iqra III', '100', 'Belajar Iqra 3', 'Username', '2020-04-25 15:39:36', 'Username', '2020-05-20 09:07:14'),
('BL 002', 'Iqra II', '110000', 'Iqra II ditujukan untuk anak yang sudah\ntamat belajar di Iqra I.', 'Username', '2020-04-23 03:39:08', 'Username', '2020-05-19 14:36:21'),
('BL 002', 'Iqra II', '110000', 'Iqra II ditujukan untuk siswa yang sudah \nmenyelesaikan Iqra I', 'Username', '2020-04-26 14:22:06', 'Username', '2020-05-19 14:36:21'),
('BL 001', 'Iqra I', '100000', 'Iqra I ditujukan untuk anak yang belum\npernah mengikuti pembelajaran Iqra\nsama sekali.', 'Username', '2020-04-22 22:05:09', 'Username', '2020-05-20 09:07:26'),
('BL 001', 'Iqra I', '100000', 'Iqra I ditujukkan untuk siswa yang baru\nmemulai pembelajaran Iqra', 'Username', '2020-05-16 11:55:30', 'Username', '2020-05-20 09:07:26'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'IndraSudirman', '2020-05-16 12:05:06', 'Username', '2020-05-20 09:07:26'),
('BL 003', 'Iqra III', '120000', 'Iqra III', 'Username', '2020-05-16 15:31:37', 'Username', '2020-05-20 09:07:14'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-16 15:13:13', 'Username', '2020-05-20 09:07:26'),
('BL 002', 'Iqra II', '110000', 'Iqra II', 'Username', '2020-05-16 15:28:01', 'Username', '2020-05-19 14:36:21'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-16 15:38:01', 'Username', '2020-05-20 09:07:26'),
('BL 005', 'Iqra V', '150000', 'Iqra V', 'Username', '2020-05-16 15:48:11', 'Username', '2020-05-20 08:58:06'),
('BL 004', 'Iqra IV', '140000', 'Iqra IV', 'Username', '2020-05-16 15:47:14', 'IndraSudirman', '2020-05-25 07:53:04'),
('BL 003', 'Iqra III', '110000', 'Iqra III bagi yang sudah lulus Iqra II', 'Username', '2020-05-16 15:46:43', 'Username', '2020-05-20 09:07:14'),
('BL 002', 'Iqra II', '110000', 'Iqra II Bagi yang sudah', 'Username', '2020-05-16 15:43:38', 'Username', '2020-05-19 14:36:21'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-16 15:39:45', 'Username', '2020-05-20 09:07:26'),
('BL 002', 'Iqra II', '110000', 'Iqra II', 'Username', '2020-05-16 17:04:08', 'Username', '2020-05-19 14:36:21'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-16 17:03:49', 'Username', '2020-05-20 09:07:26'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-17 22:26:56', 'Username', '2020-05-20 09:07:26'),
('BL 002', 'Iqra II', '110000', 'Iqra II', 'Username', '2020-05-17 22:27:18', 'Username', '2020-05-19 14:36:21'),
('BL 004', 'Iqra IV', '130000', 'Iqra IV', 'Username', '2020-05-18 13:57:54', 'IndraSudirman', '2020-05-25 07:53:04'),
('BL 003', 'Iqra III', '120000', 'Iqra III', 'Username', '2020-05-18 13:57:39', 'Username', '2020-05-20 09:07:14'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-18 13:56:55', 'Username', '2020-05-20 09:07:26'),
('BL 004', 'Iqra IV', '130000', 'Iqra IV', 'Username', '2020-05-18 14:00:43', 'IndraSudirman', '2020-05-25 07:53:04'),
('BL 003', 'Iqra III', '120000', 'Iqra III', 'Username', '2020-05-18 13:58:48', 'Username', '2020-05-20 09:07:14'),
('BL 002', 'Iqra II', '110000', 'Iqra II', 'Username', '2020-05-18 13:57:18', 'Username', '2020-05-19 14:36:21'),
('BL 002', 'Iqra II', '110000', 'Iqra II', 'Username', '2020-05-19 14:36:06', 'Username', '2020-05-19 14:36:21'),
('BL 006', 'Iqra VI', '140000', 'Iqra VI', 'Username', '2020-05-19 15:28:05', 'IndraSudirman', '2020-05-25 07:47:19'),
('BL 003', 'Iqra III', '120000', 'Iqra III', 'Username', '2020-05-19 15:27:03', 'Username', '2020-05-20 09:07:14'),
('BL 004', 'Iqra IV', '130000', 'Iqra IV', 'Username', '2020-05-19 15:27:21', 'IndraSudirman', '2020-05-25 07:53:04'),
('BL 005', 'Iqra V', '140000', 'Iqra V', 'Username', '2020-05-19 15:27:42', 'Username', '2020-05-20 08:58:06'),
('BL 003', 'Iqra III', '120000', 'Iqra III', 'Username', '2020-05-20 08:57:32', 'Username', '2020-05-20 09:07:14'),
('BL 001', 'Iqra I', '100000', 'Iqra I', 'Username', '2020-05-18 14:01:14', 'Username', '2020-05-20 09:07:26'),
('BL 006', 'Iqra VI', '150000', 'Iqra VI', 'Username', '2020-05-20 12:07:10', 'IndraSudirman', '2020-05-25 07:47:19'),
('BL 004', 'Iqra IV', '130000', 'Iqra IV', 'Username', '2020-05-20 12:06:31', 'IndraSudirman', '2020-05-25 07:53:04');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `noInduk` varchar(20) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `namaPanggilan` varchar(50) NOT NULL,
  `tempatLahir` varchar(100) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `tanggalMasukTPA` date NOT NULL,
  `namaAyah` varchar(100) NOT NULL,
  `namaIbu` varchar(100) NOT NULL,
  `noTelpAyahIbu` varchar(50) NOT NULL,
  `noWaAyahIbu` varchar(50) NOT NULL,
  `alamatLengkap` varchar(150) NOT NULL,
  `fotoSiswa` varchar(255) NOT NULL,
  `tanggalDibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user` varchar(100) NOT NULL,
  `userMadeEdit` varchar(100) DEFAULT NULL,
  `tanggalDiedit` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`noInduk`, `namaLengkap`, `namaPanggilan`, `tempatLahir`, `tanggalLahir`, `tanggalMasukTPA`, `namaAyah`, `namaIbu`, `noTelpAyahIbu`, `noWaAyahIbu`, `alamatLengkap`, `fotoSiswa`, `tanggalDibuat`, `user`, `userMadeEdit`, `tanggalDiedit`) VALUES
('2021 001', 'Nuryati', 'Nury', 'Kabupaten Banjarnegara', '1992-01-20', '2020-03-22', 'Madsupan', 'Rakem', '083894343517', '083894343517', 'Jl. Berta Krajan Susukan Banjarnegara', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Nuryati.png', '2020-04-22 02:13:50', 'Username', 'Username', '2020-04-22 08:17:23'),
('2021 002', 'Siti Nurlubna Indra Sudirman', 'Lubna', 'Tangerang Selatan', '2016-01-27', '2020-04-20', 'Indra Bayu Sudirman', 'Nuryati', '089636002345', '089636002345', 'Jl. Nangka V No 89 Rt 005/02 Pakulonan\nSerpong Utara Tangerang Selatan Banten\n15325', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Siti Nurlubna Indra Sudirman.png', '2020-04-22 02:40:54', 'Username', NULL, NULL),
('2021 003', 'Afanin Azka Ainiya Analwi', 'Fanin', 'Tangerang', '2014-02-03', '2020-04-22', 'Muhammad Naldi Novendar', 'Dewi Ratnawati Sudirman', '08128171901000', '08128171901000', 'Perum Griya Indah Serpong Blok 05/14\nGunung Sindur Kabupaten Bogor', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Afanin Azka Ainiya Analwi.jpg', '2020-04-22 02:43:29', 'Username', 'Username', '2020-04-22 09:34:49'),
('2021 004', 'Karmutiara Sudirman', 'Mutiara', 'Tangerang', '2020-08-18', '2020-05-23', 'Sudirman bin Kandim', 'Napsiah binti Sanusi', '081281719079', '081281719079', 'Jl Nangka V No 89 Rt 005/02 Pakulonan \nSerpong Utara Tangerang Selatan\n15325', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-23 05:27:16', 'IndraSudirman', NULL, NULL),
('2021 005', 'Megawati Sudirman', 'Mega', 'Indramayu', '2020-05-04', '2020-05-23', 'Sudirman bin Kandim', 'Napsiah binti Sanusi', '08123695874', '08123695874', 'Seporm', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-23 05:34:37', 'IndraSudirman', NULL, NULL),
('2021 006', 'hdfhdh', 'hdfh', 'hdfhdfh', '2020-05-23', '2020-05-23', 'hdfh', 'hdfh', '45325', '5325', 'gdsgdsg', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-23 05:37:06', 'Username', NULL, NULL),
('2021 007', 'dgfsdeg', 'dsgdsgds', 'gdsgds', '2020-05-23', '2020-05-23', 'gdsg', 'gdsg', '5325235235', '5325235235', 'gdsfgtg', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-23 05:39:16', 'Username', NULL, NULL),
('2021 008', 'gfsdgdsg', 'gsdgsd', 'gdsgdsg', '2020-05-07', '2020-05-23', 'gewgw', 'gdsgd', '43434324', '43434324', 'dsfdsfds', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-23 05:48:23', 'Username', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa_terhapus`
--

CREATE TABLE `siswa_terhapus` (
  `noInduk` varchar(20) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `namaPanggilan` varchar(50) NOT NULL,
  `tempatLahir` varchar(100) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `tanggalMasukTPA` date NOT NULL,
  `namaAyah` varchar(100) NOT NULL,
  `namaIbu` varchar(100) NOT NULL,
  `noTelpAyahIbu` varchar(50) NOT NULL,
  `noWaAyahIbu` varchar(50) NOT NULL,
  `alamatLengkap` varchar(150) NOT NULL,
  `fotoSiswa` varchar(255) NOT NULL,
  `tanggalDibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user` varchar(100) NOT NULL,
  `userMadeDelete` varchar(100) DEFAULT NULL,
  `tanggalDelete` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa_terhapus`
--

INSERT INTO `siswa_terhapus` (`noInduk`, `namaLengkap`, `namaPanggilan`, `tempatLahir`, `tanggalLahir`, `tanggalMasukTPA`, `namaAyah`, `namaIbu`, `noTelpAyahIbu`, `noWaAyahIbu`, `alamatLengkap`, `fotoSiswa`, `tanggalDibuat`, `user`, `userMadeDelete`, `tanggalDelete`) VALUES
('2021 001', 'Siti Nurlubna Indra Sudirman', 'Lubna', 'Tangerang Selatan', '2016-01-27', '2020-02-03', 'Indra Bayu Sudirman', 'Nuryati', '089636002345', '089636002345', 'Jl. Nangka V No. 89 Rt 005/02 \nKelurahan Pakulonan \nKecamatan Serpong Tangerang Selatan 15325\nBanten', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-04-21 23:21:00', 'IndraSudirman', 'IndraSudirman', '2020-04-21 23:21:08'),
('2021 002', 'Afanin Azka Ainiya Analwi', 'Fanin', 'Tangerang', '2014-02-11', '2020-02-22', 'Muhammad Naldi Novendar', 'Dewi Ratnawati Sudirman', '081281719079', '081281719079', 'Perum Griya Indah Serpong Blok 05/14\nGunung Sindur Kapupaten Bogor', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-04-21 23:04:55', 'IndraSudirman', 'Username', '2020-04-21 17:00:00'),
('2021 003', 'Nuryati', 'Nury', 'Banjarnegara', '1992-01-20', '2020-04-01', 'Madsupan', 'Rakem', '083894343517', '083894343517', 'Dusun Krajan Rt 005/02 Berta Susukan\nBanjarnegara', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Nuryati.png', '2020-04-01 12:25:19', 'IndraSudirman', 'Username', '2020-04-21 17:00:00'),
('2021 004', 'Siti Nurlubna Indra Sudirman', 'Lubna', 'Tangerang Selatan', '2019-01-27', '2020-04-03', 'Indra Bayu Sudirman', 'Nuryati', '089636002345', '089636002345', 'Jl. Nangka V No 89 Rt 005 Rw 002 Kelurahan\nPakulonan Kecamatan Serpong Utara\nKota Tangerang Selatan 15325 ', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Siti Nurlubna Indra Sudirman.png', '2020-04-03 01:53:20', 'IndraSudirman', 'IndraSudirman', '2020-05-23 01:06:20'),
('2021 005', 'tte', 'tet', 'tet', '2020-04-03', '2020-04-04', 'efef', 'tet', '564356345', '564356345', 'etfett', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-04-03 22:25:07', 'Username', NULL, '2020-04-20 17:00:00'),
('2021 006', 'Pake Foto', 'tewt', 'tewt', '2020-04-03', '2020-04-04', 'tewt', 'tewt', '774', '754', 'fghfhj', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Pake Foto.png', '2020-04-03 22:33:01', 'Username', NULL, '2020-04-20 17:00:00'),
('2021 008', 'Pakai Foto', 'dgds', 'gdsgd', '2020-03-30', '2020-04-04', 'ggdsg', 'gdsg', '454', '5345', 'tegg', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Pakai Foto.png', '2020-04-03 22:39:57', 'Username', NULL, '2020-04-20 17:00:00'),
('2021 009', 'Pake Foto 2', 'greg', 'gewg', '2020-04-03', '2020-04-04', 'fewf', 'gdrg', '5325', '5325', 'fdgfg', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\foto-siswa\\Pake Foto 2.png', '2020-04-03 22:53:14', 'Username', NULL, '2020-04-20 17:00:00'),
('2021 011', 'Tidak ada Foto', 'rer', 'r3w', '2020-04-04', '2020-04-05', 'rwqr', 'rwq', '535', '535', '53535', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-04-04 22:52:00', 'IndraSudirman', 'Indra', '2020-04-20 17:00:00'),
('2021 012', 'GL Pro', 'GL', 'Jepang', '2020-03-08', '2020-04-08', 'GL Gold Wing', 'GL Wing 1', '0898967967', '0898967967', 'Perfektur Jepang East Asia', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-04-08 13:38:10', 'IndraSudirman', NULL, '2020-04-20 17:00:00'),
('2021 004', 'GL Pro Neotech', 'GL', 'Perfectur Tokyo Japan', '2003-06-04', '2015-08-05', 'Gold Wing', 'CBR 500', '0325154513151', '0325154513151', 'Tokyo Japan East Asia', 'C:\\Users\\Jabrikos\\Documents\\NetBeansProjects\\TPAAzkaAiniya\\build\\classes\\tpaazkaainiya\\image\\no_image_siswa.png', '2020-05-15 09:30:45', 'IndraSudirman', 'IndraSudirman', '2020-05-23 01:06:20');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `passwordOne` varchar(64) NOT NULL,
  `passwordTwo` varchar(64) NOT NULL,
  `diBuatTgl` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `passwordOne`, `passwordTwo`, `diBuatTgl`) VALUES
(1, 'IndraSudirman', '4cceb1397f02abf77bf1f3df81139a57', '6f0df7323c910f9ab8f03157d5fbd940', '2020-03-12 02:27:49'),
(2, 'UmmiDewi', '72cc9c0aa42686215a205254ad7df623', 'e121813b57cc47900804fb13dd674864', '2020-03-26 10:44:40'),
(3, 'BundaNuryati', '5f3d2c3a51c6c78bf0eb66809ad4f2ed', 'c008c584ca874915b9abf057cf8bd7fd', '2020-03-31 04:31:40');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pembelajaran`
--
ALTER TABLE `pembelajaran`
  ADD PRIMARY KEY (`kodePembelajaran`);

--
-- Indexes for table `pembelajaran_siswa`
--
ALTER TABLE `pembelajaran_siswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelajaran_siswa1`
--
ALTER TABLE `pembelajaran_siswa1`
  ADD PRIMARY KEY (`noPembelajaranSiswa`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`noInduk`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pembelajaran_siswa`
--
ALTER TABLE `pembelajaran_siswa`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
