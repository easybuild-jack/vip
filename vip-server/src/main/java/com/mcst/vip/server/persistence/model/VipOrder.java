package com.mcst.vip.server.persistence.model;

import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mcst.vip.api.dto.VipOrderDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;

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
    @Column(comment = "VIP订单ID")
    private String vipOrderId;

    /**
     * 订单号
     */
    @Column(comment = "订单号")
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(comment = "用户ID")
    private String userId;

    /**
     * 套餐ID
     */
    @Column(comment = "套餐ID")
    private String planId;

    /**
     * 套餐名称
     */
    @Column(comment = "套餐名称")
    private String planName;

    /**
     * 支付金额
     */
    @Column(comment = "支付金额")
    private BigDecimal payPrice;

    /**
     * 有效天数,-1表示永久
     */
    @Column(comment = "有效天数,-1表示永久")
    private Integer days;


    /**
     * 支付时间
     */
    @Column(comment = "支付时间")
    private LocalDateTime payTime;

    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;
}