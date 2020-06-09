-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 09, 2020 at 02:26 PM
-- Server version: 5.7.30-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ekheti`
--

-- --------------------------------------------------------

--
-- Table structure for table `actualConditions`
--

CREATE TABLE `actualConditions` (
  `pH min` decimal(3,2) DEFAULT NULL,
  `pH max` decimal(3,2) DEFAULT NULL,
  `nitrogen min` decimal(5,2) DEFAULT NULL,
  `nitrogen max` decimal(5,2) DEFAULT NULL,
  `phosphorus min` decimal(4,2) DEFAULT NULL,
  `phosphorus max` decimal(4,2) DEFAULT NULL,
  `potasium min` int(3) DEFAULT NULL,
  `potasium max` int(3) DEFAULT NULL,
  `calcium min` decimal(4,2) DEFAULT NULL,
  `calcium max` decimal(4,2) DEFAULT NULL,
  `magnesium min` decimal(4,2) DEFAULT NULL,
  `magnesium max` decimal(4,2) DEFAULT NULL,
  `sulphur min` decimal(4,2) DEFAULT NULL,
  `sulphur max` decimal(4,2) DEFAULT NULL,
  `iron min` decimal(3,2) DEFAULT NULL,
  `iron max` decimal(3,2) DEFAULT NULL,
  `zinc min` decimal(3,2) DEFAULT NULL,
  `zinc max` decimal(3,2) DEFAULT NULL,
  `manganese min` decimal(3,2) DEFAULT NULL,
  `manganese max` decimal(3,2) DEFAULT NULL,
  `copper min` decimal(3,2) DEFAULT NULL,
  `copper max` decimal(3,2) DEFAULT NULL,
  `boron min` decimal(3,2) DEFAULT NULL,
  `boron max` decimal(3,2) DEFAULT NULL,
  `temperature min` int(2) DEFAULT NULL,
  `temperature max` int(2) DEFAULT NULL,
  `precipitation min` decimal(4,2) DEFAULT NULL,
  `precipitation max` decimal(4,2) DEFAULT NULL,
  `irrigation` varchar(4) DEFAULT NULL,
  `region` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actualConditions`
--

