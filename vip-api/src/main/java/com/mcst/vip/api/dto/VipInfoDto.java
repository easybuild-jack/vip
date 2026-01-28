package com.mcst.vip.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;

/**
* <p>
* VIP信息
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP信息数据对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoDto extends BaseDto {


    /**
    * VIP信息ID
    */
    @PrimaryKey
    @Schema(description= "VIP信息ID")
    private String vipInfoId;

    /**
    * VIP编号
    */
    @Schema(description= "VIP编号")
    private String vipCode;

    /**
    * VIP名称
    */
    @Schema(description= "VIP名称")
    private String vipName;

    /**
    * 禁用状态 0可用，1禁用
    */
    @Schema(description= "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;

    /**
    * 介绍
    */
    @Schema(description= "介绍")
    private String description;


}
