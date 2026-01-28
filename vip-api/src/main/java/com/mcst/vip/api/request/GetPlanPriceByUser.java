package com.mcst.vip.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Schema(description = "获取套餐价格请求对象")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPlanPriceByUser implements Serializable {

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "套餐ID")
    private String planId;

}
