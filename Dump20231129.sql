CREATE DATABASE  IF NOT EXISTS `java_big_assignment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java_big_assignment`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 192.168.0.101    Database: java_big_assignment
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `thumbnail` varchar(500) DEFAULT NULL,
  `booking_date` varchar(500) DEFAULT NULL,
  `total_money` varchar(500) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (47,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','Britannia International','KS26.png','2023-11-26 23:35:37.111','58',20,NULL,NULL),(48,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','Zedwell Piccadilly Circus','KS27.png','2023-11-26 23:37:31.627','125',20,NULL,NULL),(49,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','Park Plaza Westminster','HT28.png','2023-11-26 23:38:27.359','193',20,NULL,NULL),(50,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','Central Park Hotel','HT29.png','2023-11-26 23:56:04.762','150',20,NULL,NULL),(51,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Britannia International','KS26.png','2023-11-27 20:05:31.662','58',24,NULL,NULL),(52,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','B VAUXHALL CORSA','CAR39.png','2023-11-27 20:09:27.597','100',24,NULL,NULL),(53,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','AIR FRANCE 07:25 – 07:30 ','FL31.jpg','2023-11-27 21:24:17.209','75',24,NULL,NULL),(54,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Great Iberian Cities(9 Days)','TRIP42.jpg','2023-11-27 21:28:24.743','450',24,NULL,NULL),(55,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Europe Escape - 12 Days','TRIP43.jpg','2023-11-27 21:28:58.508','999',24,NULL,NULL),(56,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Central Park Hotel','HT29.png','2023-11-27 21:35:05.048','150',24,NULL,NULL),(57,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Park Plaza Westminster','HT28.png','2023-11-27 21:36:36.175','193',24,NULL,NULL),(58,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Zedwell Piccadilly Circus','KS27.png','2023-11-27 21:38:19.592','125',24,NULL,NULL),(59,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','BRITISH AIRWAYS 7:00 - 7:30','FL33.jpg','2023-11-27 21:40:32.942','140',24,NULL,NULL),(60,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','B VAUXHALL CORSA','CAR39.png','2023-11-27 21:46:23.467','100',24,NULL,NULL),(61,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Britain and Ireland Delight (Winter, 10 Days)','TRIP44.jpg','2023-11-27 21:53:12.175','350',24,NULL,NULL),(62,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','Renault Cilo','CAR40.png','2023-11-27 22:03:33.302','90',24,NULL,NULL),(63,'Duong Tuan Tai','tuantai@gmail.com','0983453622','Tuyen Quang','Zedwell Piccadilly Circus','KS27.png','2023-11-28 10:42:28.857','125',25,NULL,NULL),(64,'Duong Tuan Tai','tuantai@gmail.com','0983453622','Tuyen Quang','vueling 14:25 – 16:10','FL32.jpg','2023-11-28 10:42:55.677','152',25,NULL,NULL),(65,'Hoang Dinh Hiep','hiepdeptrai@gmail.com','09864258963','hoa binh','Europe Jewel - 14 Days','TRIP45.jpg','2023-11-28 16:55:05.655','499',27,NULL,NULL),(66,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','Europe Jewel - 14 Days','TRIP45.jpg','2023-11-29 10:32:46.119','499',20,NULL,NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_detail`
--

DROP TABLE IF EXISTS `booking_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` int DEFAULT NULL,
  `total_money` int DEFAULT NULL,
  `booking_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `service_id` (`service_id`),
  KEY `order_id` (`booking_id`),
  CONSTRAINT `booking_detail_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `booking_detail_ibfk_2` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_detail`
--

LOCK TABLES `booking_detail` WRITE;
/*!40000 ALTER TABLE `booking_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'hotels'),(2,'car rentals'),(3,'flights'),(4,'trips'),(5,'cuises'),(6,'activities');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `subject_name` varchar(200) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galery`
--

DROP TABLE IF EXISTS `galery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galery` (
  `id` int NOT NULL AUTO_INCREMENT,
  `thumbnail` varchar(500) DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `galery_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galery`
--

LOCK TABLES `galery` WRITE;
/*!40000 ALTER TABLE `galery` DISABLE KEYS */;
/*!40000 ALTER TABLE `galery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `title` varchar(350) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `thumbnail` varchar(500) DEFAULT NULL,
  `description` longtext,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catelogy_id` (`category_id`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (26,'KS','Britannia International',68,10,'KS26.png','Britannia International Hotel Canary Wharf has spacious rooms and limited free WiFi access in bedrooms, just 600 metres from Canary Wharf Underground Station.',NULL,NULL,NULL,1),(27,'KS','Zedwell Piccadilly Circus',145,20,'KS27.png','The hotel, housed in the famous London Trocadero is designed to focus on rest and relaxation. Each room built to remove distractions that disturb sleep such as windows, complicated technology and anxiety inducing controls. Rooms are fully air-conditioned with air purification technology, high-speed WiFi and en-suite shower rooms.',NULL,NULL,NULL,1),(28,'HT','Park Plaza Westminster',243,50,'HT28.png',' Located on the South Bank of the Thames, Park Plaza Westminster Bridge London is set opposite the Houses of Parliament and Big Ben, on the South Bank. It is less than a 5-minute walk from the London Eye, the Aquarium, restaurants and theatres.\r\nThere is a fully equipped 24-hour gym, a 15-metre swimming pool with a sauna and steam room.\r\n',NULL,NULL,NULL,1),(29,'HT','Central Park Hotel',150,0,'HT29.png','Located less than 100 metres from Hyde Park, the Central Park Hotel is just a 2-minute walk from Queensway Underground Station. A 24-hour front desk is provided and Kensington’s shops, bars and restaurants are within 15 minutes’ walk of the Central Park Hotel.',NULL,NULL,NULL,1),(31,'FL','AIR FRANCE 07:25 – 07:30 ',82,7,'FL31.jpg','Paris Charles de Gaulle Airport (CDG) - London Gatwick Airport (LGW)',NULL,NULL,NULL,3),(32,'FL','vueling 14:25 – 16:10',152,0,'FL32.jpg','Rome Leonardo da Vinci Fiumicino Airport (FCO) - Barcelona El Prat Airport (BCN)\r\n',NULL,NULL,NULL,3),(33,'FL','BRITISH AIRWAYS 7:00 - 7:30',140,0,'FL33.jpg','Hannover (HAJ) - London (LHR)',NULL,NULL,NULL,3),(34,'FL','RYANAIR 6:10 - 9:25',104,15,'FL34.jpg','Porto · OPO - Paris · BVA',NULL,NULL,NULL,3),(35,'FL','easyJet  5:40 - 7:50',200,44,'FL35.jpg','Rome · FCO - Berlin · BER',NULL,NULL,NULL,3),(36,'CAR','Fiat 500',111,72,'CAR36.png','Mileage: 400 km per rental.\r\nCollision Damage Waiver.\r\nThird Party Liability.\r\nTheft Protection.\r\nFull Coverage.\r\n',NULL,NULL,NULL,2),(38,'CAR','A KIA PICANTO',90,16,'CAR38.png','Mileage: Unlimited.\r\nCollision Damage Waiver.\r\nThird Party Liability.\r\nTheft Protection.\r\nCancel Protection.\r\nFull Coverage.\r\n',NULL,NULL,NULL,2),(39,'CAR','B VAUXHALL CORSA',100,0,'CAR39.png','Mileage: Unlimited.\r\nCollision Damage Waiver.\r\nThird Party Liability.\r\nTheft Protection.\r\nCancel Protection.\r\nFull Coverage.\r\n',NULL,NULL,NULL,2),(40,'CAR','Renault Cilo',125,35,'CAR40.png','Mileage: 400 km per rental.\r\nCollision Damage Waiver.\r\nThird Party Liability.\r\nTheft Protection.\r\nFull Coverage.\r\n',NULL,NULL,NULL,2),(41,'CAR','Ford Fiesta 5door',130,55,'CAR41.png','Mileage: Limited (100 miles per day)\r\nCollision Damage Waiver\r\nThird Party Liability\r\nTheft Protection\r\nCancel Protection\r\nFull Coverage\r\n',NULL,NULL,NULL,2),(42,'TRIP','Great Iberian Cities(9 Days)',500,50,'TRIP42.jpg','Start in Barcelona and end in Lisbon! With the In-depth Cultural tour Great Iberian Cities (9 Days), you have a 9 days tour package taking you through Barcelona, Spain and 4 other destinations in Europe. Great Iberian Cities (9 Days) includes accommodation, an expert guide, meals, transport and more.',NULL,NULL,NULL,4),(43,'TRIP','Europe Escape - 12 Days',999,0,'TRIP43.jpg','Start and end in Rome! With the Explorer tour Europe Escape - 12 Days, you have a 12 days tour package taking you through Rome, Italy and 15 other destinations in Europe. Europe Escape - 12 Days includes accommodation in a hotel as well as an expert guide, meals, transport and more.',NULL,NULL,NULL,4),(44,'TRIP','Britain and Ireland Delight (Winter, 10 Days)',700,350,'TRIP44.jpg','Start and end in London! With the Explorer tour Britain and Ireland Delight (Winter, 10 Days), you have a 10 days tour package taking you through London, England and 14 other destinations in Europe. Britain and Ireland Delight (Winter, 10 Days) includes accommodation in a hotel as well as an expert guide, meals, transport and more.',NULL,NULL,NULL,4),(45,'TRIP','Europe Jewel - 14 Days',499,0,'TRIP45.jpg','Start and end in Amsterdam! With the Explorer tour Europe Jewel - 14 Days, you have a 14 days tour package taking you through Amsterdam, Netherlands and 17 other destinations in Europe. Europe Jewel - 14 Days includes accommodation in a hotel as well as an expert guide, meals, transport and more.',NULL,NULL,NULL,4),(46,'TRIP','The Great Adventure 14 days',690,199,'TRIP46.jpg','Start in Rome and end in Amsterdam! With the Explorer tour The Great Adventure, you have a 14 days tour package taking you through Rome, Italy and 16 other destinations in Europe. The Great Adventure includes accommodation in a hotel as well as an expert guide, insurance, meals, transport and more.',NULL,NULL,NULL,4),(47,'HT','the Z hotel holborn',150,99,'HT47.png','Ideally set in the centre of London, The Z Hotel Holborn offers air-conditioned rooms, a shared lounge, free WiFi and a bar. Popular points of interest nearby include British Museum, Savoy Theatre and Leicester Square Underground Station. The hotel has family rooms.\r\nAt the hotel, the rooms come with a desk, a flat-screen TV, a private bathroom, bed linen and towels.\r\nStaff at The Z Hotel Holborn are always available to provide information at the reception.\r\nPopular points of interest near the accommodation include Royal Opera House, Lyceum Theatre and Theatre Royal Drury Lane. The nearest airport is London City Airport, 13 km from The Z Hotel Holborn.\r\n',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `deleted` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Duong Van Du','duduongvanptit@gmail.com','0332625935','Tuyen Quang','Duongdu1','2023-11-07 10:11:53',NULL,NULL,NULL),(5,'Nguyen Tien Minh','tienminh@gmail.com','0983453876','Ha Noi','1234',NULL,NULL,NULL,NULL),(7,'Dinh Xuan Doan','xuandoan@gmail.com','0976342999','Tuyen Quang','1234',NULL,NULL,NULL,NULL),(8,'Dinh Hong Giang','honggiang@gmail.com','0967234532','Tuyen Quang','123456',NULL,NULL,NULL,NULL),(10,'Duong Duc Thang','ducthang@gmail.com','0332625934','Hai Duong','123456',NULL,NULL,NULL,NULL),(11,'Nguyen Viet Van','vietvan@gmail.com','0987453211','Hai Duong','123456',NULL,NULL,NULL,NULL),(14,'Nguyen Viet Van','vietvan1@gmail.com','0332625936','Hai Duong','123',NULL,NULL,NULL,NULL),(15,'Nguyen Duc Anh','ducanh@gmail.com','0364784322','Phu Tho','123456',NULL,NULL,NULL,NULL),(16,'Nguen Anh Tuan ','nanhtuan@gmail.com','0366784333','Phu Tho','123',NULL,NULL,NULL,NULL),(18,'Le Dinh Duong','dinhduong@gmail.com','0954235333','Thanh Hoa','123',NULL,NULL,NULL,NULL),(19,'Le Hai','lehai@gmail.com','0957433445','Phu Tho','123',NULL,NULL,NULL,NULL),(20,'Nguyen Xuan Anh','xuananh@gmail.com','0934777652','Ho Chi Minh','$2a$10$o6aDjNCUtxcGofXIzRzghulrCDMOf6DOOF.Ehih32djBGKu1xHrVC',NULL,NULL,2,NULL),(22,'Du Duong Van','duongdu102003@gmail.com','0999999999','Tuyen Quang','$2a$10$Lxhp8bXO/YO.UxtqhGWMvukPad6yieGkQFTh6UH2lDHv0RMerj0BS',NULL,NULL,1,NULL),(23,'Ma Tien An','tienan@gmail.com','0335664723','Nam Dinh','$2a$10$TgZqBI3kGLy9afYg5TJS9OPKKOcZAMzjIdkOvEdwCrRz8FKEcpd/e',NULL,NULL,2,NULL),(24,'Hoang Thuy Huong','thuyhuong@gmail.com','0362783822','Thanh Hoa','$2a$10$jF6.64ZgfstbF5OnIiyIquiJHOfvUv8ODwQrSqea.WBQWlfdtULYq','2023-11-26 10:41:52',NULL,NULL,NULL),(25,'Duong Tuan Tai','tuantai@gmail.com','0983453622','Tuyen Quang','$2a$10$hA/.YEbOZhyerjpuqFMwQe7FhrE/9d4T1OonIwexnLK4dpcOgjMvi','2023-11-28 10:40:56',NULL,NULL,NULL),(26,'Nguyen Quoc Tuan','quoctuannguyen@gmail.com','0945332456','Thai Binh','$2a$10$36fF6NCrT0OctGoxJp.Oxe4CyECfJ11aM3uClCU4g8UBGjbpKeRba','2023-11-28 10:49:31',NULL,NULL,NULL),(27,'Hoang Dinh Hiep','hiepdeptrai@gmail.com','09864258963','hoa binh','$2a$10$9kD2CmZm8mSYkjZHl.yxzOU/4r9xhG.X0/uwJWkWz3M/l.LFOI0Wu','2023-11-28 16:53:31',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-29 11:52:39
