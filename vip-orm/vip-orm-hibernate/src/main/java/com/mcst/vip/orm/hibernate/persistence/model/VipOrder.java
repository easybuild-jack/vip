package com.mcst.vip.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.vip.api.dto.VipOrderDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* 作者: liu yijun
* 日期: 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "vip_order")
@AutoMapper(target = VipOrderDto.class)
public class VipOrder extends BaseHibernateEntity {

    /**
     * VIP订单ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "vip_order_id")
    private String vipOrderId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 套餐ID
     */
    @Column(name = "plan_id")
    private String planId;

    /**
     * 套餐名称
     */
    @Column(name = "plan_name")
    private String planName;

    /**
     * 支付金额
     */
    @Column(name = "pay_price")
    private BigDecimal payPrice;

    /**
     * 有效天数,-1表示永久
     */
    @Column(name = "days")
    private Integer days;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private LocalDateTime payTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
}
