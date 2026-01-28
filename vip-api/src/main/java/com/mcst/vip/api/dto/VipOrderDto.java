package com.mcst.vip.api.dto;

import com.mcst.core.entity.BaseDto;
import com.mcst.core.params.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * VIP购买订单数据传输对象
 *
 * @author easyfk
 */
@Data
@Schema(description = "VIP购买订单数据对象")
@SuperBuilder
@NoArgsConstructor
public class VipOrderDto extends BaseDto {

    @PrimaryKey
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
