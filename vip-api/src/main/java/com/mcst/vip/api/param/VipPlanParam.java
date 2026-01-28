package com.mcst.vip.api.param;

import com.mcst.core.entity.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * VIP会员套餐查询参数
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP会员套餐查询参数")
public class VipPlanParam extends BasePageParam {

    @Schema(description = "VIP编号")
    private String vipCode;

    @Schema(description = "套餐编号")
    private String planCode;

    @Schema(description = "关键词")
    private String keyword;

    @Schema(description = "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;
}
