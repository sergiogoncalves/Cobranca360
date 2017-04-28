-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29-Abr-2017 às 00:19
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
-- Estrutura da tabela `cobrancatb01_titulo`
--

CREATE TABLE `cobrancatb01_titulo` (
  `codigo_titulo` int(11) NOT NULL,
  `contrato` varchar(255) DEFAULT NULL,
  `data_criacao` datetime DEFAULT NULL,
  `data_emissao` date DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `identificacao` varchar(255) DEFAULT NULL,
  `usuario_credor` int(11) DEFAULT NULL,
  `valor_titulo` decimal(19,2) DEFAULT NULL,
  `cobranca03_codigo_titulo_tipo` int(11) DEFAULT NULL,
  `credor` int(11) DEFAULT NULL,
  `devedor` int(11) DEFAULT NULL,
  `geraltb01_codigo_situacao` int(11) DEFAULT NULL,
  `numero_parcelas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb01_titulo`
--

INSERT INTO `cobrancatb01_titulo` (`codigo_titulo`, `contrato`, `data_criacao`, `data_emissao`, `data_vencimento`, `identificacao`, `usuario_credor`, `valor_titulo`, `cobranca03_codigo_titulo_tipo`, `credor`, `devedor`, `geraltb01_codigo_situacao`, `numero_parcelas`) VALUES
(4, '', NULL, '2016-12-01', '2016-12-01', '', 0, '2500.52', 1, 1, 2, 1, 0),
(5, '', '2016-12-01 18:42:30', NULL, '2016-12-20', '', 0, '3700.00', 1, 1, 2, 1, 0),
(6, '', '2016-12-01 18:51:25', NULL, '2016-12-06', '', 0, '4250.00', 1, 1, 2, 1, 0),
(7, '', '2016-12-01 18:53:32', NULL, '2016-12-12', '', 0, '175.00', 1, 1, 2, 1, 0),
(8, '', '2016-12-01 18:54:08', NULL, '2016-12-25', '', 0, '9000.00', 1, 2, 1, 1, 0),
(9, '123456', '2016-12-02 17:27:57', '2016-12-01', '2016-12-20', '654321', 0, '450.00', 2, 1, 2, 1, 1),
(10, '123', '2016-12-13 14:36:35', '2016-12-01', '2016-12-21', '654', 0, '1500.00', 1, 4, 2, 1, 1),
(11, NULL, '2016-12-29 17:46:02', '2016-12-29', NULL, NULL, 0, '3755.03', 1, 1, 2, 1, 3),
(12, NULL, '2016-12-29 18:21:02', '2016-12-29', NULL, NULL, 0, '165.53', 1, 1, 2, 1, 3),
(19, NULL, '2017-01-02 13:49:23', '2017-01-02', NULL, NULL, 0, '1655.31', 1, 1, 2, 1, 3),
(20, NULL, '2017-01-02 15:53:01', '2017-01-02', NULL, NULL, 0, '32.18', 1, 1, 2, 1, 2),
(21, NULL, '2017-01-05 18:36:44', '2017-01-05', NULL, NULL, 0, '429.05', 1, 1, 2, 1, 2),
(22, NULL, '2017-01-06 18:15:53', '2017-01-06', NULL, NULL, 0, '843.47', 1, 1, 2, 1, 5),
(23, NULL, '2017-01-06 18:19:42', '2017-01-06', NULL, NULL, 0, '6435.63', 1, 2, 1, 1, 1),
(24, NULL, '2017-01-06 18:24:32', '2017-01-06', NULL, NULL, 0, '30.39', 1, 1, 2, 1, 1),
(25, NULL, '2017-01-09 14:44:18', '2017-01-09', NULL, NULL, 0, '380.63', 1, 1, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb02_titulo_parcela`
--

CREATE TABLE `cobrancatb02_titulo_parcela` (
  `codigo_titulo_parcela` int(11) NOT NULL,
  `data_criacao` datetime DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `numero_parcela` int(11) DEFAULT NULL,
  `usuario` int(11) NOT NULL,
  `valor_desconto` decimal(19,2) DEFAULT NULL,
  `valor_honorario` decimal(19,2) DEFAULT NULL,
  `valor_juros` decimal(19,2) DEFAULT NULL,
  `valor_mora` decimal(19,2) DEFAULT NULL,
  `valor_multa` decimal(19,2) DEFAULT NULL,
  `valor_original` decimal(19,2) DEFAULT NULL,
  `valor_parcela` decimal(19,2) DEFAULT NULL,
  `valor_recebido` decimal(19,2) DEFAULT NULL,
  `valor_saldo` decimal(19,2) DEFAULT NULL,
  `cobrancatb01_titulo_codigo` int(11) DEFAULT NULL,
  `geraltb01_codigo_situacao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb02_titulo_parcela`
--

INSERT INTO `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`, `data_criacao`, `data_vencimento`, `numero_parcela`, `usuario`, `valor_desconto`, `valor_honorario`, `valor_juros`, `valor_mora`, `valor_multa`, `valor_original`, `valor_parcela`, `valor_recebido`, `valor_saldo`, `cobrancatb01_titulo_codigo`, `geraltb01_codigo_situacao`) VALUES
(1, NULL, '2016-12-01', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1300.00', NULL, NULL, 4, 3),
(2, NULL, '2016-12-02', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '125.50', NULL, NULL, 4, 3),
(3, NULL, '2016-12-15', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1450.76', NULL, NULL, 5, 3),
(4, NULL, '2016-12-01', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, '125.00', NULL, NULL, 6, 3),
(5, NULL, '2016-12-14', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, '5.02', NULL, NULL, 7, 3),
(6, NULL, '2016-12-15', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, '5000.00', NULL, NULL, 8, 3),
(10, NULL, '2016-12-01', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1250.00', NULL, NULL, 9, 3),
(11, NULL, '2016-12-13', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1500.00', NULL, NULL, 10, 1),
(12, NULL, '2016-12-30', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '250.00', NULL, NULL, NULL, NULL),
(13, NULL, '2017-01-10', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1168.35', NULL, NULL, NULL, NULL),
(14, NULL, '2017-02-10', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1168.35', NULL, NULL, NULL, NULL),
(15, NULL, '2017-03-10', 3, 0, NULL, NULL, NULL, NULL, NULL, NULL, '1168.35', NULL, NULL, NULL, NULL),
(16, NULL, '2016-12-30', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '25.00', NULL, NULL, 12, 3),
(17, NULL, '2017-01-10', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '46.85', NULL, NULL, 12, 1),
(18, NULL, '2017-02-10', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '46.85', NULL, NULL, 12, 1),
(19, NULL, '2017-03-10', 3, 0, NULL, NULL, NULL, NULL, NULL, NULL, '46.85', NULL, NULL, 12, 1),
(25, NULL, '2017-01-02', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '655.31', NULL, NULL, 19, 3),
(26, NULL, '2017-01-02', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '333.34', NULL, NULL, 19, 3),
(27, NULL, '2017-02-02', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '333.34', NULL, NULL, 19, 1),
(28, NULL, '2017-03-02', 3, 0, NULL, NULL, NULL, NULL, NULL, NULL, '333.34', NULL, NULL, 19, 1),
(29, NULL, '2017-01-02', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '5.00', NULL, NULL, 20, 3),
(30, NULL, '2017-01-05', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '13.59', NULL, NULL, 20, 3),
(31, NULL, '2017-02-05', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '13.59', NULL, NULL, 20, 1),
(32, NULL, '2017-01-25', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '300.00', NULL, NULL, 21, 1),
(33, NULL, '2017-01-28', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '64.53', NULL, NULL, 21, 1),
(34, NULL, '2017-02-28', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '64.53', NULL, NULL, 21, 1),
(35, NULL, '2017-01-06', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '300.00', NULL, NULL, 22, 3),
(36, NULL, '2017-01-07', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '108.70', NULL, NULL, 22, 1),
(37, NULL, '2017-02-07', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '108.70', NULL, NULL, 22, 1),
(38, NULL, '2017-03-07', 3, 0, NULL, NULL, NULL, NULL, NULL, NULL, '108.70', NULL, NULL, 22, 1),
(39, NULL, '2017-04-07', 4, 0, NULL, NULL, NULL, NULL, NULL, NULL, '108.70', NULL, NULL, 22, 1),
(40, NULL, '2017-05-07', 5, 0, NULL, NULL, NULL, NULL, NULL, NULL, '108.70', NULL, NULL, 22, 1),
(41, NULL, '2017-01-06', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '6000.00', NULL, NULL, 23, 1),
(42, NULL, '2017-01-08', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '435.63', NULL, NULL, 23, 1),
(43, NULL, '2017-01-06', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '25.00', NULL, NULL, 24, 1),
(44, NULL, '2017-01-22', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '5.39', NULL, NULL, 24, 1),
(45, NULL, '2017-01-01', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '200.00', NULL, NULL, 25, 1),
(46, NULL, '2017-01-31', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, '90.32', NULL, NULL, 25, 1),
(47, NULL, '2017-03-03', 2, 0, NULL, NULL, NULL, NULL, NULL, NULL, '90.32', NULL, NULL, 25, 1);

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb04_titulo_parcela_lancamento`
--

CREATE TABLE `cobrancatb04_titulo_parcela_lancamento` (
  `codigo_titulo_parcela_lancamento` int(11) NOT NULL,
  `caixa_lancamento` int(11) DEFAULT NULL,
  `data_lancamento` date DEFAULT NULL,
  `valor_desconto` decimal(19,2) DEFAULT NULL,
  `valor_juros` decimal(19,2) DEFAULT NULL,
  `valor_lancamento` decimal(19,2) DEFAULT NULL,
  `valor_multa` decimal(19,2) DEFAULT NULL,
  `cobrancatb02_codigo_titulo_parcela` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb05_titulo_parcela_cheque`
--

CREATE TABLE `cobrancatb05_titulo_parcela_cheque` (
  `codigo_titulo_parcela_cheque` int(11) NOT NULL,
  `agencia` varchar(255) DEFAULT NULL,
  `alinea` varchar(255) DEFAULT NULL,
  `banco` varchar(255) DEFAULT NULL,
  `compensacao` varchar(255) DEFAULT NULL,
  `conta` varchar(255) DEFAULT NULL,
  `data_reimplante` varchar(255) DEFAULT NULL,
  `data_restauracao` date DEFAULT NULL,
  `digito` varchar(255) DEFAULT NULL,
  `numero_cheque` varchar(255) DEFAULT NULL,
  `razao` varchar(255) DEFAULT NULL,
  `tipificacao` varchar(255) DEFAULT NULL,
  `tipo_ocorrencia` varchar(255) DEFAULT NULL,
  `cobrancatb02_codigo_titulo_parcela` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb05_titulo_parcela_cheque`
--

INSERT INTO `cobrancatb05_titulo_parcela_cheque` (`codigo_titulo_parcela_cheque`, `agencia`, `alinea`, `banco`, `compensacao`, `conta`, `data_reimplante`, `data_restauracao`, `digito`, `numero_cheque`, `razao`, `tipificacao`, `tipo_ocorrencia`, `cobrancatb02_codigo_titulo_parcela`) VALUES
(2, 'teste', NULL, 'treste', NULL, 'teste', NULL, NULL, NULL, 'teste', NULL, NULL, NULL, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb06_titulo_observacao_financeira`
--

CREATE TABLE `cobrancatb06_titulo_observacao_financeira` (
  `codigo_titulo_observacao_financeira` int(11) NOT NULL,
  `cobrancatb01_codigo_titulo` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `data_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_reagendamento` date DEFAULT NULL,
  `observacao` text,
  `resultado_cobranca` int(11) DEFAULT NULL,
  `fila_devedores` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb07_atendimento`
--

CREATE TABLE `cobrancatb07_atendimento` (
  `codigo_atendimento` int(11) NOT NULL,
  `cobrancatb10_codigo_atendimento_situacao` int(11) NOT NULL,
  `segurancatb01_codigo_usuario` int(11) NOT NULL,
  `data_atendimento` datetime NOT NULL,
  `credor` int(11) NOT NULL,
  `devedor` int(11) NOT NULL,
  `data_retorno` datetime DEFAULT NULL,
  `observacao` text,
  `retorno_efetuado` bit(1) DEFAULT NULL,
  `data_retorno_efetuado` datetime DEFAULT NULL,
  `filatb01_codigo_fila` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb07_atendimento`
--

INSERT INTO `cobrancatb07_atendimento` (`codigo_atendimento`, `cobrancatb10_codigo_atendimento_situacao`, `segurancatb01_codigo_usuario`, `data_atendimento`, `credor`, `devedor`, `data_retorno`, `observacao`, `retorno_efetuado`, `data_retorno_efetuado`, `filatb01_codigo_fila`) VALUES
(6, 4, 1, '2017-01-03 17:45:53', 1, 2, '2017-01-25 00:00:00', 'Testando', b'0', NULL, NULL),
(7, 4, 1, '2017-01-04 15:37:32', 1, 2, '2017-01-28 00:00:00', 'Atendimento Finalizado', b'0', NULL, NULL),
(8, 4, 1, '2017-01-04 15:50:55', 1, 2, '2017-01-26 00:00:00', 'Voltar e chingar o camarada', b'0', NULL, NULL),
(9, 6, 1, '2017-01-04 16:04:00', 1, 2, NULL, NULL, b'0', NULL, NULL),
(10, 6, 1, '2017-01-05 15:28:20', 1, 2, NULL, NULL, b'0', NULL, NULL),
(11, 4, 1, '2017-01-05 16:37:46', 2, 1, '2017-01-31 00:00:00', 'teste mais que perfeito', b'0', NULL, NULL),
(12, 6, 1, '2017-01-05 16:43:19', 1, 2, NULL, NULL, b'0', NULL, NULL),
(13, 4, 1, '2017-01-05 17:45:43', 1, 2, '2017-01-26 00:00:00', 'reiniciar este atendimento bem massa', b'0', NULL, NULL),
(14, 4, 1, '2017-01-05 17:58:54', 4, 2, '2017-01-05 00:00:00', 'Novo e novo atendimento', b'0', NULL, NULL),
(15, 6, 1, '2017-01-05 18:30:35', 1, 2, NULL, NULL, b'0', NULL, NULL),
(16, 6, 1, '2017-01-05 18:35:55', 1, 2, NULL, NULL, b'0', NULL, NULL),
(17, 4, 1, '2017-01-06 16:17:50', 1, 2, '2017-01-28 00:00:00', 'hahahahahahaha', b'0', NULL, NULL),
(18, 4, 1, '2017-01-06 16:29:53', 1, 2, '2017-01-06 00:00:00', '123', b'0', NULL, NULL),
(19, 4, 1, '2017-01-06 16:32:32', 1, 2, '2017-01-27 00:00:00', 'testanto novo teste', b'0', NULL, NULL),
(20, 4, 1, '2017-01-06 16:38:03', 1, 2, '2017-05-31 00:00:00', 'novoteste 31', b'0', NULL, NULL),
(21, 4, 1, '2017-01-06 16:41:59', 1, 2, '2017-06-30 00:00:00', 'Junho', b'0', NULL, NULL),
(22, 4, 1, '2017-01-06 16:48:26', 1, 2, '2017-01-14 00:00:00', 'kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk', b'0', NULL, NULL),
(23, 4, 1, '2017-01-06 16:50:37', 1, 2, '2017-01-10 00:00:00', '123', b'0', NULL, NULL),
(24, 4, 1, '2017-01-06 16:55:02', 1, 2, '2017-01-06 00:00:00', '123', b'0', NULL, NULL),
(25, 4, 1, '2017-01-06 16:58:09', 1, 2, '2017-01-15 00:00:00', '123456', b'0', NULL, NULL),
(26, 4, 1, '2017-01-06 17:02:42', 2, 1, '2017-01-28 00:00:00', '12345678945465', b'0', NULL, NULL),
(27, 4, 1, '2017-01-06 18:15:30', 1, 2, NULL, NULL, b'0', NULL, NULL),
(28, 4, 1, '2017-01-06 18:19:16', 2, 1, NULL, NULL, b'0', NULL, NULL),
(29, 4, 1, '2017-01-06 18:23:11', 1, 2, NULL, NULL, b'0', NULL, NULL),
(30, 4, 1, '2017-01-09 14:43:05', 1, 2, NULL, NULL, NULL, NULL, NULL),
(31, 4, 1, '2017-01-18 14:14:12', 4, 2, '2017-01-19 00:00:00', '', NULL, NULL, NULL),
(32, 6, 1, '2017-01-23 15:18:34', 1, 2, NULL, NULL, NULL, NULL, NULL),
(33, 6, 1, '2017-01-23 15:21:51', 1, 2, NULL, NULL, NULL, NULL, NULL),
(34, 1, 1, '2017-03-28 18:47:18', 2, 1, NULL, NULL, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb08_atendimento_titulo_parcela`
--

CREATE TABLE `cobrancatb08_atendimento_titulo_parcela` (
  `codigo_atendimento_titulo_parcela` int(11) NOT NULL,
  `cobrancatb02_codigo_titulo_parcela` int(11) NOT NULL,
  `cobrancatb07_codigo_atendimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb09_atendimento_andamento`
--

CREATE TABLE `cobrancatb09_atendimento_andamento` (
  `codigo_atendimento_andamento` int(11) NOT NULL,
  `cobrancatb10_codigo_atendimento_situacao` int(11) NOT NULL,
  `cobrancatb07_codigo_atendimento` int(11) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb09_atendimento_andamento`
--

INSERT INTO `cobrancatb09_atendimento_andamento` (`codigo_atendimento_andamento`, `cobrancatb10_codigo_atendimento_situacao`, `cobrancatb07_codigo_atendimento`, `data_inicio`, `data_fim`) VALUES
(1, 1, 6, '2017-01-03 17:45:53', '2017-01-04 15:16:51'),
(2, 1, 7, '2017-01-04 15:37:32', NULL),
(3, 1, 7, '2017-01-04 15:37:32', '2017-01-04 15:38:04'),
(4, 1, 8, '2017-01-04 15:50:55', NULL),
(5, 1, 8, '2017-01-04 15:50:55', '2017-01-04 15:51:58'),
(6, 1, 9, '2017-01-04 16:00:26', NULL),
(7, 1, 9, '2017-01-04 16:04:00', NULL),
(8, 1, 10, '2017-01-05 15:28:20', NULL),
(9, 1, 11, '2017-01-05 16:37:46', NULL),
(10, 1, 11, '2017-01-05 16:37:46', '2017-01-05 16:38:19'),
(12, 1, 12, '2017-01-05 16:43:19', '2017-01-05 16:45:32'),
(13, 2, 12, '2017-01-05 16:45:32', '2017-01-05 17:35:36'),
(14, 1, 12, '2017-01-05 17:35:36', NULL),
(15, 1, 13, '2017-01-05 17:45:43', NULL),
(16, 1, 13, '2017-01-05 17:45:43', '2017-01-05 17:46:18'),
(17, 2, 13, '2017-01-05 17:46:18', NULL),
(18, 1, 13, '2017-01-05 17:46:57', NULL),
(19, 1, 13, '2017-01-05 17:46:57', '2017-01-05 17:48:36'),
(21, 1, 14, '2017-01-05 17:58:54', '2017-01-05 18:00:07'),
(22, 2, 14, '2017-01-05 18:00:07', '2017-01-05 18:19:07'),
(24, 1, 14, '2017-01-05 18:15:58', NULL),
(25, 1, 14, '2017-01-05 18:15:58', '2017-01-05 18:18:59'),
(26, 2, 14, '2017-01-05 18:18:59', NULL),
(27, 1, 14, '2017-01-05 18:15:58', '2017-01-05 18:18:59'),
(28, 2, 14, '2017-01-05 18:18:59', '2017-01-05 18:19:07'),
(29, 1, 14, '2017-01-05 18:19:07', NULL),
(30, 1, 14, '2017-01-05 18:15:58', '2017-01-05 18:18:59'),
(31, 2, 14, '2017-01-05 18:18:59', '2017-01-05 18:19:07'),
(32, 1, 14, '2017-01-05 18:19:07', '2017-01-05 18:19:26'),
(34, 1, 16, '2017-01-05 18:35:55', NULL),
(35, 1, 17, '2017-01-06 16:17:50', NULL),
(36, 1, 17, '2017-01-06 16:17:50', '2017-01-06 16:18:10'),
(37, 2, 17, '2017-01-06 16:18:10', NULL),
(38, 1, 17, '2017-01-06 16:18:23', NULL),
(39, 1, 17, '2017-01-06 16:18:23', '2017-01-06 16:19:18'),
(40, 1, 18, '2017-01-06 16:29:53', NULL),
(41, 1, 18, '2017-01-06 16:29:53', '2017-01-06 16:30:33'),
(42, 1, 19, '2017-01-06 16:32:32', NULL),
(43, 1, 19, '2017-01-06 16:32:32', '2017-01-06 16:33:26'),
(44, 1, 20, '2017-01-06 16:38:03', NULL),
(45, 1, 20, '2017-01-06 16:38:03', '2017-01-06 16:38:51'),
(46, 1, 21, '2017-01-06 16:41:59', NULL),
(47, 1, 21, '2017-01-06 16:41:59', '2017-01-06 16:42:29'),
(48, 1, 22, '2017-01-06 16:48:26', NULL),
(49, 1, 22, '2017-01-06 16:48:26', '2017-01-06 16:49:00'),
(50, 1, 23, '2017-01-06 16:50:37', NULL),
(51, 1, 23, '2017-01-06 16:50:37', '2017-01-06 16:50:56'),
(52, 1, 24, '2017-01-06 16:55:02', NULL),
(53, 1, 24, '2017-01-06 16:55:02', '2017-01-06 16:55:23'),
(54, 1, 25, '2017-01-06 16:58:09', NULL),
(55, 1, 25, '2017-01-06 16:58:09', '2017-01-06 16:58:30'),
(56, 1, 26, '2017-01-06 17:02:42', NULL),
(57, 1, 26, '2017-01-06 17:02:42', '2017-01-06 17:02:48'),
(58, 2, 26, '2017-01-06 17:02:48', NULL),
(59, 1, 26, '2017-01-06 17:02:55', NULL),
(60, 1, 26, '2017-01-06 17:02:55', '2017-01-06 17:03:18'),
(61, 1, 27, '2017-01-06 18:15:30', NULL),
(62, 1, 27, '2017-01-06 18:15:30', '2017-01-06 18:15:54'),
(63, 1, 28, '2017-01-06 18:19:16', NULL),
(64, 1, 28, '2017-01-06 18:19:16', '2017-01-06 18:19:42'),
(65, 1, 29, '2017-01-06 18:23:11', NULL),
(66, 1, 29, '2017-01-06 18:23:11', '2017-01-06 18:24:32'),
(67, 1, 30, '2017-01-09 14:43:05', NULL),
(68, 1, 30, '2017-01-09 14:43:05', '2017-01-09 14:44:18'),
(69, 1, 31, '2017-01-18 14:14:12', NULL),
(70, 1, 31, '2017-01-18 14:14:12', '2017-01-18 14:14:58'),
(71, 1, 34, '2017-03-28 18:47:18', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cobrancatb10_atendimento_situacao`
--

CREATE TABLE `cobrancatb10_atendimento_situacao` (
  `codigo_atendimento_situacao` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `sigla` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `cobrancatb10_atendimento_situacao`
--

INSERT INTO `cobrancatb10_atendimento_situacao` (`codigo_atendimento_situacao`, `descricao`, `sigla`) VALUES
(1, 'Em atendimento', 'EA'),
(2, 'Atendimento Pausado', 'AP'),
(3, 'Retornar Atendimento', 'RA'),
(4, 'Atendimento Finalizado', 'AF'),
(5, 'Atendimento Retornado', 'AR'),
(6, 'Atendimento Invalidado', 'AI');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb01_empresa`
--

CREATE TABLE `empresatb01_empresa` (
  `codigo_empresa` int(11) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `inscricao_estadual` varchar(255) DEFAULT NULL,
  `nome_fantasia` varchar(255) DEFAULT NULL,
  `codigo_empresa_pai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb01_empresa`
--

INSERT INTO `empresatb01_empresa` (`codigo_empresa`, `cnpj`, `data_cadastro`, `inscricao_estadual`, `nome_fantasia`, `codigo_empresa_pai`) VALUES
(1, '12345678945232', NULL, '123456', 'Cobranca 360 LTDA', NULL),
(2, '13132132132132', NULL, '113', 'teste', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb02_pessoa`
--

CREATE TABLE `empresatb02_pessoa` (
  `pessoa_codigo` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo_pessoa` varchar(255) DEFAULT NULL,
  `empresatb01_codigo_empresa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb02_pessoa`
--

INSERT INTO `empresatb02_pessoa` (`pessoa_codigo`, `nome`, `tipo_pessoa`, `empresatb01_codigo_empresa`) VALUES
(1, 'Sergio Corrêa Gonçalves', 'F', 1),
(2, 'Cleciane Maximiano Tabile', 'F', 1),
(3, 'Antonio Ferreira Sobrinho', 'F', 1),
(4, 'Lêda Teixeira Corrêa Gonçalves', 'F', 1),
(5, 'ANA MARIA MACHADO DA SILVA', 'F', 1),
(6, 'Francisco gurgel', 'F', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb03_pessoa_fisica`
--

CREATE TABLE `empresatb03_pessoa_fisica` (
  `pessoa_fisica_codigo` int(11) NOT NULL,
  `cargo` int(11) NOT NULL,
  `certificado_militar` varchar(255) DEFAULT NULL,
  `clero` int(11) NOT NULL,
  `data_cadastro` date DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `doc_federal` varchar(255) DEFAULT NULL,
  `estado_civil` int(11) DEFAULT NULL,
  `etnia` smallint(6) NOT NULL,
  `flg_serasa` varchar(255) DEFAULT NULL,
  `nacionalidade` int(11) NOT NULL,
  `naturalidade` int(11) NOT NULL,
  `nome_conjuge` varchar(255) DEFAULT NULL,
  `nome_mae` varchar(255) DEFAULT NULL,
  `nome_pai` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `rg_data_emissao` varchar(255) DEFAULT NULL,
  `rg_orgao_emissor` varchar(255) DEFAULT NULL,
  `rg_uf` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `titulo_eleitor` varchar(255) DEFAULT NULL,
  `empresatb02_codigo_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb03_pessoa_fisica`
--

INSERT INTO `empresatb03_pessoa_fisica` (`pessoa_fisica_codigo`, `cargo`, `certificado_militar`, `clero`, `data_cadastro`, `data_nascimento`, `doc_federal`, `estado_civil`, `etnia`, `flg_serasa`, `nacionalidade`, `naturalidade`, `nome_conjuge`, `nome_mae`, `nome_pai`, `rg`, `rg_data_emissao`, `rg_orgao_emissor`, `rg_uf`, `sexo`, `titulo_eleitor`, `empresatb02_codigo_pessoa`) VALUES
(1, 0, NULL, 0, NULL, NULL, '00571243100', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 1),
(2, 0, NULL, 0, NULL, NULL, '87642492120', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 2),
(3, 0, NULL, 0, NULL, NULL, '65540387104', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 3),
(4, 0, NULL, 0, NULL, NULL, '41181077168', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 4),
(5, 0, NULL, 0, NULL, NULL, '77568893120', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 5),
(6, 0, NULL, 0, NULL, NULL, '01325552470', 0, 0, NULL, 0, 0, '', '', '', '', NULL, '', '', NULL, NULL, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb04_pessoa_juridica`
--

CREATE TABLE `empresatb04_pessoa_juridica` (
  `codigo_pessoa_juridica` int(11) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `flg_tipo` varchar(255) DEFAULT NULL,
  `inscricao_estadual` varchar(255) DEFAULT NULL,
  `inscricao_municipal` varchar(255) DEFAULT NULL,
  `nome_fantasia` varchar(255) DEFAULT NULL,
  `ramo_atividade` int(11) DEFAULT NULL,
  `empresatb02_codigo_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb05_pessoa_endereco`
--

CREATE TABLE `empresatb05_pessoa_endereco` (
  `codigo_pessoa_endereco` int(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `flg_principal` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `empresatb02_codigo_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb05_pessoa_endereco`
--

INSERT INTO `empresatb05_pessoa_endereco` (`codigo_pessoa_endereco`, `bairro`, `cep`, `cidade`, `complemento`, `endereco`, `estado`, `flg_principal`, `numero`, `empresatb02_codigo_pessoa`) VALUES
(1, '', '', '', '', 'adfasdfasdfa', '', 'true', '', 2),
(2, '', '', '', '', 'Teste 2', '', 'false', '', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb06_pessoa_contato`
--

CREATE TABLE `empresatb06_pessoa_contato` (
  `codigo_pessoa_contato` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `principal` bit(1) NOT NULL,
  `empresatb02_codigo_pessoa` int(11) DEFAULT NULL,
  `geraltb02_codigo_tipo_contato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb06_pessoa_contato`
--

INSERT INTO `empresatb06_pessoa_contato` (`codigo_pessoa_contato`, `descricao`, `principal`, `empresatb02_codigo_pessoa`, `geraltb02_codigo_tipo_contato`) VALUES
(1, '9-9919-7986', b'1', 2, 1),
(3, '65-9-9959-7986', b'1', 2, 1),
(4, 'cletabile@gmail.com', b'0', 2, 2),
(5, '12346', b'0', 3, 1),
(6, 'email', b'0', 3, 2),
(8, '92445787', b'1', 1, 1),
(9, 'serheu@gmail.com', b'1', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb07_usuario_cobra_pessoa`
--

CREATE TABLE `empresatb07_usuario_cobra_pessoa` (
  `codigo_usuario_cobra_pessoa` int(11) NOT NULL,
  `empresatb01_codigo_pessoa` int(11) DEFAULT NULL,
  `segurancatb01_codigo_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb08_pessoa_regra_renegociacao`
--

CREATE TABLE `empresatb08_pessoa_regra_renegociacao` (
  `codigo_pessoa_regra_renegociacao` int(11) NOT NULL,
  `empresatb02_codigo_pessoa` int(11) NOT NULL,
  `data_cadastro` date DEFAULT NULL,
  `menor_dia` int(11) DEFAULT NULL,
  `maior_dia` int(11) DEFAULT NULL,
  `juro` decimal(14,2) DEFAULT NULL,
  `multa` decimal(14,2) DEFAULT NULL,
  `desconto` decimal(14,2) DEFAULT NULL,
  `isencao_juros` decimal(14,2) DEFAULT NULL,
  `isencao_multa` decimal(14,2) DEFAULT NULL,
  `tipo_juros` char(1) DEFAULT NULL,
  `honorario` decimal(14,2) DEFAULT NULL,
  `ativo` char(1) DEFAULT NULL,
  `percentual_entrada` decimal(14,2) DEFAULT NULL,
  `valor_minimo_parcela` decimal(14,2) DEFAULT NULL,
  `mora` decimal(14,2) DEFAULT NULL,
  `minimo_parcelas` int(11) DEFAULT NULL,
  `maximo_parcelas` int(11) DEFAULT NULL,
  `descricao` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb09_empresa_regra_renegociacao`
--

CREATE TABLE `empresatb09_empresa_regra_renegociacao` (
  `codigo_pessoa_empresa_regra_renegociacao` int(11) NOT NULL,
  `empresatb01_codigo_empresa` int(11) NOT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `menor_dia` int(11) DEFAULT NULL,
  `maior_dia` int(11) DEFAULT NULL,
  `juro` decimal(14,2) DEFAULT NULL,
  `multa` decimal(14,2) DEFAULT NULL,
  `percentual_entrada` decimal(14,2) DEFAULT NULL,
  `mora` decimal(14,2) DEFAULT NULL,
  `minimo_parcelas` int(11) DEFAULT NULL,
  `maximo_parcelas` int(11) DEFAULT NULL,
  `valor_minimo_parcela` decimal(14,2) DEFAULT NULL,
  `tipo_juros` char(1) DEFAULT NULL,
  `honorarios` decimal(14,2) DEFAULT NULL,
  `ativo` bit(1) DEFAULT NULL,
  `desconto` decimal(14,2) DEFAULT NULL,
  `descricao` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `empresatb09_empresa_regra_renegociacao`
--

INSERT INTO `empresatb09_empresa_regra_renegociacao` (`codigo_pessoa_empresa_regra_renegociacao`, `empresatb01_codigo_empresa`, `data_cadastro`, `menor_dia`, `maior_dia`, `juro`, `multa`, `percentual_entrada`, `mora`, `minimo_parcelas`, `maximo_parcelas`, `valor_minimo_parcela`, `tipo_juros`, `honorarios`, `ativo`, `desconto`, `descricao`) VALUES
(17, 1, '2016-12-19 17:18:02', 0, 0, '1.00', '10.00', '1.00', '1.00', 1, 50, '5.00', NULL, '25.00', b'1', '1.00', '13213');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresatb10_pessoa_responsavel`
--

CREATE TABLE `empresatb10_pessoa_responsavel` (
  `codigo_pessoa_responsavel` int(11) NOT NULL,
  `empresatb02_pessoa_codigo` int(11) DEFAULT NULL,
  `empresatb02_pessoa_codigo_responsavel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filatb01_fila`
--

CREATE TABLE `filatb01_fila` (
  `codigo_fila` int(11) NOT NULL,
  `empresatb01_codigo_empresa` int(11) NOT NULL,
  `segurancatb01_codigo_usuario_criacao` int(11) NOT NULL,
  `descricao` text,
  `ativo` tinyint(1) DEFAULT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `data_criacao` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `filatb01_fila`
--

INSERT INTO `filatb01_fila` (`codigo_fila`, `empresatb01_codigo_empresa`, `segurancatb01_codigo_usuario_criacao`, `descricao`, `ativo`, `data_inicio`, `data_fim`, `data_criacao`) VALUES
(1, 1, 1, 'teste', 0, '2017-02-01 00:00:00', '2017-02-28 00:00:00', NULL),
(2, 1, 1, 'teste 02', 1, '2017-02-01 00:00:00', '2017-02-28 00:00:00', NULL),
(3, 1, 1, ' Teste 03', 1, '2017-02-02 00:00:00', '2017-02-28 00:00:00', NULL),
(6, 1, 1, 'Teste 03', 1, '2017-02-03 00:00:00', '2017-02-28 00:00:00', NULL),
(7, 1, 1, 'Teste 04', 1, '2017-02-01 00:00:00', '2017-03-31 00:00:00', '2017-02-03 18:15:45'),
(8, 1, 1, 'Teste 05', 1, '2017-02-06 00:00:00', '2017-02-28 00:00:00', '2017-02-06 15:18:46');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filatb02_fila_usuario`
--

CREATE TABLE `filatb02_fila_usuario` (
  `codigo_fila_usuario` int(11) NOT NULL,
  `filatb01_codigo_fila` int(11) NOT NULL,
  `segurancatb01_codigo_usuario` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `filatb02_fila_usuario`
--

INSERT INTO `filatb02_fila_usuario` (`codigo_fila_usuario`, `filatb01_codigo_fila`, `segurancatb01_codigo_usuario`, `ativo`) VALUES
(1, 2, 1, 1),
(2, 3, 1, 1),
(5, 6, 1, 1),
(6, 7, 1, 1),
(7, 8, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `filatb03_fila_devedor`
--

CREATE TABLE `filatb03_fila_devedor` (
  `codigo_fila_devedor` int(11) NOT NULL,
  `filatb01_codigo_fila` int(11) NOT NULL,
  `filatb04_codigo_fila_titulo_situacao` int(11) NOT NULL,
  `data_inicio_atendimento` datetime DEFAULT NULL,
  `data_fim_atendimento` datetime DEFAULT NULL,
  `empresatb02_pessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `filatb03_fila_devedor`
--

INSERT INTO `filatb03_fila_devedor` (`codigo_fila_devedor`, `filatb01_codigo_fila`, `filatb04_codigo_fila_titulo_situacao`, `data_inicio_atendimento`, `data_fim_atendimento`, `empresatb02_pessoa`) VALUES
(2, 6, 1, NULL, NULL, 2),
(3, 6, 1, NULL, NULL, 1),
(4, 7, 1, NULL, NULL, 2),
(5, 7, 1, NULL, NULL, 1),
(6, 8, 1, NULL, NULL, 2),
(7, 8, 1, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `filatb04_fila_titulo_situacao`
--

CREATE TABLE `filatb04_fila_titulo_situacao` (
  `codigo_fila_titulo_situacao` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `sigla` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `filatb04_fila_titulo_situacao`
--

INSERT INTO `filatb04_fila_titulo_situacao` (`codigo_fila_titulo_situacao`, `descricao`, `sigla`) VALUES
(1, 'Não Atendido', 'NA'),
(2, 'Em atendimento', 'EA'),
(3, 'Atendido', 'AT');

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `geraltb02_tipo_contato`
--

CREATE TABLE `geraltb02_tipo_contato` (
  `codigo_tipo_contato` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `geraltb02_tipo_contato`
--

INSERT INTO `geraltb02_tipo_contato` (`codigo_tipo_contato`, `descricao`) VALUES
(1, 'Celular'),
(2, 'Email');

-- --------------------------------------------------------

--
-- Estrutura da tabela `renegociacaotb01_renegociacao`
--

CREATE TABLE `renegociacaotb01_renegociacao` (
  `codigo_renegociacao` int(11) NOT NULL,
  `segurancatb01_codigo_usuario` int(11) NOT NULL,
  `numero_parcelas` int(11) DEFAULT NULL,
  `valor_renegociado` decimal(14,2) DEFAULT NULL,
  `valor_acordado` decimal(14,2) DEFAULT NULL,
  `observacao` text,
  `valor_honorario` decimal(14,2) DEFAULT NULL,
  `valor_multa` decimal(14,2) DEFAULT NULL,
  `valor_juros` decimal(14,2) DEFAULT NULL,
  `valor_desconto` decimal(14,2) DEFAULT NULL,
  `valor_mora` decimal(14,2) DEFAULT NULL,
  `data_renegociacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fila_devedores` int(11) DEFAULT NULL,
  `cobrancatb07_codigo_atendimento` int(11) NOT NULL,
  `credor` int(11) NOT NULL,
  `devedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `renegociacaotb01_renegociacao`
--

INSERT INTO `renegociacaotb01_renegociacao` (`codigo_renegociacao`, `segurancatb01_codigo_usuario`, `numero_parcelas`, `valor_renegociado`, `valor_acordado`, `observacao`, `valor_honorario`, `valor_multa`, `valor_juros`, `valor_desconto`, `valor_mora`, `data_renegociacao`, `fila_devedores`, `cobrancatb07_codigo_atendimento`, `credor`, `devedor`) VALUES
(1, 1, 2, '333.34', '429.05', NULL, '85.81', '3.33', '3.33', '0.10', '3.33', '2017-01-05 21:36:44', 0, 16, 1, 2),
(2, 1, 5, '655.31', '843.47', NULL, '168.69', '6.55', '6.55', '0.20', '6.55', '2017-01-06 21:15:53', 0, 27, 1, 2),
(3, 1, 1, '5000.00', '6435.63', NULL, '1287.13', '50.00', '50.00', '1.50', '50.00', '2017-01-06 21:19:42', 0, 28, 2, 1),
(4, 1, 1, '23.61', '30.39', NULL, '6.08', '0.24', '0.24', '0.01', '0.24', '2017-01-06 21:24:32', 0, 29, 1, 2),
(5, 1, 2, '300.00', '380.63', NULL, '76.13', '3.00', '3.00', '4.50', '3.00', '2017-01-09 17:44:18', 0, 30, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `renegociacaotb02_renegociacao_parcela`
--

CREATE TABLE `renegociacaotb02_renegociacao_parcela` (
  `codigo_renegociacao_parcela` int(11) NOT NULL,
  `cobrancatb02_codigo_titulo_parcela` int(11) NOT NULL,
  `renegociacaotb01_codigo_renegociacao` int(11) NOT NULL,
  `geraltb01_codigo_situacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `renegociacaotb02_renegociacao_parcela`
--

INSERT INTO `renegociacaotb02_renegociacao_parcela` (`codigo_renegociacao_parcela`, `cobrancatb02_codigo_titulo_parcela`, `renegociacaotb01_codigo_renegociacao`, `geraltb01_codigo_situacao`) VALUES
(1, 32, 1, 1),
(2, 33, 1, 1),
(3, 34, 1, 1),
(4, 35, 2, 1),
(5, 36, 2, 1),
(6, 37, 2, 1),
(7, 38, 2, 1),
(8, 39, 2, 1),
(9, 40, 2, 1),
(10, 41, 3, 1),
(11, 42, 3, 1),
(12, 43, 4, 1),
(13, 44, 4, 1),
(14, 45, 5, 1),
(15, 46, 5, 1),
(16, 47, 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `renegociacaotb03_parcela_renegociada`
--

CREATE TABLE `renegociacaotb03_parcela_renegociada` (
  `codigo_parcela_renegociada` int(11) NOT NULL,
  `renegociacaotb01_codigo_renegociacao` int(11) NOT NULL,
  `cobrancatb02_codigo_titulo_parcela` int(11) NOT NULL,
  `geraltb01_codigo_situacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `renegociacaotb03_parcela_renegociada`
--

INSERT INTO `renegociacaotb03_parcela_renegociada` (`codigo_parcela_renegociada`, `renegociacaotb01_codigo_renegociacao`, `cobrancatb02_codigo_titulo_parcela`, `geraltb01_codigo_situacao`) VALUES
(1, 1, 26, 3),
(2, 2, 25, 3),
(3, 3, 6, 3),
(4, 4, 5, 3),
(5, 4, 29, 3),
(6, 4, 30, 3),
(7, 5, 35, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb01_usuario`
--

CREATE TABLE `segurancatb01_usuario` (
  `codigo_usuario` int(11) NOT NULL,
  `data_fim` date DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome_usuario` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `empresatb02_codigo_pessoa` int(11) DEFAULT NULL,
  `situacao_ativo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `segurancatb01_usuario`
--

INSERT INTO `segurancatb01_usuario` (`codigo_usuario`, `data_fim`, `data_inclusao`, `data_inicio`, `login`, `nome_usuario`, `senha`, `empresatb02_codigo_pessoa`, `situacao_ativo`) VALUES
(1, '2017-09-30', '2016-12-06', '2016-12-01', 'sergio', 'Sergio Goncalves', '15975356', 1, 'true');

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb02_processo`
--

CREATE TABLE `segurancatb02_processo` (
  `codigo_processo` int(11) NOT NULL,
  `codigo_processo_pai` int(11) DEFAULT NULL,
  `nome_processo` varchar(30) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `icone` varchar(50) DEFAULT NULL,
  `url` varchar(250) DEFAULT NULL,
  `outcome` varchar(50) DEFAULT NULL,
  `flag_menu` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `segurancatb02_processo`
--

INSERT INTO `segurancatb02_processo` (`codigo_processo`, `codigo_processo_pai`, `nome_processo`, `descricao`, `icone`, `url`, `outcome`, `flag_menu`) VALUES
(1, NULL, 'empresa', 'Empresa', 'fa-bank', '/empresa/empresa-principal.xhtml', 'empresa', b'1'),
(2, NULL, 'pessoa', 'Pessoa', 'fa-bolt', NULL, NULL, b'1'),
(3, 2, 'pessoaFisicaPrincipal', 'Pessoa Física', 'fa-male', '/pessoa/pessoa-fisica-principal.xhtml', NULL, b'1'),
(4, 2, 'pessoaJuridicaPrincipal', 'Pessoa Jurídica', 'fa-users', '/pessoa/pessoa-juridica-principal.xhtml', NULL, b'1'),
(5, NULL, 'tituloPrincipal', 'Título', 'fa-stack-exchange', '/titulo/titulo-principal.xhtml', NULL, b'1'),
(6, NULL, 'negociacaoPrincipal', 'Negociação', 'fa-money', NULL, NULL, b'1'),
(7, NULL, 'parametrosPrincipal', 'Parâmetros', 'fa-puzzle-piece', NULL, NULL, b'1'),
(8, NULL, 'segurancaPrincipal', 'Segurança', 'fa-user-secret', NULL, NULL, b'1'),
(9, 6, 'renegociar', 'Renegociar', 'fa-calculator', '/renegociacao/renegociacao-principal.xhtml', NULL, b'1'),
(10, 6, 'renegociacaoHistorico', 'Histórico', 'fa-clipboard', '/renegociacao/renegociacao-historico.xhtml', NULL, b'1'),
(11, 6, 'renegociacaoTempoReal', 'Tempo Real', 'fa-video-camera', '/renegociacao/renegociacao-tempo-real.xhtml', NULL, b'1'),
(12, 6, 'fila', 'Fila de Cobrança', 'fa-sort-numeric-asc', '/renegociacao/renegociacao-fila.xhtml', NULL, b'1'),
(13, 7, 'regrasRenegociacao', 'Regras de Negociação', 'fa-sliders', '/parametros/regras-renegociacao.xhtml', NULL, b'1'),
(14, 8, 'usuarioPrincipal', 'Usuário', 'fa-user-md', '/seguranca/usuario-principal.xhtml', NULL, b'1'),
(15, 8, 'usuarioProcesso', 'Processos', 'fa-chain', '/seguranca/usuario-processos.xhtml', NULL, b'1'),
(16, NULL, 'administrativoPrincipal', 'Administrativo', 'fa-suitcase', '', NULL, b'1'),
(17, 16, 'processosGeraisAdm', 'Processos Gerais', 'fa-cogs', '/administrativo/processos-gerais.xhtml', NULL, b'1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb03_perfil`
--

CREATE TABLE `segurancatb03_perfil` (
  `codigo_perfil` int(11) NOT NULL,
  `empresatb01_codigo_empresa` int(11) NOT NULL,
  `nome_perfil` varchar(100) NOT NULL,
  `flg_ativo` tinyint(1) DEFAULT NULL,
  `data_inclusao` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb04_perfil_processos`
--

CREATE TABLE `segurancatb04_perfil_processos` (
  `codigo_perfil_processo` int(11) NOT NULL,
  `segurancatb03_codigo_perfil` int(11) NOT NULL,
  `segurantatb08_codigo_proceso_empresa` int(11) NOT NULL,
  `flg_consulta` tinyint(1) DEFAULT NULL,
  `flg_imprimir` tinyint(1) DEFAULT NULL,
  `flg_incluir` tinyint(1) DEFAULT NULL,
  `flg_alterar` tinyint(1) DEFAULT NULL,
  `flg_excluir` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb05_perfil_usuario`
--

CREATE TABLE `segurancatb05_perfil_usuario` (
  `codigo_perfil_usuario` int(11) NOT NULL,
  `segurancatb03_codigo_perfil` int(11) NOT NULL,
  `segurancatb01_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb06_usuario_processo`
--

CREATE TABLE `segurancatb06_usuario_processo` (
  `codigo_usuario_processo` int(11) NOT NULL,
  `segurancatb01_codigo_usuario` int(11) NOT NULL,
  `segurancatb08_codigo_processo_empresa` int(11) DEFAULT NULL,
  `flg_consultar` tinyint(1) DEFAULT NULL,
  `flg_imprimir` tinyint(1) DEFAULT NULL,
  `flg_alterar` tinyint(1) DEFAULT NULL,
  `flg_excluir` tinyint(1) DEFAULT NULL,
  `flg_incluir` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `segurancatb06_usuario_processo`
--

INSERT INTO `segurancatb06_usuario_processo` (`codigo_usuario_processo`, `segurancatb01_codigo_usuario`, `segurancatb08_codigo_processo_empresa`, `flg_consultar`, `flg_imprimir`, `flg_alterar`, `flg_excluir`, `flg_incluir`) VALUES
(1, 1, 1, NULL, NULL, NULL, NULL, NULL),
(2, 1, 2, NULL, NULL, NULL, NULL, NULL),
(3, 1, 3, NULL, NULL, NULL, NULL, NULL),
(4, 1, 4, NULL, NULL, NULL, NULL, NULL),
(5, 1, 5, NULL, NULL, NULL, NULL, NULL),
(6, 1, 6, NULL, NULL, NULL, NULL, NULL),
(7, 1, 7, NULL, NULL, NULL, NULL, NULL),
(8, 1, 8, NULL, NULL, NULL, NULL, NULL),
(9, 1, 9, NULL, NULL, NULL, NULL, NULL),
(10, 1, 10, NULL, NULL, NULL, NULL, NULL),
(11, 1, 11, NULL, NULL, NULL, NULL, NULL),
(12, 1, 12, NULL, NULL, NULL, NULL, NULL),
(13, 1, 13, NULL, NULL, NULL, NULL, NULL),
(15, 1, 15, NULL, NULL, NULL, NULL, NULL),
(16, 1, 16, NULL, NULL, NULL, NULL, NULL),
(17, 1, 17, NULL, NULL, NULL, NULL, NULL),
(18, 1, 19, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb07_usuario_cobra_empresa`
--

CREATE TABLE `segurancatb07_usuario_cobra_empresa` (
  `codigo_usuario_cobra_empresa` int(11) NOT NULL,
  `empresatb01_codigo_empresa` int(11) NOT NULL,
  `segurancatb01_codigo_usuario` int(11) NOT NULL,
  `situacao_ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurancatb08_processo_empresa`
--

CREATE TABLE `segurancatb08_processo_empresa` (
  `codigo_proceso_empresa` int(11) NOT NULL,
  `empresatb01_codigo_empresa` int(11) NOT NULL,
  `segurancatb02_codigo_processo` int(11) NOT NULL,
  `flag_consultar` bit(1) DEFAULT NULL,
  `flag_imprimir` tinyint(1) DEFAULT NULL,
  `flag_alterar` tinyint(1) DEFAULT NULL,
  `flag_exclur` tinyint(1) DEFAULT NULL,
  `flag_incluir` tinyint(1) DEFAULT NULL,
  `bloqueio` tinyint(1) DEFAULT NULL,
  `mensagem_bloqueio` text
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Extraindo dados da tabela `segurancatb08_processo_empresa`
--

INSERT INTO `segurancatb08_processo_empresa` (`codigo_proceso_empresa`, `empresatb01_codigo_empresa`, `segurancatb02_codigo_processo`, `flag_consultar`, `flag_imprimir`, `flag_alterar`, `flag_exclur`, `flag_incluir`, `bloqueio`, `mensagem_bloqueio`) VALUES
(1, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 1, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 1, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 1, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 1, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 1, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 1, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 1, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 1, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 1, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 1, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, 1, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(15, 1, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(16, 1, 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(17, 1, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(18, 2, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(19, 1, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(20, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cobrancatb01_titulo`
--
ALTER TABLE `cobrancatb01_titulo`
  ADD PRIMARY KEY (`codigo_titulo`),
  ADD KEY `FKthp897pe3uom4frc3e3hln4bw` (`cobranca03_codigo_titulo_tipo`),
  ADD KEY `FKec7e5yuld85kbee2ykidx647g` (`credor`),
  ADD KEY `FKa9eljxypc2paw6bvcqkachlfk` (`devedor`),
  ADD KEY `FK70y6kn8dixqealgcweyd8lw44` (`geraltb01_codigo_situacao`);

--
-- Indexes for table `cobrancatb02_titulo_parcela`
--
ALTER TABLE `cobrancatb02_titulo_parcela`
  ADD PRIMARY KEY (`codigo_titulo_parcela`),
  ADD KEY `FKgnc7w5fkmqgkf34j6nb30q411` (`geraltb01_codigo_situacao`),
  ADD KEY `FK_COBRANCATB02_COBRANCATB01` (`cobrancatb01_titulo_codigo`);

--
-- Indexes for table `cobrancatb03_titulo_tipo`
--
ALTER TABLE `cobrancatb03_titulo_tipo`
  ADD PRIMARY KEY (`codigo_titulo_tipo`);

--
-- Indexes for table `cobrancatb04_titulo_parcela_lancamento`
--
ALTER TABLE `cobrancatb04_titulo_parcela_lancamento`
  ADD PRIMARY KEY (`codigo_titulo_parcela_lancamento`),
  ADD KEY `FKdc3hysfiau84hra7ggamb84eg` (`cobrancatb02_codigo_titulo_parcela`);

--
-- Indexes for table `cobrancatb05_titulo_parcela_cheque`
--
ALTER TABLE `cobrancatb05_titulo_parcela_cheque`
  ADD PRIMARY KEY (`codigo_titulo_parcela_cheque`),
  ADD KEY `FKcdyc2lcteuctmhvxhqyj1c8vu` (`cobrancatb02_codigo_titulo_parcela`);

--
-- Indexes for table `cobrancatb06_titulo_observacao_financeira`
--
ALTER TABLE `cobrancatb06_titulo_observacao_financeira`
  ADD PRIMARY KEY (`codigo_titulo_observacao_financeira`),
  ADD KEY `FK_COBRANCA06_COBRANCA01` (`cobrancatb01_codigo_titulo`);

--
-- Indexes for table `cobrancatb07_atendimento`
--
ALTER TABLE `cobrancatb07_atendimento`
  ADD PRIMARY KEY (`codigo_atendimento`),
  ADD KEY `FK_COBRANCATB07_COBRANCATB10` (`cobrancatb10_codigo_atendimento_situacao`),
  ADD KEY `FK_COBRANCATB07_EMPRESATB02_CREDOR` (`credor`),
  ADD KEY `FK_COBRANCATB07_EMPRESATB02_DEVEDOR` (`devedor`),
  ADD KEY `FK_COBRANCATB07_SEGURANCATB01` (`segurancatb01_codigo_usuario`),
  ADD KEY `fk_cobrancatb07_filatb01` (`filatb01_codigo_fila`);

--
-- Indexes for table `cobrancatb08_atendimento_titulo_parcela`
--
ALTER TABLE `cobrancatb08_atendimento_titulo_parcela`
  ADD PRIMARY KEY (`codigo_atendimento_titulo_parcela`),
  ADD KEY `FK_COBRANCATB08_COBRANCATB02` (`cobrancatb02_codigo_titulo_parcela`),
  ADD KEY `FK_COBRANCATB08_COBRANCATB07` (`cobrancatb07_codigo_atendimento`);

--
-- Indexes for table `cobrancatb09_atendimento_andamento`
--
ALTER TABLE `cobrancatb09_atendimento_andamento`
  ADD PRIMARY KEY (`codigo_atendimento_andamento`),
  ADD KEY `FK_COBRANCATB09_COBRANCATB07` (`cobrancatb07_codigo_atendimento`),
  ADD KEY `FK_COBRANCATB09_COBRANCATB10` (`cobrancatb10_codigo_atendimento_situacao`);

--
-- Indexes for table `cobrancatb10_atendimento_situacao`
--
ALTER TABLE `cobrancatb10_atendimento_situacao`
  ADD PRIMARY KEY (`codigo_atendimento_situacao`);

--
-- Indexes for table `empresatb01_empresa`
--
ALTER TABLE `empresatb01_empresa`
  ADD PRIMARY KEY (`codigo_empresa`),
  ADD KEY `FKpd7e7xc9sc9os57mp91aeivqh` (`codigo_empresa_pai`);

--
-- Indexes for table `empresatb02_pessoa`
--
ALTER TABLE `empresatb02_pessoa`
  ADD PRIMARY KEY (`pessoa_codigo`),
  ADD KEY `FKsfx82k9ay2gw3nsu6idjtvyu0` (`empresatb01_codigo_empresa`);

--
-- Indexes for table `empresatb03_pessoa_fisica`
--
ALTER TABLE `empresatb03_pessoa_fisica`
  ADD PRIMARY KEY (`pessoa_fisica_codigo`),
  ADD KEY `FKp04gl89838ltp1qwjjlxdfhn9` (`empresatb02_codigo_pessoa`);

--
-- Indexes for table `empresatb04_pessoa_juridica`
--
ALTER TABLE `empresatb04_pessoa_juridica`
  ADD PRIMARY KEY (`codigo_pessoa_juridica`),
  ADD KEY `FKpernuhmdy62yd2cpagaetdi6n` (`empresatb02_codigo_pessoa`);

--
-- Indexes for table `empresatb05_pessoa_endereco`
--
ALTER TABLE `empresatb05_pessoa_endereco`
  ADD PRIMARY KEY (`codigo_pessoa_endereco`),
  ADD KEY `FK4gkj4fect2o4657mbqyinfj2a` (`empresatb02_codigo_pessoa`);

--
-- Indexes for table `empresatb06_pessoa_contato`
--
ALTER TABLE `empresatb06_pessoa_contato`
  ADD PRIMARY KEY (`codigo_pessoa_contato`),
  ADD KEY `FKatwkmaq4y3csw0tuvp3avn7e4` (`empresatb02_codigo_pessoa`),
  ADD KEY `FKk4c4bgjkqlnbcu5b985thbx7n` (`geraltb02_codigo_tipo_contato`);

--
-- Indexes for table `empresatb07_usuario_cobra_pessoa`
--
ALTER TABLE `empresatb07_usuario_cobra_pessoa`
  ADD PRIMARY KEY (`codigo_usuario_cobra_pessoa`),
  ADD KEY `FKdi23t9t6mvl0jmj47us8orxcn` (`empresatb01_codigo_pessoa`),
  ADD KEY `FK2uky24c6ajwaaaygiarr60hce` (`segurancatb01_codigo_usuario`);

--
-- Indexes for table `empresatb08_pessoa_regra_renegociacao`
--
ALTER TABLE `empresatb08_pessoa_regra_renegociacao`
  ADD PRIMARY KEY (`codigo_pessoa_regra_renegociacao`);

--
-- Indexes for table `empresatb09_empresa_regra_renegociacao`
--
ALTER TABLE `empresatb09_empresa_regra_renegociacao`
  ADD PRIMARY KEY (`codigo_pessoa_empresa_regra_renegociacao`);

--
-- Indexes for table `empresatb10_pessoa_responsavel`
--
ALTER TABLE `empresatb10_pessoa_responsavel`
  ADD PRIMARY KEY (`codigo_pessoa_responsavel`),
  ADD KEY `FKesirs502p8ul7cp99cywqgwam` (`empresatb02_pessoa_codigo`),
  ADD KEY `FKb2kb72t29v4t6mco5tnetot4e` (`empresatb02_pessoa_codigo_responsavel`);

--
-- Indexes for table `filatb01_fila`
--
ALTER TABLE `filatb01_fila`
  ADD PRIMARY KEY (`codigo_fila`),
  ADD KEY `fk_filatb01_empresatb01` (`empresatb01_codigo_empresa`),
  ADD KEY `fk_filatb01_segurancatb01` (`segurancatb01_codigo_usuario_criacao`);

--
-- Indexes for table `filatb02_fila_usuario`
--
ALTER TABLE `filatb02_fila_usuario`
  ADD PRIMARY KEY (`codigo_fila_usuario`),
  ADD KEY `fk_fila02_fila01` (`filatb01_codigo_fila`),
  ADD KEY `fk_fila02_segurancatb01` (`segurancatb01_codigo_usuario`);

--
-- Indexes for table `filatb03_fila_devedor`
--
ALTER TABLE `filatb03_fila_devedor`
  ADD PRIMARY KEY (`codigo_fila_devedor`),
  ADD KEY `FK_FILATB03_FILATB01` (`filatb01_codigo_fila`),
  ADD KEY `FK_FILATB03_FILATB04` (`filatb04_codigo_fila_titulo_situacao`);

--
-- Indexes for table `filatb04_fila_titulo_situacao`
--
ALTER TABLE `filatb04_fila_titulo_situacao`
  ADD PRIMARY KEY (`codigo_fila_titulo_situacao`);

--
-- Indexes for table `geraltb01_situacao_financeira`
--
ALTER TABLE `geraltb01_situacao_financeira`
  ADD PRIMARY KEY (`codigo_situacao`);

--
-- Indexes for table `geraltb02_tipo_contato`
--
ALTER TABLE `geraltb02_tipo_contato`
  ADD PRIMARY KEY (`codigo_tipo_contato`);

--
-- Indexes for table `renegociacaotb01_renegociacao`
--
ALTER TABLE `renegociacaotb01_renegociacao`
  ADD PRIMARY KEY (`codigo_renegociacao`),
  ADD KEY `FK_RENEGOCIACAOTB01_COBRANCATB07` (`cobrancatb07_codigo_atendimento`),
  ADD KEY `FK_RENEGOCIACAOTB01_EMPRESATB02_CREDOR` (`credor`),
  ADD KEY `FK_RENEGOCIACAOTB01_EMPRESATB02_DEVEDOR` (`devedor`),
  ADD KEY `FK_RENEGOCIACAOTB01_SEGURANCATB01` (`segurancatb01_codigo_usuario`);

--
-- Indexes for table `renegociacaotb02_renegociacao_parcela`
--
ALTER TABLE `renegociacaotb02_renegociacao_parcela`
  ADD PRIMARY KEY (`codigo_renegociacao_parcela`),
  ADD KEY `FK_RENEGOCIACAO01_RENEGOCIACAO02` (`renegociacaotb01_codigo_renegociacao`),
  ADD KEY `FK_RENEGOCIACAO02_GERALTB01` (`geraltb01_codigo_situacao`),
  ADD KEY `FK_RENEGOCIACAOTB02_COBRANCATB02` (`cobrancatb02_codigo_titulo_parcela`);

--
-- Indexes for table `renegociacaotb03_parcela_renegociada`
--
ALTER TABLE `renegociacaotb03_parcela_renegociada`
  ADD PRIMARY KEY (`codigo_parcela_renegociada`),
  ADD KEY `FK_RENEGOCIACAO03_COBRANCA02` (`cobrancatb02_codigo_titulo_parcela`),
  ADD KEY `FK_RENEGOCIACAOTB03_GERALTB01` (`geraltb01_codigo_situacao`),
  ADD KEY `FK_RENEGOCIADA03_RENEGOCIADA01` (`renegociacaotb01_codigo_renegociacao`);

--
-- Indexes for table `segurancatb01_usuario`
--
ALTER TABLE `segurancatb01_usuario`
  ADD PRIMARY KEY (`codigo_usuario`),
  ADD KEY `fk_usuariotb01_empresatb02` (`empresatb02_codigo_pessoa`);

--
-- Indexes for table `segurancatb02_processo`
--
ALTER TABLE `segurancatb02_processo`
  ADD PRIMARY KEY (`codigo_processo`),
  ADD KEY `fk_segurancatb02_pai` (`codigo_processo_pai`);

--
-- Indexes for table `segurancatb03_perfil`
--
ALTER TABLE `segurancatb03_perfil`
  ADD PRIMARY KEY (`codigo_perfil`),
  ADD KEY `fk_segurancatb03_empresatb01` (`empresatb01_codigo_empresa`);

--
-- Indexes for table `segurancatb04_perfil_processos`
--
ALTER TABLE `segurancatb04_perfil_processos`
  ADD PRIMARY KEY (`codigo_perfil_processo`),
  ADD KEY `fk_segurancatb04_segurancatb03` (`segurancatb03_codigo_perfil`),
  ADD KEY `fk_segurancatb04_segurancatb08` (`segurantatb08_codigo_proceso_empresa`);

--
-- Indexes for table `segurancatb05_perfil_usuario`
--
ALTER TABLE `segurancatb05_perfil_usuario`
  ADD PRIMARY KEY (`codigo_perfil_usuario`),
  ADD KEY `fk_segurancatb05_segurancatb01` (`segurancatb01_usuario`),
  ADD KEY `fk_segurantatb05_segurancatb03` (`segurancatb03_codigo_perfil`);

--
-- Indexes for table `segurancatb06_usuario_processo`
--
ALTER TABLE `segurancatb06_usuario_processo`
  ADD PRIMARY KEY (`codigo_usuario_processo`),
  ADD KEY `fk_segurancatb06_segurancatb01` (`segurancatb01_codigo_usuario`),
  ADD KEY `fk_segurancatb06_segurancatb08` (`segurancatb08_codigo_processo_empresa`);

--
-- Indexes for table `segurancatb07_usuario_cobra_empresa`
--
ALTER TABLE `segurancatb07_usuario_cobra_empresa`
  ADD PRIMARY KEY (`codigo_usuario_cobra_empresa`),
  ADD KEY `fk_segurancatb07_empresatb01` (`empresatb01_codigo_empresa`),
  ADD KEY `fk_segurancatb07_segurancatb01` (`segurancatb01_codigo_usuario`);

--
-- Indexes for table `segurancatb08_processo_empresa`
--
ALTER TABLE `segurancatb08_processo_empresa`
  ADD PRIMARY KEY (`codigo_proceso_empresa`),
  ADD KEY `fk_segurancatb08_empresatb01` (`empresatb01_codigo_empresa`),
  ADD KEY `fk_segurancatb08_segurancatb02` (`segurancatb02_codigo_processo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cobrancatb01_titulo`
--
ALTER TABLE `cobrancatb01_titulo`
  MODIFY `codigo_titulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `cobrancatb02_titulo_parcela`
--
ALTER TABLE `cobrancatb02_titulo_parcela`
  MODIFY `codigo_titulo_parcela` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `cobrancatb03_titulo_tipo`
--
ALTER TABLE `cobrancatb03_titulo_tipo`
  MODIFY `codigo_titulo_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `cobrancatb04_titulo_parcela_lancamento`
--
ALTER TABLE `cobrancatb04_titulo_parcela_lancamento`
  MODIFY `codigo_titulo_parcela_lancamento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cobrancatb05_titulo_parcela_cheque`
--
ALTER TABLE `cobrancatb05_titulo_parcela_cheque`
  MODIFY `codigo_titulo_parcela_cheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cobrancatb06_titulo_observacao_financeira`
--
ALTER TABLE `cobrancatb06_titulo_observacao_financeira`
  MODIFY `codigo_titulo_observacao_financeira` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cobrancatb07_atendimento`
--
ALTER TABLE `cobrancatb07_atendimento`
  MODIFY `codigo_atendimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `cobrancatb08_atendimento_titulo_parcela`
--
ALTER TABLE `cobrancatb08_atendimento_titulo_parcela`
  MODIFY `codigo_atendimento_titulo_parcela` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cobrancatb09_atendimento_andamento`
--
ALTER TABLE `cobrancatb09_atendimento_andamento`
  MODIFY `codigo_atendimento_andamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT for table `cobrancatb10_atendimento_situacao`
--
ALTER TABLE `cobrancatb10_atendimento_situacao`
  MODIFY `codigo_atendimento_situacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `empresatb01_empresa`
--
ALTER TABLE `empresatb01_empresa`
  MODIFY `codigo_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `empresatb02_pessoa`
--
ALTER TABLE `empresatb02_pessoa`
  MODIFY `pessoa_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `empresatb03_pessoa_fisica`
--
ALTER TABLE `empresatb03_pessoa_fisica`
  MODIFY `pessoa_fisica_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `empresatb04_pessoa_juridica`
--
ALTER TABLE `empresatb04_pessoa_juridica`
  MODIFY `codigo_pessoa_juridica` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `empresatb05_pessoa_endereco`
--
ALTER TABLE `empresatb05_pessoa_endereco`
  MODIFY `codigo_pessoa_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `empresatb06_pessoa_contato`
--
ALTER TABLE `empresatb06_pessoa_contato`
  MODIFY `codigo_pessoa_contato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `empresatb07_usuario_cobra_pessoa`
--
ALTER TABLE `empresatb07_usuario_cobra_pessoa`
  MODIFY `codigo_usuario_cobra_pessoa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `empresatb08_pessoa_regra_renegociacao`
--
ALTER TABLE `empresatb08_pessoa_regra_renegociacao`
  MODIFY `codigo_pessoa_regra_renegociacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `empresatb09_empresa_regra_renegociacao`
--
ALTER TABLE `empresatb09_empresa_regra_renegociacao`
  MODIFY `codigo_pessoa_empresa_regra_renegociacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `empresatb10_pessoa_responsavel`
--
ALTER TABLE `empresatb10_pessoa_responsavel`
  MODIFY `codigo_pessoa_responsavel` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `filatb01_fila`
--
ALTER TABLE `filatb01_fila`
  MODIFY `codigo_fila` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `filatb02_fila_usuario`
--
ALTER TABLE `filatb02_fila_usuario`
  MODIFY `codigo_fila_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `filatb03_fila_devedor`
--
ALTER TABLE `filatb03_fila_devedor`
  MODIFY `codigo_fila_devedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `filatb04_fila_titulo_situacao`
--
ALTER TABLE `filatb04_fila_titulo_situacao`
  MODIFY `codigo_fila_titulo_situacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `geraltb01_situacao_financeira`
--
ALTER TABLE `geraltb01_situacao_financeira`
  MODIFY `codigo_situacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `geraltb02_tipo_contato`
--
ALTER TABLE `geraltb02_tipo_contato`
  MODIFY `codigo_tipo_contato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `renegociacaotb01_renegociacao`
--
ALTER TABLE `renegociacaotb01_renegociacao`
  MODIFY `codigo_renegociacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `renegociacaotb02_renegociacao_parcela`
--
ALTER TABLE `renegociacaotb02_renegociacao_parcela`
  MODIFY `codigo_renegociacao_parcela` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `renegociacaotb03_parcela_renegociada`
--
ALTER TABLE `renegociacaotb03_parcela_renegociada`
  MODIFY `codigo_parcela_renegociada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `segurancatb01_usuario`
--
ALTER TABLE `segurancatb01_usuario`
  MODIFY `codigo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `segurancatb02_processo`
--
ALTER TABLE `segurancatb02_processo`
  MODIFY `codigo_processo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `segurancatb03_perfil`
--
ALTER TABLE `segurancatb03_perfil`
  MODIFY `codigo_perfil` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `segurancatb04_perfil_processos`
--
ALTER TABLE `segurancatb04_perfil_processos`
  MODIFY `codigo_perfil_processo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `segurancatb05_perfil_usuario`
--
ALTER TABLE `segurancatb05_perfil_usuario`
  MODIFY `codigo_perfil_usuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `segurancatb06_usuario_processo`
--
ALTER TABLE `segurancatb06_usuario_processo`
  MODIFY `codigo_usuario_processo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `segurancatb07_usuario_cobra_empresa`
--
ALTER TABLE `segurancatb07_usuario_cobra_empresa`
  MODIFY `codigo_usuario_cobra_empresa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `segurancatb08_processo_empresa`
--
ALTER TABLE `segurancatb08_processo_empresa`
  MODIFY `codigo_proceso_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cobrancatb01_titulo`
--
ALTER TABLE `cobrancatb01_titulo`
  ADD CONSTRAINT `FK70y6kn8dixqealgcweyd8lw44` FOREIGN KEY (`geraltb01_codigo_situacao`) REFERENCES `geraltb01_situacao_financeira` (`codigo_situacao`),
  ADD CONSTRAINT `FKa9eljxypc2paw6bvcqkachlfk` FOREIGN KEY (`devedor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FKec7e5yuld85kbee2ykidx647g` FOREIGN KEY (`credor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FKthp897pe3uom4frc3e3hln4bw` FOREIGN KEY (`cobranca03_codigo_titulo_tipo`) REFERENCES `cobrancatb03_titulo_tipo` (`codigo_titulo_tipo`);

--
-- Limitadores para a tabela `cobrancatb02_titulo_parcela`
--
ALTER TABLE `cobrancatb02_titulo_parcela`
  ADD CONSTRAINT `FK_COBRANCATB02_COBRANCATB01` FOREIGN KEY (`cobrancatb01_titulo_codigo`) REFERENCES `cobrancatb01_titulo` (`codigo_titulo`),
  ADD CONSTRAINT `FKgnc7w5fkmqgkf34j6nb30q411` FOREIGN KEY (`geraltb01_codigo_situacao`) REFERENCES `geraltb01_situacao_financeira` (`codigo_situacao`),
  ADD CONSTRAINT `FKihurb0ah04wme41h4x9tsagqe` FOREIGN KEY (`cobrancatb01_titulo_codigo`) REFERENCES `cobrancatb01_titulo` (`codigo_titulo`);

--
-- Limitadores para a tabela `cobrancatb04_titulo_parcela_lancamento`
--
ALTER TABLE `cobrancatb04_titulo_parcela_lancamento`
  ADD CONSTRAINT `FKdc3hysfiau84hra7ggamb84eg` FOREIGN KEY (`cobrancatb02_codigo_titulo_parcela`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`);

--
-- Limitadores para a tabela `cobrancatb05_titulo_parcela_cheque`
--
ALTER TABLE `cobrancatb05_titulo_parcela_cheque`
  ADD CONSTRAINT `FKcdyc2lcteuctmhvxhqyj1c8vu` FOREIGN KEY (`cobrancatb02_codigo_titulo_parcela`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`);

--
-- Limitadores para a tabela `cobrancatb06_titulo_observacao_financeira`
--
ALTER TABLE `cobrancatb06_titulo_observacao_financeira`
  ADD CONSTRAINT `FK_COBRANCA06_COBRANCA01` FOREIGN KEY (`cobrancatb01_codigo_titulo`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`);

--
-- Limitadores para a tabela `cobrancatb07_atendimento`
--
ALTER TABLE `cobrancatb07_atendimento`
  ADD CONSTRAINT `FK_COBRANCATB07_COBRANCATB10` FOREIGN KEY (`cobrancatb10_codigo_atendimento_situacao`) REFERENCES `cobrancatb10_atendimento_situacao` (`codigo_atendimento_situacao`),
  ADD CONSTRAINT `FK_COBRANCATB07_EMPRESATB02_CREDOR` FOREIGN KEY (`credor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FK_COBRANCATB07_EMPRESATB02_DEVEDOR` FOREIGN KEY (`devedor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FK_COBRANCATB07_SEGURANCATB01` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`),
  ADD CONSTRAINT `fk_cobrancatb07_filatb01` FOREIGN KEY (`filatb01_codigo_fila`) REFERENCES `filatb01_fila` (`codigo_fila`);

--
-- Limitadores para a tabela `cobrancatb08_atendimento_titulo_parcela`
--
ALTER TABLE `cobrancatb08_atendimento_titulo_parcela`
  ADD CONSTRAINT `FK_COBRANCATB08_COBRANCATB02` FOREIGN KEY (`cobrancatb02_codigo_titulo_parcela`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`),
  ADD CONSTRAINT `FK_COBRANCATB08_COBRANCATB07` FOREIGN KEY (`cobrancatb07_codigo_atendimento`) REFERENCES `cobrancatb07_atendimento` (`codigo_atendimento`);

--
-- Limitadores para a tabela `cobrancatb09_atendimento_andamento`
--
ALTER TABLE `cobrancatb09_atendimento_andamento`
  ADD CONSTRAINT `FK_COBRANCATB09_COBRANCATB07` FOREIGN KEY (`cobrancatb07_codigo_atendimento`) REFERENCES `cobrancatb07_atendimento` (`codigo_atendimento`),
  ADD CONSTRAINT `FK_COBRANCATB09_COBRANCATB10` FOREIGN KEY (`cobrancatb10_codigo_atendimento_situacao`) REFERENCES `cobrancatb10_atendimento_situacao` (`codigo_atendimento_situacao`);

--
-- Limitadores para a tabela `empresatb01_empresa`
--
ALTER TABLE `empresatb01_empresa`
  ADD CONSTRAINT `FKpd7e7xc9sc9os57mp91aeivqh` FOREIGN KEY (`codigo_empresa_pai`) REFERENCES `empresatb01_empresa` (`codigo_empresa`);

--
-- Limitadores para a tabela `empresatb02_pessoa`
--
ALTER TABLE `empresatb02_pessoa`
  ADD CONSTRAINT `FKsfx82k9ay2gw3nsu6idjtvyu0` FOREIGN KEY (`empresatb01_codigo_empresa`) REFERENCES `empresatb01_empresa` (`codigo_empresa`);

--
-- Limitadores para a tabela `empresatb03_pessoa_fisica`
--
ALTER TABLE `empresatb03_pessoa_fisica`
  ADD CONSTRAINT `FKp04gl89838ltp1qwjjlxdfhn9` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `empresatb04_pessoa_juridica`
--
ALTER TABLE `empresatb04_pessoa_juridica`
  ADD CONSTRAINT `FKpernuhmdy62yd2cpagaetdi6n` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `empresatb05_pessoa_endereco`
--
ALTER TABLE `empresatb05_pessoa_endereco`
  ADD CONSTRAINT `FK4gkj4fect2o4657mbqyinfj2a` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `empresatb06_pessoa_contato`
--
ALTER TABLE `empresatb06_pessoa_contato`
  ADD CONSTRAINT `FKatwkmaq4y3csw0tuvp3avn7e4` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FKk4c4bgjkqlnbcu5b985thbx7n` FOREIGN KEY (`geraltb02_codigo_tipo_contato`) REFERENCES `geraltb02_tipo_contato` (`codigo_tipo_contato`);

--
-- Limitadores para a tabela `empresatb07_usuario_cobra_pessoa`
--
ALTER TABLE `empresatb07_usuario_cobra_pessoa`
  ADD CONSTRAINT `FK2uky24c6ajwaaaygiarr60hce` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`),
  ADD CONSTRAINT `FKdi23t9t6mvl0jmj47us8orxcn` FOREIGN KEY (`empresatb01_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `empresatb10_pessoa_responsavel`
--
ALTER TABLE `empresatb10_pessoa_responsavel`
  ADD CONSTRAINT `FKb2kb72t29v4t6mco5tnetot4e` FOREIGN KEY (`empresatb02_pessoa_codigo_responsavel`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FKesirs502p8ul7cp99cywqgwam` FOREIGN KEY (`empresatb02_pessoa_codigo`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `filatb01_fila`
--
ALTER TABLE `filatb01_fila`
  ADD CONSTRAINT `fk_filatb01_empresatb01` FOREIGN KEY (`empresatb01_codigo_empresa`) REFERENCES `empresatb01_empresa` (`codigo_empresa`),
  ADD CONSTRAINT `fk_filatb01_segurancatb01` FOREIGN KEY (`segurancatb01_codigo_usuario_criacao`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`);

--
-- Limitadores para a tabela `filatb02_fila_usuario`
--
ALTER TABLE `filatb02_fila_usuario`
  ADD CONSTRAINT `fk_fila02_fila01` FOREIGN KEY (`filatb01_codigo_fila`) REFERENCES `filatb01_fila` (`codigo_fila`),
  ADD CONSTRAINT `fk_fila02_segurancatb01` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`);

--
-- Limitadores para a tabela `filatb03_fila_devedor`
--
ALTER TABLE `filatb03_fila_devedor`
  ADD CONSTRAINT `FK_FILATB03_FILATB01` FOREIGN KEY (`filatb01_codigo_fila`) REFERENCES `filatb01_fila` (`codigo_fila`),
  ADD CONSTRAINT `FK_FILATB03_FILATB04` FOREIGN KEY (`filatb04_codigo_fila_titulo_situacao`) REFERENCES `filatb04_fila_titulo_situacao` (`codigo_fila_titulo_situacao`);

--
-- Limitadores para a tabela `renegociacaotb01_renegociacao`
--
ALTER TABLE `renegociacaotb01_renegociacao`
  ADD CONSTRAINT `FK_RENEGOCIACAOTB01_COBRANCATB07` FOREIGN KEY (`cobrancatb07_codigo_atendimento`) REFERENCES `cobrancatb07_atendimento` (`codigo_atendimento`),
  ADD CONSTRAINT `FK_RENEGOCIACAOTB01_EMPRESATB02_CREDOR` FOREIGN KEY (`credor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FK_RENEGOCIACAOTB01_EMPRESATB02_DEVEDOR` FOREIGN KEY (`devedor`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `FK_RENEGOCIACAOTB01_SEGURANCATB01` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`);

--
-- Limitadores para a tabela `renegociacaotb02_renegociacao_parcela`
--
ALTER TABLE `renegociacaotb02_renegociacao_parcela`
  ADD CONSTRAINT `FK_RENEGOCIACAO01_RENEGOCIACAO02` FOREIGN KEY (`renegociacaotb01_codigo_renegociacao`) REFERENCES `renegociacaotb01_renegociacao` (`codigo_renegociacao`),
  ADD CONSTRAINT `FK_RENEGOCIACAO02_GERALTB01` FOREIGN KEY (`geraltb01_codigo_situacao`) REFERENCES `geraltb01_situacao_financeira` (`codigo_situacao`),
  ADD CONSTRAINT `FK_RENEGOCIACAOTB02_COBRANCATB02` FOREIGN KEY (`cobrancatb02_codigo_titulo_parcela`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`);

--
-- Limitadores para a tabela `renegociacaotb03_parcela_renegociada`
--
ALTER TABLE `renegociacaotb03_parcela_renegociada`
  ADD CONSTRAINT `FK_RENEGOCIACAO03_COBRANCA02` FOREIGN KEY (`cobrancatb02_codigo_titulo_parcela`) REFERENCES `cobrancatb02_titulo_parcela` (`codigo_titulo_parcela`),
  ADD CONSTRAINT `FK_RENEGOCIACAOTB03_GERALTB01` FOREIGN KEY (`geraltb01_codigo_situacao`) REFERENCES `geraltb01_situacao_financeira` (`codigo_situacao`),
  ADD CONSTRAINT `FK_RENEGOCIADA03_RENEGOCIADA01` FOREIGN KEY (`renegociacaotb01_codigo_renegociacao`) REFERENCES `renegociacaotb01_renegociacao` (`codigo_renegociacao`);

--
-- Limitadores para a tabela `segurancatb01_usuario`
--
ALTER TABLE `segurancatb01_usuario`
  ADD CONSTRAINT `FK2k1gc3uudj6rlw2gkr5mf88ue` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`),
  ADD CONSTRAINT `fk_usuariotb01_empresatb02` FOREIGN KEY (`empresatb02_codigo_pessoa`) REFERENCES `empresatb02_pessoa` (`pessoa_codigo`);

--
-- Limitadores para a tabela `segurancatb02_processo`
--
ALTER TABLE `segurancatb02_processo`
  ADD CONSTRAINT `fk_segurancatb02_pai` FOREIGN KEY (`codigo_processo_pai`) REFERENCES `segurancatb02_processo` (`codigo_processo`);

--
-- Limitadores para a tabela `segurancatb03_perfil`
--
ALTER TABLE `segurancatb03_perfil`
  ADD CONSTRAINT `fk_segurancatb03_empresatb01` FOREIGN KEY (`empresatb01_codigo_empresa`) REFERENCES `empresatb01_empresa` (`codigo_empresa`);

--
-- Limitadores para a tabela `segurancatb04_perfil_processos`
--
ALTER TABLE `segurancatb04_perfil_processos`
  ADD CONSTRAINT `fk_segurancatb04_segurancatb03` FOREIGN KEY (`segurancatb03_codigo_perfil`) REFERENCES `segurancatb03_perfil` (`codigo_perfil`),
  ADD CONSTRAINT `fk_segurancatb04_segurancatb08` FOREIGN KEY (`segurantatb08_codigo_proceso_empresa`) REFERENCES `segurancatb08_processo_empresa` (`codigo_proceso_empresa`);

--
-- Limitadores para a tabela `segurancatb05_perfil_usuario`
--
ALTER TABLE `segurancatb05_perfil_usuario`
  ADD CONSTRAINT `fk_segurancatb05_segurancatb01` FOREIGN KEY (`segurancatb01_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`),
  ADD CONSTRAINT `fk_segurantatb05_segurancatb03` FOREIGN KEY (`segurancatb03_codigo_perfil`) REFERENCES `segurancatb03_perfil` (`codigo_perfil`);

--
-- Limitadores para a tabela `segurancatb06_usuario_processo`
--
ALTER TABLE `segurancatb06_usuario_processo`
  ADD CONSTRAINT `fk_segurancatb06_segurancatb01` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`),
  ADD CONSTRAINT `fk_segurancatb06_segurancatb08` FOREIGN KEY (`segurancatb08_codigo_processo_empresa`) REFERENCES `segurancatb08_processo_empresa` (`codigo_proceso_empresa`);

--
-- Limitadores para a tabela `segurancatb07_usuario_cobra_empresa`
--
ALTER TABLE `segurancatb07_usuario_cobra_empresa`
  ADD CONSTRAINT `fk_segurancatb07_empresatb01` FOREIGN KEY (`empresatb01_codigo_empresa`) REFERENCES `empresatb01_empresa` (`codigo_empresa`),
  ADD CONSTRAINT `fk_segurancatb07_segurancatb01` FOREIGN KEY (`segurancatb01_codigo_usuario`) REFERENCES `segurancatb01_usuario` (`codigo_usuario`);

--
-- Limitadores para a tabela `segurancatb08_processo_empresa`
--
ALTER TABLE `segurancatb08_processo_empresa`
  ADD CONSTRAINT `fk_segurancatb08_empresatb01` FOREIGN KEY (`empresatb01_codigo_empresa`) REFERENCES `empresatb01_empresa` (`codigo_empresa`),
  ADD CONSTRAINT `fk_segurancatb08_segurancatb02` FOREIGN KEY (`segurancatb02_codigo_processo`) REFERENCES `segurancatb02_processo` (`codigo_processo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
