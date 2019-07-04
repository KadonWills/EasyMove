-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: easymove
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `agencies`
--

DROP TABLE IF EXISTS `agencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agencies` (
  `agencies_id` int(11) NOT NULL AUTO_INCREMENT,
  `agencies_name` varchar(254) DEFAULT NULL,
  `town` varchar(254) DEFAULT NULL,
  `quarter` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`agencies_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencies`
--

LOCK TABLES `agencies` WRITE;
/*!40000 ALTER TABLE `agencies` DISABLE KEYS */;
INSERT INTO `agencies` VALUES (1,'Mvan, Yaounde','Yaounde','Mvan'),(2,'Biyemassi, Yaounde','Yaounde','Biyemassi'),(3,'Yassa, Douala','Douala','Yassa'),(4,'Logpom, Douala','Douala','Logpom'),(37,'Name','Yaounde','Quarter');
/*!40000 ALTER TABLE `agencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_trips`
--

DROP TABLE IF EXISTS `bus_trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus_trips` (
  `id_` int(11) NOT NULL,
  `trips_id` int(11) NOT NULL,
  PRIMARY KEY (`id_`,`trips_id`),
  KEY `FK_bus_trips_trips_id` (`trips_id`),
  CONSTRAINT `FK_bus_trips_id_` FOREIGN KEY (`id_`) REFERENCES `buses` (`id_`),
  CONSTRAINT `FK_bus_trips_trips_id` FOREIGN KEY (`trips_id`) REFERENCES `trips` (`trips_id`),
  CONSTRAINT `fk_has` FOREIGN KEY (`id_`) REFERENCES `buses` (`id_`),
  CONSTRAINT `fk_has2` FOREIGN KEY (`trips_id`) REFERENCES `trips` (`trips_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_trips`
--

LOCK TABLES `bus_trips` WRITE;
/*!40000 ALTER TABLE `bus_trips` DISABLE KEYS */;
/*!40000 ALTER TABLE `bus_trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buses`
--

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buses` (
  `id_` int(11) NOT NULL AUTO_INCREMENT,
  `bus_number` varchar(254) DEFAULT NULL,
  `colour` varchar(254) DEFAULT NULL,
  `num_of_sits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buses`
--

LOCK TABLES `buses` WRITE;
/*!40000 ALTER TABLE `buses` DISABLE KEYS */;
/*!40000 ALTER TABLE `buses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mails`
--

DROP TABLE IF EXISTS `mails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mails` (
  `mails_id` int(11) NOT NULL AUTO_INCREMENT,
  `users_id` int(11) DEFAULT NULL,
  `use_users_id` int(11) NOT NULL,
  `id_` int(11) DEFAULT NULL,
  `trips_id` int(11) DEFAULT NULL,
  `mails_type` varchar(254) DEFAULT NULL,
  `receiver_name` varchar(254) DEFAULT NULL,
  `receiver_number` varchar(254) DEFAULT NULL,
  `mail_state` varchar(254) DEFAULT NULL,
  `mails_name` varchar(254) DEFAULT NULL,
  `sender_name` varchar(254) DEFAULT NULL,
  `sender_number` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`mails_id`),
  KEY `FK_mails_id_` (`id_`,`trips_id`),
  KEY `FK_mails_use_users_id` (`use_users_id`),
  KEY `FK_mails_users_id` (`users_id`),
  CONSTRAINT `FK_mails_id_` FOREIGN KEY (`id_`, `trips_id`) REFERENCES `bus_trips` (`id_`, `trips_id`),
  CONSTRAINT `FK_mails_use_users_id` FOREIGN KEY (`use_users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `FK_mails_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_association_13` FOREIGN KEY (`id_`, `trips_id`) REFERENCES `bus_trips` (`id_`, `trips_id`),
  CONSTRAINT `fk_users_maildischarge` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_users_mailsent` FOREIGN KEY (`use_users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mails`
--

LOCK TABLES `mails` WRITE;
/*!40000 ALTER TABLE `mails` DISABLE KEYS */;
/*!40000 ALTER TABLE `mails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operations`
--

DROP TABLE IF EXISTS `operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operations` (
  `id_operations` int(11) NOT NULL AUTO_INCREMENT,
  `users_id` int(11) DEFAULT NULL,
  `operations_name` varchar(254) DEFAULT NULL,
  `operation_target` varchar(254) DEFAULT NULL,
  `operation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id_operations`),
  KEY `FK_operations_users_id` (`users_id`),
  CONSTRAINT `FK_operations_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_users_operations` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operations`
--

LOCK TABLES `operations` WRITE;
/*!40000 ALTER TABLE `operations` DISABLE KEYS */;
INSERT INTO `operations` VALUES (1,NULL,'Create new agency','null with id = 5',NULL),(2,NULL,'Create new agency','null with id = 6',NULL),(3,NULL,'Create new agency','test with id = 7',NULL),(4,NULL,'Create new agency','test with id = 8',NULL),(5,NULL,'Create new agency','test with id = 9',NULL),(6,NULL,'Create new agency','test with id = 10',NULL),(7,NULL,'Create new agency','test with id = 11',NULL),(8,NULL,'Create new agency','tete with id = 12',NULL),(9,NULL,'Create new agency','Test with id = 13',NULL),(10,NULL,'Create new agency','Test1 with id = 14',NULL),(11,NULL,'Create new agency','test2 with id = 15',NULL),(12,NULL,'Create new agency','test3 with id = 16',NULL),(13,NULL,'Create new agency','test1 with id = 17',NULL),(14,NULL,'Create new agency','tst2 with id = 18',NULL),(15,NULL,'Create new agency','test with id = 19',NULL),(16,NULL,'Create new agency','test with id = 20',NULL),(17,NULL,'Create new agency','null with id = 21',NULL),(18,NULL,'Create new agency','Test with id = 22',NULL),(19,NULL,'Create new agency','test with id = 23',NULL),(20,NULL,'Create new agency','test2 with id = 24',NULL),(21,NULL,'Create new agency','null with id = 25',NULL),(22,NULL,'Create new agency','null with id = 26',NULL),(23,NULL,'Create new agency','null with id = 27',NULL),(24,NULL,'Create new agency','null with id = 28',NULL),(25,NULL,'Create new agency','null with id = 29',NULL),(26,NULL,'Create new agency','null with id = 30',NULL),(27,NULL,'Create new agency','test3 with id = 31',NULL),(28,NULL,'Create new agency','test with id = 32',NULL),(29,NULL,'Create new agency','test with id = 33',NULL),(30,NULL,'Create new agency','tst2 with id = 34',NULL),(31,NULL,'Create new agency','Main Agency with id = 35',NULL),(32,NULL,'Create new agency','mfou with id = 36',NULL),(33,NULL,'Create new agency','test with id = 37',NULL),(34,NULL,'Edited an existing agency','test with id = 37',NULL),(35,NULL,'Edited an existing agency','name with id = 37',NULL),(36,NULL,'Create new agency','test with id = 38',NULL),(37,NULL,'Deleted an agency','test with id = 38',NULL),(38,NULL,'Create new agency','test with id = 39',NULL),(39,NULL,'Deleted an agency','test with id = 39',NULL),(40,NULL,'Create new agency','test with id = 40',NULL),(41,NULL,'Create new agency','test1 with id = 41',NULL),(42,NULL,'Deleted an agency','test1 with id = 41',NULL),(43,NULL,'Deleted an agency','test with id = 40',NULL),(44,NULL,'Create new agency','test with id = 42',NULL),(45,NULL,'Edited an existing agency','test with id = 42',NULL),(46,NULL,'Deleted an agency','test with id = 42','2019-07-04 12:54:07'),(47,NULL,'Edited an existing agency','Name with id = 37','2019-07-04 12:55:33'),(48,NULL,'Deleted a trip','From  to  with id = 5','2019-07-04 16:22:25'),(49,NULL,'Edited an existing agency','From  to  with id = 2','2019-07-04 17:01:36'),(50,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 18:48:14'),(51,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 18:51:49'),(52,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:04:35'),(53,NULL,'Edited an existing agency','From  to  with id = 1','2019-07-04 19:04:57'),(54,NULL,'Edited an existing agency','From  to  with id = 1','2019-07-04 19:05:47'),(55,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:06:15'),(56,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:09:32'),(57,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:09:56'),(58,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:10:20'),(59,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:11:52'),(60,NULL,'Edited an existing agency','From  to  with id = 2','2019-07-04 19:12:17'),(61,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:13:48'),(62,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:14:06'),(63,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:27:56'),(64,NULL,'Edited an existing agency','From  to  with id = 3','2019-07-04 19:28:05'),(65,NULL,'Edited an existing agency','From  to  with id = 1','2019-07-04 19:47:50'),(66,NULL,'Create new agency','From  to  with id = 6','2019-07-04 20:22:14'),(67,NULL,'Edited an existing agency','From  to  with id = 6','2019-07-04 20:24:17'),(68,NULL,'Deleted a trip','From  to  with id = 6','2019-07-04 20:25:08'),(69,NULL,'Create new agency','From null to null with id = 7','2019-07-04 20:33:18'),(70,NULL,'Edited an existing agency','From null to null with id = 7','2019-07-04 20:36:04'),(71,NULL,'Create new agency','From null to null with id = 8','2019-07-04 20:36:17'),(72,NULL,'Edited an existing agency','From null to null with id = 8','2019-07-04 20:36:26'),(73,NULL,'Deleted a trip','From null to null with id = 8','2019-07-04 20:40:34'),(74,NULL,'Edited an existing agency','From null to null with id = 7','2019-07-04 20:40:44'),(75,NULL,'Create new agency','From null to null with id = 9','2019-07-04 20:41:17');
/*!40000 ALTER TABLE `operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `priviledges`
--

DROP TABLE IF EXISTS `priviledges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `priviledges` (
  `users_id` int(11) NOT NULL,
  `idmenu` int(11) NOT NULL,
  PRIMARY KEY (`users_id`,`idmenu`),
  KEY `fk_accessed` (`idmenu`),
  CONSTRAINT `fk_accessed` FOREIGN KEY (`idmenu`) REFERENCES `users_menu` (`idmenu`),
  CONSTRAINT `fk_has_access` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priviledges`
--

LOCK TABLES `priviledges` WRITE;
/*!40000 ALTER TABLE `priviledges` DISABLE KEYS */;
/*!40000 ALTER TABLE `priviledges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `users_id` int(11) NOT NULL,
  `trips_id` int(11) NOT NULL,
  `reservation_date` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`users_id`,`trips_id`),
  KEY `FK_reservations_trips_id` (`trips_id`),
  CONSTRAINT `FK_reservations_trips_id` FOREIGN KEY (`trips_id`) REFERENCES `trips` (`trips_id`),
  CONSTRAINT `FK_reservations_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_is_reserved` FOREIGN KEY (`trips_id`) REFERENCES `trips` (`trips_id`),
  CONSTRAINT `fk_reserves` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trips` (
  `trips_id` int(11) NOT NULL AUTO_INCREMENT,
  `agencies_id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `age_agencies_id` int(11) NOT NULL,
  `departure` datetime DEFAULT NULL,
  `arrival` datetime DEFAULT NULL,
  `depart_agency` varchar(254) DEFAULT NULL,
  `arrival_agency` varchar(254) DEFAULT NULL,
  `trips_type` varchar(254) DEFAULT NULL,
  `price` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`trips_id`),
  KEY `FK_trips_users_id` (`users_id`),
  KEY `FK_trips_age_agencies_id` (`age_agencies_id`),
  KEY `FK_trips_agencies_id` (`agencies_id`),
  CONSTRAINT `FK_trips_age_agencies_id` FOREIGN KEY (`age_agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `FK_trips_agencies_id` FOREIGN KEY (`agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `FK_trips_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_agencies_tripdeparture` FOREIGN KEY (`age_agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `fk_buses_triparrival` FOREIGN KEY (`agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `fk_users_trips` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (1,4,1,2,'2019-07-04 01:00:00','2019-07-04 01:00:00','','','Economic','7000'),(2,37,1,3,'2019-07-04 01:00:00','2019-07-04 01:00:00','','','Economic','4500'),(4,2,1,3,'2019-07-04 16:21:53','2019-07-04 16:21:53','','','VIP','5000'),(5,2,1,4,'2019-07-04 17:05:03','2019-07-04 17:05:03','','','VIP','5000'),(7,2,2,2,'2019-07-04 01:00:00','2019-07-04 01:00:00',NULL,NULL,'Economic','1247'),(9,1,2,3,'2019-07-04 01:00:00','2019-07-04 01:00:00',NULL,NULL,'Economic','0001');
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `users_id` int(11) NOT NULL AUTO_INCREMENT,
  `agencies_id` int(11) DEFAULT NULL,
  `use_users_id` int(11) DEFAULT NULL,
  `first_name` varchar(254) DEFAULT NULL,
  `last_name` varchar(254) DEFAULT NULL,
  `lusers_ogin` varchar(254) DEFAULT NULL,
  `users_password` varchar(254) DEFAULT NULL,
  `users_role` varchar(254) DEFAULT NULL,
  `users_status` varchar(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `id_card` varchar(254) DEFAULT NULL,
  `gender` varchar(254) DEFAULT NULL,
  `phone_num` varchar(254) DEFAULT NULL,
  `adresse` varchar(254) DEFAULT NULL,
  `photo` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`users_id`),
  KEY `FK_users_agencies_id` (`agencies_id`),
  KEY `FK_users_use_users_id` (`use_users_id`),
  CONSTRAINT `FK_users_agencies_id` FOREIGN KEY (`agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `FK_users_use_users_id` FOREIGN KEY (`use_users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `fk_agencies_users` FOREIGN KEY (`agencies_id`) REFERENCES `agencies` (`agencies_id`),
  CONSTRAINT `fk_parentusers_childusers` FOREIGN KEY (`use_users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,'Njinkou','Sandra','admin','92668751','admin',NULL,'njinkousandra@hotmail.com','475125865','Female','672354157','Nkolanga','https://avatars1.githubusercontent.com/u/35223630?s=460&v=4'),(2,1,NULL,'Manuella','Kebou','agency head','92668751','manu',NULL,'njinkousandra@hotmail.com','475125865','Female','672354157','Nkolanga','https://avatars1.githubusercontent.com/u/35223630?s=460&v=4');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_menu`
--

DROP TABLE IF EXISTS `users_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_menu` (
  `idmenu` int(11) NOT NULL AUTO_INCREMENT,
  `use_idmenu` int(11) DEFAULT NULL,
  `menu_name` varchar(254) DEFAULT NULL,
  `menu_key` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idmenu`),
  KEY `FK_users_menu_use_idmenu` (`use_idmenu`),
  CONSTRAINT `FK_users_menu_use_idmenu` FOREIGN KEY (`use_idmenu`) REFERENCES `users_menu` (`idmenu`),
  CONSTRAINT `fk_parentmenu_childmenu` FOREIGN KEY (`use_idmenu`) REFERENCES `users_menu` (`idmenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_menu`
--

LOCK TABLES `users_menu` WRITE;
/*!40000 ALTER TABLE `users_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-04 21:26:42
