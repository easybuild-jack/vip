package com.mcst.vip.api.dto;

import com.mcst.core.entity.BaseDto;
import com.mcst.core.params.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * VIP会员套餐数据传输对象
 *
 * @author easyfk
 */
@Data
@Schema(description = "VIP会员套餐数据对象")
@SuperBuilder
@NoArgsConstructor
public class VipPlanDto extends BaseDto {

    @PrimaryKey
    @Schema(description = "套餐ID")
    private String planId;

    @Schema(description = "VOP编号")
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
