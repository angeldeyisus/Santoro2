-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2023 a las 05:10:19
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `ordenes` (
  `orden_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ordenes`
--

INSERT INTO `ordenes` (`orden_id`, `producto_id`, `usuario_id`, `cantidad`, `fecha`) VALUES
(25, 3, 1, 3, '2021-05-15'),
(26, 2, 1, 1, '2021-05-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `producto_id` int(11) NOT NULL,
  `nombre` varchar(450) NOT NULL,
  `categoria` varchar(450) NOT NULL,
  `precio` double NOT NULL,
  `img` varchar(450) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`producto_id`, `nombre`, `categoria`, `precio`, `img`, `stock`) VALUES
(1, 'Carne para Bistec', 'Res', 197.99, 'bistec.jpg', 50),
(2, 'Carne Molida', 'Res', 142.99, 'molida.jpg', 50),
(3, 'Chamorro de Res', 'Res', 124.99, 'chamorro.jpg', 50),
(4, 'Costilla de Res para Caldo', 'Res', 124.99, 'costillares.jpg', 50),
(5, 'Costilla de Res para Asar', 'Res', 129.99, 'costillaresasar.jpg', 50),
(6, 'Costilla de Puerco', 'Puerco', 164.99, 'costillapuerco.jpg', 50),
(7, 'Corazon de Res', 'Res', 104.99, 'corazon.jpg', 50),
(8, 'Higado de Res', 'Res', 67.99, 'higado.jpg', 50),
(9, 'Hueso de Res', 'Res', 39.99, 'huesores.jpg', 50),
(10, 'Hueso de Puerco', 'Puerco', 54.99, 'huesopuerco.jpg', 50),
(11, 'Menudo de Res', 'Res', 129.99, 'menudo.jpg', 50),
(12, 'Asado de Paleta', 'Puerco', 209.99, 'asado.jpg', 50),
(13, 'Diezmillo de Res', 'Res', 274.99, 'diezmillo.jpg', 50),
(14, 'Carne Adobada de Puerco', 'Puerco', 174.99, 'adobada.jpg', 50),
(15, 'Pechuga de Pollo', 'Pollo', 179.99, 'pechuga.jpg', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `pass` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario_id`, `nombre`, `email`, `pass`) VALUES
(1, 'juan', 'juan.acosta@potros.itson.edu.mx', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD PRIMARY KEY (`orden_id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`producto_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `orden_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `producto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
