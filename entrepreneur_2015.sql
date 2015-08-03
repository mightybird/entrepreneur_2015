CREATE DATABASE  IF NOT EXISTS `entrepreneur_2015` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `entrepreneur_2015`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: entrepreneur_2015
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `id` varchar(32) NOT NULL,
  `title` varchar(45) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `publish_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `signature` varchar(200) NOT NULL,
  `update_time` datetime NOT NULL,
  `parent_action` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AUTHORITY_NAME_UNIQUE` (`name`),
  KEY `AUTHORITY_NAME_INDEX` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_dictionary`
--

DROP TABLE IF EXISTS `data_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_dictionary` (
  `id` varchar(32) NOT NULL,
  `ddkey` varchar(50) NOT NULL,
  `ddvalue` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_dictionary`
--

LOCK TABLES `data_dictionary` WRITE;
/*!40000 ALTER TABLE `data_dictionary` DISABLE KEYS */;
INSERT INTO `data_dictionary` VALUES ('059579f86fbd4918be85edfbf4feba8b','af1929c6704847709eef88a8e15e1f8e标签','第三产业'),('086f106485a3405b8d0af8a1108feaa7','cae34172568f49a6bcb8da145777f0b3标签','金融'),('0c222061b4de4658a7f18e34a73b3685','30bb73da1201471c9b8c3e3d6741697c标签','电网'),('0d2ba721fa094501b719419c910d6203','d057492a80af42f8a54abcb2b6e0461c标签','金融'),('1','fund_scope','10-20'),('10','fund_type','个体经营'),('1019b00bdc424541b9f17978f16d6044','3e8a239dafe041ed958ded1c2d3e164b标签','第三产业'),('11','fund_lack','10-20'),('12','fund_lack','20-30'),('13','fund_lack','30-50'),('16a3529b38be47a3b2a2121bfe88c6b1','d057492a80af42f8a54abcb2b6e0461c标签','电网'),('16b0f3d941f24141ad4a11ca67e27bbc','d8796d4137e94b8b8219894bfc62f048标签','电网'),('2','tutor_type','财务导师'),('20576602dc1a46cd90be60b157db01f8','a9bbb699dfad40d8aefab09e0aaefe44标签','投资'),('3','tutor_type','经营管理导师'),('3ab6cc49312743cc98a150b96a2eee05','30bb73da1201471c9b8c3e3d6741697c标签','第三产业'),('3f0b71f02e934e948fb86f8845c1597d','ee9fbf894dda4a169b14be8f3acf4dea标签','投资'),('4','tutor_type','技术指导导师'),('4d55a30cbd034239a357dc1ef36c501c','26c3562aed43428b99444c619622c40b标签','第三产业'),('5','tutor_type','市场环境导师'),('516e26dd0d6c4737a1f506a578f37f65','10b7a9791f2f43af84c15e53c67a31ee标签','第三产业'),('586e373da8d343d19193752df32f8731','d8796d4137e94b8b8219894bfc62f048标签','金融'),('58844c340d6d4ec3905454bffeae4cd8','c1746da4fe1d4e1897f7ea4b12027170标签','电网'),('59cea279a12e43c68b542037bf17bdb2','10b7a9791f2f43af84c15e53c67a31ee标签','电网'),('5b5f4ae5b9ff47b8be31c321b6535ea2','d8796d4137e94b8b8219894bfc62f048标签','第三产业'),('5fa7a9514b4b48f5ad3f4374231af081','74300a7424eb4edebf1bdd1096511480标签','金融'),('5fdbaae6feff4ba8a9525d809f9fcf87','10b7a9791f2f43af84c15e53c67a31ee标签','投资'),('6','fund_scope','20-30'),('60c80a371d114f26ad05cfc93196d513','30bb73da1201471c9b8c3e3d6741697c标签','投资'),('671449aee1be4b92ba8d7ed1f2f3447e','af1929c6704847709eef88a8e15e1f8e标签','投资'),('68bb4a98e24543a1bd44ffc9bc5869b8','d057492a80af42f8a54abcb2b6e0461c标签','第三产业'),('6d3ce7f3444f4bb5b586056a8a17da2e','a9bbb699dfad40d8aefab09e0aaefe44标签','电网'),('7','fund_scope','30-50'),('70e303977ca145f2b965e98f431cab31','ee9fbf894dda4a169b14be8f3acf4dea标签','金融'),('718f8d361b3e485e840c9c3066533454','3e96c028d10b475eb11236700d3072be标签','金融'),('751b575ec0bc4423ae38b20605ff7eac','74300a7424eb4edebf1bdd1096511480标签','投资'),('778d4b4ad779476bbe76bf42454ac968','26c3562aed43428b99444c619622c40b标签','投资'),('79a8f8f6e5f948eeae1bcd6098e9098d','26c3562aed43428b99444c619622c40b标签','电网'),('79d0ba2ce86d4d9baff01d27d4a6efbd','26c3562aed43428b99444c619622c40b标签','金融'),('7a301e24d35447b4bd1f453910f52c98','a9bbb699dfad40d8aefab09e0aaefe44标签','金融'),('7f024e62a23248e685ba0b1fd3e58b8d','0dcaa52e709647c981d2c56555deee01标签','金融'),('8','fund_type','行业投资'),('85db89e5ca6c4996be7c855ccb06a0bc','a9bbb699dfad40d8aefab09e0aaefe44标签','第三产业'),('8e133d00aa644841b05fb62dece8bdd5','ee9fbf894dda4a169b14be8f3acf4dea标签','第三产业'),('9','fund_type','股票基金'),('90f52fd41b484d3c8e87e0ecf469af76','10b7a9791f2f43af84c15e53c67a31ee标签','金融'),('93583007f0634afe81d546aa581755a5','526a0a9e76bb4dc8a7549805da1cbd6b标签','金融'),('940cdf72aaf949c68777274e5ccfe48c','30bb73da1201471c9b8c3e3d6741697c标签','金融'),('94d4eb4818fb48e4bb17ab097218fe93','3e8a239dafe041ed958ded1c2d3e164b标签','电网'),('9f47d49c44ca4775b7c087e304ddc3ce','af1929c6704847709eef88a8e15e1f8e标签','金融'),('a45863c3c2d04ee18cb91edc06da6b33','74300a7424eb4edebf1bdd1096511480标签','电网'),('a46c83b997074e3cb01d895ccc377cec','3e8a239dafe041ed958ded1c2d3e164b标签','金融'),('b146d0813a86479eb15ef6bd0a09c352','c1746da4fe1d4e1897f7ea4b12027170标签','金融'),('b280c1ce875c4baf9af3af561369510b','c1746da4fe1d4e1897f7ea4b12027170标签','投资'),('b4c688b0164b49fab7503d4b70a6cb47','d8796d4137e94b8b8219894bfc62f048标签','投资'),('baa5ebfda10c40188c4526ee29ac9988','ee9fbf894dda4a169b14be8f3acf4dea标签','电网'),('bb98d9ad740049cebe2028d22eeb0a1f','3e8a239dafe041ed958ded1c2d3e164b标签','投资'),('bfd56a6c22244314bc19a5bb7415b1f5','bdab8f31832b4806ba4fbfa781a3a73b标签','金融'),('c2e4ba2635134fc58db75810efb44c26','c1746da4fe1d4e1897f7ea4b12027170标签','第三产业'),('e3c75a7adddf4d07a471b5278c2bc292','74300a7424eb4edebf1bdd1096511480标签','第三产业'),('f723a44530f344ccaf791830ee234968','af1929c6704847709eef88a8e15e1f8e标签','电网'),('fac2ddcb58d348379eb16ed7e53a371d','d057492a80af42f8a54abcb2b6e0461c标签','投资'),('i1','institution_type','融资借贷'),('i2','institution_type','人才培训'),('i3','institution_type','市场咨询'),('i4','institution_type','财务咨询'),('i5','institution_type','场地租赁');
/*!40000 ALTER TABLE `data_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrepreneur`
--

DROP TABLE IF EXISTS `entrepreneur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrepreneur` (
  `id` varchar(32) NOT NULL,
  `degree` varchar(45) DEFAULT NULL,
  `major` varchar(200) DEFAULT NULL,
  `experience` text,
  `resume_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_enterpreneur_user1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrepreneur`
--

LOCK TABLES `entrepreneur` WRITE;
/*!40000 ALTER TABLE `entrepreneur` DISABLE KEYS */;
INSERT INTO `entrepreneur` VALUES ('1','student','计算机','百度',NULL),('13881a9fec404481a61d880eb9a5978a','JuniorHigh','师范','阿里巴巴Boss',NULL),('54454bdc587f4a4e93264afd82cf8769','Master','软件工程','Siemens',NULL);
/*!40000 ALTER TABLE `entrepreneur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `environment_factor`
--

DROP TABLE IF EXISTS `environment_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `environment_factor` (
  `ENVIRONMENT_FACTOR_ID` varchar(32) NOT NULL,
  `POLICY_SUPPORT` float(10,2) NOT NULL DEFAULT '0.00',
  `RESOURCE_SUPPORT_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `ECONOMY_BOOM_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`ENVIRONMENT_FACTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `environment_factor`
--

LOCK TABLES `environment_factor` WRITE;
/*!40000 ALTER TABLE `environment_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `environment_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finance_factor`
--

DROP TABLE IF EXISTS `finance_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finance_factor` (
  `FINANCE_FACTOR_ID` varchar(32) NOT NULL,
  `RETURN_ON_INVESTMENT` float(10,2) NOT NULL DEFAULT '0.00',
  `FINANCE_RECOVER_TIME_AND_BARRIER` float(10,2) NOT NULL DEFAULT '0.00',
  `FINANCE_PLAN_RATIONALITY` float(10,2) NOT NULL DEFAULT '0.00',
  `RETURE_ON_INVESTMENT` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`FINANCE_FACTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finance_factor`
--

LOCK TABLES `finance_factor` WRITE;
/*!40000 ALTER TABLE `finance_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` varchar(32) NOT NULL,
  `follower_id` varchar(32) NOT NULL,
  `followee_id` varchar(32) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_A_ID` (`follower_id`),
  KEY `USER_B_ID` (`followee_id`),
  CONSTRAINT `t_friend_ibfk_1` FOREIGN KEY (`follower_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_friend_ibfk_2` FOREIGN KEY (`followee_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendly_link`
--

DROP TABLE IF EXISTS `friendly_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendly_link` (
  `id` varchar(32) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendly_link`
--

LOCK TABLES `friendly_link` WRITE;
/*!40000 ALTER TABLE `friendly_link` DISABLE KEYS */;
INSERT INTO `friendly_link` VALUES ('0ff36ed736e34bf89868ccd57a1acc54','xjtu','http://www.xjtu.edu.cn','imagepath'),('3907657fd5514e06ba646c1b54d991e2','xjtu','http://www.xjtu.edu.cn','imagepath'),('408b81e3343542569119b622c05a083f','xjtu','http://www.xjtu.edu.cn','imagepath'),('522712615c234599a2ac140491979c79','xjtu','http://www.xjtu.edu.cn','imagepath'),('593599e1d06f42088f6046e506e25c2a','xjtu','http://www.xjtu.edu.cn','imagepath');
/*!40000 ALTER TABLE `friendly_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `help`
--

DROP TABLE IF EXISTS `help`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `help` (
  `id` varchar(32) NOT NULL,
  `help_type` varchar(50) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `help`
--

LOCK TABLES `help` WRITE;
/*!40000 ALTER TABLE `help` DISABLE KEYS */;
/*!40000 ALTER TABLE `help` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `industry`
--

DROP TABLE IF EXISTS `industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `industry` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `saturation` varchar(50) DEFAULT NULL,
  `entry_barrier` varchar(50) DEFAULT NULL,
  `maturity` varchar(50) DEFAULT NULL,
  `scale` varchar(50) DEFAULT NULL,
  `future` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDUSTRY_NAME_UNIQUE` (`name`),
  KEY `22` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry`
--

LOCK TABLES `industry` WRITE;
/*!40000 ALTER TABLE `industry` DISABLE KEYS */;
INSERT INTO `industry` VALUES ('1','信息技术',NULL,NULL,NULL,NULL,NULL,NULL),('10','租赁服务',NULL,NULL,NULL,NULL,NULL,NULL),('11','教育科研',NULL,NULL,NULL,NULL,NULL,NULL),('12','卫生医药',NULL,NULL,NULL,NULL,NULL,NULL),('13','农林牧渔',NULL,NULL,NULL,NULL,NULL,NULL),('2','金融',NULL,NULL,NULL,NULL,NULL,NULL),('3','互联网',NULL,NULL,NULL,NULL,NULL,NULL),('4','制造',NULL,NULL,NULL,NULL,NULL,NULL),('5','建筑',NULL,NULL,NULL,NULL,NULL,NULL),('6','房地产',NULL,NULL,NULL,NULL,NULL,NULL),('7','文体娱乐',NULL,NULL,NULL,NULL,NULL,NULL),('8','住宿餐饮',NULL,NULL,NULL,NULL,NULL,NULL),('9','交通物流',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institution` (
  `id` varchar(32) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `principal` varchar(50) DEFAULT NULL,
  `scale` text,
  `service` text,
  `foster_industry` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_INSTITUTION_USER` (`id`),
  CONSTRAINT `PK_INSTITUTION_USER` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES ('fa79f168e27d4d22aec5614cb1cb1d0c','场地租赁','李开复','600人','写字楼，办公室，会议室租赁','信息技术');
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `type` varchar(50) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  `project_stage` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDUSTRY_ID` (`industry_id`),
  CONSTRAINT `t_entrepreneurship_knowledge_ibfk_1` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_label`
--

DROP TABLE IF EXISTS `knowledge_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_label` (
  `id` varchar(32) NOT NULL,
  `knowledge_id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_knowledge_label_knowledge1_idx` (`knowledge_id`),
  KEY `fk_knowledge_label_label1_idx` (`label_id`),
  CONSTRAINT `fk_knowledge_label_knowledge1` FOREIGN KEY (`knowledge_id`) REFERENCES `knowledge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_knowledge_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_label`
--

LOCK TABLES `knowledge_label` WRITE;
/*!40000 ALTER TABLE `knowledge_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `knowledge_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `id` varchar(32) NOT NULL,
  `count` int(5) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` VALUES ('338c6f5602a141059a335fe4f106a0e6',14,'金融'),('688fd06c02f946a7bc355af101b21294',13,'电网'),('6cef0705253a42a59fec57f5d5cc9be2',13,'投资'),('7e6507c5f5824afca3ae6aab1127d5f6',13,'第三产业');
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `law`
--

DROP TABLE IF EXISTS `law`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `law` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) NOT NULL,
  `publish_time` datetime NOT NULL,
  `content` text NOT NULL,
  `type` varchar(50) NOT NULL,
  `read_count` int(11) DEFAULT '0',
  `project_stage` varchar(50) DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_law_industry1_idx` (`industry_id`),
  CONSTRAINT `fk_law_industry1` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `law`
--

LOCK TABLES `law` WRITE;
/*!40000 ALTER TABLE `law` DISABLE KEYS */;
/*!40000 ALTER TABLE `law` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `law_label`
--

DROP TABLE IF EXISTS `law_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `law_label` (
  `id` varchar(32) NOT NULL,
  `law_id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_law_label_law1_idx` (`law_id`),
  KEY `fk_law_label_label1_idx` (`label_id`),
  CONSTRAINT `fk_law_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_law_label_law1` FOREIGN KEY (`law_id`) REFERENCES `law` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `law_label`
--

LOCK TABLES `law_label` WRITE;
/*!40000 ALTER TABLE `law_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `law_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail`
--

DROP TABLE IF EXISTS `mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mail` (
  `id` varchar(32) NOT NULL,
  `sender_id` varchar(32) NOT NULL,
  `receiver_id` varchar(32) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` text,
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(50) NOT NULL DEFAULT 'UNREAD',
  PRIMARY KEY (`id`),
  KEY `FK_MAIL_SENDER` (`sender_id`),
  KEY `FK_MAIL_RECEIVER` (`receiver_id`),
  CONSTRAINT `FK_MAIL_RECEIVER` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_MAIL_SENDER` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail`
--

LOCK TABLES `mail` WRITE;
/*!40000 ALTER TABLE `mail` DISABLE KEYS */;
/*!40000 ALTER TABLE `mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `management_risk`
--

DROP TABLE IF EXISTS `management_risk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `management_risk` (
  `MANAGEMENT_RISK_ID` varchar(32) NOT NULL,
  `SAFETY_CONTROL_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TAX_PLANNING` float(10,2) NOT NULL DEFAULT '0.00',
  `ORGANIZATION_PROMISE_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`MANAGEMENT_RISK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `management_risk`
--

LOCK TABLES `management_risk` WRITE;
/*!40000 ALTER TABLE `management_risk` DISABLE KEYS */;
/*!40000 ALTER TABLE `management_risk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `management_team`
--

DROP TABLE IF EXISTS `management_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `management_team` (
  `MANAGEMENT_TEAM_ID` varchar(32) NOT NULL,
  `MANAGEMENT_RISK_ID` varchar(32) NOT NULL,
  `CORE_COMPETENCE_ID` varchar(32) NOT NULL,
  `COMMENT` text,
  `LEADER_QUALITY_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`MANAGEMENT_TEAM_ID`),
  KEY `MANAGEMENT_RISK_ID` (`MANAGEMENT_RISK_ID`),
  KEY `CORE_COMPETENCE_ID` (`CORE_COMPETENCE_ID`),
  CONSTRAINT `t_management_team_ibfk_3` FOREIGN KEY (`MANAGEMENT_RISK_ID`) REFERENCES `management_risk` (`MANAGEMENT_RISK_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_management_team_ibfk_4` FOREIGN KEY (`CORE_COMPETENCE_ID`) REFERENCES `team_core_competence` (`TEAM_CORE_COMPETENCE_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `management_team`
--

LOCK TABLES `management_team` WRITE;
/*!40000 ALTER TABLE `management_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `management_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `market_assess_factor`
--

DROP TABLE IF EXISTS `market_assess_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `market_assess_factor` (
  `MARKET_ASSESS_FACTOR_ID` varchar(32) NOT NULL,
  `MARKET_SCALE` float(10,2) NOT NULL DEFAULT '0.00',
  `VALUE_CHAIN_TRANSFER_EFFICIENCY` float(10,2) NOT NULL DEFAULT '0.00',
  `RISE_CONTINUITY` float(10,2) NOT NULL DEFAULT '0.00',
  `ENTRY_BARRIER` float(10,2) NOT NULL DEFAULT '0.00',
  `CLIENT_VALUE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`MARKET_ASSESS_FACTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `market_assess_factor`
--

LOCK TABLES `market_assess_factor` WRITE;
/*!40000 ALTER TABLE `market_assess_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `market_assess_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `need`
--

DROP TABLE IF EXISTS `need`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `need` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) NOT NULL,
  `type` varchar(50) NOT NULL,
  `content` text,
  `publish_time` datetime NOT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `fund_amount` varchar(50) DEFAULT NULL,
  `lack_fund` varchar(50) DEFAULT NULL,
  `fund_type` varchar(50) DEFAULT NULL,
  `project_name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  `area` varchar(200) DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `industry` (`industry_id`),
  KEY `pk_need_user` (`user_id`),
  CONSTRAINT `pk_need_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_need_ibfk_1` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `need`
--

LOCK TABLES `need` WRITE;
/*!40000 ALTER TABLE `need` DISABLE KEYS */;
/*!40000 ALTER TABLE `need` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `need_label`
--

DROP TABLE IF EXISTS `need_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `need_label` (
  `id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  `need_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_need_label_label1_idx` (`label_id`),
  KEY `fk_need_label_need1_idx` (`need_id`),
  CONSTRAINT `fk_need_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_need_label_need1` FOREIGN KEY (`need_id`) REFERENCES `need` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `need_label`
--

LOCK TABLES `need_label` WRITE;
/*!40000 ALTER TABLE `need_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `need_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_info`
--

DROP TABLE IF EXISTS `news_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_info` (
  `id` varchar(32) NOT NULL,
  `news_info_type` varchar(50) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `publish_time` datetime DEFAULT NULL,
  `read_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_info`
--

LOCK TABLES `news_info` WRITE;
/*!40000 ALTER TABLE `news_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  `send_time` datetime DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_ID` (`user_id`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_template`
--

DROP TABLE IF EXISTS `notice_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_template` (
  `id` varchar(32) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `send_time` datetime DEFAULT NULL,
  `notice_type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_template`
--

LOCK TABLES `notice_template` WRITE;
/*!40000 ALTER TABLE `notice_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation_log`
--

DROP TABLE IF EXISTS `operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation_log` (
  `id` varchar(32) NOT NULL,
  `ip` varchar(60) DEFAULT NULL,
  `browser` varchar(45) DEFAULT NULL,
  `operation` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_operation_log_user_idx` (`user_id`),
  CONSTRAINT `fk_operation_log_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_log`
--

LOCK TABLES `operation_log` WRITE;
/*!40000 ALTER TABLE `operation_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) NOT NULL,
  `publish_time` datetime NOT NULL,
  `content` text NOT NULL,
  `type` varchar(50) NOT NULL,
  `area` varchar(100) DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  `read_count` int(11) NOT NULL DEFAULT '0',
  `project_stage` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `INDUSTRY_idx` (`industry_id`),
  CONSTRAINT `INDUSTRY` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_label`
--

DROP TABLE IF EXISTS `policy_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_label` (
  `id` varchar(32) NOT NULL,
  `policy_id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_policy_label_policy1_idx` (`policy_id`),
  KEY `fk_policy_label_label1_idx` (`label_id`),
  CONSTRAINT `fk_policy_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_policy_label_policy1` FOREIGN KEY (`policy_id`) REFERENCES `policy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_label`
--

LOCK TABLES `policy_label` WRITE;
/*!40000 ALTER TABLE `policy_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_technology_factor`
--

DROP TABLE IF EXISTS `product_technology_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_technology_factor` (
  `PRODUCT_TECHNOLOGY_FACTOR_ID` varchar(32) NOT NULL,
  `TECHNOLOGY_SPECIFICALITY` float(10,2) NOT NULL DEFAULT '0.00',
  `TECHNOLOGY_PREVENT_IMITATIVENESS` float(10,2) NOT NULL DEFAULT '0.00',
  `TECHNOLOGY_BREAKTHROUGH` float(10,2) NOT NULL DEFAULT '0.00',
  `TECHNOLOGY_SUBSTITUTABILITY` float(10,2) NOT NULL DEFAULT '0.00',
  `TECHNOLOGY_INDUSTRIALIZATION_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TECHNOLOGY_MARKET_MATCH_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`PRODUCT_TECHNOLOGY_FACTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_technology_factor`
--

LOCK TABLES `product_technology_factor` WRITE;
/*!40000 ALTER TABLE `product_technology_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_technology_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `fund_type` varchar(50) DEFAULT NULL,
  `fund_amount_upper` decimal(20,2) DEFAULT NULL,
  `fund_amount_lower` decimal(20,2) DEFAULT NULL,
  `fund_lack_lower` decimal(20,2) DEFAULT NULL,
  `fund_lack_upper` decimal(20,2) DEFAULT NULL,
  `contact` varchar(32) DEFAULT NULL,
  `introduce` text,
  `area` varchar(50) DEFAULT NULL,
  `management_status` varchar(50) DEFAULT NULL,
  `project_stage` varchar(50) DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  `member_number` int(5) DEFAULT '0',
  `Visitor_number` int(6) DEFAULT '0',
  `project_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_project_industry` (`industry_id`),
  CONSTRAINT `pk_project_industry` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('01c93cfaef4d4756a18c13caac0cd758','eee','2015-08-03 00:00:00','个体经营',20.00,10.00,10.00,20.00,'11','11',NULL,NULL,NULL,NULL,1,0,NULL),('0a8bb7b93c6a42d5864c2a9b575dc26e',NULL,'2015-08-14 00:00:00','个体经营',20.00,10.00,10.00,20.00,NULL,'12312',NULL,NULL,NULL,NULL,1,0,NULL),('1','西藏骑行','2014-08-28 15:44:54','融资',20.00,10.00,10.00,20.00,'156449898','你好啊',NULL,NULL,NULL,NULL,0,0,NULL),('10b7a9791f2f43af84c15e53c67a31ee','你是傻逼','2015-08-01 00:00:00','个体经营',20.00,10.00,10.00,20.00,'11','22',NULL,NULL,NULL,NULL,1,0,NULL),('26c3562aed43428b99444c619622c40b','1111111111111','2015-08-01 00:00:00','个体经营',20.00,10.00,10.00,20.00,'1111111111111','1111111111111',NULL,NULL,NULL,NULL,1,0,NULL),('297a14cee6994022942d95c15eff79ad','麻辣烫1',NULL,'个体经营',20.00,10.00,10.00,20.00,'1','1',NULL,NULL,NULL,NULL,1,0,NULL),('3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL),('30bb73da1201471c9b8c3e3d6741697c','ssss',NULL,'个体经营',20.00,10.00,10.00,20.00,'123456','cccccccccccccccccccccc',NULL,NULL,NULL,NULL,1,0,NULL),('3e8a239dafe041ed958ded1c2d3e164b','3333','2015-08-13 00:00:00','个体经营',20.00,10.00,10.00,20.00,'DDDDDD','NINI',NULL,NULL,NULL,NULL,1,0,NULL),('3f2ff138642b4f0585da7a894f6c7c58','2121',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('4d115642d0d544c0a33b3de4b88758cc','12345678',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('5ffb40810a0841cd96df8412f0e90a37','还不行啊','2015-08-03 00:00:00','个体经营',20.00,10.00,10.00,20.00,'12121','212',NULL,NULL,NULL,NULL,1,0,NULL),('76b52e8c98fb42788c1da503b4d5b83e','er','2015-08-03 00:00:00','个体经营',20.00,10.00,10.00,20.00,'1212','1212',NULL,NULL,NULL,NULL,1,0,NULL),('8ad659c20d794c61886e8e6d43fd1e2a','mm',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('a7c95a6c7b37444f9e97f35e9760c8c3','还不行',NULL,'个体经营',20.00,10.00,10.00,20.00,'1','1',NULL,NULL,NULL,NULL,1,0,NULL),('a9bbb699dfad40d8aefab09e0aaefe44','1111111','2015-08-01 00:00:00','个体经营',20.00,10.00,10.00,20.00,'11111111','11111111',NULL,NULL,NULL,NULL,1,0,NULL),('af1929c6704847709eef88a8e15e1f8e','1111111111111111','2015-08-01 00:00:00','个体经营',20.00,10.00,10.00,20.00,'1111111111','111111111111111',NULL,NULL,NULL,NULL,1,0,NULL),('c1746da4fe1d4e1897f7ea4b12027170','1111111111111','2015-08-01 00:00:00','个体经营',20.00,10.00,10.00,20.00,'222222222222','1111111111111',NULL,NULL,NULL,NULL,1,0,NULL),('c633f658efd449298928d6f1f6523dcd','1212','2015-08-03 00:00:00','个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('d057492a80af42f8a54abcb2b6e0461c','ttttttttttt',NULL,'个体经营',20.00,10.00,10.00,20.00,'2222222222','22222222222222',NULL,NULL,NULL,NULL,1,0,NULL),('d2d96c48ac0a4571a2d1feef74297cdf','212121','2015-08-03 00:00:00','个体经营',20.00,10.00,10.00,20.00,'2112','21',NULL,NULL,NULL,NULL,1,0,NULL),('d490d3e7f04c40b39a14c74fcb9f46ba','wqwq',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('d60b2b3004454104bbc416d8a3ba95a2','wqqw',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('d8796d4137e94b8b8219894bfc62f048','gggggggggg',NULL,'个体经营',20.00,10.00,10.00,20.00,'hhhhhhhhhh','jjjjjjjjjjjjjjjjj',NULL,NULL,NULL,NULL,1,0,NULL),('e2a97c7d02ee4392a5f7ba4c6d6214e7','yy',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('e2d4c8981cb1402ab82b221ff0f5b6f6','121',NULL,'个体经营',20.00,10.00,10.00,20.00,'','',NULL,NULL,NULL,NULL,1,0,NULL),('fb0a26d6a2e84b018edc9e69b4eb556f','111',NULL,'个体经营',20.00,10.00,10.00,20.00,'','11',NULL,NULL,NULL,NULL,1,0,NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_entrepreneur`
--

DROP TABLE IF EXISTS `project_entrepreneur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_entrepreneur` (
  `id` varchar(32) NOT NULL,
  `enterpreneur_id` varchar(32) NOT NULL,
  `project_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id_UNIQUE` (`project_id`),
  KEY `fk_project_entrepreneur_enterpreneur1_idx` (`enterpreneur_id`),
  KEY `fk_project_entrepreneur_t_project1_idx` (`project_id`),
  CONSTRAINT `fk_project_entrepreneur_enterpreneur1` FOREIGN KEY (`enterpreneur_id`) REFERENCES `entrepreneur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_project_entrepreneur_t_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_entrepreneur`
--

LOCK TABLES `project_entrepreneur` WRITE;
/*!40000 ALTER TABLE `project_entrepreneur` DISABLE KEYS */;
INSERT INTO `project_entrepreneur` VALUES ('0767910693fe4ae69f79b2ea4dca4f92','1','e2d4c8981cb1402ab82b221ff0f5b6f6'),('1','54454bdc587f4a4e93264afd82cf8769','1'),('119367e6bfe141b881803814a10e03b5','1','d8796d4137e94b8b8219894bfc62f048'),('1bd47881c51e48d893961ce1e88c2f03','1','fb0a26d6a2e84b018edc9e69b4eb556f'),('27a7f322b81b48a982c0814c00ff7cd3','1','d057492a80af42f8a54abcb2b6e0461c'),('28dc81db9613497c8e9ecc15ec29d77d','1','5ffb40810a0841cd96df8412f0e90a37'),('292ff72d37284a6aaff6c0aa192d2a3d','1','d2d96c48ac0a4571a2d1feef74297cdf'),('46f7977ae49548e0b302432659436809','1','8ad659c20d794c61886e8e6d43fd1e2a'),('4fa86383154a4c5c82fd852ac390235b','1','76b52e8c98fb42788c1da503b4d5b83e'),('5a4b7940b08a4496a1da6d38b8268cf5','1','30bb73da1201471c9b8c3e3d6741697c'),('6893daf868be467b8c48391dbc352668','1','a7c95a6c7b37444f9e97f35e9760c8c3'),('969b7b27959d417099189d9308caa706','1','d490d3e7f04c40b39a14c74fcb9f46ba'),('a2257de5bd194881bd6a5cbc6b31176c','1','4d115642d0d544c0a33b3de4b88758cc'),('b5caef5e28484fd4af3f577f79a0c2f8','1','01c93cfaef4d4756a18c13caac0cd758'),('c6ce4dbd66dc424987ce618921a03c41','1','c633f658efd449298928d6f1f6523dcd'),('c73f3ea24f9244ca9cfd2b74c75efd8a','1','e2a97c7d02ee4392a5f7ba4c6d6214e7'),('e3035ecabb2143e19b5930b0a4fab5e4','1','d60b2b3004454104bbc416d8a3ba95a2'),('f35f9502e7b1477bb4dfe669d0175064','1','3f2ff138642b4f0585da7a894f6c7c58'),('fc6955ad30af4524b62c70f7ab15049f','1','297a14cee6994022942d95c15eff79ad');
/*!40000 ALTER TABLE `project_entrepreneur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_index`
--

DROP TABLE IF EXISTS `project_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_index` (
  `PROJECT_INDEX_ID` varchar(32) NOT NULL,
  `FINANCE_FACTOR_ID` varchar(32) NOT NULL,
  `MARKET_ASSESS_FACTOR_ID` varchar(32) NOT NULL,
  `PRODUCT_TECHNOLOGY_ID` varchar(32) NOT NULL,
  `MANAGEMENT_TEAM_ID` varchar(32) NOT NULL,
  `ENVIRONMENT_FACTOR_ID` varchar(32) NOT NULL,
  `CREATE_TYPE` varchar(50) NOT NULL,
  `TUTOR_ID` varchar(32) DEFAULT NULL,
  `COMMENT` text,
  `TOTAL_SCORE` float NOT NULL,
  `PROJECT_ID` varchar(32) NOT NULL,
  `QUESTIONNAIRE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PROJECT_INDEX_ID`),
  KEY `FINANCE_FACTOR_ID` (`FINANCE_FACTOR_ID`),
  KEY `MARKET_ASSESS_FACTOR_ID` (`MARKET_ASSESS_FACTOR_ID`),
  KEY `PRODUCT_TECHNOLOGY_ID` (`PRODUCT_TECHNOLOGY_ID`),
  KEY `MANAGEMENT_TEAM_ID` (`MANAGEMENT_TEAM_ID`),
  KEY `ENVIRONMENT_FACTOR_ID` (`ENVIRONMENT_FACTOR_ID`),
  KEY `PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `t_project_index_ibfk_10` FOREIGN KEY (`PRODUCT_TECHNOLOGY_ID`) REFERENCES `product_technology_factor` (`PRODUCT_TECHNOLOGY_FACTOR_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_index_ibfk_11` FOREIGN KEY (`MANAGEMENT_TEAM_ID`) REFERENCES `management_team` (`MANAGEMENT_TEAM_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_index_ibfk_12` FOREIGN KEY (`ENVIRONMENT_FACTOR_ID`) REFERENCES `environment_factor` (`ENVIRONMENT_FACTOR_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_index_ibfk_14` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_index_ibfk_8` FOREIGN KEY (`FINANCE_FACTOR_ID`) REFERENCES `finance_factor` (`FINANCE_FACTOR_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_index_ibfk_9` FOREIGN KEY (`MARKET_ASSESS_FACTOR_ID`) REFERENCES `market_assess_factor` (`MARKET_ASSESS_FACTOR_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_index`
--

LOCK TABLES `project_index` WRITE;
/*!40000 ALTER TABLE `project_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_institution`
--

DROP TABLE IF EXISTS `project_institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_institution` (
  `id` varchar(32) NOT NULL,
  `institution_id` varchar(32) NOT NULL,
  `project_id` varchar(32) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `apply_type` varchar(32) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL,
  `apply_status` varchar(32) DEFAULT NULL,
  `agree_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id_UNIQUE` (`project_id`),
  KEY `s` (`project_id`),
  KEY `fk_t_project_institution_institution1_idx` (`institution_id`),
  CONSTRAINT `fk_t_project_institution_institution1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_institution_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_institution`
--

LOCK TABLES `project_institution` WRITE;
/*!40000 ALTER TABLE `project_institution` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_label`
--

DROP TABLE IF EXISTS `project_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_label` (
  `id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  `project_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_project_label_label1_idx` (`label_id`),
  KEY `fk_project_label_project1_idx` (`project_id`),
  CONSTRAINT `fk_project_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_project_label_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_label`
--

LOCK TABLES `project_label` WRITE;
/*!40000 ALTER TABLE `project_label` DISABLE KEYS */;
INSERT INTO `project_label` VALUES ('031423ec041e40c3b32628bba59dc1f2','7e6507c5f5824afca3ae6aab1127d5f6','d490d3e7f04c40b39a14c74fcb9f46ba'),('093b9095f9164c6b94dcbe70019d1706','338c6f5602a141059a335fe4f106a0e6','8ad659c20d794c61886e8e6d43fd1e2a'),('0bd798c92bc1473ab247960e9a9f61c1','6cef0705253a42a59fec57f5d5cc9be2','fb0a26d6a2e84b018edc9e69b4eb556f'),('0de2ad9f5f9e42dbafb4eaec76ab11b3','6cef0705253a42a59fec57f5d5cc9be2','d60b2b3004454104bbc416d8a3ba95a2'),('0fee76652e03470ca9c2fcba63592d95','6cef0705253a42a59fec57f5d5cc9be2','c633f658efd449298928d6f1f6523dcd'),('1058f62d3d91472ab5e2bfca379a2cd9','688fd06c02f946a7bc355af101b21294','d490d3e7f04c40b39a14c74fcb9f46ba'),('13fb6d4d1f034710894506cf663ee590','7e6507c5f5824afca3ae6aab1127d5f6','3f2ff138642b4f0585da7a894f6c7c58'),('1e69d220faa54ec4af2dd77134c34ebd','338c6f5602a141059a335fe4f106a0e6','d2d96c48ac0a4571a2d1feef74297cdf'),('28f87f37903441979254e4b0f46042a0','338c6f5602a141059a335fe4f106a0e6','4d115642d0d544c0a33b3de4b88758cc'),('2bdfa4cd103c4ccc9d9946afabbddf0a','338c6f5602a141059a335fe4f106a0e6','3f2ff138642b4f0585da7a894f6c7c58'),('2cb2ede9bbda4c0a88986468e8256484','338c6f5602a141059a335fe4f106a0e6','a7c95a6c7b37444f9e97f35e9760c8c3'),('2e9b98bcade040d99642294ec4cdd221','7e6507c5f5824afca3ae6aab1127d5f6','76b52e8c98fb42788c1da503b4d5b83e'),('34c8b02032974a9c9f78373afacc66f2','688fd06c02f946a7bc355af101b21294','e2a97c7d02ee4392a5f7ba4c6d6214e7'),('39356128f6a543dd9282b5cbf15edcff','7e6507c5f5824afca3ae6aab1127d5f6','d2d96c48ac0a4571a2d1feef74297cdf'),('495f203603564d7d985b23216248f7d6','688fd06c02f946a7bc355af101b21294','76b52e8c98fb42788c1da503b4d5b83e'),('49a4c54c02d4417b926debbee91249ab','6cef0705253a42a59fec57f5d5cc9be2','e2a97c7d02ee4392a5f7ba4c6d6214e7'),('5b1f5eedf94241f294e1d70f7d7a6aaa','6cef0705253a42a59fec57f5d5cc9be2','a7c95a6c7b37444f9e97f35e9760c8c3'),('5bf20ee7d88f4cc9a7c556f5e42ffa3b','338c6f5602a141059a335fe4f106a0e6','e2a97c7d02ee4392a5f7ba4c6d6214e7'),('64feeb117a6342169f09afb53c09761c','688fd06c02f946a7bc355af101b21294','01c93cfaef4d4756a18c13caac0cd758'),('68a483a0f55045748b1ed06172460b41','338c6f5602a141059a335fe4f106a0e6','d60b2b3004454104bbc416d8a3ba95a2'),('6fc9da06b7a9472785896ee8016aa633','688fd06c02f946a7bc355af101b21294','8ad659c20d794c61886e8e6d43fd1e2a'),('732232eef1a140ce8fdcef3c194b605f','6cef0705253a42a59fec57f5d5cc9be2','d490d3e7f04c40b39a14c74fcb9f46ba'),('74010b72700245cb8e48546646b7e609','6cef0705253a42a59fec57f5d5cc9be2','8ad659c20d794c61886e8e6d43fd1e2a'),('7b889ba0ef7d42afbdd9097a52d76d09','688fd06c02f946a7bc355af101b21294','d2d96c48ac0a4571a2d1feef74297cdf'),('87ef95be1d064e08ba284a82d12dc2e2','688fd06c02f946a7bc355af101b21294','4d115642d0d544c0a33b3de4b88758cc'),('89b9b677139d41cba8954a6638b1dc5e','7e6507c5f5824afca3ae6aab1127d5f6','e2a97c7d02ee4392a5f7ba4c6d6214e7'),('8c77e48ead6c40ccac2bf40d927830c3','688fd06c02f946a7bc355af101b21294','a7c95a6c7b37444f9e97f35e9760c8c3'),('8eb9b48943cd4ec7af5e423ce5893315','338c6f5602a141059a335fe4f106a0e6','fb0a26d6a2e84b018edc9e69b4eb556f'),('94713b07795d42c9924aa340729b733f','338c6f5602a141059a335fe4f106a0e6','e2d4c8981cb1402ab82b221ff0f5b6f6'),('9c34552a16a74d719cee9bdaa622f895','6cef0705253a42a59fec57f5d5cc9be2','3f2ff138642b4f0585da7a894f6c7c58'),('9e4d1bf02ed740a498abcce4de078781','7e6507c5f5824afca3ae6aab1127d5f6','d60b2b3004454104bbc416d8a3ba95a2'),('ac4d90de626f42b8a2bf152ba3ebecc5','7e6507c5f5824afca3ae6aab1127d5f6','01c93cfaef4d4756a18c13caac0cd758'),('b0fdab59d1a540cab53ee0f2e7864272','688fd06c02f946a7bc355af101b21294','3f2ff138642b4f0585da7a894f6c7c58'),('b6029cfa0fe546c0bf0487d257995086','338c6f5602a141059a335fe4f106a0e6','c633f658efd449298928d6f1f6523dcd'),('b795744934954d8da684bef8fd521ecd','338c6f5602a141059a335fe4f106a0e6','76b52e8c98fb42788c1da503b4d5b83e'),('bcb73e17dfac4fd583d8af494d900ad5','688fd06c02f946a7bc355af101b21294','c633f658efd449298928d6f1f6523dcd'),('bf3a55f2401c429d876d327aa95b6107','7e6507c5f5824afca3ae6aab1127d5f6','e2d4c8981cb1402ab82b221ff0f5b6f6'),('c18ccf0756f146debac89485005b4fc1','6cef0705253a42a59fec57f5d5cc9be2','e2d4c8981cb1402ab82b221ff0f5b6f6'),('c1cce200b0a04c0587e4cee527865601','338c6f5602a141059a335fe4f106a0e6','d490d3e7f04c40b39a14c74fcb9f46ba'),('c3f5bf0f88aa4e8b8c2d30d96ce32286','6cef0705253a42a59fec57f5d5cc9be2','76b52e8c98fb42788c1da503b4d5b83e'),('c60b62adff164347b816fb73fa9e2fd9','688fd06c02f946a7bc355af101b21294','e2d4c8981cb1402ab82b221ff0f5b6f6'),('c73fd909505049409f39ba3557f1df41','338c6f5602a141059a335fe4f106a0e6','01c93cfaef4d4756a18c13caac0cd758'),('d744f14203f84d4eba646d64d0ec3ba3','688fd06c02f946a7bc355af101b21294','fb0a26d6a2e84b018edc9e69b4eb556f'),('db5e5200ec024b78b328a3cb7b71b5e6','7e6507c5f5824afca3ae6aab1127d5f6','fb0a26d6a2e84b018edc9e69b4eb556f'),('e14fbc54ddad42cead964f7fb129e195','7e6507c5f5824afca3ae6aab1127d5f6','4d115642d0d544c0a33b3de4b88758cc'),('e172cdb539be459c8ce4954db79d53d9','7e6507c5f5824afca3ae6aab1127d5f6','a7c95a6c7b37444f9e97f35e9760c8c3'),('e1b3797da83e4e76a7e8b57019b1f026','6cef0705253a42a59fec57f5d5cc9be2','4d115642d0d544c0a33b3de4b88758cc'),('e55a83a89fc44c4abde34c72b60a0614','688fd06c02f946a7bc355af101b21294','d60b2b3004454104bbc416d8a3ba95a2'),('ebef192bdebb4df78a73b55294b72610','6cef0705253a42a59fec57f5d5cc9be2','d2d96c48ac0a4571a2d1feef74297cdf'),('f0f11e51f88e46feb71fab0e57a21225','7e6507c5f5824afca3ae6aab1127d5f6','c633f658efd449298928d6f1f6523dcd'),('fe03f252f14541e9bf9683c9b7fe1925','7e6507c5f5824afca3ae6aab1127d5f6','8ad659c20d794c61886e8e6d43fd1e2a'),('fe19e68b72c741d09cd113a2ee5144f4','6cef0705253a42a59fec57f5d5cc9be2','01c93cfaef4d4756a18c13caac0cd758');
/*!40000 ALTER TABLE `project_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_tutor`
--

DROP TABLE IF EXISTS `project_tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_tutor` (
  `id` varchar(32) NOT NULL,
  `tutor_id` varchar(32) NOT NULL,
  `project_id` varchar(32) NOT NULL,
  `access_status` varchar(50) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `score` float(10,2) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `finished_time` datetime DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `grade_status` varchar(50) DEFAULT NULL,
  `project_index_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PROJECT_ID` (`project_id`),
  KEY `PROJECT_INDEX_ID` (`project_index_id`),
  KEY `fk_t_project_tutor_tutor1_idx` (`tutor_id`),
  CONSTRAINT `fk_t_project_tutor_tutor1` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_tutor_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_project_tutor_ibfk_3` FOREIGN KEY (`project_index_id`) REFERENCES `project_index` (`PROJECT_INDEX_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tutor`
--

LOCK TABLES `project_tutor` WRITE;
/*!40000 ALTER TABLE `project_tutor` DISABLE KEYS */;
INSERT INTO `project_tutor` VALUES ('1','12','1',NULL,'hello',NULL,NULL,NULL,NULL,NULL,NULL),('2','12','1',NULL,'hello',NULL,NULL,NULL,NULL,NULL,NULL),('3','12','3',NULL,'hello',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `project_tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` varchar(32) NOT NULL,
  `owner_id` varchar(32) DEFAULT NULL,
  `resource_type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('1','entrepreneur'),('2','tutor'),('3','institution'),('4','administrator');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `authority_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AUTHORITY_ID` (`authority_id`),
  KEY `ROLE_ID` (`role_id`),
  CONSTRAINT `t_role_authority_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_role_authority_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authority`
--

LOCK TABLES `role_authority` WRITE;
/*!40000 ALTER TABLE `role_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply`
--

DROP TABLE IF EXISTS `supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) NOT NULL,
  `type` varchar(50) NOT NULL,
  `content` text,
  `publish_time` datetime NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `industry_id` varchar(32) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  `fund_amount` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_supply_industry` (`industry_id`),
  KEY `pk_supply_user` (`user_id`),
  CONSTRAINT `pk_supply_industry` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pk_supply_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply`
--

LOCK TABLES `supply` WRITE;
/*!40000 ALTER TABLE `supply` DISABLE KEYS */;
INSERT INTO `supply` VALUES ('1','提供码农两只','人力资源','提供码农222222','2015-08-03 00:00:00',NULL,NULL,'5','陕西西安','54454bdc587f4a4e93264afd82cf8769',NULL);
/*!40000 ALTER TABLE `supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply_label`
--

DROP TABLE IF EXISTS `supply_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply_label` (
  `id` varchar(32) NOT NULL,
  `supply_id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supply_label_supply1_idx` (`supply_id`),
  KEY `fk_supply_label_label1_idx` (`label_id`),
  CONSTRAINT `fk_supply_label_label1` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_supply_label_supply1` FOREIGN KEY (`supply_id`) REFERENCES `supply` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply_label`
--

LOCK TABLES `supply_label` WRITE;
/*!40000 ALTER TABLE `supply_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `supply_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_core_competence`
--

DROP TABLE IF EXISTS `team_core_competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_core_competence` (
  `TEAM_CORE_COMPETENCE_ID` varchar(32) NOT NULL,
  `TEAM_ENTREPRENEURSHIP_EXPERIENCE` float(10,2) NOT NULL DEFAULT '0.00',
  `TEAM_PROFESSION_SKILL` float(10,2) NOT NULL DEFAULT '0.00',
  `TEAM_HOMOGENEITY` float(10,2) NOT NULL DEFAULT '0.00',
  `TEAM_MEMBER_FAMILIAR_DEGREE` float(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_SCORE` float(10,2) NOT NULL DEFAULT '0.00',
  `COMMENT` text,
  PRIMARY KEY (`TEAM_CORE_COMPETENCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_core_competence`
--

LOCK TABLES `team_core_competence` WRITE;
/*!40000 ALTER TABLE `team_core_competence` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_core_competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutor` (
  `id` varchar(32) NOT NULL,
  `type` varchar(32) DEFAULT NULL,
  `experience` text,
  `occupation` varchar(200) DEFAULT NULL,
  `tutorship` varchar(200) DEFAULT NULL,
  `average_score` float(32,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_TUTOR_USER` (`id`),
  CONSTRAINT `PK_TUTOR_USER` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES ('1','sshuju','哈哈哈','jabva','daos',12),('10','财务导师','哈哈哈',NULL,NULL,NULL),('11','经营管理导师',NULL,NULL,NULL,NULL),('12','经营管理导师','helloword',NULL,NULL,NULL),('13','财务导师',NULL,NULL,NULL,NULL),('14','财务导师',NULL,NULL,NULL,NULL),('15','财务导师','范德萨发生','发生的发生','发斯蒂芬',0),('16','财务导师',NULL,NULL,NULL,NULL),('17','财务导师',NULL,NULL,NULL,NULL),('18','财务导师',NULL,NULL,NULL,NULL),('19','财务导师',NULL,NULL,NULL,NULL),('20','额度全文',NULL,NULL,NULL,NULL),('21','市场环境导师',NULL,NULL,NULL,NULL),('22','市场环境导师',NULL,NULL,NULL,NULL),('23','市场环境导师',NULL,NULL,NULL,NULL),('24','市场环境导师',NULL,NULL,NULL,NULL),('25','市场环境导师',NULL,NULL,NULL,4545),('26','市场环境导师',NULL,NULL,NULL,NULL),('27','市场环境导师',NULL,NULL,NULL,98),('28','市场环境导师',NULL,NULL,NULL,45),('29','市场环境导师',NULL,NULL,NULL,78),('3','33','fasdfa','333','333',87),('30','市场环境导师',NULL,NULL,NULL,88),('31','市场环境导师',NULL,NULL,NULL,89),('32','市场环境导师',NULL,NULL,NULL,98),('4','5454','srdfsdfae','fsef','fgsrf',7887),('5','67','trete','666','666',98),('54454bdc587f4a4e93264afd82cf8769','454','chsdhoi','454545','fgda',0),('6','技术指导导师','地方','发生的发生','发生的发生',99),('7',NULL,NULL,NULL,NULL,NULL),('8',NULL,NULL,NULL,NULL,NULL),('9',NULL,NULL,NULL,NULL,NULL),('989b1575b4ac4acd9944fa175e8cae32','技术指导导师','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT '未填写',
  `contact` varchar(32) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `introduce` varchar(500) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `head_image` varchar(200) DEFAULT 'head_image_default.png',
  `gender` varchar(2) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `visited_count` int(6) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `EMAIL` (`email`),
  KEY `fk_user_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','2','steven',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('10','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('11','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('12','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('13','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('13881a9fec404481a61d880eb9a5978a','2','马云','222222222','2015-07-01 00:00:00','11111111111','ali@a.com','123456',NULL,'男','333333333','激活','2015-07-29 15:31:20',0),('14','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('15','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('16','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('17','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('18','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('19','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('20','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('21','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('22','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('23','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('24','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('25','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('26','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('27','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('28','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('29','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('3','3','huhu',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('30','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('31','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('32','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('4','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('5','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('54454bdc587f4a4e93264afd82cf8769','1','聂鹏','029-2222222','1988-06-13 00:00:00','代码写的不多','np@np.com','123456',NULL,'男','碑林区咸宁西路28号西安交通大学','激活','2015-07-28 16:03:01',0),('6','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('7','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('8','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('9','2','未填写',NULL,NULL,NULL,'','','head_image_default.png',NULL,NULL,NULL,NULL,0),('989b1575b4ac4acd9944fa175e8cae32','2','唐老师','02922222','2016-01-09 00:00:00','','1@11.com','123456',NULL,'男','','激活','2015-07-29 10:10:26',0),('fa79f168e27d4d22aec5614cb1cb1d0c','3','创新工场','321654','2015-07-18 00:00:00','','i@i.com','123456',NULL,'男','123456','激活','2015-07-29 13:18:57',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_label`
--

DROP TABLE IF EXISTS `user_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_label` (
  `id` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `LABEL_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_user_label_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_label`
--

LOCK TABLES `user_label` WRITE;
/*!40000 ALTER TABLE `user_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-03 21:42:24
