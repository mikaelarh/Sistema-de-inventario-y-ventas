-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-02-2021 a las 19:20:23
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pvdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `Id` int(11) NOT NULL,
  `Producto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `UID1` int(11) DEFAULT NULL,
  `Um1` varchar(11) COLLATE utf8_spanish_ci DEFAULT NULL,
  `P1` float DEFAULT NULL,
  `C1` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`Id`, `Producto`, `UID1`, `Um1`, `P1`, `C1`) VALUES
(1, 'frijoles', 1, '1 KG', 30, 16),
(2, 'arroz', 1, '1 KG', 25, 9),
(3, 'sal de mar', 3, '1/4 KG', 7, 9),
(4, 'agua purificada', 4, '1 LT', 10, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_info`
--

CREATE TABLE `reporte_info` (
  `Id` int(11) NOT NULL,
  `Id_vendedor` int(11) NOT NULL,
  `Total_Venta` double DEFAULT NULL,
  `Fecha` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Hora` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Dia` int(11) NOT NULL,
  `Semana` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Año` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `reporte_info`
--

INSERT INTO `reporte_info` (`Id`, `Id_vendedor`, `Total_Venta`, `Fecha`, `Hora`, `Dia`, `Semana`, `Mes`, `Año`) VALUES
(1, 1, 92, '18-02-2021', '10:43', 18, 7, 2, 2021),
(2, 2, 70, '18-02-2021', '11:38', 18, 7, 2, 2021);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_venta`
--

CREATE TABLE `reporte_venta` (
  `Id` int(11) NOT NULL,
  `Id_Info` int(11) NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Producto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Presentacion` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `TotalProducto` double NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `reporte_venta`
--

INSERT INTO `reporte_venta` (`Id`, `Id_Info`, `Id_Producto`, `Producto`, `Presentacion`, `TotalProducto`, `Cantidad`) VALUES
(1, 1, 3, 'sal de mar', '1/4 KG', 7, 1),
(2, 1, 1, 'frijoles', '1 KG', 60, 2),
(3, 1, 2, 'arroz', '1 KG', 25, 1),
(4, 2, 1, 'frijoles', '1 KG', 60, 2),
(5, 2, 4, 'agua purificada', '1 LT', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Contraseña` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Rango` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`IdUsuario`, `Nombre`, `Usuario`, `Contraseña`, `Rango`) VALUES
(1, 'Administrador', 'user', 'password', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `reporte_info`
--
ALTER TABLE `reporte_info`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_vendedor` (`Id_vendedor`);

--
-- Indices de la tabla `reporte_venta`
--
ALTER TABLE `reporte_venta`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Info` (`Id_Info`),
  ADD KEY `Id_Producto` (`Id_Producto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`IdUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
