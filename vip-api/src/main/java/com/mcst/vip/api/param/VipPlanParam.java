package com.mcst.vip.api.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.request.BasicParam;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

/**
* <p>
* VIP套餐数据参数对象
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP套餐数据参数对象")
@SuperBuilder
@NoArgsConstructor
public class VipPlanParam extends BasicParam {

    /**
    * VIP套餐ID
    */
    @Schema(description= "VIP套餐ID")
    private String vipPlanId;
    /**
    * VIP编号
    */
    @Schema(description= "VIP编号")
    private String vipCode;
    /**
    * VIP名称
    */
    @Schema(description= "VIP名称")
    private String vipName;
    /**
    * 套餐编号
    */
    @Schema(description= "套餐编号")
    private String planCode;
    /**
    * 套餐名称
    */
    @Schema(description= "套餐名称")
    private String planName;
    /**
    * 首购金额
    */
    @Schema(description= "首购金额")
    private BigDecimal firstPrice;
    /**
    * 原价
    */
    @Schema(description= "原价")
    private BigDecimal price;
    /**
    * 活动价
    */
    @Schema(description= "活动价")
    private BigDecimal activityPrice;
    /**
    * 有效天数,-1表示永久
    */
    @Schema(description= "有效天数,-1表示永久")
    private Integer days;
    /**
    * 禁用状态 0可用，1禁用
    */
    @Schema(description= "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;
}