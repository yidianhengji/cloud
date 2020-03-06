/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : cloudcity

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-03-06 16:19:47
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
  `content` varchar(2000) DEFAULT NULL COMMENT '商品详情',
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
INSERT INTO `tb_product_brand` VALUES ('e2654212838c4e0faa61602be2452acb', '', '', '华为手机', '0', '2020-03-06 14:11:03', '2020-03-06 14:10:29');
INSERT INTO `tb_product_brand` VALUES ('f071d7e9662c4966bc961a2dd5580e06', '', '', '苹果手机', '0', '2020-03-06 14:10:43', '2020-03-06 14:10:43');

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
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `category_code` varchar(20) DEFAULT NULL COMMENT '分类CODE',
  `Is_delete` int(11) DEFAULT NULL COMMENT '是否删除 是否删除 是否删除 是否删除 1、是 2、否',
  `clas_attribute` varchar(255) DEFAULT NULL COMMENT '类目属性code',
  `sales_information` varchar(255) DEFAULT NULL COMMENT '销售信息code 多的已逗号隔开',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='分类表';

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------
INSERT INTO `tb_product_category` VALUES ('1e115095ea564059a4318b4e2e09fffc', '58628f6638f24fb7850f9fcd5430c1c5', '0', '冰箱冷柜', '', '0', '', '', '2020-03-06 14:39:29', '2020-03-06 14:39:29');
INSERT INTO `tb_product_category` VALUES ('58628f6638f24fb7850f9fcd5430c1c5', '', '0', '电器', '', '0', '', '', '2020-03-06 14:39:00', '2020-03-06 14:39:00');
INSERT INTO `tb_product_category` VALUES ('6cf09a5c2a9f41ec88122136f9b3499c', '715ed401b9084ba7b5b1f644823a2fa0', '0', '手机耳机', '', '0', '', '', '2020-03-06 14:38:08', '2020-03-06 14:38:08');
INSERT INTO `tb_product_category` VALUES ('715ed401b9084ba7b5b1f644823a2fa0', '', '0', '手机', '', '0', '', '', '2020-03-06 14:37:21', '2020-03-06 14:37:21');
INSERT INTO `tb_product_category` VALUES ('8110032542fa4b698e63c2ac0f4c6c44', '58628f6638f24fb7850f9fcd5430c1c5', '0', '洗衣机', '', '0', '', '', '2020-03-06 14:39:35', '2020-03-06 14:39:35');
INSERT INTO `tb_product_category` VALUES ('8131de22604648e9a7484b08361f9344', '58628f6638f24fb7850f9fcd5430c1c5', '0', '烤箱', '', '0', '', '', '2020-03-06 14:39:40', '2020-03-06 14:39:40');
INSERT INTO `tb_product_category` VALUES ('9a7e95e73477427b9c100db7f9478540', '58628f6638f24fb7850f9fcd5430c1c5', '0', '厨房小电器', '', '0', '', '', '2020-03-06 14:39:19', '2020-03-06 14:39:19');
INSERT INTO `tb_product_category` VALUES ('b0eaae34b9404212ad273de78b7c8899', '715ed401b9084ba7b5b1f644823a2fa0', '0', '充电宝', '', '0', '', '', '2020-03-06 14:38:14', '2020-03-06 14:38:14');
INSERT INTO `tb_product_category` VALUES ('b4d955171aa748e68d5b866ba4d0b8d3', '715ed401b9084ba7b5b1f644823a2fa0', '0', '手机贴纸', '', '0', '', '', '2020-03-06 14:38:26', '2020-03-06 14:38:26');
INSERT INTO `tb_product_category` VALUES ('c0ffce2764784834a6a05f768a99694e', '715ed401b9084ba7b5b1f644823a2fa0', '0', '手机壳', '', '0', '', '', '2020-03-06 14:37:59', '2020-03-06 14:37:59');
INSERT INTO `tb_product_category` VALUES ('ec72bf1a98c446569777fa77defb875a', '58628f6638f24fb7850f9fcd5430c1c5', '0', '电视机', '', '0', '', '', '2020-03-06 14:39:10', '2020-03-06 14:39:10');
INSERT INTO `tb_product_category` VALUES ('f80a12579f6246f29c0846bcb35147ef', '715ed401b9084ba7b5b1f644823a2fa0', '0', '手机挂件', '', '0', '', '', '2020-03-06 14:38:38', '2020-03-06 14:38:38');
INSERT INTO `tb_product_category` VALUES ('ffe1b5ff9dfa43f2875e87a0688d43a4', '715ed401b9084ba7b5b1f644823a2fa0', '0', '手机支架', '', '0', '', '', '2020-03-06 14:38:32', '2020-03-06 14:38:32');

-- ----------------------------
-- Table structure for tb_product_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_dictionary`;
CREATE TABLE `tb_product_dictionary` (
  `uuid` varchar(255) NOT NULL COMMENT '主键',
  `code` varchar(30) DEFAULT NULL COMMENT '编码code',
  `name` varchar(30) DEFAULT NULL COMMENT '键',
  `values` varchar(30) DEFAULT NULL COMMENT '值',
  `level` int(11) DEFAULT NULL COMMENT '级别',
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
  `status` int(11) unsigned zerofill DEFAULT NULL COMMENT '状态 状态 状态 状态 1正常 2.禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='管理员表';

-- ----------------------------
-- Records of tb_sys_admin
-- ----------------------------
INSERT INTO `tb_sys_admin` VALUES ('04512791d3c6489393e18fa678c266d7', 'admin', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:45:13', '2020-03-06 16:17:18');
INSERT INTO `tb_sys_admin` VALUES ('21bb101b8bb3445ba120c0f6aa1295dd', '张三2', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:45:57', '2020-03-06 15:45:57');
INSERT INTO `tb_sys_admin` VALUES ('296fa0a4626d4903b648d24446959151', '张三1', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:45:54', '2020-03-06 15:45:54');
INSERT INTO `tb_sys_admin` VALUES ('5814fcd63b7a415594fe4eb15e35457e', '张三6', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:46:05', '2020-03-06 15:46:05');
INSERT INTO `tb_sys_admin` VALUES ('71852d61922640d085cac387daaa43eb', '张三7', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:46:06', '2020-03-06 15:46:06');
INSERT INTO `tb_sys_admin` VALUES ('7c88e8e72e6c4017b7987425d866f2a6', '张三7', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 16:16:40', '2020-03-06 16:16:40');
INSERT INTO `tb_sys_admin` VALUES ('b84d6491c47f451dae47ca1aae778e13', '张三5', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:46:03', '2020-03-06 15:46:03');
INSERT INTO `tb_sys_admin` VALUES ('cb473e9ae5d94ebfb90d8c5ec80cd790', '张三3', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:45:59', '2020-03-06 15:45:59');
INSERT INTO `tb_sys_admin` VALUES ('e7afc44cf9c04537969bdca2833632c1', '张三4', '18588773304', 'e10adc3949ba59abbe56e057f20f883e', '', '', '00000000000', '2020-03-06 15:46:01', '2020-03-06 15:46:01');

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
