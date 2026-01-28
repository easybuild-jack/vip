package com.mcst.vip.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

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


    /**
     * 天数，-1表示永久
     */
    private Integer days;

}
