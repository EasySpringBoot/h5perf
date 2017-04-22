CREATE DATABASE  IF NOT EXISTS `h5perf` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `h5perf`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: h5perf
-- ------------------------------------------------------
-- Server version       5.7.11

--
-- Table structure for table `test_case`
--

DROP TABLE IF EXISTS `test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `container_type` varchar(45) DEFAULT NULL COMMENT '‘ORIGIN_WEBVIEW’,’UC_WEBVIEW’',
  `test_url` varchar(45) DEFAULT NULL,
  `net_type` varchar(45) DEFAULT NULL COMMENT '‘WIFI’,‘3G’,‘4G’',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `test_resource`
--

DROP TABLE IF EXISTS `test_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_case_id` int(11) DEFAULT NULL,
  `start_time` bigint(11) DEFAULT NULL,
  `resource_url` varchar(500) DEFAULT NULL,
  `resource_type` varchar(45) DEFAULT NULL COMMENT 'IMG,JS,CSS,OTHER',
  `resource_time` bigint(11) DEFAULT NULL COMMENT 'onLoadResource资源时间戳',
  `resource_size` bigint(11) DEFAULT NULL COMMENT '资源大小',
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `test_time_data`
--

DROP TABLE IF EXISTS `test_time_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_time_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_case_id` int(11) DEFAULT NULL,
  `on_recieve_title` varchar(45) DEFAULT NULL COMMENT '近似白屏时间',
  `on_page_finished` varchar(45) DEFAULT NULL COMMENT '页面加载完成时间',
  `dom_content_load` varchar(45) DEFAULT NULL COMMENT 'dom内容加载完成时间',
  `load` varchar(45) DEFAULT NULL COMMENT '资源加载完成时间',
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



-- Dump completed on 2017-04-22 15:42:54
