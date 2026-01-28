package com.mcst.vip.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.core.params.PrimaryKey;
import com.mcst.orm.mybatis.core.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipPlanDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * VIP会员套餐
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("vip_plan")
@AutoMapper(target = VipPlanDto.class)
public class VipPlan extends BaseMyBatisPlusEntity<VipPlan> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String planId;

    /**
     * VOP编号
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
