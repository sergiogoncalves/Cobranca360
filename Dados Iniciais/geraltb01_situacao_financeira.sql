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
-- Estrutura da tabela `geraltb01_situacao_financeira`
--

CREATE TABLE `geraltb01_situacao_financeira` (
  `codigo_situacao` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `geraltb01_situacao_financeira`
--

INSERT INTO `geraltb01_situacao_financeira` (`codigo_situacao`, `descricao`, `sigla`) VALUES
(1, 'Em Aberto', 'A'),
(2, 'Quitado', 'Q'),
(3, 'Renegociado', 'R');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `geraltb01_situacao_financeira`
--
ALTER TABLE `geraltb01_situacao_financeira`
  ADD PRIMARY KEY (`codigo_situacao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `geraltb01_situacao_financeira`
--
ALTER TABLE `geraltb01_situacao_financeira`
  MODIFY `codigo_situacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
