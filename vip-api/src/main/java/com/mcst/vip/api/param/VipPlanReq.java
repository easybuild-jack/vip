package com.mcst.vip.api.param;

import com.mcst.core.entity.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * VIP会员套餐请求对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP会员套餐请求对象")
@SuperBuilder
@NoArgsConstructor
public class VipPlanReq extends BaseReq {

    @Schema(description = "套餐ID")
    private String planId;

    @Schema(description = "VIP编号")
    private String vipCode;

    @Schema(description = "VIP名称")
    private String vipName;

    @Schema(description = "套餐编号")
    private String planCode;

    @Schema(description = "套餐名称")
    private String planName;

    @Schema(description = "首购金额")
    private BigDecimal firstPrice;

    @Schema(description = "原价")
    private BigDecimal price;

    @Schema(description = "活动价")
    private BigDecimal activityPrice;

    @Schema(description = "有效天数,-1表示永久")
    private Integer days;

    @Schema(description = "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;
}
