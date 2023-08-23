-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: my_db
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `email` varchar(100) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`email`,`role_id`),
  KEY `FK_user_role` (`role_id`),
  CONSTRAINT `FK_authorities` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `FK_users` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin@ukr.net',1),('had0uken@ukr.net',1),('admin@ukr.net',2),('had0uken@ukr.net',2);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_email` varchar(100) NOT NULL,
  `title` varchar(245) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `deadline` varchar(45) DEFAULT NULL,
  `frequency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_email` (`user_email`),
  CONSTRAINT `fk_user_email` FOREIGN KEY (`user_email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (56,'admin@ukr.net','0803TEST','TEST0803',0,1,'FINISHED',NULL,'2023-08-03','INFREQUENT'),(57,'admin@ukr.net','0803test2','0803test2',0,1,'IN_PLAN',NULL,'2023-08-03','INFREQUENT'),(58,'admin@ukr.net','0801TEST','0801TESTTEST',0,1,'FAILED',NULL,'2023-08-01','INFREQUENT'),(59,'admin@ukr.net','0804test','test',0,1,'IN_PLAN',NULL,'2023-08-04','INFREQUENT'),(60,'admin@ukr.net','0804test2','0804test20804test2',0,1,'FAILED',NULL,'2023-08-04','INFREQUENT'),(61,'admin@ukr.net','Test reg status','Status reg test',0,1,'IN_PLAN','DAILY','2999-01-01','FREQUENT'),(62,'admin@ukr.net','Test reg2 status','Status reg2 test',0,1,'IN_PLAN','DAILY','2999-01-01','FREQUENT'),(63,'admin@ukr.net','Test reg3 status','Status reg3 test',0,1,'IN_PLAN','DAILY','2999-01-01','FREQUENT'),(64,'admin@ukr.net','Test reg status','Status reg test',0,1,'IN_PLAN',NULL,'2023-08-05',NULL),(65,'admin@ukr.net','Test reg2 status','Status reg2 test',0,1,'FAILED',NULL,'2023-08-06',NULL),(66,'admin@ukr.net','0801','0801',0,1,'IN_PLAN',NULL,'2023-08-01','INFREQUENT'),(67,'admin@ukr.net','Test reg2 status','Status reg2 test',0,1,'IN_PLAN',NULL,'2023-08-06',NULL),(68,'admin@ukr.net','Test reg3 status','Status reg3 test',0,1,'IN_PLAN',NULL,'2023-08-03',NULL),(69,'admin@ukr.net','Test reg status','Status reg test',0,1,'IN_PLAN',NULL,'2023-08-03',NULL);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@ukr.net','admin','admin','$2a$05$Fk0jEmt6wgFvBQ68BldApO4AKXoEY9ZDNl0JpnZMmfkZtO/Cn.kz6',1),('had0uken@ukr.net','had0uken','had0uken','$2a$05$Fk0jEmt6wgFvBQ68BldApO4AKXoEY9ZDNl0JpnZMmfkZtO/Cn.kz6',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-06 11:09:10
