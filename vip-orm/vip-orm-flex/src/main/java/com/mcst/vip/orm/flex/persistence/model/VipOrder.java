package com.mcst.vip.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.vip.api.dto.VipOrderDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
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
@Table("vip_order")
@AutoMapper(target = VipOrderDto.class)
public class VipOrder extends BaseFlexEntity<VipOrder> {

    /**
     * VIP订单ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String vipOrderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 套餐ID
     */
    private String planId;

    /**
     * 套餐名称
     */
    private String planName;

    /**
     * 支付金额
     */
    private BigDecimal payPrice;

    /**
     * 有效天数,-1表示永久
     */
    private Integer days;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 备注
     */
    private String remark;
}
