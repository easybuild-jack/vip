package com.mcst.vip.api.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.request.BasicParam;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
* <p>
* VIP信息数据参数对象
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP信息数据参数对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoParam extends BasicParam {

    /**
    * VIP信息ID
    */
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