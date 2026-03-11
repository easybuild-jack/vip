package com.mcst.vip.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.vip.api.dto.VipPlanDto;
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

/**
 * 作者: liu yijun
 * 日期: 2026-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "vip_plan")
@AutoMapper(target = VipPlanDto.class)
public class VipPlan extends BaseHibernateEntity {

    /**
     * VIP套餐ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "vip_plan_id")
    private String vipPlanId;

    /**
     * VIP编号
     */
    @Column(name = "vip_code")
    private String vipCode;

    /**
     * VIP名称
     */
    @Column(name = "vip_name")
    private String vipName;

    /**
     * 套餐编号
     */
    @Column(name = "plan_code")
    private String planCode;

    /**
     * 套餐名称
     */
    @Column(name = "plan_name")
    private String planName;

    /**
     * 首购金额
     */
    @Column(name = "first_price")
    private BigDecimal firstPrice;

    /**
     * 原价
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * 活动价
     */
    @Column(name = "activity_price")
    private BigDecimal activityPrice;

    /**
     * 有效天数,-1表示永久
     */
    @Column(name = "days")
    private Integer days;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    @Column(name = "forbidden_flag")
    private Integer forbiddenFlag;
}
