-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-09-2022 a las 22:05:09
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_mg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_cliente`
--

CREATE TABLE `mg_cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `NOMBRE_CLIENTE` varchar(100) DEFAULT NULL,
  `APELLIDOS_CLIENTE` varchar(200) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `DIRECCION` varchar(200) DEFAULT NULL,
  `TALLA` decimal(8,2) DEFAULT NULL,
  `PESO_INICIAL` decimal(8,2) DEFAULT NULL,
  `PESO_ACTUAL` decimal(8,2) DEFAULT NULL,
  `IMC` decimal(8,2) DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `CELULAR` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_detalle_dieta_ingredientes`
--

CREATE TABLE `mg_detalle_dieta_ingredientes` (
  `ID_DETALLE_DIETA_ING` int(11) NOT NULL,
  `INGREDIENTES` varchar(100) DEFAULT NULL,
  `UNIDAD_MEDIDA` varchar(5) DEFAULT NULL,
  `CANTIDAD` decimal(8,2) DEFAULT NULL,
  `ID_DIETA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_detalle_dieta_preparacion`
--

CREATE TABLE `mg_detalle_dieta_preparacion` (
  `ID_DETALLE_DIETA_PREPARACION` int(11) NOT NULL,
  `PREPARACION` varchar(500) DEFAULT NULL,
  `ID_DIETA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_detalle_dieta_semana`
--

CREATE TABLE `mg_detalle_dieta_semana` (
  `ID_DETALLE_DIETA_SEM` int(11) NOT NULL,
  `NOMBRE_SEMANA` varchar(20) DEFAULT NULL,
  `ID_DIETA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_detalle_rutina_items`
--

CREATE TABLE `mg_detalle_rutina_items` (
  `ID_DETALLE_RUTINA_ITEMS` int(11) NOT NULL,
  `DESCRIPCION_RUTINA` varchar(500) DEFAULT NULL,
  `ID_RUTINA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_detalle_rutina_semana`
--

CREATE TABLE `mg_detalle_rutina_semana` (
  `ID_DETALLE_RUTINA_SEM` int(11) NOT NULL,
  `NOMBRE_SEMANA` varchar(20) DEFAULT NULL,
  `ID_RUTINA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_dieta`
--

CREATE TABLE `mg_dieta` (
  `ID_DIETA` int(11) NOT NULL,
  `NOMBRE_DIETA` varchar(100) DEFAULT NULL,
  `ID_TIPO_DIETA` int(11) DEFAULT NULL,
  `ID_GYM_DIETA_DIARIA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_dieta_diaria`
--

CREATE TABLE `mg_dieta_diaria` (
  `ID_GYM_DIETA_DIARIA` int(11) DEFAULT NULL,
  `DESCRIPCION_GYM_DIETA_DIARIA` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_programacion`
--

