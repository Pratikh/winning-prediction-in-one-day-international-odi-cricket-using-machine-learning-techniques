-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: crickinfo
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `australia`
--

DROP TABLE IF EXISTS `australia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `australia` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `australia`
--

LOCK TABLES `australia` WRITE;
/*!40000 ALTER TABLE `australia` DISABLE KEYS */;
INSERT INTO `australia` VALUES (11,'finch'),(12,'hazlewood'),(13,'maxwell'),(14,'KEN RICHARDSON'),(15,'mmarsh'),(16,'david'),(17,'finch'),(18,'hazlewood'),(19,'Head'),(20,'hilton'),(21,'JAMES FAULKNAR'),(22,'KEN RICHARDSON'),(23,'mmarsh'),(24,'PETER HANDSCOMB'),(25,'Starc');
/*!40000 ALTER TABLE `australia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `england`
--

DROP TABLE IF EXISTS `england`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `england` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `england`
--

LOCK TABLES `england` WRITE;
/*!40000 ALTER TABLE `england` DISABLE KEYS */;
INSERT INTO `england` VALUES (6,'JOSEPH ROOT'),(7,'LIAM PLUNKETT'),(8,'JACOB BALL'),(9,'CHRISTOPHER WOAKES'),(10,'BENJAMIN STOKES'),(11,'Moeen Ali');
/*!40000 ALTER TABLE `england` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ground`
--

DROP TABLE IF EXISTS `ground`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ground` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  UNIQUE KEY `gname` (`gname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ground`
--

LOCK TABLES `ground` WRITE;
/*!40000 ALTER TABLE `ground` DISABLE KEYS */;
/*!40000 ALTER TABLE `ground` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `india`
--

DROP TABLE IF EXISTS `india`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `india` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `india`
--

LOCK TABLES `india` WRITE;
/*!40000 ALTER TABLE `india` DISABLE KEYS */;
INSERT INTO `india` VALUES (24,'Dinesh Karthik'),(25,'Manish Pandey'),(26,'MS Dhoni'),(27,'B Kumar'),(28,'Bumrah'),(29,'Ajinkya Rahane'),(30,'Dinesh Karthik'),(31,'Manish Pandey'),(32,'MS Dhoni'),(33,'Pandya'),(34,'Axar'),(35,'B Kumar'),(36,'Bumrah'),(37,'M Shami'),(38,'Shreyas Iyer');
/*!40000 ALTER TABLE `india` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `team1` varchar(20) DEFAULT NULL,
  `team2` varchar(20) DEFAULT NULL,
  `toss` int(11) DEFAULT NULL,
  `ground` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (9,'England','South Africa',2,'Himachal Pradesh Cricket Association Stadium'),(10,'India','Australia',1,'Eden Gardens');
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores`
--

DROP TABLE IF EXISTS `scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scores` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `runs` int(11) DEFAULT NULL,
  `no_of_wickets` int(11) DEFAULT NULL,
  `overs` varchar(10) DEFAULT NULL,
  `player1` varchar(50) DEFAULT NULL,
  `player2` varchar(20) DEFAULT NULL,
  `wickets` varchar(500) DEFAULT NULL,
  `team` varchar(20) DEFAULT NULL,
  `timestamp` double DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `playing_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores`
--

LOCK TABLES `scores` WRITE;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
INSERT INTO `scores` VALUES (11,20,0,'2','AB:10','De:10','','South Africa',1527071089243,9,1);
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `southafrica`
--

DROP TABLE IF EXISTS `southafrica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `southafrica` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `southafrica`
--

LOCK TABLES `southafrica` WRITE;
/*!40000 ALTER TABLE `southafrica` DISABLE KEYS */;
INSERT INTO `southafrica` VALUES (6,'Aiden Markram'),(7,'DEAN ELGAR'),(8,'FAF'),(9,'IMRAN TAHIR'),(10,'RABADA'),(11,'VERNON PHILANDER'),(12,'KLAASEN'),(13,'WAYNE PARNELL'),(14,'MORRIS');
/*!40000 ALTER TABLE `southafrica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-24 16:23:34
