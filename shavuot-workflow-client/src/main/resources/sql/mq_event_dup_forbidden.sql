/*
MySQL Data Transfer
Source Host: localhost
Source Database: activiti
Target Host: localhost
Target Database: activiti
Date: 2017/4/23 18:25:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for mq_event_dup_forbidden
-- ----------------------------
CREATE TABLE `mq_event_dup_forbidden` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `source` varchar(50) DEFAULT NULL,
  `seq` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `mq_event_dup_forbidden` VALUES ('1', 'startProcess', '11');
