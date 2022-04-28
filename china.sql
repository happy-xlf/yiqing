/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : yiqing

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2022-04-28 13:45:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for china
-- ----------------------------
DROP TABLE IF EXISTS `china`;
CREATE TABLE `china` (
  `time` datetime DEFAULT NULL,
  `provinceName` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `currentConfirmedCount` int(255) DEFAULT NULL,
  `confirmedCount` int(255) DEFAULT NULL,
  `suspectedCount` int(255) DEFAULT NULL,
  `curedCount` int(255) DEFAULT NULL,
  `deadCount` int(255) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for local_world
-- ----------------------------
DROP TABLE IF EXISTS `local_world`;
CREATE TABLE `local_world` (
  `Date` varchar(255) DEFAULT NULL,
  `yz` int(255) DEFAULT NULL,
  `bmz` int(255) DEFAULT NULL,
  `oz` int(255) DEFAULT NULL,
  `dyz` int(255) DEFAULT NULL,
  `qita` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sum_world
-- ----------------------------
DROP TABLE IF EXISTS `sum_world`;
CREATE TABLE `sum_world` (
  `Date` varchar(255) DEFAULT NULL,
  `confirmedCount` int(255) DEFAULT NULL,
  `suspectedCount` int(255) DEFAULT NULL,
  `curedCount` int(255) DEFAULT NULL,
  `deadCount` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for world_map
-- ----------------------------
DROP TABLE IF EXISTS `world_map`;
CREATE TABLE `world_map` (
  `id` int(11) DEFAULT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `continents` varchar(255) DEFAULT NULL,
  `provinceName` varchar(255) DEFAULT NULL,
  `cityName` varchar(255) DEFAULT NULL,
  `confirmedCount` int(255) DEFAULT NULL,
  `suspectedCount` int(255) DEFAULT NULL,
  `curedCount` int(255) DEFAULT NULL,
  `deadCount` int(255) DEFAULT NULL,
  `locationId` varchar(255) DEFAULT NULL,
  `countryShortCode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
