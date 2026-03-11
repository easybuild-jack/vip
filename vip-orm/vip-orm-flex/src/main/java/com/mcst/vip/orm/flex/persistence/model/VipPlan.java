package com.mcst.vip.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.vip.api.dto.VipPlanDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 作者: liu yijun
 * 日期: 2026-01-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("vip_plan")
@AutoMapper(target = VipPlanDto.class)
public class VipPlan extends BaseFlexEntity<VipPlan> {

    /**
     * VIP套餐ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String vipPlanId;

    /**
     * VIP编号
     */
    private String vipCode;

    /**
     * VIP名称
     */
    private String vipName;

    /**
     * 套餐编号
     */
    private String planCode;

    /**
     * 套餐名称
     */
    private String planName;

    /**
     * 首购金额
     */
    private BigDecimal firstPrice;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 活动价
     */
    private BigDecimal activityPrice;

    /**
     * 有效天数,-1表示永久
     */
    private Integer days;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;
}
