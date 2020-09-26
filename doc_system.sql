/*
Navicat MySQL Data Transfer

Source Server         : MySqL
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : doc_system

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-09-15 17:54:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `ftip` varchar(255) DEFAULT NULL,
  `ctip` varchar(255) DEFAULT NULL,
  `del` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of doc
-- ----------------------------
INSERT INTO `doc` VALUES ('2', '小峰仔的博客', '空你脊瓦', 'mainfactory', 'mainfactory', '2020-08-27 22:18:45', '6', '不错，还可以，继续加油！！！', '写的还行', '0');
INSERT INTO `doc` VALUES ('3', '铁大微视频大赛', '大会忽地外的娃还打回单位', 'mainfactory', 'mainfactory', '2020-08-28 22:35:17', '6', '凑合', '一般吧！！！', '0');
INSERT INTO `doc` VALUES ('4', '清风紫雪', 'B乐团派对\n\n题目：https://ac.nowcoder.com/acm/contest/6874/B\n\n题解：贪心的思路，将能力值从小到大排序，先判断能否组成一个乐队，从后开始遍历往前，如果可以得到一个乐队，那么标记此时的位置。否则，输出-1\n\n标记位置后，开始从头遍历到标记的位置，看最多能组成多少队，在标记位置之前的如果组不成一个就融入到最后那个乐队。', 'mainfactory', 'mainfactory', '2020-08-30 16:12:01', '6', '优秀', '厉害！！', '0');
INSERT INTO `doc` VALUES ('5', '浪味仙', '一直不对外哦多久啊奥剪发年卡开价多少弟娃康乐街号丢还哦到的\n大王卡降低我奥飞外哦豁·\n地位较较低哦哇\n但我爱的\n当年我爱好滴哦\n登记哦哇囧的\n等我啊会哦的', 'mainfactory', '办公室', '2020-08-30 22:13:36', '2', '知识水平低下', null, '1');
INSERT INTO `doc` VALUES ('6', '小风仔', '你的后安抚大家会给iu疯狂加班干活日u国旅可v你是差价哦怕大家哦帝王局\n\n对境外哦的就挖坟挖配件\n大家我啊剪掉\n但我交代', 'mainfactory', '办公室', '2020-08-30 22:26:03', '4', '还不错！！', '还有欠缺', '1');
INSERT INTO `doc` VALUES ('7', '上官婉儿', '等我怀旧佛帕克的老霸道的大奖赛哦豁丢我啊就打完后好大好对挖但我就卡和第五海盗户外活动1', 'mainfactory', 'mainfactory', '2020-08-30 23:07:27', '6', 'good!!!', 'pretty good！！！', '0');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `permissionId` varchar(11) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'cz', '123456', '3', '厂长', '1');
INSERT INTO `users` VALUES ('2', 'fcz', '123456', '2', '副厂长', '1');
INSERT INTO `users` VALUES ('3', 'office', '123456', '1', '办公室', '1');
INSERT INTO `users` VALUES ('4', 'mainfactory', '123456', '0', '主厂区', '1');
INSERT INTO `users` VALUES ('5', 'firstfactory', '123456', '0', '一分区', '1');
INSERT INTO `users` VALUES ('6', 'secondfactory', '123456', '0', '二分区', '1');
INSERT INTO `users` VALUES ('7', 'thirdfactory', '123456', '0', '三分区', '1');
INSERT INTO `users` VALUES ('8', 'salespart', '123456', '0', '销售部门', '1');
INSERT INTO `users` VALUES ('9', 'financepart', '123456', '0', '财务部门', '1');
INSERT INTO `users` VALUES ('10', 'admin', 'admin', '10', '系统管理员', '1');
