CREATE DATABASE  IF NOT EXISTS `h5perf` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `h5perf`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: h5perf
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `request_resource`
--

DROP TABLE IF EXISTS `request_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(100) DEFAULT NULL,
  `test_url` longtext,
  `index` int(11) DEFAULT NULL,
  `start_timestamp` bigint(11) DEFAULT NULL,
  `timestamp` bigint(11) DEFAULT NULL,
  `time_cost` int(11) DEFAULT NULL,
  `request_url` longtext,
  `method` varchar(10) DEFAULT NULL,
  `headers` longtext,
  `content_encoding` varchar(100) DEFAULT NULL,
  `content_type` varchar(100) DEFAULT NULL,
  `content_length` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1054 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_case`
--

DROP TABLE IF EXISTS `test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `container_type` varchar(45) DEFAULT NULL COMMENT '‘ORIGIN_WEBVIEW’,’UC_WEBVIEW’',
  `test_url` varchar(200) DEFAULT NULL,
  `net_type` varchar(45) DEFAULT NULL COMMENT '‘WIFI’,‘3G’,‘4G’',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `tid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_task`
--

DROP TABLE IF EXISTS `test_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '0: RUNNING  1: DONE',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_time_data`
--

DROP TABLE IF EXISTS `test_time_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_time_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(45) DEFAULT NULL,
  `on_received_title` varchar(45) DEFAULT NULL COMMENT '近似白屏时间',
  `dom_total` varchar(45) DEFAULT NULL COMMENT '页面加载完成时间',
  `dom_content_load` varchar(45) DEFAULT NULL COMMENT 'dom内容加载完成时间',
  `load` varchar(45) DEFAULT NULL COMMENT '资源加载完成时间',
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-27 17:58:44
