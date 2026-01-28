package com.mcst.vip.api.param;

import com.mcst.core.entity.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * VIP购买订单查询参数
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP购买订单查询参数")
public class VipOrderParam extends BasePageParam {

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "套餐ID")
    private String planId;

    @Schema(description = "关键词")
    private String keyword;
}
