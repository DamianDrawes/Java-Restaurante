-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 20:37:03
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectorestaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `numeroMesa` int(11) NOT NULL,
  `baja` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`idMesa`, `capacidad`, `estado`, `numeroMesa`, `baja`) VALUES
(2, 2, 0, 1, 1),
(3, 5, 0, 24, 1),
(4, 5, 0, 23, 1),
(5, 5, 0, 25, 1),
(6, 4, 1, 20, 0),
(8, 3, 1, 26, 1),
(9, 2, 1, 27, 1),
(11, 5, 1, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesero`
--

CREATE TABLE `mesero` (
  `idMesero` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesero`
--

INSERT INTO `mesero` (`idMesero`, `nombre`, `apellido`, `estado`, `dni`) VALUES
(1, 'esteban', 'messi', 1, 33666333),
(3, 'marcelo', 'tinelli', 1, 12345678),
(5, 'ezequiel', 'scheffer', 1, 99887766),
(6, 'damian', 'barrios', 1, 40944913),
(13, 'rodrigo', 'afortunado', 1, 11122278);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idMesero` int(11) NOT NULL,
  `estadoPago` tinyint(1) NOT NULL,
  `fechaPedido` date NOT NULL,
  `horaPedido` time NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idMesa`, `idMesero`, `estadoPago`, `fechaPedido`, `horaPedido`, `idProducto`, `cantidadProducto`, `estado`) VALUES
(1, 2, 1, 1, '2023-10-19', '10:00:00', 8, 3, 1),
(2, 2, 1, 1, '2023-10-27', '09:00:00', 15, 2, 1),
(3, 2, 1, 1, '2023-06-10', '10:00:00', 8, 7, 1),
(4, 4, 1, 0, '2023-10-16', '16:02:18', 15, 4, 1),
(5, 4, 1, 0, '2023-10-16', '16:02:19', 8, 1, 1),
(6, 8, 3, 0, '2023-10-19', '16:21:00', 8, 2, 1),
(7, 2, 1, 0, '2023-10-19', '11:45:00', 15, 5, 1),
(9, 3, 1, 0, '2023-10-30', '11:35:00', 15, 10, 0),
(10, 3, 1, 0, '2023-10-30', '11:35:00', 19, 2, 1),
(11, 4, 5, 1, '2023-10-30', '11:35:00', 15, 1, 1),
(12, 3, 1, 0, '2023-10-30', '11:58:00', 17, 1, 1),
(13, 3, 1, 0, '2023-10-30', '11:58:00', 19, 1, 1),
(14, 3, 1, 0, '2023-10-30', '11:58:00', 20, 1, 1),
(15, 4, 6, 1, '2023-10-30', '11:58:00', 28, 1, 1),
(16, 4, 6, 0, '2023-10-30', '11:58:00', 27, 1, 1),
(17, 4, 6, 0, '2023-10-30', '11:58:00', 26, 1, 1),
(18, 8, 6, 0, '2023-10-30', '11:58:00', 24, 1, 0),
(19, 8, 6, 0, '2023-10-30', '11:58:00', 23, 1, 0),
(20, 8, 6, 0, '2023-10-30', '11:58:00', 28, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `precio`, `stock`, `estado`, `codigo`, `nombreProducto`) VALUES
(8, 2, 20, 1, 1, 'Ñoquis'),
(15, 130, 20, 1, 2, 'Ravioles'),
(17, 1200, 19, 1, 3, 'muzzarella'),
(19, 1500, 17, 1, 4, 'napolitana'),
(20, 1600, 14, 1, 5, 'Lomo'),
(21, 1000, 18, 1, 6, 'hamburguesas'),
(23, 1000, 24, 1, 7, 'tacos'),
(24, 600, 39, 1, 8, 'coca cola'),
(26, 600, 39, 1, 9, 'Sprite'),
(27, 700, 39, 1, 10, 'Quilmez'),
(28, 800, 38, 1, 11, 'Corona'),
(29, 700, 30, 1, 12, 'Brahama'),
(30, 650, 30, 1, 13, 'H20'),
(31, 900, 30, 1, 14, 'Fernet');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`idMesa`),
  ADD UNIQUE KEY `numeroMesa` (`numeroMesa`);

--
-- Indices de la tabla `mesero`
--
ALTER TABLE `mesero`
  ADD PRIMARY KEY (`idMesero`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idMesa` (`idMesa`),
  ADD KEY `idMesero` (`idMesero`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `mesero`
--
ALTER TABLE `mesero`
  MODIFY `idMesero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idMesero`) REFERENCES `mesero` (`idMesero`),
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
