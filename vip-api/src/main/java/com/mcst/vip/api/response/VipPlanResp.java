package com.mcst.vip.api.response;

import com.mcst.vip.api.dto.VipPlanDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * VIP会员套餐响应对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP会员套餐响应对象")
@SuperBuilder
@NoArgsConstructor
public class VipPlanResp extends VipPlanDto {

}
