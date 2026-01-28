-- VIP模块 PostgreSQL 初始化脚本
-- 创建时间: 2026-01-28

-- VIP信息表
CREATE TABLE IF NOT EXISTS vip_info (
    vip_id VARCHAR(32) NOT NULL,
    vip_code VARCHAR(32) DEFAULT NULL,
    vip_name VARCHAR(50) DEFAULT NULL,
    forbidden_flag SMALLINT NOT NULL DEFAULT 0,
    description VARCHAR(500) DEFAULT NULL,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator VARCHAR(32) DEFAULT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    del_flag SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (vip_id)
);

COMMENT ON TABLE vip_info IS 'VIP信息表';
COMMENT ON COLUMN vip_info.vip_id IS 'VIP会员ID';
COMMENT ON COLUMN vip_info.vip_code IS 'VIP编号';
COMMENT ON COLUMN vip_info.vip_name IS 'VIP名称';
COMMENT ON COLUMN vip_info.forbidden_flag IS '禁用状态 0可用，1禁用';
COMMENT ON COLUMN vip_info.description IS '介绍';

CREATE INDEX idx_info_vip_code ON vip_info(vip_code);

-- VIP会员套餐表
CREATE TABLE IF NOT EXISTS vip_plan (
    plan_id VARCHAR(32) NOT NULL,
    vip_code VARCHAR(32) DEFAULT NULL,
    vip_name VARCHAR(50) DEFAULT NULL,
    plan_code VARCHAR(32) DEFAULT NULL,
    plan_name VARCHAR(100) DEFAULT NULL,
    first_price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    activity_price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    days INT NOT NULL,
    forbidden_flag SMALLINT NOT NULL DEFAULT 0,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator VARCHAR(32) DEFAULT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    del_flag SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (plan_id)
);

COMMENT ON TABLE vip_plan IS 'VIP会员套餐表';
COMMENT ON COLUMN vip_plan.plan_id IS '套餐ID';
COMMENT ON COLUMN vip_plan.vip_code IS 'VIP编号';
COMMENT ON COLUMN vip_plan.vip_name IS 'VIP名称';
COMMENT ON COLUMN vip_plan.plan_code IS '套餐编号';
COMMENT ON COLUMN vip_plan.plan_name IS '套餐名称';
COMMENT ON COLUMN vip_plan.first_price IS '首购金额';
COMMENT ON COLUMN vip_plan.price IS '原价';
COMMENT ON COLUMN vip_plan.activity_price IS '活动价';
COMMENT ON COLUMN vip_plan.days IS '有效天数,-1表示永久';
COMMENT ON COLUMN vip_plan.forbidden_flag IS '禁用状态 0可用，1禁用';

CREATE INDEX idx_plan_vip_code ON vip_plan(vip_code);
CREATE INDEX idx_plan_plan_code ON vip_plan(plan_code);

-- VIP购买订单表
CREATE TABLE IF NOT EXISTS vip_order (
    order_id VARCHAR(32) NOT NULL,
    order_no VARCHAR(32) DEFAULT NULL,
    user_id VARCHAR(32) NOT NULL,
    plan_id VARCHAR(32) NOT NULL,
    plan_name VARCHAR(100) DEFAULT NULL,
    pay_price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    days INT NOT NULL,
    pay_time TIMESTAMP DEFAULT NULL,
    remark VARCHAR(255) DEFAULT NULL,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator VARCHAR(32) DEFAULT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    del_flag SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_id)
);

COMMENT ON TABLE vip_order IS 'VIP购买订单表';
COMMENT ON COLUMN vip_order.order_id IS '订单ID';
COMMENT ON COLUMN vip_order.order_no IS '订单号';
COMMENT ON COLUMN vip_order.user_id IS '用户ID';
COMMENT ON COLUMN vip_order.plan_id IS '套餐ID';
COMMENT ON COLUMN vip_order.plan_name IS '套餐名称';
COMMENT ON COLUMN vip_order.pay_price IS '支付金额';
COMMENT ON COLUMN vip_order.days IS '有效天数,-1表示永久';
COMMENT ON COLUMN vip_order.pay_time IS '支付时间';

CREATE INDEX idx_order_user_id ON vip_order(user_id);
CREATE INDEX idx_order_plan_id ON vip_order(plan_id);
CREATE INDEX idx_order_order_no ON vip_order(order_no);
CREATE INDEX idx_order_create_time ON vip_order(create_time);
