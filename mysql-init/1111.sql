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
INSERT INTO `authorities` VALUES ('admin@ukr.net',1),('had0uken@ukr.net',1),('had0uken2@ukr.net',1),('masha@ukr.net',1),('user@ukr.net',1),('admin@ukr.net',2);
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
  `description` varchar(1145) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `deadline` varchar(45) DEFAULT NULL,
  `frequency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_email` (`user_email`),
  CONSTRAINT `fk_user_email` FOREIGN KEY (`user_email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (94,'admin@ukr.net','Running','Running',0,7,'IN_PLAN','DAILY','2999-12-01','FREQUENT'),(95,'admin@ukr.net','3 workouts a week','At least 3 workouts at week',0,3,'IN_PLAN','WEEKLY','2999-12-01','FREQUENT'),(96,'admin@ukr.net','7 filling rings of activities','at least 6 days fill all rings',0,7,'IN_PLAN','WEEKLY','2999-12-01','FREQUENT'),(97,'admin@ukr.net','MONTH TEST','MONTH TEST',0,1,'IN_PLAN','MONTHLY','2999-12-01','FREQUENT'),(98,'admin@ukr.net','MONTH TEST2','MONTH TEST2',0,1,'IN_PLAN','MONTHLY','2999-12-01','FREQUENT'),(99,'admin@ukr.net','YEAR TEST','YEAR TEST',0,1,'IN_PLAN','YEARLY','2999-12-01','FREQUENT'),(119,'admin@ukr.net','Drink water2','drink w12',0,4,'IN_PLAN','DAILY','2999-12-01','FREQUENT'),(120,'admin@ukr.net','Year test2','year2',0,4,'IN_PLAN','YEARLY','2999-12-01','FREQUENT'),(124,'admin@ukr.net','dqew','qewqew',0,33,'IN_PLAN','WEEKLY','2999-12-01','FREQUENT'),(125,'admin@ukr.net','MONTH TEST5','MT5',0,5,'IN_PLAN','MONTHLY','2999-12-01','FREQUENT'),(132,'admin@ukr.net','3 workouts a week','do 3 workouts',0,3,'IN_PLAN','WEEKLY','2999-12-01','ROUTINE'),(133,'admin@ukr.net','at least 6 day all circles','at le 3 cir a week',0,3,'IN_PLAN','WEEKLY','2999-12-01','ROUTINE'),(134,'admin@ukr.net','get 18 points','get 18 points',0,1,'IN_PLAN','MONTHLY','2999-12-01','ROUTINE'),(135,'admin@ukr.net','learn english','learn engl',0,1,'IN_PLAN','YEARLY','2999-12-01','ROUTINE'),(136,'admin@ukr.net','earn 100$','earn 100&',0,100,'IN_PLAN','YEARLY','2999-12-01','ROUTINE'),(159,'admin@ukr.net','Helthy meal','Helthy meal',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(160,'admin@ukr.net','Everyday pullups','Everyday pullups',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(161,'admin@ukr.net','wash face','wash face',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(175,'admin@ukr.net','drink morning glass of water','drink morning glass of water',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(181,'admin@ukr.net','get 12 ','get 12',0,12,'IN_PLAN','MONTHLY','2999-12-01','ROUTINE'),(191,'admin@ukr.net','test ','test',0,1,'FAILED','DAILY','2023-08-09','INFREQUENT'),(192,'admin@ukr.net','test ','test',0,1,'FAILED','DAILY','2023-08-10','INFREQUENT'),(193,'admin@ukr.net','drfsdfs','dfsfds',2,3,'IN_PROCESS','MONTHLY','2023-08-31','INFREQUENT'),(194,'admin@ukr.net','Helthy meal','Helthy meal',0,1,'IN_PLAN','DAILY','2023-08-11','INFREQUENT'),(195,'admin@ukr.net','Everyday pullups','Everyday pullups',0,1,'FAILED','DAILY','2023-08-11','INFREQUENT'),(196,'admin@ukr.net','wash face','wash face',0,1,'IN_PLAN','DAILY','2023-08-11','INFREQUENT'),(197,'admin@ukr.net','drink morning glass of water','drink morning glass of water',0,1,'IN_PROCESS','DAILY','2023-08-11','INFREQUENT'),(205,'masha@ukr.net','Save 2000$ for a down payment on a house.','Before the end of the year, you need to save up $2,000 for a contribution to the house. This money must be untouchable. Throughout the year I will note how the process goes.',761,2000,'IN_PROCESS','YEARLY','2023-12-31','INFREQUENT'),(206,'masha@ukr.net','Visit at least 3 new counties','It is always interesting to discover something new for yourself. Considering all the circumstances: work, finances and others, I expect that the real number of new countries that can be visited during the year is 3 countries.',0,3,'IN_PLAN','YEARLY','2999-12-01','ROUTINE'),(207,'masha@ukr.net','Complete an online course in a new subject area.','Education and self-development is incredibly important. You always need to become the best copy of yourself. Therefore, it is impossible that at least one new skill was not obtained in a year. Online courses in today\'s realities are a very convenient solution for this. Therefore, the goal is to complete at least 1 online course this year.',0,1,'IN_PLAN','YEARLY','2999-12-01','FREQUENT'),(208,'masha@ukr.net','Spend at least 1 weekend with a family','Family is the most important. It is not always possible to spend enough time with them. Therefore, the goal is to spend at least 1 weekend with your family this month, without being distracted by other people or circumstances.',0,1,'IN_PLAN','MONTHLY','2999-12-01','ROUTINE'),(209,'masha@ukr.net','At least 1 volunteerism every month','I\'ll research local volunteer opportunities and select causes that resonate with me. Creating a calendar of events will help me plan ahead and allocate time for volunteering. By participating in different projects, I\'ll contribute positively to my community, connect with like-minded individuals, and make a tangible impact.',0,1,'IN_PLAN','MONTHLY','2999-12-01','ROUTINE'),(210,'masha@ukr.net','Get tested and check health.','This month, be sure to go to the doctor, pass all the necessary tests and make sure that I\'m healthy.',0,1,'IN_PLAN','MONTHLY','2999-12-01','FREQUENT'),(211,'masha@ukr.net','Increase the maximum number of pull-ups to 30 during this year.','Practice pull-ups day after day. Bring the maximum number of repetitions to 30 times. And do it this year.',0,30,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(212,'masha@ukr.net','Morning glass of water','Start every morning with a glass of water. This should become a routine. Just like brushing your teeth.',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(213,'masha@ukr.net','Read at least 5 books','Books are a rich source of knowledge, information, and insights. They provide opportunities to learn about a wide range of topics, from history and science to culture and philosophy. So it is vital to read at least 5 books at year',0,5,'IN_PLAN','YEARLY','2999-12-01','ROUTINE'),(214,'masha@ukr.net','Read a new book','Books are a rich source of knowledge, information, and insights. They provide opportunities to learn about a wide range of topics, from history and science to culture and philosophy.',0,1,'IN_PLAN','MONTHLY','2999-12-01','FREQUENT'),(215,'masha@ukr.net','Evening run','Running is an excellent cardiovascular exercise that helps improve cardiovascular health, strengthen the heart, and enhance lung capacity. It also helps in maintaining a healthy weight and improving overall body composition.',0,1,'IN_PLAN','DAILY','2999-12-01','FREQUENT'),(216,'masha@ukr.net','Workout','Workouts are important for overall health and well-being. Engaging in regular physical activity through workouts offers a wide range of benefits for both your physical and mental health. ',0,1,'IN_PLAN','DAILY','2999-12-01','FREQUENT'),(217,'masha@ukr.net','At least 30 minutes of learning a foreign language','Learning a foreign language requires regularity. Therefore, you need to devote only 30 minutes of time per day to get a good result.',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(218,'masha@ukr.net','Do the cleaning','A clean house reduces the presence of allergens, dust, and germs that can lead to respiratory issues, allergies, and infections. Regular cleaning helps create a healthier environment for you and your family.',0,1,'IN_PLAN','DAILY','2999-12-01','FREQUENT'),(219,'masha@ukr.net','Walk 8000 steps','Today, people\'s physical activity is very limited. Therefore, it is recommended to walk at least 8,000 steps every day. This should become a daily routine. This can minimize the harm from a sedentary lifestyle.',0,1,'IN_PLAN','DAILY','2999-12-01','ROUTINE'),(220,'masha@ukr.net','Weekly apartment cleaning','A clean house reduces the presence of allergens, dust, and germs that can lead to respiratory issues, allergies, and infections. Regular cleaning helps create a healthier environment for you and your family.',0,1,'IN_PLAN','WEEKLY','2999-12-01','ROUTINE'),(221,'masha@ukr.net','Learn Spanish','Spanish is one of the most widely spoken languages in the world. It is spoken by millions of people across different continents and is the official or national language in many countries. Knowing Spanish will allow you to expand your horizons.',0,1,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(222,'masha@ukr.net','Find a new job','A new job means new opportunities, better conditions, an opportunity to learn new skills and make new connections.',0,1,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(223,'masha@ukr.net','Move to another city','Moving to another city allows you to open up new opportunities that are not available in your city. In addition, a fresh environment will positively affect your well-being and allow you to develop in new areas.',0,1,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(224,'masha@ukr.net','Morning glass of water','Start every morning with a glass of water. This should become a routine. Just like brushing your teeth.',0,1,'IN_PROCESS','DAILY','2023-08-15','INFREQUENT'),(225,'masha@ukr.net','At least 30 minutes of learning a foreign language','Learning a foreign language requires regularity. Therefore, you need to devote only 30 minutes of time per day to get a good result.',0,1,'IN_PLAN','DAILY','2023-08-15','INFREQUENT'),(226,'masha@ukr.net','Walk 8000 steps','Today, people\'s physical activity is very limited. Therefore, it is recommended to walk at least 8,000 steps every day. This should become a daily routine. This can minimize the harm from a sedentary lifestyle.',0,1,'IN_PLAN','DAILY','2023-08-15','INFREQUENT'),(229,'masha@ukr.net','Get tested and check health.','This month, be sure to go to the doctor, pass all the necessary tests and make sure that I\'m healthy.',0,1,'IN_PLAN','MONTHLY','2023-09-15','INFREQUENT'),(230,'masha@ukr.net','Get tested and check health.','This month, be sure to go to the doctor, pass all the necessary tests and make sure that I\'m healthy.',0,1,'IN_PLAN','MONTHLY','2023-09-15','INFREQUENT'),(231,'masha@ukr.net','Morning glass of water','Start every morning with a glass of water. This should become a routine. Just like brushing your teeth.',0,1,'IN_PLAN','DAILY','2023-09-15','INFREQUENT'),(232,'masha@ukr.net','At least 30 minutes of learning a foreign language','Learning a foreign language requires regularity. Therefore, you need to devote only 30 minutes of time per day to get a good result.',0,1,'IN_PLAN','DAILY','2023-09-15','INFREQUENT'),(233,'masha@ukr.net','Walk 8000 steps','Today, people\'s physical activity is very limited. Therefore, it is recommended to walk at least 8,000 steps every day. This should become a daily routine. This can minimize the harm from a sedentary lifestyle.',0,1,'IN_PLAN','DAILY','2023-09-15','INFREQUENT'),(234,'masha@ukr.net','Workout','Workouts are important for overall health and well-being. Engaging in regular physical activity through workouts offers a wide range of benefits for both your physical and mental health. ',0,1,'IN_PLAN','DAILY','2023-09-15','INFREQUENT'),(235,'admin@ukr.net','Helthy meal','Helthy meal',0,1,'FAILED','DAILY','2023-08-17','INFREQUENT'),(239,'admin@ukr.net','Helthy meal','Helthy meal',0,1,'FAILED','DAILY','2023-08-18','INFREQUENT'),(240,'admin@ukr.net','Helthy meal','Helthy meal',0,1,'IN_PLAN','DAILY','2023-08-18','INFREQUENT'),(241,'admin@ukr.net','Everyday pullups','Everyday pullups',0,1,'IN_PLAN','DAILY','2023-08-18','INFREQUENT'),(242,'admin@ukr.net','wash face','wash face',0,1,'FAILED','DAILY','2023-08-18','INFREQUENT'),(243,'admin@ukr.net','drink morning glass of water','drink morning glass of water',0,1,'IN_PLAN','DAILY','2023-08-18','INFREQUENT'),(248,'admin@ukr.net','Drink water2','drink w12',0,1,'IN_PLAN','DAILY','2023-08-17','INFREQUENT'),(249,'admin@ukr.net','Drink water2','drink w12',0,1,'IN_PLAN','DAILY','2023-08-17','INFREQUENT'),(250,'admin@ukr.net','Running','Running',0,1,'IN_PLAN','DAILY','2023-08-18','INFREQUENT'),(251,'admin@ukr.net','3 workouts a week','do 3 workouts',2,3,'FAILED','WEEKLY','2023-08-20','INFREQUENT'),(252,'admin@ukr.net','at least 6 day all circles','at le 3 cir a week',2,3,'IN_PLAN','WEEKLY','2023-08-20','INFREQUENT'),(253,'admin@ukr.net','dasdas','dadas',199,333,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(254,'admin@ukr.net','adsdasdas','dasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdas',0,2332,'IN_PLAN','YEARLY','2023-12-31','INFREQUENT'),(255,'admin@ukr.net','next week test 4','next week test 4next week test 4next week test 4',0,4,'IN_PLAN','WEEKLY','2023-08-27','INFREQUENT'),(257,'admin@ukr.net','Rrr','rrr',0,4,'IN_PLAN','MONTHLY','2999-12-01','ROUTINE'),(258,'admin@ukr.net','dasdasas','dasdasdasdas',0,1,'IN_PLAN','DAILY','2023-08-21','INFREQUENT'),(259,'admin@ukr.net','qewqew','fzxvxcvvxzzzzz',0,1,'IN_PLAN','DAILY','2023-08-21','INFREQUENT'),(260,'admin@ukr.net','ghhh','ghghgddgf',0,1,'IN_PLAN','DAILY','2999-12-01','FREQUENT');
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
INSERT INTO `users` VALUES ('admin@ukr.net','admin','admin','$2a$05$Fk0jEmt6wgFvBQ68BldApO4AKXoEY9ZDNl0JpnZMmfkZtO/Cn.kz6',1),('had0uken@ukr.net','had0uken','had0uken','$2a$05$IwiFuDZS/4hPBcjGqX5FnubKcWl96574chUtJoNMUks5skFYDJQYW',1),('had0uken2@ukr.net','had0uken2','had0uken2','$2a$05$0bpNgnx3K1CQmbkKrMMSNOwPy2XYSlbkArivX7Y9H/8Cj.7Z6chC2',1),('masha@ukr.net','masha','masha','$2a$05$Qobc8h44oQe/ECzvohGGzevWmwPM54Spe5mtM.zyG7utErpaYkAWe',1),('user@ukr.net','user','user','$2a$05$tQiufy6F7vOQ.OCl25nioOENsNPoQtTtewNV72bEq5tGks0GOe.BG',1);
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

-- Dump completed on 2023-08-23 14:41:39
