-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: sistema_cavalos
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `cavalo`
--

DROP TABLE IF EXISTS `cavalo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cavalo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `altura` float NOT NULL,
  `cor_pelo` varchar(45) NOT NULL,
  `peso` float NOT NULL,
  `alimentacao` varchar(45) NOT NULL,
  `raca_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cavalo_raca` (`raca_id`),
  CONSTRAINT `fk_cavalo_raca` FOREIGN KEY (`raca_id`) REFERENCES `raca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cavalo`
--

LOCK TABLES `cavalo` WRITE;
/*!40000 ALTER TABLE `cavalo` DISABLE KEYS */;
INSERT INTO `cavalo` VALUES (13,'asdsad',3,'s',4,'d',68),(14,'asdsad',3,'s',4,'d',68),(15,'asdsad',3,'s',4,'d',68),(16,'asdsad',3,'s',4,'d',68),(17,'asdsad',3,'s',4,'d',68),(18,'asdsad',3,'s',4,'d',68),(19,'asdsad',3,'s',4,'d',68),(20,'asdsad',3,'s',4,'d',68),(21,'asdsad',3,'s',4,'d',68),(22,'asdsad',3,'s',4,'d',68),(23,'asdsad',3,'s',4,'d',68),(24,'asdsad',3,'s',4,'d',68),(25,'asdsad',3,'s',4,'d',68),(26,'asdsad',3,'s',4,'d',68),(27,'asdsad',3,'s',4,'d',68),(28,'asdsad',3,'s',4,'d',68),(29,'asdsad',3,'s',4,'d',68),(30,'asdsad',3,'s',4,'d',68),(31,'O Silmarillion',1,'n',1,'m',67);
/*!40000 ALTER TABLE `cavalo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-12 17:58:01
