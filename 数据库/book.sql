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
INSERT INTO `book` VALUES ('10','红与黑1','司汤达','法国','小说','长','命运','1'),('11','童年','高尔基','俄国','小说','中','命运','1'),('12','老人与海','欧内斯特·米勒尔·海明威','美国','小说','中','命运','1'),('13','羊脂球','莫泊桑','法国','小说','短','批判','1'),('14','白夜行','东野圭吾','日本','小说','长','推理','1'),('15','丰乳肥臀','莫言','中国','小说','长','生活','1'),('16','倾城之恋','张爱玲','中国','小说','短','情感','1'),('17','飞鸟集','泰戈尔','印度','诗集','短','爱情','1'),('18','繁星','冰心','中国','诗集','短','自然','1'),('19','春水','冰心','中国','诗集','短','自然','1'),('2','边城','沈从文','中国','小说','长','情感','1'),('20','钢铁是怎样炼成的','奥斯特洛夫斯基','苏联','小说','长','奋斗','1'),('21','呼啸山庄','奥米莉·勃朗特','英国','小说','长','社会','1'),('22','三国演义','罗贯中','中国','小说','长','历史','1'),('23','水浒传','施耐庵','中国','小说','长','历史','1'),('24','红楼梦','曹雪芹','中国','小说','长','爱情','1'),('25','西游记','吴承恩','中国','小说','长','魔幻','1'),('26','茶花女','家亚历山大·小仲马','法国','小说','短','社会','1'),('27','战争与和平','列夫·托尔斯泰','俄国','小说','长','社会','1'),('28','百年孤独','加西亚·马尔克斯','哥伦比亚','小说','中','魔幻','1'),('29','城堡','弗兰茨·卡夫卡','奥匈帝国','小说','长','社会','1'),('3','骆驼祥子','老舍','中国','小说','中','批判','1'),('30','笑面人','雨果','法国','小说','短','社会','1'),('31','堂吉诃德','塞万提斯','西班牙','小说','短','社会','1'),('32','罗生门','芥川龙之介','日本','小说','中','社会','1'),('33','高老头','巴尔扎克','法国','小说','中','社会','1'),('34','局外人','加缪','法国','小说','中','社会','1'),('35','一九八四','乔治·奥威尔','英国','小说','中','社会','1'),('36','追忆似水年华','马塞尔·普鲁斯特','法国','小说','中','自然','1'),('37','尤利西斯','詹姆斯·乔伊斯','爱尔兰','小说','中','社会','1'),('38','喧哗与骚动','威廉﹒福克纳','美国','小说','中','社会','1'),('39','约翰·克利斯朵夫','罗曼·罗兰','法国','小说','中','社会','1'),('4','传奇','张爱玲','中国','小说','中','命运','1'),('40','浮士德','歌德','德国','小说','中','批判','1'),('41','哈姆雷特','莎士比亚','英国','小说','中','社会','1'),('42','十日谈','薄迦丘','意大利','小说','中','社会','1'),('43','包法利夫人','福楼拜','法国','小说','中','社会','1'),('44','纳尔齐斯与歌尔德蒙','赫尔曼·黑塞','德国','小说','中','成长','1'),('45','我的名字叫红','奥尔罕·帕慕克','土耳其','小说','中','社会','1'),('46','日瓦戈医生','鲍里斯·帕斯捷尔纳克','苏联','小说','长','社会','1'),('47','看不见的城市','伊塔洛·卡尔维诺','意大利','小说','中','社会','1'),('48','人鼠之间','约翰·斯坦贝克','美国','小说','中','命运','1'),('49','活着','活着','中国','小说','中','社会','1'),('5','围城','钱钟书','中国','小说','中','讽刺','1'),('50','尘埃落定','阿来','中国','小说','长','社会','1'),('51','平凡的世界','路遥','中国','小说','长','社会','1'),('52','黄金时代','王小波','中国','小说','短','批判','1'),('53','穆斯林的葬礼','霍达','中国','小说','长','命运','1'),('54','灵山','高行健','法国','小说','长','成长','1'),('55','狼图腾','姜戎','中国','小说','中','成长','1'),('56','白鹿原','白鹿原','中国','小说','长','社会','1'),('57','长恨歌','王安忆','中国','小说','长','社会','1'),('58',' 国富论','亚当·斯密','英国','小说','长','经济','1'),('59','离开前请叫醒我','卢思浩','中国','小说','中','命运','1'),('6','子夜','矛盾','中国','小说','中','讽刺','1'),('60','商业博弈','孔英','中国','小说','中','经济','1'),('61',' 半小时漫画经济学4','陈磊','中国','小说','中','经济','1'),('62','与人亲密:相处是一门可以习得的艺术','盖伊.芬利','美国','小说','短','生活','1'),('63','无人幸免','奥马尔·阿卡德','加拿大','小说','短','科幻','1'),('64','两京十五日','马伯庸','中国','小说','中','历史','1'),('7','家','巴金','中国','小说','长','讽刺','1'),('8','安娜·卡列尼娜','列夫·托尔斯泰','俄国','小说','长','命运','1'),('9','巴黎圣母院','维克多·雨果','法国','小说','长','命运','1');
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
INSERT INTO `book_borrow` VALUES ('1','呐喊','user','2020-11-23','2020-12-23'),('x','呐喊','甄子丹','2020/11/24','x'),('x','呐喊','甄子丹','2020/11/24','x'),('x','红与黑','甄子丹','2020/11/24','x'),('x','童年','甄子丹','2020/11/24','x'),('x','老人与海','杨紫','2020/11/24','x'),('x','羊脂球','聂湛然','2020/11/24','x'),('x','白夜行','赵丽颖','2020/11/24','x'),('x','丰乳肥臀','甄子丹','2020/11/24','x'),('x','呐喊','甄子丹','2020/11/24','x'),('x','红与黑','孔关茂','2020/11/24','x'),('x','呐喊','杨紫','2020/11/24','x'),('x','呐喊','杨紫','2020/11/24','x');
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
  `notice_details` varchar(500) NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES ('1','40','阅读是一种放松身心的休闲方式，为了满足大家的阅读需求，图书馆自11月27日开始， 读者所借图书均可在借书日期起一个月内归还。欢迎大家到图书馆借阅，度过一个书香四溢的冬天。');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `book_borrow_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `borrow_user_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `return_time` varchar(45) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
