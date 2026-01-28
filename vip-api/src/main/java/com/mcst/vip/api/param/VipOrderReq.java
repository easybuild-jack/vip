package com.mcst.vip.api.param;

import com.mcst.core.entity.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * VIP购买订单请求对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP购买订单请求对象")
@SuperBuilder
@NoArgsConstructor
public class VipOrderReq extends BaseReq {

    @Schema(description = "订单ID")
    private String orderId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "套餐ID")
    private String planId;

    @Schema(description = "套餐名称")
    private String planName;

    @Schema(description = "支付金额")
    private BigDecimal payPrice;

    @Schema(description = "有效天数,-1表示永久")
    private Integer days;

    @Schema(description = "到期时间")
    private LocalDateTime expireTime;

    @Schema(description = "支付时间")
    private LocalDateTime payTime;

    @Schema(description = "备注")
    private String remark;

}
