package com.mcst.vip.api.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "获取套餐价格请求对象")
@Builder
@NoArgsConstructor
public class GetPlanPriceByUser implements Serializable {

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "套餐ID")
    private String planId;

}
