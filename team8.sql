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
INSERT INTO `tbldiem` VALUES (1,10,10,10,10,10,'20171','B16DCCN319',1,5),(2,8,8,8,8,8,'20171','B16DCCN239',1,4),(3,5,5,5,5,5,'20171','B16DCCN148',1,1),(4,9,9,9,9,9,'20171','B16DCCN159',1,3),(5,9.5,9.5,9,9,9.5,'20171','B16DCCN151',1,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblgiangvien`
--

LOCK TABLES `tblgiangvien` WRITE;
/*!40000 ALTER TABLE `tblgiangvien` DISABLE KEYS */;
INSERT INTO `tblgiangvien` VALUES (1,6,'CNTT','CNTT','Tiến Sĩ',NULL),(2,7,'CNTT','CNTT','Tiến Sĩ',NULL),(3,8,'CNTT','CNTT','PGS. Tiến Sĩ',NULL),(4,9,'CNTT','CNTT','Tiến Sĩ',NULL),(5,12,'DPT','CNDPT','Thạc Sĩ',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllichgiangday`
--

LOCK TABLES `tbllichgiangday` WRITE;
/*!40000 ALTER TABLE `tbllichgiangday` DISABLE KEYS */;
INSERT INTO `tbllichgiangday` VALUES (1,11,34,13,3,3,3),(2,11,23,15,5,3,4),(3,11,34,1,1,6,1),(4,6,22,13,3,8,3);
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
  `daChon` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_ngoai_mon_hoc` (`tblMonHocId`),
  CONSTRAINT `khoa_ngoai_mon_hoc` FOREIGN KEY (`tblMonHocId`) REFERENCES `tblmonhoc` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllophocphan`
--

LOCK TABLES `tbllophocphan` WRITE;
/*!40000 ALTER TABLE `tbllophocphan` DISABLE KEYS */;
INSERT INTO `tbllophocphan` VALUES (1,'aaa','XLA 01','1',59,4,33),(2,'bbb','XLA 02','1',59,4,59),(3,'ccc','XLA 03','1',59,4,3),(4,'def','XLA 04','1',59,4,46),(5,'fed','XLA 05','1',59,4,27),(6,'hihi','KTDH 01','1',39,3,3),(7,'haha','KTDH 02','1',39,3,33),(8,'agag','CNPM 01','1',69,1,50);
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
  `khoa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmonhoc`
--

LOCK TABLES `tblmonhoc` WRITE;
/*!40000 ALTER TABLE `tblmonhoc` DISABLE KEYS */;
INSERT INTO `tblmonhoc` VALUES (1,'a1','Nhập môn Công nghệ phần mềm',3,45,0,0,0.1,0.1,0,0.2,0.6,NULL,'CNPM','CNTT'),(2,'b2','Nhập môn Trí tuệ nhân tạo',3,40,5,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(3,'c3','Kỹ thuật đồ họa',2,45,0,0,0.1,0.1,0,0.1,0.7,NULL,NULL,'CNTT'),(4,'a2','Xử lý ảnh',13,45,0,0,0.1,0.1,0,0,0.7,NULL,NULL,'CNTT'),(5,'b3','Xử lý tín hiệu số',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ĐTVT');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnguoidung`
--

LOCK TABLES `tblnguoidung` WRITE;
/*!40000 ALTER TABLE `tblnguoidung` DISABLE KEYS */;
INSERT INTO `tblnguoidung` VALUES (1,'B16DCCN148','148','Tạ Duy Hiếu','a','Nam','SV'),(2,'B16DCCN151','tranhailinh','Lê Thị Hoa','a','Nữ','SV'),(3,'B16DCCN159','159','Phạm Ngọc Hoàng','06/12/1998','Nam','SV'),(4,'B16DCCN239','239','Nguyễn Văn Nam','a','Nam','SV'),(5,'B16DCCN319','319','Nguyễn Đình Thắng','a','Nam','SV'),(6,'GV001','4','Nguyễn Mạnh Hùng','a','Nam','GV'),(7,'GV002','5','Ngô Xuân Bách','a','Nam','GV'),(8,'GV003','6','Ngô Quốc Tạo','a','Nam','GV'),(9,'GV004','7','Trịnh Thị Vân Anh','b','Nữ','GV'),(10,'QL001','8','Ngô Xuân Thành','b','Nam','GVU'),(11,'QL002','9','Chu Phương Hiền','b','Nữ','GVU'),(12,'GV005','abc','Vũ Hữu Tiến','b','Nam','GV'),(13,'B18DCAT137','137','Nguyễn Thùy Linh','???','Nữ','SV'),(14,'B15DCQT107','qt107','Trần Hải Linh',NULL,NULL,'SV'),(15,'B16DCVT022','chianh','Phạm Thị Ngọc Ánh',NULL,NULL,'SV');
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblphieudangky`
--

LOCK TABLES `tblphieudangky` WRITE;
/*!40000 ALTER TABLE `tblphieudangky` DISABLE KEYS */;
INSERT INTO `tblphieudangky` VALUES (11,'Tue Apr 30 10:39:04 ICT 2019',435000,3,4),(12,'Tue Apr 30 10:39:04 ICT 2019',435000,6,4),(19,'Tue Apr 30 10:44:01 ICT 2019',435000,6,2),(20,'Tue Apr 30 10:44:01 ICT 2019',435000,3,2),(39,'Tue Apr 30 23:06:13 ICT 2019',435000,6,5),(40,'Tue Apr 30 23:06:13 ICT 2019',435000,3,5),(43,'Tue Apr 30 23:21:48 ICT 2019',435000,6,3),(44,'Tue Apr 30 23:21:48 ICT 2019',435000,3,3);
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
INSERT INTO `tblphonghoc` VALUES (1,'101 A2',NULL,59,NULL,NULL),(2,'102 A2',NULL,59,NULL,NULL),(3,'201 A2',NULL,59,NULL,NULL),(4,'203 A2',NULL,59,NULL,NULL),(5,'303 A3',NULL,59,NULL,NULL),(6,'302 A3',NULL,59,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsinhvien`
--

LOCK TABLES `tblsinhvien` WRITE;
/*!40000 ALTER TABLE `tblsinhvien` DISABLE KEYS */;
INSERT INTO `tblsinhvien` VALUES (1,1,'CNTT','CNTT',NULL,NULL,NULL,'CN1'),(2,2,'CNTT','CNTT',NULL,NULL,NULL,'CN2'),(3,3,'CNTT','CNTT',NULL,NULL,NULL,'CN3'),(4,4,'CNTT','CNTT',NULL,NULL,NULL,'CN4'),(5,5,'CNTT','CNTT',NULL,NULL,NULL,'CN5'),(6,13,'CNTT','ATTT',NULL,NULL,NULL,'CN6'),(7,14,'CNTT','CNTT',NULL,NULL,NULL,'CN7'),(8,15,'VT','ĐTVT',NULL,NULL,NULL,'VT6');
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

-- Dump completed on 2019-04-30 23:26:59
