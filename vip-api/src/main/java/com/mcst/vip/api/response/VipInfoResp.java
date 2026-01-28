package com.mcst.vip.api.response;

import com.mcst.vip.api.dto.VipInfoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * VIP会员响应对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP会员响应对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoResp extends VipInfoDto {

    @Schema(description = "折扣率(0-100)")
    private Integer discountRate;

    @Schema(description = "是否已过期")
    private Boolean expired;
}
