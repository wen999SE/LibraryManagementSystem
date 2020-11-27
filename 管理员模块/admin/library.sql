-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` varchar(100) NOT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `book_author` varchar(100) DEFAULT NULL,
  `book_country` varchar(100) DEFAULT NULL,
  `book_type` varchar(100) DEFAULT NULL,
  `book_length` varchar(100) DEFAULT NULL,
  `book_theme` varchar(100) DEFAULT NULL,
  `book_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('1','呐喊','鲁迅','中国','小说','短','批判','0'),('10','红与黑','司汤达','法国','小说','长','命运','0'),('11','童年','高尔基','俄国','小说','中','命运','0'),('12','老人与海','欧内斯特·米勒尔·海明威','美国','小说','中','命运','0'),('13','羊脂球','莫泊桑','法国','小说','短','批判','0'),('14','白夜行','东野圭吾','日本','小说','长','推理','0'),('15','丰乳肥臀','莫言','中国','小说','长','生活','1'),('16','倾城之恋','张爱玲','中国','小说','短','情感','1'),('2','边城','沈从文','中国','小说','长','情感','1'),('3','骆驼祥子','老舍','中国','小说','中','批判','1'),('4','传奇','张爱玲','中国','小说','中','命运','1'),('5','围城','钱钟书','中国','小说','中','讽刺','1'),('6','子夜','矛盾','中国','小说','中','讽刺','1'),('7','家','巴金','中国','小说','长','讽刺','1'),('8','安娜·卡列尼娜','列夫·托尔斯泰','俄国','小说','长','命运','1'),('9','巴黎圣母院','维克多·雨果','法国','小说','长','命运','1');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_borrow`
--

DROP TABLE IF EXISTS `book_borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_borrow` (
  `book_borrow_id` varchar(45) DEFAULT NULL,
  `book_borrow_name` varchar(45) DEFAULT NULL,
  `borrow_user_name` varchar(45) DEFAULT NULL,
  `borrow_time` varchar(45) DEFAULT NULL,
  `return_time` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_borrow`
--

LOCK TABLES `book_borrow` WRITE;
/*!40000 ALTER TABLE `book_borrow` DISABLE KEYS */;
INSERT INTO `book_borrow` VALUES ('1','呐喊','user','2020-11-23','2020-12-23'),('x','呐喊','甄子丹','2020/11/24','x'),('x','呐喊','甄子丹','2020/11/24','x'),('x','红与黑','甄子丹','2020/11/24','x'),('x','童年','甄子丹','2020/11/24','x'),('x','老人与海','杨紫','2020/11/24','x'),('x','羊脂球','聂湛然','2020/11/24','x'),('x','白夜行','赵丽颖','2020/11/24','x');
/*!40000 ALTER TABLE `book_borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `book_borrow_name` varchar(45) DEFAULT NULL,
  `borrow_user_name` varchar(45) DEFAULT NULL,
  `borrow_time` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES ('呐喊','甄子丹','2020/11/24'),('红与黑','甄子丹','2020/11/24'),('童年','甄子丹','2020/11/24'),('老人与海','杨紫','2020/11/24'),('羊脂球','聂湛然','2020/11/24'),('白夜行','赵丽颖','2020/11/24');
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` varchar(45) NOT NULL,
  `notice_time` varchar(30) NOT NULL,
  `notice_details` varchar(200) NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES ('1','40','88888888888888888888');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `book_borrow_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `borrow_user_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `return_time` varchar(45) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(100) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_sex` varchar(5) DEFAULT NULL,
  `user_age` varchar(5) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_pwd` varchar(45) DEFAULT NULL,
  `user_birthday` varchar(45) DEFAULT NULL,
  `user_borrowid` varchar(45) DEFAULT NULL,
  `user_phone` varchar(30) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_describe` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','甄子丹','男','21','uapmspujall@sina.com','Mm123456@','1999-10-22','1','13555613513','广东汕尾','武功盖世'),('10','杨紫','女','21','1234fff@qq.com','Qq123456]','1999-07-06','10','13555613506','广东东莞','肥头大耳'),('2','吴彦祖','男','21','mniqpwqecjhkv@email.com.cn','Nn123456@','1999-12-02','2','13555613514','广东河源','帅帅帅帅'),('3','刘亦菲','女','20','rkjjmbcppt@hotmail.com','Oo123456@','2000-06-08','3','13555613515','广东阳江','倾国倾城'),('4','杨幂','女','22','mmmidjhoibn@sogou@com','Pp123456@','1998-05-03','4','13555613516','广东清远','貌美如花'),('5','范冰冰','女','20','1234aaa@qq.com','Qq123456]','2000-10-30','5','13555613501','湖南长沙','倾国倾城'),('556765t5','聂湛然','女','22','123@qq.com','1111','111','Tue Nov 24 09:28:20 CST 2020','111','111','111'),('6','德云社','男','21','1234bbb@qq.com','Qq123456]','1999-01-10','6','13555613502','广东江门','玉树临风'),('7','劳力士','男','21','1234ccc@qq.com','Qq123456]','1999-07-30','7','13555613503','广东湛江','眉清目秀'),('9','赵丽颖','女','21','1234eee@qq.com','Qq123456]','1999-01-10','9','13555613505','广东湛江','可爱'),('user','user','男','16','1231@qq.com','Qq123456]','1998-09-12','12','11','2','1');
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

-- Dump completed on 2020-11-24 18:09:54
