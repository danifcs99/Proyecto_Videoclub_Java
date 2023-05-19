-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2023 a las 17:21:44
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_videoclub`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquiler`
--

CREATE TABLE `alquiler` (
  `num_socio` int(11) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Director` varchar(50) NOT NULL,
  `Genero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `Titulo` varchar(25) NOT NULL,
  `Director` varchar(20) NOT NULL,
  `Genero` varchar(20) NOT NULL,
  `año` int(8) NOT NULL,
  `alquilada` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`Titulo`, `Director`, `Genero`, `año`, `alquilada`) VALUES
('gigante de hierro', 'ELBOTELLA', 'Terror', 1978, 0),
('DEAD', 'el', 'Acción', 2000, 0),
('Dead pool', 'el', 'Drama', 2001, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `num_socio` bigint(20) UNSIGNED NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`num_socio`, `Nombre`, `Apellido`, `Telefono`, `Email`) VALUES
(14, 'Daniel', 'Santaella', 654324567, 'daniel@gmail.com'),
(16, 'Jose', 'metralleta', 675115766, 'jose@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD UNIQUE KEY `num_socio` (`num_socio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `num_socio` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
