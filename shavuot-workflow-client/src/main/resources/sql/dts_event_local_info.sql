/*
MySQL Data Transfer
Source Host: localhost
Source Database: shavuot
Target Host: localhost
Target Database: shavuot
Date: 2017/4/23 18:25:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dts_event_local_info
-- ----------------------------
CREATE TABLE `dts_event_local_info` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `topic` varchar(20) DEFAULT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `retries` int(11) DEFAULT NULL,
  `exception_msg` varchar(4000) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` bigint(22) DEFAULT NULL,
  `update_by` bigint(22) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
