-- VIP模块 MySQL 初始化脚本
-- 创建时间: 2026-01-28
-- 设置字符集，确保中文注释正常显示
SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

-- VIP信息表
CREATE TABLE IF NOT EXISTS `vip_info` (
    `vip_id` VARCHAR(32) NOT NULL COMMENT 'VIP会员ID',
    `vip_code` VARCHAR(32) DEFAULT NULL COMMENT 'VIP编号',
    `vip_name` VARCHAR(50) DEFAULT NULL COMMENT 'VIP名称',
    `forbidden_flag` TINYINT NOT NULL DEFAULT 0 COMMENT '禁用状态 0可用，1禁用',
    `description` VARCHAR(500) DEFAULT NULL COMMENT '介绍',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识: 0-正常, 1-已删除',
    PRIMARY KEY (`vip_id`),
    KEY `idx_vip_code` (`vip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='VIP信息表';

-- VIP会员套餐表
CREATE TABLE IF NOT EXISTS `vip_plan` (
    `plan_id` VARCHAR(32) NOT NULL COMMENT '套餐ID',
    `vip_code` VARCHAR(32) DEFAULT NULL COMMENT 'VIP编号',
    `vip_name` VARCHAR(50) DEFAULT NULL COMMENT 'VIP名称',
    `plan_code` VARCHAR(32) DEFAULT NULL COMMENT '套餐编号',
    `plan_name` VARCHAR(100) DEFAULT NULL COMMENT '套餐名称',
    `first_price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '首购金额',
    `price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '原价',
    `activity_price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '活动价',
    `days` INT NOT NULL COMMENT '有效天数,-1表示永久',
    `forbidden_flag` TINYINT NOT NULL DEFAULT 0 COMMENT '禁用状态 0可用，1禁用',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识: 0-正常, 1-已删除',
    PRIMARY KEY (`plan_id`),
    KEY `idx_vip_code` (`vip_code`),
    KEY `idx_plan_code` (`plan_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='VIP会员套餐表';

-- VIP购买订单表
CREATE TABLE IF NOT EXISTS `vip_order` (
    `order_id` VARCHAR(32) NOT NULL COMMENT '订单ID',
    `order_no` VARCHAR(32) DEFAULT NULL COMMENT '订单号',
    `user_id` VARCHAR(32) NOT NULL COMMENT '用户ID',
    `plan_id` VARCHAR(32) NOT NULL COMMENT '套餐ID',
    `plan_name` VARCHAR(100) DEFAULT NULL COMMENT '套餐名称',
    `pay_price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
    `days` INT NOT NULL COMMENT '有效天数,-1表示永久',
    `pay_time` DATETIME DEFAULT NULL COMMENT '支付时间',
    `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT NOT NULL DEFAULT 0 COMMENT '逻辑删除标识: 0-正常, 1-已删除',
    PRIMARY KEY (`order_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_plan_id` (`plan_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_insert_time` (`insert_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='VIP购买订单表';
