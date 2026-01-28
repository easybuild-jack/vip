package com.mcst.vip.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.mcst.vip.api.param.VipPlanParam;

/**
* <p>
* VIP套餐数据请求对象
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="VIP套餐数据请求对象")
@SuperBuilder
@NoArgsConstructor
public class VipPlanReq extends VipPlanParam {


}
