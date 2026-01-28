package com.mcst.vip.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* <p>
* VIP订单
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP订单数据对象")
@SuperBuilder
@NoArgsConstructor
public class VipOrderDto extends BaseDto {


    /**
    * VIP订单ID
    */
    @PrimaryKey
    @Schema(description= "VIP订单ID")
    private String vipOrderId;

    /**
    * 订单号
    */
    @Schema(description= "订单号")
    private String orderNo;

    /**
    * 用户ID
    */
    @Schema(description= "用户ID")
    private String userId;

    /**
    * 套餐ID
    */
    @Schema(description= "套餐ID")
    private String planId;

    /**
    * 套餐名称
    */
    @Schema(description= "套餐名称")
    private String planName;

    /**
    * 支付金额
    */
    @Schema(description= "支付金额")
    private BigDecimal payPrice;

    /**
    * 有效天数,-1表示永久
    */
    @Schema(description= "有效天数,-1表示永久")
    private Integer days;

    /**
    * 支付时间
    */
    @Schema(description= "支付时间")
    private LocalDateTime payTime;

    /**
    * 备注
    */
    @Schema(description= "备注")
    private String remark;


}
