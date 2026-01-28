package com.mcst.vip.api.response;

import com.mcst.vip.api.dto.VipInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
* <p>
* VIP信息数据响应对象
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP信息数据响应对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoResp extends VipInfoDto {


}
