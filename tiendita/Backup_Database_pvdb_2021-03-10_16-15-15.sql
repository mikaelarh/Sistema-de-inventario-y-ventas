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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,'frijoles',1,'1 KG',30,16),(2,'arroz',1,'1 KG',25,9),(3,'sal de mar',3,'1/4 KG',7,8),(4,'agua purificada',4,'1 LT',10,12);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medidas`
--

LOCK TABLES `medidas` WRITE;
/*!40000 ALTER TABLE `medidas` DISABLE KEYS */;
INSERT INTO `medidas` VALUES (1,'KG'),(2,'LT'),(3,'UNIDAD'),(4,'Reja');
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
  `Id_Usuario` int(11) NOT NULL,
  `FechaDeAcceso` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `HoraDeAcceso` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `CajaInicial` float NOT NULL,
  `FechaDeCierre` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HoraDeCierre` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CajaFinal` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registros`
--

LOCK TABLES `registros` WRITE;
/*!40000 ALTER TABLE `registros` DISABLE KEYS */;
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
INSERT INTO `reporte_info` VALUES (1,1,27,'10-03-2021','15:09',10,10,3,2021);
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
  `Cantidad` int(11) NOT NULL,
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
INSERT INTO `reporte_venta` VALUES (1,1,4,'agua purificada','1 LT',20,2),(2,1,3,'sal de mar','1/4 KG',7,1);
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
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Administrador','user','password',1);
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

-- Dump completed on 2021-03-10 16:15:19
