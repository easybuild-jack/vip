package com.mcst.vip.api.dto;

import com.mcst.core.entity.BaseDto;
import com.mcst.core.params.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * VIP会员数据传输对象
 *
 * @author easyfk
 */
@Data
@Schema(description = "VIP会员数据对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoDto extends BaseDto {

    @PrimaryKey
    @Schema(description = "VIP会员ID")
    private String vipId;

    @Schema(description = "VIP编号")
    private String vipCode;

    @Schema(description = "VIP名称")
    private String vipName;

    @Schema(description = "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;

    @Schema(description = "介绍")
    private String description;
}