INSERT INTO `return` VALUES ('呐喊','user','2020-12-25');
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return2`
--

DROP TABLE IF EXISTS `return2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return2` (
  `book_borrow_name` varchar(45) DEFAULT NULL,
  `borrow_user_name` varchar(45) DEFAULT NULL,
  `return_time` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return2`
--

LOCK TABLES `return2` WRITE;
/*!40000 ALTER TABLE `return2` DISABLE KEYS */;
INSERT INTO `return2` VALUES ('呐喊','甄子丹','Wed Nov 25 09:14:39 CST 2020'),('红与黑','甄子丹','Wed Nov 25 09:15:10 CST 2020'),('童年','甄子丹','Wed Nov 25 09:15:13 CST 2020'),('老人与海','杨紫','Wed Nov 25 09:16:15 CST 2020'),('羊脂球','聂湛然','Wed Nov 25 09:16:25 CST 2020'),('白夜行','赵丽颖','Wed Nov 25 09:16:29 CST 2020'),('丰乳肥臀','甄子丹','Wed Nov 25 09:16:31 CST 2020'),('红与黑','孔关茂','Wed Nov 25 10:06:22 CST 2020'),('呐喊','甄子丹','Wed Nov 25 10:07:24 CST 2020'),('呐喊','杨紫','Wed Nov 25 11:22:21 CST 2020'),('呐喊','杨紫','Wed Nov 25 11:23:10 CST 2020');
/*!40000 ALTER TABLE `return2` ENABLE KEYS */;
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
INSERT INTO `user` VALUES ('10','杨紫','女','21','1234ffff@qq.com','Qq123456]','1999-07-06','10','13555613506','广东东莞','肥头大耳'),('11','孔关茂','男','21','1234fff@qq.com','Qq123456]','1999-1-18','11','13555613507','广东湛江','口出狂言'),('12','宋源峰','男','21','1234ggg@qq.com','Qq123456]','1999-11-11','12a','13555613508','广东湛江','美如冠玉'),('13','聂湛然','男','21','1234hhh@qq.com','Qq123456]','1999-10-10','13','13555613509','广东粪坑','豁达大度'),('14','李城轩','男','21','1234iii@qq.com','Qq123456]','1999-10-2','14','13555613510','广东肇庆','腰大膀粗'),('15','钟耿洲','男','21','1234jjj@qq.com','Qq123456]','1999-9-10','15','13555613517','广东梅州','滔滔不绝'),('2','吴彦祖','男','21','mniqpwqecjhkv@email.com.cn','Nn123456@','1999-12-02','2','13555613514','广东河源','帅帅帅帅'),('3','刘亦菲','女','20','rkjjmbcppt@hotmail.com','Oo123456@','2000-06-08','3','13555613515','广东阳江','倾国倾城'),('30','张三','男','20','1234fsfs@126.com','Qq123456]','2000/1/1','30','13555639553','浙江金华','温文尔雅'),('31','李四','男','20','1234bfg@127.com','Qq123457]','2000/3/2','31','13552339553','浙江嵊州','清新俊逸'),('32','赵武','男','20','1234ffdg@128.com','Qq123458]','2000/5/3','32','13555899553','浙江宁波','雅人深致'),('33','林流','男','20','1234fgjjs@129.com','Qq123459]','2000/6/4','33','13523639553','浙江台州','惊才风逸'),('34','赵军','男','20','1234fs86s@130.com','Qq123460]','2000/7/5','34','13558639553','浙江丽水','才貌双全'),('35','赵俊','男','20','1234fsf53s@131.com','Qq123461]','2000/9/6','35','13135639553','浙江湖州','风流才子'),('36','李白','男','20','1234fsf4s@132.com','Qq123462]','2000/10/7','36','13590639553','浙江嘉兴','英俊潇洒'),('37','李信','男','20','1234fsfsg@133.com','Qq123463]','2000/11/8','37','13553439553','浙江丽水','豪情万丈'),('38','李小白','男','20','1234dfsd@134.com','Qq123464]','2000/12/9','38','13556439553','浙江湖州','顶天立地'),('39','刘依秋','女','22','1234mnhu@345.com','Qq123465]','1998/1/1','39','13645864843','浙江嘉兴','铁骨铮铮'),('4','杨幂','女','22','mmmidjhoibn@sogou@com','Pp123456@','1998-05-03','4','13555613516','广东清远','貌美如花'),('40','安依波','女','22','1234mggyu@346.com','Qq123466]','1998/3/2','40','13642534843','浙江舟山','雄姿英发'),('41','习忆之','女','22','1234mjlu@347.com','Qq123467]','1998/7/3','41','13642364843','浙江宁波','风度翩翩'),('42','赵香巧','女','22','1234mj44u@348.com','Qq123468]','1998/7/4','42','13642856843','河北保定','闭月羞花'),('43','刘紫萱','女','22','1234mjy76u@349.com','Qq123469]','1998/9/5','43','13642861443','河北唐山','国色天香'),('44','刘涵易','女','22','1234mjy44u@350.com','Qq123470]','1998/3/6','44','13642944843','河北秦皇岛','倾国倾城'),('45','慕容白亦','女','22','1234mjy1sdu@351.com','Qq123471]','1998/11/7','45','13642897843','河北张家口','亭亭玉立'),('46','钟美倩','女','22','1234mjy64u@352.com','Qq123472]','1998/12/8','46','13642822843','河北石家庄','小家碧玉'),('47','叶幻巧','女','22','1234mj65yu@353.com','Qq123473]','1998/11/9','47','13642864973','河北邢台','天生丽质'),('48','司马怜雪','女','22','1234mjy7u@354.com','Qq123474]','1998/12/10','48','13642824843','河北衡水','秀色可餐'),('49','赵安寒','女','22','1234mjy2u@355.com','Qq123475]','1998/12/11','49','13686864843','河北廊坊','冰肌玉骨'),('5','范冰冰','女','20','1234aaa@qq.com','Qq123456]','2000-10-30','5','13555613501','湖南长沙','倾国倾城'),('51','聂湛然','女','22','123@qq.com','1111','111','Tue Nov 24 09:28:20 CST 2020','111','111','111'),('6','德云社','男','21','1234bbb@qq.com','Qq123456]','1999-01-10','6','13555613502','广东江门','玉树临风'),('7','劳力士','男','21','1234ccc@qq.com','Qq123456]','1999-07-30','7','13555613503','广东湛江','眉清目秀'),('9','赵丽颖','女','21','1234eee@qq.com','Qq123456]','1999-01-10','9','13555613505','广东湛江','可爱'),('Test1','孔光茂',NULL,NULL,'12345678@qq.com','Aa@12345678',NULL,NULL,NULL,NULL,NULL),('user','user','男','16','1231@qq.com','Qq123456]','1998-09-12','12','11','2','1'),('user1','user1','男','16','1231@qq.com','Qq123456]','1','1','1','1','1');
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

-- Dump completed on 2020-11-25 11:43:33
