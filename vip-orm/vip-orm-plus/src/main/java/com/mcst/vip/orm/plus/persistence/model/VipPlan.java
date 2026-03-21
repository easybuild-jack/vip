package com.mcst.vip.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipPlanDto;
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
@TableName("vip_plan")
@AutoMapper(target = VipPlanDto.class)
public class VipPlan extends BaseMyBatisPlusEntity<VipPlan> {


    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "VIP套餐ID")
    private String vipPlanId;


    /**
     * VIP编号
     */
    @EntityColumn(comment = "VIP编号")
    private String vipCode;

    /**
     * VIP名称
     */
    @EntityColumn(comment = "VIP名称")
    private String vipName;

    /**
     * 套餐编号
     */
    @EntityColumn(comment = "套餐编号")
    private String planCode;

    /**
     * 套餐名称
     */
    @EntityColumn(comment = "套餐名称")
    private String planName;

    /**
     * 首购金额
     */
    @EntityColumn(comment = "首购金额")
    private BigDecimal firstPrice;

    /**
     * 原价
     */
    @EntityColumn(comment = "原价")
    private BigDecimal price;

    /**
     * 活动价
     */
    @EntityColumn(comment = "活动价")
    private BigDecimal activityPrice;

    /**
     * 有效天数,-1表示永久
     */
    @EntityColumn(comment = "有效天数,-1表示永久")
    private Integer days;

    /**
     * 禁用状态 0可用，1禁用
     */
    @EntityColumn(comment = "禁用状态 0可用，1禁用")
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;
}
