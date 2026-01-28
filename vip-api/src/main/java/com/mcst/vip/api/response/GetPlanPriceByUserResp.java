package com.mcst.vip.api.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data   
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPlanPriceByUserResp implements Serializable {

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * VIP编码
     */
    private String vipCode;

    /**
     * VIP名称
     */
    private String vipName;

}
