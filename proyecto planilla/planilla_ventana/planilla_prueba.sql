-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-03-2019 a las 06:58:01
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `planilla_prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bancos`
--

CREATE TABLE IF NOT EXISTS `bancos` (
  `codigo_banco` int(11) NOT NULL,
  `nombre_banco` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cuenta_banco` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_banco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `bancos`
--

INSERT INTO `bancos` (`codigo_banco`, `nombre_banco`, `cuenta_banco`) VALUES
(21, 'banrural', 100023),
(32, 'Industrial', 21321809),
(79, 'G&T Continental', 39250840);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `codigo_concepto` int(11) NOT NULL,
  `nombre_concepto` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `efecto_concepto` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`codigo_concepto`, `nombre_concepto`, `efecto_concepto`) VALUES
(111, 'IGSS', 'resta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE IF NOT EXISTS `departamento` (
  `codigo_departamento` int(11) NOT NULL,
  `nombre_departamento` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo_departamento`, `nombre_departamento`) VALUES
(901, 'Ingenieria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `dpi` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_empleado` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sueldo_empleado` float DEFAULT NULL,
  `codigo_puesto1` int(11) NOT NULL,
  `codigo_departamento1` int(11) NOT NULL,
  PRIMARY KEY (`dpi`),
  KEY `fk_codigo_puesto` (`codigo_puesto1`),
  KEY `fk_codigo_departamento` (`codigo_departamento1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`dpi`, `nombre_empleado`, `sueldo_empleado`, `codigo_puesto1`, `codigo_departamento1`) VALUES
('1233333333', 'pedro', 700, 1, 901),
('2341', 'juan', 1222, 1, 901),
('234554463', 'Alejandra', 6000, 1, 901),
('321231', 'Gian', 100000, 1, 901),
('93389237', 'chepe', 100.1, 1, 901);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina_detalle`
--

CREATE TABLE IF NOT EXISTS `nomina_detalle` (
  `codigo_nomina1` int(11) NOT NULL,
  `dpi2` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_concepto1` int(11) NOT NULL,
  `valor_nomina_detalle` float DEFAULT NULL,
  PRIMARY KEY (`codigo_nomina1`,`dpi2`,`codigo_concepto1`),
  KEY `fk_dpi2` (`dpi2`),
  KEY `fk_codigo_concepto1` (`codigo_concepto1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `nomina_detalle`
--

INSERT INTO `nomina_detalle` (`codigo_nomina1`, `dpi2`, `codigo_concepto1`, `valor_nomina_detalle`) VALUES
(101, '93389237', 111, 7000.35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina_encabezado`
--

CREATE TABLE IF NOT EXISTS `nomina_encabezado` (
  `codigo_nomina` int(11) NOT NULL,
  `fecha_inicio_nomina` datetime DEFAULT NULL,
  `fecha_fin_nomina` datetime DEFAULT NULL,
  `total_nomina` double DEFAULT NULL,
  `codigo_banco1` int(11) NOT NULL,
  PRIMARY KEY (`codigo_nomina`),
  KEY `fk_codigo_banco1` (`codigo_banco1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `nomina_encabezado`
--

INSERT INTO `nomina_encabezado` (`codigo_nomina`, `fecha_inicio_nomina`, `fecha_fin_nomina`, `total_nomina`, `codigo_banco1`) VALUES
(101, '2010-01-01 00:00:00', '2015-12-12 00:00:00', 700, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE IF NOT EXISTS `puesto` (
  `codigo_puesto` int(11) NOT NULL,
  `nombre_puesto` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`codigo_puesto`, `nombre_puesto`) VALUES
(1, 'Jefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrar_usuario`
--

CREATE TABLE IF NOT EXISTS `registrar_usuario` (
  `codigo_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contraseña_usuario` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_usuario` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dpi1` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `fk_dpi1` (`dpi1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `registrar_usuario`
--

INSERT INTO `registrar_usuario` (`codigo_usuario`, `nombre_usuario`, `contraseña_usuario`, `estado_usuario`, `dpi1`) VALUES
(101, 'valeri0', 'valerio123', 't', '93389237');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `nomina_detalle`
--
ALTER TABLE `nomina_detalle`
  ADD CONSTRAINT `fk_codigo_nomina1` FOREIGN KEY (`codigo_nomina1`) REFERENCES `nomina_encabezado` (`codigo_nomina`),
  ADD CONSTRAINT `fk_dpi2` FOREIGN KEY (`dpi2`) REFERENCES `empleado` (`dpi`),
  ADD CONSTRAINT `fk_codigo_concepto1` FOREIGN KEY (`codigo_concepto1`) REFERENCES `concepto` (`codigo_concepto`);

--
-- Filtros para la tabla `nomina_encabezado`
--
ALTER TABLE `nomina_encabezado`
  ADD CONSTRAINT `fk_codigo_banco1` FOREIGN KEY (`codigo_banco1`) REFERENCES `bancos` (`codigo_banco`);

--
-- Filtros para la tabla `registrar_usuario`
--
ALTER TABLE `registrar_usuario`
  ADD CONSTRAINT `fk_dpi1` FOREIGN KEY (`dpi1`) REFERENCES `empleado` (`dpi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
