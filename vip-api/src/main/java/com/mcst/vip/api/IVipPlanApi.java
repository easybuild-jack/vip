package com.mcst.vip.api;

import java.math.BigDecimal;

import com.mcst.service.core.base.IBaseService;
import com.mcst.vip.api.dto.VipPlanResp;
import com.mcst.vip.api.param.VipPlanReq;

/**
 * VIP套餐API接口
 *
 * @author easyfk
 */
public interface IVipPlanApi extends IBaseService<VipPlanResp, String, VipPlanReq> {

    /**
     * 根据套餐ID获取套餐价格
     * 
     * @param planId
     * @return
     */
    BigDecimal getVipPlanPrice(String planId);

}