CREATE TABLE `mg_programacion` (
  `ID_CONSOLIDACION_PROGRAMACION` int(11) NOT NULL,
  `FECHA_INICIAL` datetime DEFAULT NULL,
  `FECHA_FINAL` datetime DEFAULT NULL,
  `ID_DIETA` int(11) DEFAULT NULL,
  `ID_RUTINA` int(11) DEFAULT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_rutina`
--

CREATE TABLE `mg_rutina` (
  `ID_RUTINA` int(11) NOT NULL,
  `NOMBRE_RUTINA_EJERCICIO` varchar(50) DEFAULT NULL,
  `ID_TIPO_RUTINA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_tabla_imc`
--

CREATE TABLE `mg_tabla_imc` (
  `ID_TABLA_IMC` int(11) NOT NULL,
  `DESCIPCION_IMC` varchar(100) DEFAULT NULL,
  `RANGO_INICIAL` decimal(8,2) DEFAULT NULL,
  `RANGO_FINAL` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_tipo_dieta`
--

CREATE TABLE `mg_tipo_dieta` (
  `ID_TIPO_DIETA` int(11) NOT NULL,
  `NOMBRE_TIPO_DIETA` varchar(100) DEFAULT NULL,
  `TIEMPO_DIETA_MES` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_tipo_rutina`
--

CREATE TABLE `mg_tipo_rutina` (
  `ID_TIPO_RUTINA` int(11) NOT NULL,
  `NOMBRE_TIPO_RUTINA` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mg_usuario`
--

CREATE TABLE `mg_usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `NOMBRE_USUARIO` varchar(20) DEFAULT NULL,
  `CLAVE_USUARIO` varchar(50) DEFAULT NULL,
  `PERFIL_USUARIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mg_usuario`
--

INSERT INTO `mg_usuario` (`ID_USUARIO`, `NOMBRE_USUARIO`, `CLAVE_USUARIO`, `PERFIL_USUARIO`) VALUES
(1, 'ferdecor', '26021981', 2),
(2, 'aurbina', '12345678', 1),
(3, 'ftorres', '87654321', 1),
(4, 'jcanihua', '44440000', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mg_cliente`
--
ALTER TABLE `mg_cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `mg_detalle_dieta_ingredientes`
--
ALTER TABLE `mg_detalle_dieta_ingredientes`
  ADD PRIMARY KEY (`ID_DETALLE_DIETA_ING`),
  ADD KEY `ID_DIETA` (`ID_DIETA`);

--
-- Indices de la tabla `mg_detalle_dieta_preparacion`
--
ALTER TABLE `mg_detalle_dieta_preparacion`
  ADD PRIMARY KEY (`ID_DETALLE_DIETA_PREPARACION`),
  ADD KEY `ID_DIETA` (`ID_DIETA`);

--
-- Indices de la tabla `mg_detalle_dieta_semana`
--
ALTER TABLE `mg_detalle_dieta_semana`
  ADD PRIMARY KEY (`ID_DETALLE_DIETA_SEM`),
  ADD KEY `ID_DIETA` (`ID_DIETA`);

--
-- Indices de la tabla `mg_detalle_rutina_items`
--
ALTER TABLE `mg_detalle_rutina_items`
  ADD PRIMARY KEY (`ID_DETALLE_RUTINA_ITEMS`),
  ADD KEY `ID_RUTINA` (`ID_RUTINA`);

--
-- Indices de la tabla `mg_detalle_rutina_semana`
--
ALTER TABLE `mg_detalle_rutina_semana`
  ADD PRIMARY KEY (`ID_DETALLE_RUTINA_SEM`),
  ADD KEY `ID_RUTINA` (`ID_RUTINA`);

--
-- Indices de la tabla `mg_dieta`
--
ALTER TABLE `mg_dieta`
  ADD PRIMARY KEY (`ID_DIETA`),
  ADD KEY `ID_TIPO_DIETA` (`ID_TIPO_DIETA`);

--
-- Indices de la tabla `mg_programacion`
--
ALTER TABLE `mg_programacion`
  ADD PRIMARY KEY (`ID_CONSOLIDACION_PROGRAMACION`),
  ADD KEY `ID_CLIENTE` (`ID_CLIENTE`),
  ADD KEY `ID_DIETA` (`ID_DIETA`),
  ADD KEY `ID_RUTINA` (`ID_RUTINA`);

--
-- Indices de la tabla `mg_rutina`
--
ALTER TABLE `mg_rutina`
  ADD PRIMARY KEY (`ID_RUTINA`),
  ADD KEY `ID_TIPO_RUTINA` (`ID_TIPO_RUTINA`);

--
-- Indices de la tabla `mg_tabla_imc`
--
ALTER TABLE `mg_tabla_imc`
  ADD PRIMARY KEY (`ID_TABLA_IMC`);

--
-- Indices de la tabla `mg_tipo_dieta`
--
ALTER TABLE `mg_tipo_dieta`
  ADD PRIMARY KEY (`ID_TIPO_DIETA`);

--
-- Indices de la tabla `mg_tipo_rutina`
--
ALTER TABLE `mg_tipo_rutina`
  ADD PRIMARY KEY (`ID_TIPO_RUTINA`);

--
-- Indices de la tabla `mg_usuario`
--
ALTER TABLE `mg_usuario`
  ADD PRIMARY KEY (`ID_USUARIO`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mg_cliente`
--
ALTER TABLE `mg_cliente`
  ADD CONSTRAINT `mg_cliente_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `mg_usuario` (`ID_USUARIO`);

--
-- Filtros para la tabla `mg_detalle_dieta_ingredientes`
--
ALTER TABLE `mg_detalle_dieta_ingredientes`
  ADD CONSTRAINT `mg_detalle_dieta_ingredientes_ibfk_1` FOREIGN KEY (`ID_DIETA`) REFERENCES `mg_dieta` (`ID_DIETA`);

--
-- Filtros para la tabla `mg_detalle_dieta_preparacion`
--
ALTER TABLE `mg_detalle_dieta_preparacion`
  ADD CONSTRAINT `mg_detalle_dieta_preparacion_ibfk_1` FOREIGN KEY (`ID_DIETA`) REFERENCES `mg_dieta` (`ID_DIETA`);

--
-- Filtros para la tabla `mg_detalle_dieta_semana`
--
ALTER TABLE `mg_detalle_dieta_semana`
  ADD CONSTRAINT `mg_detalle_dieta_semana_ibfk_1` FOREIGN KEY (`ID_DIETA`) REFERENCES `mg_dieta` (`ID_DIETA`);

--
-- Filtros para la tabla `mg_detalle_rutina_items`
--
ALTER TABLE `mg_detalle_rutina_items`
  ADD CONSTRAINT `mg_detalle_rutina_items_ibfk_1` FOREIGN KEY (`ID_RUTINA`) REFERENCES `mg_rutina` (`ID_RUTINA`);

--
-- Filtros para la tabla `mg_detalle_rutina_semana`
--
ALTER TABLE `mg_detalle_rutina_semana`
  ADD CONSTRAINT `mg_detalle_rutina_semana_ibfk_1` FOREIGN KEY (`ID_RUTINA`) REFERENCES `mg_rutina` (`ID_RUTINA`);

--
-- Filtros para la tabla `mg_dieta`
--
ALTER TABLE `mg_dieta`
  ADD CONSTRAINT `mg_dieta_ibfk_1` FOREIGN KEY (`ID_TIPO_DIETA`) REFERENCES `mg_tipo_dieta` (`ID_TIPO_DIETA`);

--
-- Filtros para la tabla `mg_programacion`
--
ALTER TABLE `mg_programacion`
  ADD CONSTRAINT `mg_programacion_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `mg_cliente` (`ID_CLIENTE`),
  ADD CONSTRAINT `mg_programacion_ibfk_2` FOREIGN KEY (`ID_DIETA`) REFERENCES `mg_dieta` (`ID_DIETA`),
  ADD CONSTRAINT `mg_programacion_ibfk_3` FOREIGN KEY (`ID_RUTINA`) REFERENCES `mg_rutina` (`ID_RUTINA`);

--
-- Filtros para la tabla `mg_rutina`
--
ALTER TABLE `mg_rutina`
  ADD CONSTRAINT `mg_rutina_ibfk_1` FOREIGN KEY (`ID_TIPO_RUTINA`) REFERENCES `mg_tipo_rutina` (`ID_TIPO_RUTINA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
