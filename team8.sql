-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: qltc
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbldiem`
--

DROP TABLE IF EXISTS `tbldiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbldiem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diemCC` float DEFAULT NULL,
  `diemKT` float DEFAULT NULL,
  `diemTH` float DEFAULT NULL,
  `diemBTL` float DEFAULT NULL,
  `diemCK` float DEFAULT NULL,
  `kyHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `maSinhVien` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tblMonHocId` int(11) DEFAULT NULL,
  `tblSinhVientblNguoiDungId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_mon_hoc_diem` (`tblMonHocId`),
  KEY `khoa_ngoai_diem_sinh_vien` (`tblSinhVientblNguoiDungId`),
  CONSTRAINT `khoa_ngoai_diem_sinh_vien` FOREIGN KEY (`tblSinhVientblNguoiDungId`) REFERENCES `tblsinhvien` (`id`) ON DELETE SET NULL,
  CONSTRAINT `khoa_ngoai_mon_hoc_diem` FOREIGN KEY (`tblMonHocId`) REFERENCES `tblmonhoc` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldiem`
--

LOCK TABLES `tbldiem` WRITE;
/*!40000 ALTER TABLE `tbldiem` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbldiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblgiangvien`
--

DROP TABLE IF EXISTS `tblgiangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblgiangvien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tblNguoiDungId` int(11) DEFAULT NULL,
  `khoa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nganh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `hocVi` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `boMon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_giang_vien` (`tblNguoiDungId`),
  CONSTRAINT `khoa_ngoai_giang_vien` FOREIGN KEY (`tblNguoiDungId`) REFERENCES `tblnguoidung` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblgiangvien`
--

LOCK TABLES `tblgiangvien` WRITE;
/*!40000 ALTER TABLE `tblgiangvien` DISABLE KEYS */;
INSERT INTO `tblgiangvien` VALUES (1,6,'CNTT','CNTT','Tiến Sĩ',NULL),(2,7,'CNTT','CNTT','Tiến Sĩ',NULL),(3,8,'CNTT','ATTT','PGS. Tiến Sĩ',NULL),(4,9,'CNTT','CNTT','Tiến Sĩ',NULL),(6,119,'CB','CB','Tiến Sĩ',NULL),(7,120,'CNTT','ATTT','Thạc Sĩ',NULL),(8,121,'CB','CB','PGS. Tiến Sĩ',NULL),(9,122,'CNTT','CNTT','Tiến Sĩ',NULL),(10,123,'ĐTVT','VT','Thạc Sĩ',NULL),(11,124,'CNTT','ATTT','Tiến Sĩ',NULL),(12,125,'CB','CB','Tiến Sĩ',NULL),(13,126,'ĐPT','TTĐPT','Tiến Sĩ',NULL),(14,127,'CNTT','CNTT','Tiến Sĩ',NULL),(15,128,'KT','KT','Tiến Sĩ',NULL),(16,129,'CNTT','CNTT','Thạc Sĩ',NULL),(17,130,'CNTT','ATTT','PGS. Tiến Sĩ',NULL),(18,131,'CNTT','CNTT','Tiến Sĩ',NULL),(19,132,'ĐTVT','ĐT','Thạc Sĩ',NULL),(20,133,'CNTT','CNTT','Tiến Sĩ',NULL),(21,134,'CNTT','ATTT','Tiến Sĩ',NULL);
/*!40000 ALTER TABLE `tblgiangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblkiphoc`
--

DROP TABLE IF EXISTS `tblkiphoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblkiphoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gioBatDau` int(11) DEFAULT NULL,
  `gioKetThuc` int(11) DEFAULT NULL,
  `thu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblkiphoc`
--

LOCK TABLES `tblkiphoc` WRITE;
/*!40000 ALTER TABLE `tblkiphoc` DISABLE KEYS */;
INSERT INTO `tblkiphoc` VALUES (1,7,9,2),(2,9,11,2),(3,12,14,2),(4,14,16,2),(5,16,18,2),(6,18,20,2),(7,7,9,3),(8,9,11,3),(9,12,14,3),(10,14,16,3),(11,16,18,3),(12,18,20,3),(13,7,9,4),(14,9,11,4),(15,12,14,4),(16,14,16,4),(17,16,18,4),(18,18,20,4),(19,7,9,5),(20,9,11,5),(21,12,14,5),(22,14,16,5),(23,16,18,5),(24,18,20,5),(25,7,9,6),(26,9,11,6),(27,12,14,6),(28,14,16,6),(29,16,18,6),(30,18,20,6);
/*!40000 ALTER TABLE `tblkiphoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllichgiangday`
--

DROP TABLE IF EXISTS `tbllichgiangday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbllichgiangday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tuanBatDau` int(5) DEFAULT NULL,
  `tuanKetThuc` int(5) DEFAULT NULL,
  `tblKipHocId` int(11) DEFAULT NULL,
  `tblPhongHocId` int(11) DEFAULT NULL,
  `tblLopHocPhanId` int(11) DEFAULT NULL,
  `tblGiangVientblNguoiDungId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_kip_hoc` (`tblKipHocId`),
  KEY `khoa_ngoai_phong_hoc` (`tblPhongHocId`),
  KEY `khoa_ngoai_lop_hoc_phan` (`tblLopHocPhanId`),
  KEY `khoa_ngoai_giang_vien_1` (`tblGiangVientblNguoiDungId`),
  CONSTRAINT `khoa_ngoai_giang_vien_1` FOREIGN KEY (`tblGiangVientblNguoiDungId`) REFERENCES `tblgiangvien` (`id`) ON DELETE SET NULL,
  CONSTRAINT `khoa_ngoai_kip_hoc` FOREIGN KEY (`tblKipHocId`) REFERENCES `tblkiphoc` (`id`),
  CONSTRAINT `khoa_ngoai_lop_hoc_phan` FOREIGN KEY (`tblLopHocPhanId`) REFERENCES `tbllophocphan` (`id`),
  CONSTRAINT `khoa_ngoai_phong_hoc` FOREIGN KEY (`tblPhongHocId`) REFERENCES `tblphonghoc` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllichgiangday`
--

LOCK TABLES `tbllichgiangday` WRITE;
/*!40000 ALTER TABLE `tbllichgiangday` DISABLE KEYS */;
INSERT INTO `tbllichgiangday` VALUES (10,11,33,1,1,1,3),(11,11,22,2,1,1,3);
/*!40000 ALTER TABLE `tbllichgiangday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllophocphan`
--

DROP TABLE IF EXISTS `tbllophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbllophocphan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maLop` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `hocKy` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `siSo` int(10) DEFAULT NULL,
  `tblMonHocId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_mon_hoc` (`tblMonHocId`),
  CONSTRAINT `khoa_ngoai_mon_hoc` FOREIGN KEY (`tblMonHocId`) REFERENCES `tblmonhoc` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllophocphan`
--

LOCK TABLES `tbllophocphan` WRITE;
/*!40000 ALTER TABLE `tbllophocphan` DISABLE KEYS */;
INSERT INTO `tbllophocphan` VALUES (1,'D16-01','Xử lý ảnh 01','20171',15,4),(2,'D16-02','Xử lý ảnh 02','20171',15,4),(3,'D16-03','Xử lý ảnh 03','20171',15,4),(4,'D16-04','Xử lý ảnh 04','20171',15,4),(5,'D16-05','Xử lý ảnh 05','20171',15,4),(10,'D16-99','13 Tín chỉ','20691',100,7),(12,'D16-11','Nhập môn CNPM 01','20171',15,1),(13,'D16-12','Nhập môn CNPM 02','20171',15,1),(14,'D16-13','Nhập môn CNPM 03','20171',15,1),(15,'D16-14','Nhập môn CNPM 04','20171',15,1),(16,'D16-15','A11 01','20171',15,9),(17,'D16-16','A11 02','20171',15,9),(18,'D16-17','A11 03','20171',15,9),(19,'D16-18','A12 01','20171',15,10),(20,'D16-19','A12 02','20171',15,10),(21,'D16-20','A12 03','20171',15,10),(22,'D16-21','A21 01','20171',15,11),(23,'D16-22','A21 02','20171',15,11),(24,'D16-23','A21 03','20171',15,11),(25,'D16-24','A22 01','20171',15,12),(26,'D16-25','A22 02','20171',15,12),(27,'D16-26','A22 03','20171',15,12),(28,'D16-27','Nhập môn TTNT 01','20171',15,14),(29,'D16-28','Nhập môn TTNT 02','20171',15,14),(30,'D16-29','Nhập môn TTNT 03','20171',15,14),(31,'D16-30','Mạng máy tính 01','20171',15,15),(32,'D16-31','Mạng máy tính 02','20171',15,15),(33,'D16-32','Mạng máy tính 03','20171',15,15),(34,'D16-33','Kỹ thuật đồ họa 01','20171',15,16),(35,'D16-34','Kỹ thuật đồ họa 02','20171',15,16),(36,'D16-35','Kỹ thuật đồ họa 03','20171',15,16),(37,'D16-36','ATBM HTTT 01','20171',15,17),(38,'D16-37','ATBM HTTT 02','20171',15,17),(39,'D16-38','ATBM HTTT 03','20171',15,17),(40,'D16-39','Lập trình hướng đối tượng 01','20171',15,18),(41,'D16-40','Lập trình hướng đối tượng 02','20171',15,18),(42,'D16-41','Lập trình hướng đối tượng 03','20171',15,18),(43,'D16-42','CTDL GT 01','20171',15,19),(44,'D16-43','CTDL GT 02','20171',15,19),(45,'D16-44','CTDL GT 03','20171',15,19),(46,'D16-45','Toán rời rạc1 01','20171',15,20),(47,'D16-46','Toán rời rạc1 02','20171',15,20),(48,'D16-47','Toán rời rạc1 03','20171',15,20),(49,'D16-48','Toán rời rạc2 01','20171',15,21),(50,'D16-49','Toán rời rạc2 02','20171',15,21),(51,'D16-50','Toán rời rạc2 03','20171',15,21),(52,'D16-51','Cơ sở dữ liệu 01','20171',15,22),(53,'D16-52','Cơ sở dữ liệu 02','20171',15,22),(54,'D16-53','Cơ sở dữ liệu 03','20171',15,22),(55,'D16-54','Hệ điều hành 01','20171',15,23),(56,'D16-55','Hệ điều hành 02','20171',15,23),(57,'D16-56','Hệ điều hành 03','20171',15,23),(58,'D16-55','Kỹ thuật vxl 01','20171',15,24),(59,'D16-56','Kỹ thuật vxl 02','20171',15,24),(60,'D16-57','Kỹ thuật vxl 03','20171',15,24),(61,'D16-58','Tin học cơ sở1 01','20171',15,25),(62,'D16-59','Tin học cơ sở1 02','20171',15,25),(63,'D16-60','Tin học cơ sở1 03','20171',15,25),(64,'D16-61','Tin học cơ sở2 01','20171',15,26),(65,'D16-62','Tin học cơ sở2 02','20171',15,26),(66,'D16-63','Tin học cơ sở2 03','20171',15,26),(67,'D16-64','Lập trình C++ 01','20171',15,27),(68,'D16-65','Lập trình C++ 02','20171',15,27),(69,'D16-66','Lập trình C++ 03','20171',15,27),(70,'D16-67','Xử lý tín hiệu số 01','20171',15,28),(71,'D16-68','Xử lý tín hiệu số 02','20171',15,28),(72,'D16-69','Xử lý tín hiệu số 03','20171',15,28),(73,'D16-70','Lý thuyết thông tin 01','20171',15,29),(74,'D16-71','Lý thuyết thông tin 02','20171',15,29),(75,'D16-72','Lý thuyết thông tin 03','20171',15,29),(76,'D16-73','Vật lý1 01','20171',15,30),(77,'D16-74','Vật lý1 02','20171',15,30),(78,'D16-75','Vật lý1 03','20171',15,30),(79,'D16-76','Vật lý3 01','20171',15,31),(80,'D16-77','Vật lý3 02','20171',15,31),(81,'D16-78','Vật lý3 03','20171',15,31);
/*!40000 ALTER TABLE `tbllophocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmonhoc`
--

DROP TABLE IF EXISTS `tblmonhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblmonhoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maMon` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenMon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `soTinChi` int(11) DEFAULT NULL,
  `soTietLT` int(11) DEFAULT NULL,
  `soTietBT` int(11) DEFAULT NULL,
  `soTietTH` int(11) DEFAULT NULL,
  `hsChuyenCan` double DEFAULT NULL,
  `hsKiemTra` double DEFAULT NULL,
  `hsThucHanh` double DEFAULT NULL,
  `hsBaiTapLon` double DEFAULT NULL,
  `hsCuoiKy` double DEFAULT NULL,
  `monDK` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `boMon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `khoa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmonhoc`
--

LOCK TABLES `tblmonhoc` WRITE;
/*!40000 ALTER TABLE `tblmonhoc` DISABLE KEYS */;
INSERT INTO `tblmonhoc` VALUES (1,'INT1340','Nhập môn Công nghệ phần mềm',3,45,0,0,0.1,0.1,0,0.2,0.6,NULL,'CNPM','CNTT'),(4,'INT1362','Xử lý ảnh',2,45,0,0,0.1,0.1,0.1,0,0.7,NULL,NULL,'CNTT'),(7,'TST1111','13 Tín Chỉ',13,100,0,0,0,0,0,0,1,NULL,NULL,'CB'),(9,'BAS1141','Tiếng Anh A11',4,45,0,0,0,0,0,0,1,NULL,NULL,'CB'),(10,'BAS1142','Tiếng Anh A12',4,45,0,0,0,0,0,0,1,NULL,NULL,'CB'),(11,'BAS1143','Tiếng Anh A21',4,45,0,0,0,0,0,0,1,NULL,NULL,'CB'),(12,'BAS1144','Tiếng Anh A22',4,45,0,0,0,0,0,0,1,NULL,NULL,'CB'),(14,'INT1341','Nhập môn trí tuệ nhân tạo',3,45,0,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(15,'INT1336','Mạng máy tính',3,40,0,5,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT'),(16,'INT1328','Kỹ thuật đồ họa',3,45,0,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(17,'INT1303','An toàn bảo mật hệ thống thông tin',3,40,0,5,0.1,0.1,0,0.2,0.6,NULL,NULL,'CNTT'),(18,'INT1332','Lập trình hướng đối tượng',3,45,0,8,0.1,0.2,0.2,0,0.5,NULL,NULL,'CNTT'),(19,'INT1306','Cấu trúc dữ liệu và giải thuật',3,45,0,0,0.1,0.2,0.2,0,0.5,NULL,NULL,'CNTT'),(20,'INT1358','Toán rời rạc 1',3,45,0,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(21,'INT1359','Toán rời rạc 2',3,45,0,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(22,'INT1313','Cơ sở dữ liệu',3,40,0,5,0.1,0.1,0,0.2,0.6,NULL,NULL,'CNTT'),(23,'INT1319','Hệ điều hành',3,40,0,5,0.1,0.1,0.1,0,0.7,NULL,NULL,'CNTT'),(24,'INT1330','Kĩ thuật vi xử lý',3,45,0,0,0.1,0.1,0,0.2,0.6,NULL,NULL,'CNTT'),(25,'INT1154','Tin học cơ sở 1',3,35,0,10,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT'),(26,'INT1155','Tin học cơ sở 2',3,35,0,0,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT'),(27,'INT1339','Ngôn ngữ lập trình C++',3,35,0,0,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT'),(28,'ELE1330','Xử lý tín hiệu số',3,45,0,0,0.1,0.1,0,0.2,0.6,NULL,NULL,'CNTT'),(29,'ELE1319','Lý thuyết thông tin',3,45,0,0,0.1,0.1,0,0.2,0.6,NULL,NULL,'CNTT'),(30,'BAS1324','Vật lý 1 và thí nghiệm',3,40,0,5,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT'),(31,'BAS1327','Vật lý 3 và thí nghiệm',3,40,0,5,0.1,0.1,0.2,0,0.6,NULL,NULL,'CNTT');
/*!40000 ALTER TABLE `tblmonhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblnguoidung`
--

DROP TABLE IF EXISTS `tblnguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblnguoidung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenDangNhap` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hoTen` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaySinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gioiTinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `vaiTro` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenDangNhap_UNIQUE` (`tenDangNhap`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnguoidung`
--

LOCK TABLES `tblnguoidung` WRITE;
/*!40000 ALTER TABLE `tblnguoidung` DISABLE KEYS */;
INSERT INTO `tblnguoidung` VALUES (1,'B16DCCN148','148','Tạ Duy Hiếu','01/02/1998','Nam','SV'),(2,'B16DCCN151','tranhailinh','Lê Thị Hoa','28/11/1998','Nữ','SV'),(3,'B16DCCN159','159','Phạm Ngọc Hoàng','06/12/1998','Nam','SV'),(4,'B16DCCN239','239','Nguyễn Văn Nam','18/02/1998','Nam','SV'),(5,'B16DCCN319','319','Nguyễn Đình Thắng','20/10/1993','Nam','SV'),(6,'GV001','1','Nguyễn Mạnh Hùng','30/04/1975','Nam','GV'),(7,'GV002','1','Ngô Xuân Bách','30/04/1975','Nam','GV'),(8,'GV003','1','Ngô Quốc Tạo','19/08/1960','Nam','GV'),(9,'GV004','1','Trịnh Thị Vân Anh','30/04/1975','Nữ','GV'),(10,'QL001','1','Ngô Xuân Thành','30/04/1975','Nam','GVU'),(11,'QL002','1','Chu Phương Hiền','30/04/1975','Nữ','GVU'),(13,'admin','admin','admin','admin','admin','admin'),(16,'B16DCCN001','1','Chu Văn An','29/08/1998',NULL,'SV'),(17,'B16DCCN010','1','Nguyễn Thị Lan Anh','01/06/1998',NULL,'SV'),(18,'B16DCCN011','1','Nguyễn Trọng Đức Anh','01/08/1998',NULL,'SV'),(19,'B16DCCN018','1','Hoàng Ngọc ánh','27/12/1997',NULL,'SV'),(20,'B16DCCN026','1','Nguyễn Trọng Bằng','09/03/1998',NULL,'SV'),(21,'B16DCCN027','1','Trần Chí Bảo','19/09/1998',NULL,'SV'),(22,'B16DCCN033','1','Cao Minh Chúng','09/08/1998',NULL,'SV'),(23,'B16DCCN034','1','Trần Đức Chuyên','28/02/1997',NULL,'SV'),(24,'B16DCCN035','1','Nguyễn Bá Công','23/10/1998',NULL,'SV'),(25,'B16DCCN042','1','Dương Quốc Cường','12/10/1998',NULL,'SV'),(26,'B16DCCN051','1','Bùi Xuân Dân','25/12/1998',NULL,'SV'),(27,'B16DCCN058','1','Lê Quang Đạo','24/01/1998',NULL,'SV'),(28,'B16DCCN065','1','Nguyễn Văn Đạt','03/12/1998',NULL,'SV'),(29,'B16DCCN059','1','Đào Quốc Đạt','22/08/1998',NULL,'SV'),(30,'B16DCCN067','1','Tạ Khắc Đạt','02/03/1998',NULL,'SV'),(31,'B16DCCN073','1','Nguyễn Mạnh Đình','30/03/1998',NULL,'SV'),(32,'B16DCCN097','1','Phạm Văn Dũng','25/11/1998',NULL,'SV'),(33,'B16DCCN098','1','Phạm Việt Dũng','25/11/1997',NULL,'SV'),(34,'B16DCCN090','1','Đỗ Trọng Dũng','22/10/1998',NULL,'SV'),(35,'B16DCCN113','1','Kim Bằng Giang','12/01/1998',NULL,'SV'),(36,'B16DCCN137','1','Nguyễn Hoàng Hiệp','02/04/1998',NULL,'SV'),(37,'B16DCCN145','1','Nguyễn Trung Hiếu','19/05/1998',NULL,'SV'),(38,'B16DCCN146','1','Nguyễn Văn Hiếu','17/04/1998',NULL,'SV'),(39,'B16DCCN153','1','Nguyễn Văn Hòa','11/04/1997',NULL,'SV'),(40,'B16DCCN162','1','Phùng Văn Hùng','27/06/1998',NULL,'SV'),(41,'B16DCCN170','1','Nguyễn Thị Hồng Hương','19/02/1998',NULL,'SV'),(42,'B16DCCN186','1','Nhữ Thị Huyền','11/06/1998',NULL,'SV'),(43,'B16DCCN193','1','Phạm Văn Khoa','08/10/1998',NULL,'SV'),(44,'B16DCCN194','1','Trần Đăng Khoa','13/10/1998',NULL,'SV'),(45,'B16DCCN201','1','Hà Duyên Lâm','03/02/1998',NULL,'SV'),(46,'B16DCCN202','1','Hà Tùng Lâm','21/09/1998',NULL,'SV'),(47,'B16DCCN218','1','Bùi Thị Lụa','26/09/1998',NULL,'SV'),(48,'B16DCCN233','1','Vũ Văn Minh','25/02/1997',NULL,'SV'),(49,'B16DCCN241','1','Phạm Văn Nam','29/05/1998',NULL,'SV'),(50,'B16DCCN249','1','Châu Văn Nghị','03/01/1998',NULL,'SV'),(51,'B16DCCN258','1','Đỗ Đình Nhất','10/06/1998',NULL,'SV'),(52,'B16DCCN265','1','Khổng Hoàng Phong','15/10/1998',NULL,'SV'),(53,'B16DCCN274','1','Nguyễn Thị Phương','27/07/1998',NULL,'SV'),(54,'B16DCCN298','1','Hàn Hồng Sơn','23/09/1998',NULL,'SV'),(55,'B16DCCN329','1','Nguyễn Khắc Thành','16/06/1997',NULL,'SV'),(56,'B16DCCN330','1','Nguyễn Minh Thành','30/03/1998',NULL,'SV'),(57,'B16DCCN337','1','Phạm Văn Thiên','01/06/1998',NULL,'SV'),(58,'B16DCCN338','1','Lê Đức Thiện','16/11/1998',NULL,'SV'),(59,'B16DCCN353','1','Nguyễn Đình Tiến','25/03/1997',NULL,'SV'),(60,'B16DCCN354','1','Trần Thế Tiến','20/06/1998',NULL,'SV'),(61,'B16DCCN362','1','Nguyễn Hữu Tráng','30/08/1998',NULL,'SV'),(62,'B16DCCN377','1','Nguyễn Anh Tú','07/04/1998',NULL,'SV'),(63,'B16DCCN378','1','Phạm Viết Tú','02/06/1998',NULL,'SV'),(64,'B16DCCN385','1','Lê Văn Tuấn','14/12/1998',NULL,'SV'),(65,'B16DCCN394','1','Hồ Diên Tùng','13/09/1998',NULL,'SV'),(66,'B16DCCN402','1','Đào Văn Tuyên','25/01/1998',NULL,'SV'),(67,'B16DCCN004','1','Nhữ Đình An','03/05/1998',NULL,'SV'),(68,'B16DCCN013','1','Nguyễn Việt Anh','19/01/1998',NULL,'SV'),(69,'B16DCCN005','1','Bành Tuấn Anh','22/08/1998',NULL,'SV'),(70,'B16DCCN020','1','Phạm Ngọc ánh','21/10/1998',NULL,'SV'),(71,'B16DCCN021','1','Trịnh Thị Ngọc ánh','19/09/1998',NULL,'SV'),(72,'B16DCCN028','1','Nguyễn Minh Châu','18/02/1998',NULL,'SV'),(73,'B16DCCN036','1','Nguyễn Tiến Công','02/07/1998',NULL,'SV'),(74,'B16DCCN053','1','Lê Minh Đăng','20/09/1998',NULL,'SV'),(75,'B16DCCN068','1','Trần Quốc Đạt','10/05/1998',NULL,'SV'),(76,'B16DCCN061','1','Hoàng Văn Đạt','10/03/1997',NULL,'SV'),(77,'B16DCCN083','1','Phạm Minh Đức','21/05/1998',NULL,'SV'),(78,'B16DCCN084','1','Phạm Minh Đức','26/12/1997',NULL,'SV'),(79,'B16DCCN091','1','Giáp Mạnh Dũng','10/12/1998',NULL,'SV'),(80,'B16DCCN107','1','Bùi Thọ Dưỡng','27/08/1998',NULL,'SV'),(81,'B16DCCN108','1','Thái Khắc Đường','02/01/1998',NULL,'SV'),(82,'B16DCCN115','1','Phạm Đức Giang','05/03/1998',NULL,'SV'),(83,'B16DCCN116','1','Phùng Thị Giang','13/03/1998',NULL,'SV'),(84,'B16DCCN155','1','Hà Duy Hoàng','24/02/1998',NULL,'SV'),(85,'B16DCCN156','1','Nguyễn Nhật Hoàng','12/04/1998',NULL,'SV'),(86,'B16DCCN164','1','Ngô Quang Hưng','08/07/1998',NULL,'SV'),(87,'B16DCCN171','1','Nguyễn Thị Lan Hương','14/01/1998',NULL,'SV'),(88,'B16DCCN172','1','Nguyễn Thị Hường','20/02/1998',NULL,'SV'),(89,'B16DCCN179','1','Nguyễn Quốc Huy','09/02/1998',NULL,'SV'),(90,'B16DCCN188','1','Phan Văn Khải','02/04/1998',NULL,'SV'),(91,'B16DCCN196','1','Nguyễn Bá Kiên','19/02/1998',NULL,'SV'),(92,'B16DCCN203','1','Nguyễn Hữu Lâm','08/12/1998',NULL,'SV'),(93,'B16DCCN211','1','Nguyễn Quang Linh','26/04/1998',NULL,'SV'),(94,'B16DCCN219','1','Nguyễn Tiến Lực','08/10/1998',NULL,'SV'),(95,'B16DCCN227','1','Hoàng Thị Mến','15/07/1998',NULL,'SV'),(96,'B16DCCN244','1','Trần Khắc Nam','30/06/1998',NULL,'SV'),(97,'B16DCCN236','1','Nguyễn Phương Nam','17/10/1998',NULL,'SV'),(98,'B16DCCN251','1','Lê Trọng Nghĩa','18/11/1998',NULL,'SV'),(99,'B16DCCN252','1','Tào Trọng Nghĩa','06/02/1998',NULL,'SV'),(100,'B16DCCN259','1','Đào Long Nhật','10/01/1998',NULL,'SV'),(101,'B16DCCN260','1','Phạm Quang Ninh','24/01/1998',NULL,'SV'),(102,'B16DCCN267','1','Trương Thanh Phong','13/01/1998',NULL,'SV'),(103,'B16DCCN268','1','Trần Văn Phú','22/09/1998',NULL,'SV'),(104,'B16DCCN283','1','Vũ Đình Quân','14/02/1998',NULL,'SV'),(105,'B16DCCN299','1','Hoàng Anh Vĩ Sơn','25/07/1998',NULL,'SV'),(106,'B16DCCN300','1','Nguyễn Hữu Sơn','29/09/1998',NULL,'SV'),(107,'B16DCCN307','1','Nguyễn Thị Thanh Tâm','09/06/1998',NULL,'SV'),(108,'B16DCCN331','1','Phan Quang Thành','17/02/1998',NULL,'SV'),(109,'B16DCCN332','1','Phan Tiến Thành','25/10/1998',NULL,'SV'),(110,'B16DCCN347','1','Quách Quang Thuận','23/06/1996',NULL,'SV'),(111,'B16DCCN348','1','Nguyễn Tiến Thuật','28/07/1998',NULL,'SV'),(112,'B16DCCN363','1','Nguyễn Công Trí','30/06/1998',NULL,'SV'),(113,'B16DCCN364','1','Phạm Văn Triều','11/05/1998',NULL,'SV'),(114,'B16DCCN379','1','Thái Phúc Tú','01/03/1998',NULL,'SV'),(115,'B16DCCN388','1','Tạ Anh Tuấn','26/10/1998',NULL,'SV'),(116,'B16DCCN395','1','Hoàng Mạnh Tùng','05/03/1998',NULL,'SV'),(117,'B16DCCN396','1','Hoàng Thế Tùng','31/12/1998',NULL,'SV'),(119,'GV005','1','Hoàng Xuân Dậu','30/04/1975',NULL,'GV'),(120,'GV006','1','Dương Trần Đức','30/04/1975',NULL,'GV'),(121,'GV008','1','Nguyễn Mạnh Sơn','30/04/1975',NULL,'GV'),(122,'GV009','1','Đặng Ngọc Hùng','30/04/1975',NULL,'GV'),(123,'GV007','1','Vũ Hoài Nam','30/04/1975',NULL,'GV'),(124,'GV010','1','Đặng Thị Thúy Quỳnh','30/04/1975',NULL,'GV'),(125,'GV011','1','Nguyễn Thị Hương Thảo','30/04/1975',NULL,'GV'),(126,'GV012','1','Phạm Ngọc Anh','30/04/1975',NULL,'GV'),(127,'GV013','1','Hoàng Phi Dũng','30/04/1975',NULL,'GV'),(128,'GV014','1','Lê Văn Ngọc','30/04/1975',NULL,'GV'),(129,'GV015','1','Vũ Hữu Nhự','30/04/1975',NULL,'GV'),(130,'GV016','1','Lê Bá Long','30/04/1975',NULL,'GV'),(131,'GV017','1','Trần Việt Anh','30/04/1975',NULL,'GV'),(132,'GV018','1','Nguyễn Thị Thu','30/04/1975',NULL,'GV'),(133,'GV019','1','Nguyễn Thu Nga','30/04/1975',NULL,'GV'),(134,'GV020','1','Lê Minh Thanh','30/04/1975',NULL,'GV');
/*!40000 ALTER TABLE `tblnguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblphieudangky`
--

DROP TABLE IF EXISTS `tblphieudangky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblphieudangky` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thoiGian` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `hocPhi` int(11) DEFAULT NULL,
  `tblLopHocPhanId` int(11) DEFAULT NULL,
  `tblSinhVientblNguoiDungId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_lop_hoc_phan_phieu_dang_ki` (`tblLopHocPhanId`),
  KEY `khoa_ngoai_sinh_vien_phieu_dang_ky` (`tblSinhVientblNguoiDungId`),
  CONSTRAINT `khoa_ngoai_lop_hoc_phan_phieu_dang_ki` FOREIGN KEY (`tblLopHocPhanId`) REFERENCES `tbllophocphan` (`id`) ON DELETE SET NULL,
  CONSTRAINT `khoa_ngoai_sinh_vien_phieu_dang_ky` FOREIGN KEY (`tblSinhVientblNguoiDungId`) REFERENCES `tblsinhvien` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblphieudangky`
--

LOCK TABLES `tblphieudangky` WRITE;
/*!40000 ALTER TABLE `tblphieudangky` DISABLE KEYS */;
INSERT INTO `tblphieudangky` VALUES (105,'Sun May 05 13:40:55 ICT 2019',435000,10,1),(106,'Sun May 05 13:40:55 ICT 2019',435000,1,1);
/*!40000 ALTER TABLE `tblphieudangky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblphonghoc`
--

DROP TABLE IF EXISTS `tblphonghoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblphonghoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenPhong` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `viTri` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `suaChua` int(11) DEFAULT NULL,
  `moTa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tblTruongId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai` (`tblTruongId`),
  CONSTRAINT `khoa_ngoai` FOREIGN KEY (`tblTruongId`) REFERENCES `tbltruong` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblphonghoc`
--

LOCK TABLES `tblphonghoc` WRITE;
/*!40000 ALTER TABLE `tblphonghoc` DISABLE KEYS */;
INSERT INTO `tblphonghoc` VALUES (1,'101 A2',NULL,59,NULL,1),(2,'102 A2',NULL,59,NULL,1),(3,'201 A2',NULL,59,NULL,1),(4,'203 A2',NULL,59,NULL,1),(5,'303 A3',NULL,59,NULL,1),(6,'302 A3',NULL,59,NULL,1);
/*!40000 ALTER TABLE `tblphonghoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsinhvien`
--

DROP TABLE IF EXISTS `tblsinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblsinhvien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tblNguoiDungId` int(11) NOT NULL,
  `khoa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nganh` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gpa` float DEFAULT NULL,
  `stcTichLuy` int(11) DEFAULT NULL,
  `hocLuc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `lop` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_sinh_vien` (`tblNguoiDungId`),
  CONSTRAINT `khoa_ngoai_sinh_vien` FOREIGN KEY (`tblNguoiDungId`) REFERENCES `tblnguoidung` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsinhvien`
--

LOCK TABLES `tblsinhvien` WRITE;
/*!40000 ALTER TABLE `tblsinhvien` DISABLE KEYS */;
INSERT INTO `tblsinhvien` VALUES (1,1,'CNTT','CNTT',NULL,NULL,NULL,'CN1'),(2,2,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(3,3,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(4,4,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(5,5,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(9,16,'CNTT','CNTT',NULL,NULL,NULL,'CN1'),(10,17,'CNTT','ATTT',NULL,NULL,NULL,'AT1'),(11,18,'CNTT','CNTT',NULL,NULL,NULL,'CN1'),(12,19,'CNTT','ATTT',NULL,NULL,NULL,'AT1'),(13,20,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(14,21,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(15,22,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(16,23,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(17,24,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(18,25,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(19,26,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(20,27,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(21,28,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(22,29,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(23,30,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(24,31,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(25,32,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(26,33,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(27,34,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(28,35,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(29,36,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(30,37,'CNTT','ATTT',NULL,NULL,NULL,'AT2'),(31,38,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(32,39,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(33,40,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(34,41,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(35,42,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(36,43,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(37,44,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(38,45,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(39,46,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(40,47,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(41,48,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(42,49,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(43,50,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(44,51,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(45,52,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(46,53,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(47,54,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(48,55,'CNTT','ATTT',NULL,NULL,NULL,'AT3'),(49,56,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(50,57,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(51,58,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(52,59,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(53,60,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(54,61,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(55,62,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(56,63,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(57,64,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(58,65,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(59,66,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(60,67,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(61,68,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(62,69,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(63,70,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(64,71,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(65,72,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(66,73,'CNTT','ATTT',NULL,NULL,NULL,'AT4'),(67,74,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(68,75,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(69,76,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(70,77,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(71,78,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(72,79,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(73,80,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(74,81,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(75,82,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(76,83,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(77,84,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(78,85,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(79,86,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(80,87,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(81,88,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(82,89,'CNTT','ATTT',NULL,NULL,NULL,'AT5'),(83,90,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(84,91,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(85,92,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(86,93,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(87,94,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(88,95,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(89,96,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(90,97,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(91,98,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(92,99,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(93,100,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(94,101,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(95,102,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(96,103,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(97,104,'CNTT','CNTT',NULL,NULL,NULL,'CN6'),(98,105,'CNTT','ATTT',NULL,NULL,NULL,'AT6'),(99,106,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(100,107,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(101,108,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(102,109,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(103,110,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(104,111,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(105,112,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(106,113,'CNTT','ATTT',NULL,NULL,NULL,'AT7'),(107,114,'CNTT','CNTT',NULL,NULL,NULL,'CN8'),(108,115,'CNTT','ATTT',NULL,NULL,NULL,'AT8'),(109,116,'CNTT','CNTT',NULL,NULL,NULL,'CN8'),(110,117,'CNTT','ATTT',NULL,NULL,NULL,'AT8');
/*!40000 ALTER TABLE `tblsinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltruong`
--

DROP TABLE IF EXISTS `tbltruong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbltruong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltruong`
--

LOCK TABLES `tbltruong` WRITE;
/*!40000 ALTER TABLE `tbltruong` DISABLE KEYS */;
INSERT INTO `tbltruong` VALUES (1,'Học viện Công nghệ Bưu chính Viễn thông','aaa','ptit@ptit.edu.vn',NULL);
/*!40000 ALTER TABLE `tbltruong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-05 13:43:47
