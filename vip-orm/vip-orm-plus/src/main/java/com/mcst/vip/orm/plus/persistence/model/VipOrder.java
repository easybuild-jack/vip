package com.mcst.vip.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipOrderDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 作者: liu yijun
 * 日期: 2026-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vip_order")
@AutoMapper(target = VipOrderDto.class)
public class VipOrder extends BaseMyBatisPlusEntity<VipOrder> {


    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "VIP订单ID")
    private String vipOrderId;

    /**
     * 订单号
     */
    @EntityColumn(comment = "订单号")
    private String orderNo;

    /**
     * 用户ID
     */
    @EntityColumn(comment = "用户ID")
    private String userId;

    /**
     * 套餐ID
     */
    @EntityColumn(comment = "套餐ID")
    private String planId;

    /**
     * 套餐名称
     */
    @EntityColumn(comment = "套餐名称")
    private String planName;

    /**
     * 支付金额
     */
    @EntityColumn(comment = "支付金额")
    private BigDecimal payPrice;

    /**
     * 有效天数,-1表示永久
     */
    @EntityColumn(comment = "有效天数,-1表示永久")
    private Integer days;


    /**
     * 支付时间
     */
    @EntityColumn(comment = "支付时间")
    private LocalDateTime payTime;

    /**
     * 备注
     */
    @EntityColumn(comment = "备注")
    private String remark;
}
