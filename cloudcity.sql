/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : cloudcity

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-03-03 17:27:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `area_id` varchar(255) DEFAULT NULL COMMENT '上级id',
  `LEVEL` int(11) DEFAULT NULL COMMENT '级别',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `area_telno` int(11) DEFAULT NULL COMMENT '地区区号',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='区域表';

-- ----------------------------
-- Records of tb_area
-- ----------------------------

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `字段46` varchar(4000) DEFAULT NULL,
  `字段47` varchar(4000) DEFAULT NULL,
  `字段48` varchar(4000) DEFAULT NULL,
  `字段49` varchar(4000) DEFAULT NULL,
  `字段50` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单';

-- ----------------------------
-- Records of tb_orders
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `brand_id` varchar(255) DEFAULT NULL COMMENT '品牌id',
  `category_id` varchar(255) DEFAULT NULL COMMENT '分类id',
  `review_id` varchar(255) DEFAULT NULL COMMENT '评论id',
  `sku_id` varchar(255) DEFAULT NULL COMMENT '库存id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `product_number` varchar(30) DEFAULT NULL COMMENT '编号',
  `market_price` double(23,6) DEFAULT NULL COMMENT '市场价',
  `member_price` double(23,6) DEFAULT NULL COMMENT '会员价',
  `praise_rate` double(23,6) DEFAULT NULL COMMENT '好评率',
  `cover_image` varchar(200) DEFAULT NULL COMMENT '商品封面',
  `second_image` varchar(200) DEFAULT NULL COMMENT '商品图片',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '商品详情',
  `score_number` int(11) DEFAULT NULL COMMENT '评分数',
  `point_number` int(11) DEFAULT NULL COMMENT '商品积分数',
  `is_index` int(11) DEFAULT NULL COMMENT '是否首页',
  `is_recommend` int(11) DEFAULT NULL COMMENT '是否推荐',
  `is_top` int(11) DEFAULT NULL COMMENT '是否置顶',
  `is_hot` int(11) DEFAULT NULL COMMENT '是否热点',
  `is_sell` int(11) DEFAULT NULL COMMENT '是否上架',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `stock_number` int(11) DEFAULT NULL COMMENT '总数量',
  `surplus_number` int(11) DEFAULT NULL COMMENT '剩余商品',
  `sold_number` int(11) DEFAULT NULL COMMENT '已售商品',
  `start_time` datetime DEFAULT NULL COMMENT '开始日期',
  `end_time` datetime DEFAULT NULL COMMENT '截止日期',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品表';

