package com.mcst.vip.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "保存订单请求对象")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrderReq implements Serializable {

    /**
     * 订单号
     */
    @Schema(description = "订单号")
    private String orderNo;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private String userId;

    /**
     * 套餐ID
     */
    @Schema(description = "套餐ID")
    private String planId;

    /**
     * 支付金额
     */
    @Schema(description = "支付金额")
    private BigDecimal payPrice;

    /**
     * 支付时间
     */
    @Schema(description = "支付时间")
    private LocalDateTime payTime;


    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

}
