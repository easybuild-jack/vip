package com.mcst.vip.server.service;

import java.math.BigDecimal;

import com.mcst.service.core.base.IBaseService;
import com.mcst.vip.api.dto.VipPlanResp;
import com.mcst.vip.api.param.VipPlanReq;

/**
 * VIP会员套餐 业务接口
 *
 * @author easyfk
 */
public interface IVipPlanService extends IBaseService<VipPlanResp, String, VipPlanReq> {

    
    /**
     * 根据套餐ID获取套餐价格
     * 
     * @param planId
     * @return
     */
    BigDecimal getVipPlanPrice(String planId);
}
