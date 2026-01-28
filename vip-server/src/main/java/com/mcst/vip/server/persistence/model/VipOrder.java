package com.mcst.vip.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.core.params.PrimaryKey;
import com.mcst.orm.mybatis.core.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipOrderDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * VIP购买订单记录
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("vip_order")
@AutoMapper(target = VipOrderDto.class)
public class VipOrder extends BaseMyBatisPlusEntity<VipOrder> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderId;

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
     * 到期时间
     */
    private LocalDateTime expireTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 备注
     */
    private String remark;

}
