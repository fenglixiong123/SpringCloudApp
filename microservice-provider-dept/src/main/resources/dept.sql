DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO `dept` VALUES ('1', '开发部', 'clouddb01');
INSERT INTO `dept` VALUES ('2', '人事部', 'clouddb01');
INSERT INTO `dept` VALUES ('3', '财务部', 'clouddb01');
INSERT INTO `dept` VALUES ('4', '市场部', 'clouddb01');
INSERT INTO `dept` VALUES ('5', '运维部', 'clouddb01');
INSERT INTO `dept` VALUES ('6', '开心部', 'clouddb01');
