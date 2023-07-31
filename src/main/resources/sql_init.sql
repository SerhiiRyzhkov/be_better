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
INSERT INTO `users` VALUES ('admin@ukr.net','admin','admin','$2a$05$Fk0jEmt6wgFvBQ68BldApO4AKXoEY9ZDNl0JpnZMmfkZtO/Cn.kz6',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



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
INSERT INTO `authorities` VALUES ('admin@ukr.net',1),('admin@ukr.net',2);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;