-- MySQL dump 10.16  Distrib 10.1.34-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: pvdb
-- ------------------------------------------------------
-- Server version	10.1.34-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Producto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `UID1` int(11) DEFAULT NULL,
  `Um1` varchar(11) COLLATE utf8_spanish_ci DEFAULT NULL,
  `P1` float DEFAULT NULL,
  `C1` float DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,'frijoles',0,'1 KG',30,11.5),(2,'arroz',0,'1 KG',25,9),(3,'sal de mar',0,'1 KG',7,8),(4,'agua purificada',1,'1 LT',10,12),(5,'Reja de huevo',3,'Reja',65,10);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medidas`
--

DROP TABLE IF EXISTS `medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medidas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Um` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medidas`
--

LOCK TABLES `medidas` WRITE;
/*!40000 ALTER TABLE `medidas` DISABLE KEYS */;
INSERT INTO `medidas` VALUES (1,'KG'),(2,'LT'),(3,'UNIDAD'),(4,'Reja'),(5,'Caja');
/*!40000 ALTER TABLE `medidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registros`
--

DROP TABLE IF EXISTS `registros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registros` (
  `Id` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `FechaDeAcceso` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `HoraDeAcceso` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `CajaInicial` float DEFAULT NULL,
  `FechaDeCierre` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HoraDeCierre` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CajaFinal` float DEFAULT NULL,
  `Semana` int(11) DEFAULT NULL,
  `Acceso` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Usuario` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registros`
--

LOCK TABLES `registros` WRITE;
/*!40000 ALTER TABLE `registros` DISABLE KEYS */;
INSERT INTO `registros` VALUES (1,1,'11-03-2021','15:44',200,'11-03-2021','15:44',200,10,'Administrador'),(2,1,'11-03-2021','15:48',200,'11-03-2021','15:48',200,10,'Administrador'),(3,1,'11-03-2021','15:50',200,'11-03-2021','15:50',200,10,'Administrador'),(4,1,'11-03-2021','15:54',200,'11-03-2021','15:54',200,10,'Administrador'),(5,1,'11-03-2021','16:00',200,'11-03-2021','16:00',200,10,'Administrador'),(6,1,'12-03-2021','07:52',NULL,NULL,NULL,NULL,10,'Administrador'),(7,1,'12-03-2021','07:54',200,'12-03-2021','07:54',200,10,'Vendedor'),(8,1,'12-03-2021','08:24',NULL,'12-03-2021','08:24',NULL,10,'Administrador'),(9,1,'12-03-2021','08:24',200,'12-03-2021','08:24',300,10,'Vendedor'),(10,1,'12-03-2021','09:11',NULL,'12-03-2021','09:11',NULL,10,'Administrador'),(11,1,'12-03-2021','09:11',200,'12-03-2021','09:11',200,10,'Vendedor'),(12,1,'12-03-2021','09:27',NULL,'12-03-2021','09:27',NULL,10,'Administrador'),(13,1,'12-03-2021','09:27',200,'12-03-2021','09:27',200,10,'Vendedor'),(14,1,'12-03-2021','09:36',NULL,'12-03-2021','09:36',NULL,10,'Administrador'),(15,1,'12-03-2021','09:37',NULL,'12-03-2021','09:37',NULL,10,'Administrador'),(16,1,'12-03-2021','09:39',NULL,'12-03-2021','09:39',NULL,10,'Administrador'),(17,1,'12-03-2021','09:54',NULL,'12-03-2021','09:54',NULL,10,'Administrador'),(18,1,'12-03-2021','09:54',NULL,'12-03-2021','09:54',NULL,10,'Administrador'),(19,1,'12-03-2021','09:56',NULL,'12-03-2021','09:56',NULL,10,'Administrador'),(20,1,'12-03-2021','09:59',NULL,'12-03-2021','09:59',NULL,10,'Administrador'),(21,1,'12-03-2021','10:00',NULL,'12-03-2021','10:00',NULL,10,'Administrador'),(22,1,'12-03-2021','10:05',NULL,'12-03-2021','10:05',NULL,10,'Administrador'),(23,1,'12-03-2021','10:07',NULL,'12-03-2021','10:07',NULL,10,'Administrador'),(24,1,'12-03-2021','10:07',NULL,'12-03-2021','10:07',NULL,10,'Administrador');
/*!40000 ALTER TABLE `registros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte_info`
--

DROP TABLE IF EXISTS `reporte_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporte_info` (
  `Id` int(11) NOT NULL,
  `Id_vendedor` int(11) NOT NULL,
  `Total_Venta` double DEFAULT NULL,
  `Fecha` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Hora` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Dia` int(11) NOT NULL,
  `Semana` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Año` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_vendedor` (`Id_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte_info`
--

LOCK TABLES `reporte_info` WRITE;
/*!40000 ALTER TABLE `reporte_info` DISABLE KEYS */;
INSERT INTO `reporte_info` VALUES (1,1,30,'12-03-2021','08:24',12,10,3,2021),(2,1,120,'12-03-2021','08:24',12,10,3,2021),(3,1,15,'12-03-2021','09:11',12,10,3,2021),(4,1,15,'12-03-2021','09:27',12,10,3,2021);
/*!40000 ALTER TABLE `reporte_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte_venta`
--

DROP TABLE IF EXISTS `reporte_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporte_venta` (
  `Id` int(11) NOT NULL,
  `Id_Info` int(11) NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Producto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Presentacion` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `TotalProducto` double NOT NULL,
  `Cantidad` double NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Info` (`Id_Info`),
  KEY `Id_Producto` (`Id_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte_venta`
--

LOCK TABLES `reporte_venta` WRITE;
/*!40000 ALTER TABLE `reporte_venta` DISABLE KEYS */;
INSERT INTO `reporte_venta` VALUES (1,1,1,'frijoles','1 KG',30,1),(2,2,1,'frijoles','1 KG',90,3),(3,4,1,'frijoles','1 KG',15,0.5);
/*!40000 ALTER TABLE `reporte_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Contraseña` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Rango` int(11) NOT NULL,
  `Sesion` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Administrador','user','password',1,0),(2,'Martin','vendedor1','123',0,0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-12 10:09:37
