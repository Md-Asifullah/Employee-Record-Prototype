-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2022 at 03:08 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeerecord`
--
CREATE DATABASE IF NOT EXISTS `employeerecord` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `employeerecord`;

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `firstName` tinytext NOT NULL,
  `lastName` tinytext NOT NULL,
  `age` int(11) NOT NULL,
  `designation` tinytext NOT NULL,
  `nationality` tinytext NOT NULL,
  `address` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`id`, `firstName`, `lastName`, `age`, `designation`, `nationality`, `address`) VALUES
(1, 'Md', 'Asif', 27, 'Graphic Designer', 'Bangladeshi', 'Cyberjaya, Selangor, Malaysia'),
(2, 'Albert', 'Hansen', 35, 'Software Engineer', 'British', 'Ampang Jaya, Kuala Lumpur, Malaysia'),
(3, 'Hasan', 'Mahmud', 33, 'Video Editor', 'Bangladeshi', 'Shyamolo, Dhaka, Bangladesh'),
(4, 'Wei', 'Ting', 25, 'Programmer', 'Chinese', 'Foshan, Guangdong, China'),
(5, 'Kaniz', 'Farhana', 27, 'System Analyst', 'Bangladeshi', 'Cyberjaya, Selangor, Malaysia');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `record`
--
ALTER TABLE `record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
