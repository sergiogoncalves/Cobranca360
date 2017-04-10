-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29-Dez-2016 às 22:42
-- Versão do servidor: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cobranca360`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb03_titulo_tipo`
--

CREATE TABLE `cobrancatb03_titulo_tipo` (
  `codigo_titulo_tipo` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb03_titulo_tipo`
--

INSERT INTO `cobrancatb03_titulo_tipo` (`codigo_titulo_tipo`, `descricao`, `sigla`) VALUES
(1, 'Normal', 'NM'),
(2, 'Cheque', 'CQ'),
(3, 'Dividendos', 'DV');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cobrancatb03_titulo_tipo`
--
ALTER TABLE `cobrancatb03_titulo_tipo`
  ADD PRIMARY KEY (`codigo_titulo_tipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cobrancatb03_titulo_tipo`
--
ALTER TABLE `cobrancatb03_titulo_tipo`
  MODIFY `codigo_titulo_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
