package com.mcst.vip.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * VIP购买订单响应对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP购买订单响应对象")
@SuperBuilder
@NoArgsConstructor
public class VipOrderResp extends VipOrderDto {

}