-- ----------------------------
-- Records of tb_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_brand`;
CREATE TABLE `tb_product_brand` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `ico` varchar(200) DEFAULT NULL COMMENT '图标',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 是否删除 是否删除 是否删除 1、是 2、否',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='品牌表';

-- ----------------------------
-- Records of tb_product_brand
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_brand_categroy
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_brand_categroy`;
CREATE TABLE `tb_product_brand_categroy` (
  `uuid` int(11) NOT NULL COMMENT '主键',
  `brand_id` varchar(4000) DEFAULT NULL COMMENT '品牌id',
  `category_id` varchar(4000) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='品牌分类关联表';

-- ----------------------------
-- Records of tb_product_brand_categroy
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `category_id` varchar(255) DEFAULT NULL COMMENT '上级id',
  `LEVEL` int(11) DEFAULT NULL COMMENT '级别',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `category_code` varchar(20) DEFAULT NULL COMMENT '分类CODE',
  `Is_Delete` int(11) DEFAULT NULL COMMENT '是否删除 是否删除 是否删除 是否删除 1、是 2、否',
  `clas_attribute` varchar(255) DEFAULT NULL COMMENT '类目属性code',
  `sales_information` varchar(255) DEFAULT NULL COMMENT '销售信息code 多的已逗号隔开',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='分类表';

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_dictionary`;
CREATE TABLE `tb_product_dictionary` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `CODE` varchar(30) DEFAULT NULL COMMENT '编码code',
  `name` varchar(30) DEFAULT NULL COMMENT '键',
  `VALUES` varchar(30) DEFAULT NULL COMMENT '值',
  `LEVEL` int(11) DEFAULT NULL COMMENT '级别',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品字典表';

-- ----------------------------
-- Records of tb_product_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_review
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_review`;
CREATE TABLE `tb_product_review` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `user_id` varchar(255) DEFAULT NULL COMMENT '会员id',
  `product_id` varchar(255) DEFAULT NULL COMMENT '商品ID',
  `point_number` int(11) DEFAULT NULL COMMENT '分值',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '评论内容',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品评论';

-- ----------------------------
-- Records of tb_product_review
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_stock`;
CREATE TABLE `tb_product_stock` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `combination_id` varchar(255) DEFAULT NULL COMMENT '组合商品id',
  `product_id` varchar(255) DEFAULT NULL COMMENT '商品_id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品库存';

-- ----------------------------
-- Records of tb_product_stock
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_admin`;
CREATE TABLE `tb_sys_admin` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role_id` varchar(255) DEFAULT NULL COMMENT '所属角色',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `status` int(11) DEFAULT NULL COMMENT '状态 状态 状态 状态 1正常 2.禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='管理员表';

-- ----------------------------
-- Records of tb_sys_admin
-- ----------------------------
INSERT INTO `tb_sys_admin` VALUES ('49362091e4a84140b69e9e6a1d40cba5', '李四5', null, null, null, null, null, '2020-03-03 11:01:47', '2020-03-03 11:01:47');
INSERT INTO `tb_sys_admin` VALUES ('57e54a6034f24b4d869ea88670fc41d4', '李四12', null, null, null, null, null, '2020-03-03 11:02:10', '2020-03-03 11:02:10');
INSERT INTO `tb_sys_admin` VALUES ('59bb4d1d1be4478f8b2e03fe7090162f', '11张三', '18588773304', null, null, null, null, '2020-03-03 09:53:05', '2020-03-03 09:53:05');
INSERT INTO `tb_sys_admin` VALUES ('66f54abf8ed54faeae09db98d624d280', 'admin', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', null, null, '1', '2020-03-03 11:30:16', '2020-03-03 11:33:12');
INSERT INTO `tb_sys_admin` VALUES ('766adef1addd4369b5f85aa59150a445', '李四7', null, null, null, null, null, '2020-03-03 11:01:52', '2020-03-03 11:01:52');
INSERT INTO `tb_sys_admin` VALUES ('7ed724ee337448fca3b52963c68f2820', '李四3', null, null, null, null, null, '2020-03-03 11:01:32', '2020-03-03 11:01:32');
INSERT INTO `tb_sys_admin` VALUES ('929276134cd243f98405d7277bfbdf09', 'sdasdfgd', '185887733', null, null, null, null, '2020-03-02 17:24:01', '2020-03-02 17:24:01');
INSERT INTO `tb_sys_admin` VALUES ('9f06be4864144accb4079e42d734642e', '李四9', null, null, null, null, null, '2020-03-03 11:02:00', '2020-03-03 11:02:00');
INSERT INTO `tb_sys_admin` VALUES ('a71705c9e7db438892732ac1e5f832d2', '李四8', null, null, null, null, null, '2020-03-03 11:01:57', '2020-03-03 11:01:57');
INSERT INTO `tb_sys_admin` VALUES ('ab4892f7210d4e7faa7d9f0f828943a9', '李四2', null, null, null, null, null, '2020-03-03 11:01:30', '2020-03-03 11:01:30');
INSERT INTO `tb_sys_admin` VALUES ('d9e76fbf9f484317b14be0ae8b130d32', '李四6', null, null, null, null, null, '2020-03-03 11:01:50', '2020-03-03 11:01:50');
INSERT INTO `tb_sys_admin` VALUES ('dadb0f55eefb420bac9314ad0acaee0f', '李四10', null, null, null, null, null, '2020-03-03 11:02:02', '2020-03-03 11:02:02');
INSERT INTO `tb_sys_admin` VALUES ('dde1d2ba205b4997bfd97ddb9a3d088d', '李四1', null, null, null, null, null, '2020-03-03 11:01:27', '2020-03-03 11:01:27');
INSERT INTO `tb_sys_admin` VALUES ('e81ec4bb6d224d959c12798b03b76d91', 'sdasd12fgd', '185887733', null, null, null, null, '2020-03-02 17:24:47', '2020-03-02 17:24:47');
INSERT INTO `tb_sys_admin` VALUES ('ea2a0072ad5a4ababd31ca12a1554018', '李四11', null, null, null, null, null, '2020-03-03 11:02:08', '2020-03-03 11:02:08');
INSERT INTO `tb_sys_admin` VALUES ('f306c7eff4864673afbd3a79d08494de', '李四4', null, null, null, null, null, '2020-03-03 11:01:34', '2020-03-03 11:01:34');

-- ----------------------------
-- Table structure for tb_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_menu`;
CREATE TABLE `tb_sys_menu` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `LEVEL` int(11) DEFAULT NULL COMMENT '级别',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `url` varchar(255) DEFAULT NULL COMMENT '路径',
  `menu_uuid` varchar(255) DEFAULT NULL COMMENT '上级菜单',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单表';

-- ----------------------------
-- Records of tb_sys_menu
-- ----------------------------
INSERT INTO `tb_sys_menu` VALUES ('31c9186e39a74d4f8be48b5d4d7b861f', '功能模块', '0', '', '', '0', '0', '2020-03-03 17:21:49', '2020-03-03 17:22:22');

-- ----------------------------
-- Table structure for tb_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role`;
CREATE TABLE `tb_sys_role` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of tb_sys_role
-- ----------------------------
INSERT INTO `tb_sys_role` VALUES ('ae059ee021ca4fec890eee47c720005a', 'sdfsdfdsfdsfsdf', '', '0', '2020-03-03 17:04:16', '2020-03-03 17:05:02');

-- ----------------------------
-- Table structure for tb_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role_menu`;
CREATE TABLE `tb_sys_role_menu` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(255) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色菜单资源表';

-- ----------------------------
-- Records of tb_sys_role_menu
-- ----------------------------
INSERT INTO `tb_sys_role_menu` VALUES ('17eb5c56f8824e8d9de1f8dd6e7298fb', '12', '2222222');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `nickname` varchar(10) DEFAULT NULL COMMENT '昵称',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `head_imageurl` varchar(255) DEFAULT NULL COMMENT '会员头像图片',
  `mobile` int(11) DEFAULT NULL COMMENT '手机',
  `point_number` int(11) DEFAULT NULL COMMENT '会员积分',
  `level_id` varchar(255) DEFAULT NULL COMMENT '级别id',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `province_id` varchar(50) DEFAULT NULL COMMENT '省',
  `city_id` varchar(50) DEFAULT NULL COMMENT '市',
  `area_id` varchar(50) DEFAULT NULL COMMENT '区',
  `address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='会员表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_address`;
CREATE TABLE `tb_user_address` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `user_id` varchar(255) DEFAULT NULL COMMENT '会员id',
  `is_use` int(11) DEFAULT NULL COMMENT '当前地址 0=不是，1=是',
  `receive_name` varchar(50) DEFAULT NULL COMMENT '收货人',
  `phone` int(11) DEFAULT NULL COMMENT '手机',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `province_id` varchar(255) DEFAULT NULL COMMENT '省',
  `city_id` varchar(255) DEFAULT NULL COMMENT '市',
  `area_id` varchar(255) DEFAULT NULL COMMENT '区',
  `CreateDate` varchar(2000) DEFAULT NULL COMMENT '详细地址',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='会员收货地址';

-- ----------------------------
-- Records of tb_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_collect
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_collect`;
CREATE TABLE `tb_user_collect` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `product_id` varchar(255) DEFAULT NULL COMMENT '商品_id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '会员ID',
  `TYPE` int(11) DEFAULT NULL COMMENT '类型 1、收藏 2、关注',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='会员收藏表、关注';

-- ----------------------------
-- Records of tb_user_collect
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_level
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_level`;
CREATE TABLE `tb_user_level` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `grade_name` varchar(20) DEFAULT NULL COMMENT '等级',
  `grade_number` int(11) DEFAULT NULL COMMENT '等级分值',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='会员级别';

-- ----------------------------
-- Records of tb_user_level
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_wx
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_wx`;
CREATE TABLE `tb_user_wx` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信用户唯一id',
  `bind_user` varchar(255) DEFAULT NULL COMMENT '绑定的people用户',
  `gender` int(1) DEFAULT NULL COMMENT '性别 性别（1.男 2女）',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE,
  KEY `IDX_tb_user_wx_bind_user` (`bind_user`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微信登录的用户表';

-- ----------------------------
-- Records of tb_user_wx
-- ----------------------------