INSERT INTO `actualConditions` (`pH min`, `pH max`, `nitrogen min`, `nitrogen max`, `phosphorus min`, `phosphorus max`, `potasium min`, `potasium max`, `calcium min`, `calcium max`, `magnesium min`, `magnesium max`, `sulphur min`, `sulphur max`, `iron min`, `iron max`, `zinc min`, `zinc max`, `manganese min`, `manganese max`, `copper min`, `copper max`, `boron min`, `boron max`, `temperature min`, `temperature max`, `precipitation min`, `precipitation max`, `irrigation`, `region`) VALUES
('7.60', '7.60', '326.14', '326.14', '47.04', '47.04', 680, 680, '75.00', '75.00', '46.00', '46.00', '37.00', '37.00', '2.74', '2.74', '2.87', '2.87', '4.81', '4.81', '1.87', '1.87', '2.25', '2.25', 22, 32, '47.85', '47.85', 'yes', 'mohol'),
('7.96', '7.96', '175.62', '175.62', '38.51', '38.51', 616, 616, '35.00', '35.00', '23.00', '23.00', '15.62', '15.62', '3.23', '3.23', '0.45', '0.45', '5.03', '5.03', '2.38', '2.38', '1.26', '1.26', 22, 32, '47.85', '47.85', 'no', 'mohol'),
('7.88', '7.88', '225.79', '225.79', '31.36', '31.36', 952, 952, '65.90', '65.90', '37.20', '37.20', '36.15', '36.15', '2.70', '2.70', '1.48', '1.48', '2.20', '2.20', '2.77', '2.77', '2.07', '2.07', 20, 30, '49.65', '49.65', 'yes', 'pandharpur'),
('7.85', '7.85', '175.62', '175.62', '26.72', '26.72', 784, 784, '57.70', '57.70', '33.40', '33.40', '16.85', '16.85', '2.63', '2.63', '1.21', '1.21', '1.99', '1.99', '2.20', '2.20', '0.72', '0.72', 20, 30, '49.65', '49.65', 'no', 'pandharpur'),
('7.66', '7.66', '200.70', '200.70', '24.42', '24.42', 504, 504, '60.00', '60.00', '87.00', '87.00', '43.00', '43.00', '4.13', '4.13', '0.90', '0.90', '3.59', '3.59', '1.93', '1.93', '0.54', '0.54', 20, 30, '44.79', '44.79', 'yes', 'mangalwedha'),
('7.11', '7.11', '200.70', '200.70', '17.56', '17.56', 368, 368, '45.00', '45.00', '74.00', '74.00', '62.84', '62.84', '3.81', '3.81', '1.12', '1.12', '2.34', '2.34', '3.28', '3.28', '0.45', '0.45', 20, 30, '44.79', '44.79', 'no', 'mangalwedha'),
('8.18', '8.18', '200.70', '200.70', '27.10', '27.10', 504, 504, '80.35', '80.35', '73.00', '73.00', '41.07', '41.07', '3.64', '3.64', '0.90', '0.90', '3.10', '3.10', '3.27', '3.27', '0.99', '0.99', 20, 30, '53.85', '53.85', 'yes', 'akkalkot'),
('7.79', '7.79', '200.70', '200.70', '13.30', '13.30', 504, 504, '65.77', '65.77', '78.00', '78.00', '38.47', '38.47', '4.00', '4.00', '1.21', '1.21', '3.46', '3.46', '2.65', '2.65', '0.36', '0.36', 20, 30, '53.85', '53.85', 'no', 'akkalkot'),
('7.63', '7.63', '200.70', '200.70', '16.74', '16.74', 448, 448, '63.46', '63.46', '48.82', '48.82', '44.92', '44.92', '5.17', '5.17', '0.58', '0.58', '3.59', '3.59', '2.15', '2.15', '0.36', '0.36', 21, 31, '50.83', '50.83', 'yes', 'madha'),
('7.95', '7.95', '125.44', '125.44', '14.48', '14.48', 568, 568, '56.32', '56.32', '44.53', '44.53', '45.48', '45.48', '3.46', '3.46', '0.40', '0.40', '3.23', '3.23', '2.11', '2.11', '0.36', '0.36', 22, 32, '50.83', '50.83', 'no', 'madha'),
('7.87', '7.87', '225.79', '225.79', '25.46', '25.46', 752, 752, '65.36', '65.36', '48.46', '48.46', '45.23', '45.23', '3.84', '3.84', '0.81', '0.81', '3.73', '3.73', '3.65', '3.65', '0.36', '0.36', 20, 30, '54.20', '54.20', 'yes', 'south solapur'),
('7.81', '7.81', '200.70', '200.70', '21.97', '21.97', 696, 696, '55.26', '55.26', '37.60', '37.60', '47.92', '47.92', '3.02', '3.02', '0.76', '0.76', '2.74', '2.74', '2.83', '2.83', '0.36', '0.36', 20, 30, '54.20', '54.20', 'no', 'south solapur'),
('7.48', '7.48', '250.88', '250.88', '19.79', '19.79', 224, 224, '63.12', '63.12', '37.19', '37.19', '36.15', '36.15', '3.81', '3.81', '1.35', '1.35', '3.05', '3.05', '2.84', '2.84', '0.81', '0.81', 20, 30, '54.20', '54.20', 'yes', 'north solapur'),
('7.80', '7.80', '200.70', '200.70', '18.96', '18.96', 152, 152, '55.78', '55.78', '34.28', '34.28', '39.33', '39.33', '4.00', '4.00', '0.40', '0.40', '3.21', '3.21', '3.28', '3.28', '0.99', '0.99', 20, 30, '54.20', '54.20', 'no', ' north solapur'),
('7.17', '7.17', '225.79', '225.79', '23.07', '23.07', 336, 336, '63.56', '63.56', '42.61', '42.61', '49.54', '49.54', '4.31', '4.31', '0.58', '0.58', '3.20', '3.20', '3.22', '3.22', '0.72', '0.72', 20, 30, '36.90', '36.90', 'yes', 'katmala'),
('7.74', '7.74', '175.62', '175.62', '16.05', '16.05', 672, 672, '60.32', '60.32', '33.54', '33.54', '42.84', '42.84', '2.70', '2.70', '0.45', '0.45', '2.96', '2.96', '3.05', '3.05', '0.36', '0.36', 20, 30, '36.90', '36.90', 'no', 'katmala'),
('8.30', '8.30', '200.35', '200.35', '36.05', '36.05', 480, 480, '57.21', '57.21', '37.65', '37.65', '51.77', '51.77', '3.47', '3.47', '0.85', '0.85', '3.48', '3.48', '3.29', '3.29', '0.36', '0.36', 20, 30, '38.66', '38.66', 'yes', 'sangola'),
('7.79', '7.79', '275.97', '275.97', '42.34', '42.34', 448, 448, '51.70', '51.70', '31.52', '31.52', '48.54', '48.54', '2.07', '2.07', '1.30', '1.30', '2.77', '2.77', '2.80', '2.80', '1.17', '1.17', 20, 30, '38.66', '38.66', 'no', 'sangola'),
('7.60', '7.60', '150.53', '150.53', '55.96', '55.96', 728, 728, '45.56', '45.56', '36.46', '36.46', '44.69', '44.69', '2.70', '2.70', '0.49', '0.49', '2.16', '2.16', '3.50', '3.50', '0.63', '0.63', 21, 31, '60.18', '60.18', 'yes ', 'barshi'),
('7.75', '7.75', '175.62', '175.62', '58.02', '58.02', 448, 448, '35.36', '35.36', '31.83', '31.83', '22.46', '22.46', '3.82', '3.82', '0.54', '0.54', '2.43', '2.43', '3.01', '3.01', '0.45', '0.45', 22, 32, '38.66', '38.66', 'no', 'sangola'),
('8.00', '8.00', '150.53', '150.53', '70.64', '70.64', 616, 616, '48.62', '48.62', '49.21', '49.21', '48.08', '48.08', '2.68', '2.68', '1.62', '1.62', '2.61', '2.61', '1.59', '1.59', '0.54', '0.54', 20, 30, '46.56', '46.56', 'yes', 'malshiras'),
('7.90', '7.90', '175.62', '175.62', '66.46', '66.46', 584, 584, '41.60', '41.60', '34.86', '34.86', '39.84', '39.84', '1.89', '1.89', '1.61', '1.61', '2.00', '2.00', '1.05', '1.05', '1.35', '1.35', 24, 30, '46.56', '46.56', 'no', 'malshiras'),
('7.60', '7.60', '150.53', '150.53', '55.96', '55.96', 728, 728, '45.56', '45.56', '36.46', '36.46', '44.69', '44.69', '2.70', '2.70', '0.49', '0.49', '2.16', '2.16', '3.50', '3.50', '0.63', '0.63', 21, 31, '60.18', '60.18', 'no ', 'barshi');

