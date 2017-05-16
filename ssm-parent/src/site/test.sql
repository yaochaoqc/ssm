/*
Navicat MySQL Data Transfer

Source Server         : 192.168.23.10_3306
Source Server Version : 50717
Source Host           : 192.168.23.10:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-14 14:39:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '用户编号',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `isSuper` int(2) DEFAULT NULL COMMENT '是否为管理员(1:是,2:否)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('29ca1e1cb38f404db115b27691189682', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', '1');
INSERT INTO `user` VALUES ('33bd35d3eec14e89b90eb813bdebd27d', 'test', 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3', '0');
