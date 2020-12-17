/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : chapter20_ssm

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 17/12/2020 12:54:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) NOT NULL,
  `booktype` int(2) NOT NULL,
  `bookauthor` varchar(45) NOT NULL,
  `publishpress` varchar(200) NOT NULL,
  `publishdate` date NOT NULL,
  `isborrow` int(2) NOT NULL,
  `createdBy` varchar(45) NOT NULL,
  `creat_time` date NOT NULL,
  `last_update_time` date NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
BEGIN;
INSERT INTO `bookinfo` VALUES (1, 'java编程思想', 1, '阿科尔', '机械工业出版社', '2018-10-15', 2, '大飞', '2018-10-09', '2018-10-09');
INSERT INTO `bookinfo` VALUES (2, '遮天', 2, '陈东', '新华出版社', '2010-10-17', 1, '大飞', '2018-10-01', '2018-10-24');
INSERT INTO `bookinfo` VALUES (3, '巴黎圣母艳', 3, '雨果', '机械工业出版社', '2018-10-17', 2, '大飞', '2018-10-16', '2018-10-08');
INSERT INTO `bookinfo` VALUES (4, '呼啸山庄', 3, '艾米丽', '中原出版社', '2018-10-09', 2, '大飞', '2018-10-07', '2018-10-26');
INSERT INTO `bookinfo` VALUES (5, '安娜', 3, '雷夫', '机械工业出版社', '2018-10-09', 1, '大飞', '2018-10-01', '2018-10-01');
INSERT INTO `bookinfo` VALUES (6, '盗墓笔记', 2, '南派三叔', '新华出版社', '2018-10-09', 1, '大飞', '2018-10-01', '2018-10-01');
INSERT INTO `bookinfo` VALUES (7, '一世之尊', 2, '乌贼', '新华出版社', '2018-10-09', 1, '大飞', '2018-10-01', '2018-10-01');
COMMIT;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '研发部');
INSERT INTO `dept` VALUES (2, '人事部');
COMMIT;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(30) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `dno` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `dno` (`dno`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`dno`) REFERENCES `dept` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
BEGIN;
INSERT INTO `emp` VALUES (1, '聪聪', 15000, 1);
INSERT INTO `emp` VALUES (2, '邦邦', 5000, 1);
INSERT INTO `emp` VALUES (3, '美美', 6000, 2);
INSERT INTO `emp` VALUES (4, '小风', 8000, 2);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, 'dianshi', 900);
INSERT INTO `orders` VALUES (2, 'xiyiji', 100);
INSERT INTO `orders` VALUES (3, 'xiyifen', 90);
INSERT INTO `orders` VALUES (4, 'dianshi', 900);
INSERT INTO `orders` VALUES (5, 'xiyifen', 90);
INSERT INTO `orders` VALUES (6, 'xiyifen', 90);
INSERT INTO `orders` VALUES (7, 'dahai', 400);
INSERT INTO `orders` VALUES (8, 'ace', 400);
INSERT INTO `orders` VALUES (9, 'ace1', 400);
COMMIT;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
BEGIN;
INSERT INTO `stu` VALUES (1, 'qwer');
INSERT INTO `stu` VALUES (2, 'tom');
INSERT INTO `stu` VALUES (3, 'tom');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (13, '张三', '北京', '2020-11-11');
INSERT INTO `sys_user` VALUES (14, '张三2', '北京2', '2020-11-11');
INSERT INTO `sys_user` VALUES (15, '张三3', '北京3', '2020-11-11');
INSERT INTO `sys_user` VALUES (16, '张三4', '北4', '2020-11-11');
INSERT INTO `sys_user` VALUES (17, '张三5', '北京5', '2020-11-11');
INSERT INTO `sys_user` VALUES (18, '张三6', '北京6', '2020-11-11');
INSERT INTO `sys_user` VALUES (19, '张三7', '北京7', '2020-11-11');
INSERT INTO `sys_user` VALUES (20, '张三8', '北京8', '2020-11-11');
COMMIT;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
BEGIN;
INSERT INTO `tb_department` VALUES ('10005', 'AI人工智能开发部');
INSERT INTO `tb_department` VALUES ('10004', 'BigData开发部');
INSERT INTO `tb_department` VALUES ('10001', 'Java开发部');
INSERT INTO `tb_department` VALUES ('10003', 'Python开发部');
INSERT INTO `tb_department` VALUES ('10002', '测试部');
COMMIT;

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` varchar(15) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `hireDate` date DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `dept_id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_employee_dept_id_FK` (`dept_id`),
  CONSTRAINT `tb_employee_dept_id_FK` FOREIGN KEY (`dept_id`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
BEGIN;
INSERT INTO `tb_employee` VALUES ('11111', '李晓明', 1, '2003-03-05', 8000, '10001');
INSERT INTO `tb_employee` VALUES ('123', 'duanguizhou123', 1, '2020-09-16', 3000, '10005');
INSERT INTO `tb_employee` VALUES ('22222', '应毅', 1, '2004-03-05', 10000, '10004');
INSERT INTO `tb_employee` VALUES ('33333', '李菲', 0, '2006-03-05', 8000, '10002');
COMMIT;

-- ----------------------------
-- Table structure for tb_loginUser
-- ----------------------------
DROP TABLE IF EXISTS `tb_loginUser`;
CREATE TABLE `tb_loginUser` (
  `userName` varchar(30) NOT NULL,
  `loginPwd` varchar(15) NOT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_loginUser
-- ----------------------------
BEGIN;
INSERT INTO `tb_loginUser` VALUES ('ace', '123456', 1);
COMMIT;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `gender` char(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `entry_data` date DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `resume` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
BEGIN;
INSERT INTO `test` VALUES (1, 'hello', NULL, NULL, NULL, 'it', 4000, NULL);
INSERT INTO `test` VALUES (2, 'tom', 'nan', '1990-11-11', '2018-11-11', 'it', 4000, 'hro');
INSERT INTO `test` VALUES (3, '美美', 'nan', '1990-11-11', '2018-11-11', 'it', 4000, 'hro');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'ace');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `registertime` date NOT NULL,
  `lastlogintime` date NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'admin', '123', '123@163.com', '男', '2018-10-01', '2018-10-17');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