-- --------------------------------------------------------

--
-- Table structure for table `healthCard`
--

CREATE TABLE `healthCard` (
  `healthID` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pHMin` varchar(50) NOT NULL,
  `pHMax` varchar(50) NOT NULL,
  `nitrogenMin` varchar(50) NOT NULL,
  `nitrogenMax` varchar(50) NOT NULL,
  `phosphorusMin` varchar(50) NOT NULL,
  `phosphorusMax` varchar(50) NOT NULL,
  `potassiumMin` varchar(50) NOT NULL,
  `potassiumMax` varchar(50) NOT NULL,
  `calciumMin` varchar(50) NOT NULL,
  `calciumMax` varchar(50) NOT NULL,
  `magnesiumMin` varchar(50) NOT NULL,
  `magnesiumMax` varchar(50) NOT NULL,
  `sulphurMin` varchar(50) NOT NULL,
  `sulphurMax` varchar(50) NOT NULL,
  `ironMin` varchar(50) NOT NULL,
  `ironMax` varchar(50) NOT NULL,
  `zincMin` varchar(50) NOT NULL,
  `zincMax` varchar(50) NOT NULL,
  `manganeseMin` varchar(50) NOT NULL,
  `manganeseMax` varchar(50) NOT NULL,
  `copperMin` varchar(50) NOT NULL,
  `copperMax` varchar(50) NOT NULL,
  `boronMin` varchar(50) NOT NULL,
  `boronMax` varchar(50) NOT NULL,
  `temperatureMin` varchar(50) NOT NULL,
  `temperatureMax` varchar(50) NOT NULL,
  `precipitationMin` varchar(50) NOT NULL,
  `precipitationMax` varchar(50) NOT NULL,
  `irrigation` varchar(20) NOT NULL,
  `region` varchar(25) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `healthCard`
--

INSERT INTO `healthCard` (`healthID`, `email`, `pHMin`, `pHMax`, `nitrogenMin`, `nitrogenMax`, `phosphorusMin`, `phosphorusMax`, `potassiumMin`, `potassiumMax`, `calciumMin`, `calciumMax`, `magnesiumMin`, `magnesiumMax`, `sulphurMin`, `sulphurMax`, `ironMin`, `ironMax`, `zincMin`, `zincMax`, `manganeseMin`, `manganeseMax`, `copperMin`, `copperMax`, `boronMin`, `boronMax`, `temperatureMin`, `temperatureMax`, `precipitationMin`, `precipitationMax`, `irrigation`, `region`, `date`) VALUES
('1234', 'alokrocks217@gmail.com', '6.5', '7.5', '191.', '191', '89', '89', '235', '235', '57', '57', '73', '73', '21', '21', '0.13', '0.13', '0.38', '0.38', '0.34', '0.34', '0.11', '0.11', '0', '0', '18', '27', '60', '100', 'yes', 'barshi', '2020-04-02 18:32:54'),
('5555', 'oilseeds@gmail.com', '5.5', '7.5', '50', '150', '18', '90', '30', '385', '20', '210', '13', '70', '5', '8', '0.29', '7.75', '0.28', '0.75', '0.09', '0.42', '0.03', '0.06', '0', '0', '25', '35', '20', '20', 'no', 'katmala', '2020-04-03 12:00:58'),
('797729', 'pakya@gmail.com', '5.5', '8.5', '80', '80', '40', '40', '45', '45', '22', '22', '17', '17', '22', '22', '2.5', '2.5', '0.21', '0.21', '0.17', '0.17', '0.3', '0.3', '0', '0', '26.4', '33.9', '0.8', '0.9', 'no', 'barshi', '2020-04-03 21:44:03'),
('9874', 'adish.pathare@gmail.com', '6', '8', '200', '200', '53', '53', '280', '280', '42', '42', '50', '50', '30', '30', '3.4', '3.4', '0.4', '0.4', '1.2', '1.2', '0.6', '0.6', '0.2', '0.2', '20', '26', '100', '175', 'yes', 'mohol', '2020-04-01 12:17:51');

-- --------------------------------------------------------

--
-- Table structure for table `markets`
--

CREATE TABLE `markets` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `market_lat` float(20,8) DEFAULT NULL,
  `market_long` float(20,8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `markets`
--

INSERT INTO `markets` (`id`, `name`, `market_lat`, `market_long`) VALUES
(1, 'Pune', 18.52039909, 73.85669708),
(2, 'Vashi Mandi', 19.08639908, 73.01000214),
(3, 'Panvel market', 18.98940086, 73.11750031),
(4, 'Badlapur MKT', 19.16679955, 73.23680115),
(5, 'Vidyavihar', 19.08108139, 72.88755035),
(6, 'Kurla Mandi', 19.08108139, 72.88755035),
(7, 'Kalyan', 19.24029922, 73.13050079),
(8, 'Bhivandi', 19.28129959, 73.04830170),
(9, 'Dadar MKT', 19.01779938, 72.84780121),
(10, 'Vasai', 19.39189911, 72.83969879),
(11, 'Goa National Market', 15.29930019, 74.12400055),
(12, 'Sewri Mandi', 19.00702858, 72.85132599),
(13, 'x', 19.22522545, 73.08483887),
(14, 'DB', 19.22522545, 73.08483887),
(15, 'z', 19.22522545, 73.08483887),
(16, '', 19.22522545, 73.08483887),
(17, 'DB', 19.22522545, 73.08483887),
(18, 'DB', 19.22522545, 73.08483887),
(19, 'DB', 19.22522545, 73.08483887);

-- --------------------------------------------------------

--
-- Table structure for table `market_crop_rel`
--

CREATE TABLE `market_crop_rel` (
  `id` int(11) NOT NULL,
  `market_id` int(11) DEFAULT NULL,
  `crop_name` varchar(100) DEFAULT NULL,
  `crop_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `market_crop_rel`
--

INSERT INTO `market_crop_rel` (`id`, `market_id`, `crop_name`, `crop_price`) VALUES
(1, 1, 'Rice', 1000),
(3, 2, 'Rice', 100),
(4, 2, 'Wheat', 50),
(5, 3, 'Wheat', 60),
(6, 4, 'Rice', 100),
(7, 5, 'Rice', 50),
(8, 6, 'Rice', 90),
(9, 7, 'Rice', 1001),
(10, 8, 'Rice', 1100),
(11, 9, 'Rice', 900),
(12, 10, 'Rice', 250),
(13, 11, 'Wheat', 110);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `region` varchar(25) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `irrigation` varchar(20) NOT NULL,
  `healthID` varchar(50) DEFAULT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `firstname`, `lastname`, `contact`, `region`, `password`, `irrigation`, `healthID`, `reg_date`) VALUES
