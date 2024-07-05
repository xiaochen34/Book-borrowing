/*
 Navicat Premium Data Transfer

 Source Server         : mysql1010
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 13/10/2023 21:44:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (33, '123', '123', '123', '2023-10-04 19:36:18', NULL, 'fed1c13a35d2a4f811085df5eda6e457');
INSERT INTO `admin` VALUES (37, 'admin', '23534232', '182394322@qq.com', '2023-10-13 21:17:06', NULL, 'fed1c13a35d2a4f811085df5eda6e457');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `publish_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `book_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (27, '喧嚣荧光', '茫茫星海中，一艘以微型双子黑洞为引擎的宇宙探索舰“喧嚣号”正在返回地球，原本顺利的归途却屡遭诡异危机：黑洞引擎反常波动、引力波异常增强、真空中出现恐怖回响……造成这一切的原因，竟是千年以前的一次超新星爆发！\n    人类**舰船遭受重创，险象环生中却隐藏了更大的灾难——超新星爆发产生的高能粒子风暴包裹了整个地球，全体人类危在旦夕！', '2020-07-22', '东南季枫', '四川科学技术出版社', '科幻与奇幻 > 硬科幻', '9787536497900', '2023-10-13 21:34:46', '2023-10-13 00:00:00', 'https://img.alicdn.com/imgextra/i1/707890731/O1CN010aQ1Kx1HGq9UfHhTG_!!707890731.jpg');
INSERT INTO `book` VALUES (28, '触摸星辰', '  一场“瘟疫”来袭，宇宙中的智慧生物大多沦为了“瘟疫”的战争工具。战斗机驾驶员定一为了查明真相击败“瘟疫”，与同僚哈代、刘星辰一道联合地外文明Xenus人，在仅仅三个月的时间内，研制出了对抗“瘟疫”的反调制信息！\n    他们循序渐进，发现了“瘟疫”的真实目的，找到了“瘟疫”的巢穴所在。最后关头，定一成了太阳系里**一个保留自我意识的人类，人类命运掌握在定一手中，是广播出那道反调制信息，回到亲人与朋友的身边？还是留在“瘟疫”身边，上传意识，带领人类飞出太阳系？', '2023-07-13', '邓思渊', '四川科学技术出版社', '科幻与奇幻 > 软科幻', '9787536497597', '2023-10-13 21:35:58', NULL, 'https://img.alicdn.com/imgextra/i4/707890731/O1CN01CblzBB1HGqAtwN1pK_!!707890731.jpg');
INSERT INTO `book` VALUES (29, '飘', '老师推荐世界名著全套正版书籍国外名著经典儿童文学初中生学生青少年必读课外书小学四五六年级阅读 老人与海 简爱 骆驼祥子 童年', '2019-10-01', '玛格丽特·米切尔', '成都地图出版社有限公司', '儿童与青少年 > 儿童小说', '9787555714767', '2023-10-13 21:41:34', NULL, 'https://img.alicdn.com/imgextra/i3/2207944373331/O1CN01UvQiNG1aTdzZJfLpZ_!!2207944373331-0-scmitem176000.jpg');
INSERT INTO `book` VALUES (30, '地下121天长', '正版长青藤 大奖小说系列:地下121天 霍尔曼儿童文学故事书9-12-15岁四五六年级中小学生课外书籍青少年阅读物少儿励志图书', '2021-05-13', '费利斯.霍尔曼', '晨光出版社', '儿童与青少年 > 幼儿读物', '9787541460739', '2023-10-13 21:42:39', NULL, 'https://img.alicdn.com/imgextra/i4/859515618/O1CN01W4eouf1rN5vt7Mi6O_!!859515618.jpg');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `book_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `Return` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `borrowstatus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (27, '触摸星辰', '9787536497597', '20231013625532160', '青鸟啼', NULL, '2023-10-13 21:36:59', NULL, NULL, NULL, '未归还');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (12, '2啊啊啊', 'AA', 11, '2023-10-05 11:29:17', NULL);
INSERT INTO `category` VALUES (13, '娃娃', '王', 11, '2023-10-05 11:30:23', NULL);
INSERT INTO `category` VALUES (14, '232', '323', 11, '2023-10-05 11:30:53', NULL);
INSERT INTO `category` VALUES (24, '22', '2', 18, '2023-10-05 11:45:00', NULL);
INSERT INTO `category` VALUES (25, '33', NULL, 23, '2023-10-05 14:01:45', NULL);
INSERT INTO `category` VALUES (27, 'iij', 'ijj', 26, '2023-10-05 19:50:15', NULL);
INSERT INTO `category` VALUES (28, '小说', '包括虚构故事，通常由小说家编写。', NULL, '2023-10-13 21:18:53', NULL);
INSERT INTO `category` VALUES (30, '诗歌', '括各种诗歌形式，从古典到现代诗歌。', NULL, '2023-10-13 21:20:00', NULL);
INSERT INTO `category` VALUES (31, '科幻与奇幻', '包含科幻和奇幻小说以及相关子类别。', NULL, '2023-10-13 21:20:31', NULL);
INSERT INTO `category` VALUES (32, '儿童与青少年', '适用于儿童和青少年读者的图书。', NULL, '2023-10-13 21:20:40', NULL);
INSERT INTO `category` VALUES (33, '悬疑与惊悚', '包括紧张的情节和未解之谜的小说。', NULL, '2023-10-13 21:20:51', NULL);
INSERT INTO `category` VALUES (34, '侦探小说', '包括以侦探工作和犯罪解谜为中心的悬疑小说。', 33, '2023-10-13 21:21:48', NULL);
INSERT INTO `category` VALUES (35, '恐怖小说', '涵盖各种吓人、恐怖和超自然元素的小说，旨在引发恐怖感。', 33, '2023-10-13 21:22:00', NULL);
INSERT INTO `category` VALUES (36, '神秘小说', '包括充满谜团和未解之谜的小说，强调解谜过程。', 33, '2023-10-13 21:22:07', NULL);
INSERT INTO `category` VALUES (37, '幼儿读物', '适合婴幼儿和幼儿的图书，包括绘本和亲子阅读材料。', 32, '2023-10-13 21:22:23', NULL);
INSERT INTO `category` VALUES (38, '儿童小说', '面向儿童读者的虚构小说，以满足他们的年龄和兴趣。', 32, '2023-10-13 21:22:34', NULL);
INSERT INTO `category` VALUES (39, '古典诗歌', '包括古代文学中的各种经典诗歌作品，如《诗经》和莎士比亚的 sonnets。', 30, '2023-10-13 21:22:59', NULL);
INSERT INTO `category` VALUES (40, '现代诗歌', '涵盖20世纪及之后的现代诗歌创作，包括各种风格和流派。', 30, '2023-10-13 21:23:07', NULL);
INSERT INTO `category` VALUES (41, '硬科幻', '强调科学和技术的科幻小说，注重科学真实性和可行性。', 31, '2023-10-13 21:23:24', NULL);
INSERT INTO `category` VALUES (42, '软科幻', '包括更注重社会和人类经验的科幻故事，可以包含未来和外太空元素。', 31, '2023-10-13 21:23:38', NULL);
INSERT INTO `category` VALUES (43, '魔幻小说', '包括充满魔法、奇幻世界和魔幻生物的小说。', 31, '2023-10-13 21:23:47', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (33, '云风雨', '202310131555310978', 23, '男', '2131221323213', '北京市东城区王府井大街123号', '2023-10-13 21:15:19', NULL);
INSERT INTO `user` VALUES (34, '青鸟啼', '20231013625532160', 33, '男', '2232323323', '上海市浦东新区陆家嘴中路456号', '2023-10-13 21:15:40', NULL);
INSERT INTO `user` VALUES (35, '清泉流', '20231013862603785', 23, '女', '3434322334', '深圳市南山区深南大道1010号', '2023-10-13 21:15:58', NULL);
INSERT INTO `user` VALUES (36, '时光慢', '20231013995868875', 43, '男', '23235454', '成都市武侯区锦江大道234号', '2023-10-13 21:16:14', NULL);

SET FOREIGN_KEY_CHECKS = 1;