('1@gmail.com', 'h', 'p', '100', 'mohol', '1', 'Yes', NULL, '2020-04-03 12:38:01'),
('ab@gmail.com', 'a', 'b', '1', 'barshi', '1', 'Yes', NULL, '2020-04-03 20:26:38'),
('adish.pathare@gmail.com', 'Adish', 'Pathare', '770041020', 'mohol', '1', 'Yes', '9874', '2020-04-01 12:17:51'),
('adish@gmail.com', 'Adish', 'Chaudhari', '8040', 'barshi', '1', 'no', NULL, '2020-04-03 22:06:27'),
('alokrocks217@gmail.com', 'Alok', 'Pandey', '8422047749', 'barshi', 'alok', 'yes', '1234', '2020-03-31 13:48:28'),
('alokrocks2@gmail.com', 'Rahul', 'Pandey', '08422047749', 'pandharpur', '1', 'Yes', NULL, '2020-04-02 18:29:41'),
('calden@gmail.com', 'Calden', 'Rg', '9876', 'malshiras', '1', 'yes', NULL, '2020-04-03 22:08:38'),
('grapes@gmail.com', 'Rakesh', 'Patil', '855', 'malshiras', '1', 'yes', NULL, '2020-04-03 22:04:46'),
('m@gmail.com', 'Mithilesh', 'Chaudhari', '5656', 'pandharpur', '1', 'yes', NULL, '2020-04-03 22:09:24'),
('mithi@gmail.com', 'mith', 'win', '84458635638', 'north solapur', '1', 'No', NULL, '2020-02-25 05:22:58'),
('mithilesh@gmail.com', 'mithi', 'Chaudhary', '8446830125', 'barshi', '1', 'yes', NULL, '2020-04-03 11:32:08'),
('oilseeds@gmail.com', 'Rajesh', 'Tope', '8456921395', 'katmala', '1', 'no', '5555', '2020-04-03 12:00:58'),
('pakya@gmail.com', 'P', 'K', '100', 'barshi', '1', 'No', '797729', '2020-04-03 21:44:03'),
('pandey@gmail.com', 'Alok', 'Pandey', '16090', 'pandharpur', '1', 'yes', NULL, '2020-04-03 22:07:12'),
('team3@gmail.com', 'Team', 'Leader', '8045736528', 'mohol', '12345678', 'Yes', NULL, '2020-04-03 20:32:00'),
('tope@gmail.com', 'Alok', 'Tope', '30212', 'barshi', '1', 'no', NULL, '2020-04-03 22:07:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `healthCard`
--
ALTER TABLE `healthCard`
  ADD PRIMARY KEY (`healthID`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `markets`
--
ALTER TABLE `markets`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `market_crop_rel`
--
ALTER TABLE `market_crop_rel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `market_id` (`market_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`),
  ADD KEY `healthID` (`healthID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `markets`
--
ALTER TABLE `markets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `market_crop_rel`
--
ALTER TABLE `market_crop_rel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `healthCard`
--
ALTER TABLE `healthCard`
  ADD CONSTRAINT `healthCard_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`);

--
-- Constraints for table `market_crop_rel`
--
ALTER TABLE `market_crop_rel`
  ADD CONSTRAINT `market_crop_rel_ibfk_1` FOREIGN KEY (`market_id`) REFERENCES `markets` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`healthID`) REFERENCES `healthCard` (`healthID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
