package com.mcst.vip.api;

import java.math.BigDecimal;

import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;

/**
 * VIP套餐API接口
 *
 * @author easyfk
 */
public interface IVipPlanApi extends IBaseService<VipPlanResp, String, VipPlanReq> {

    /**
     * 根据套餐ID获取套餐价格
     * 
     * @param param
     * @return GetPlanPriceByUserResp
     */
    GetPlanPriceByUserResp getVipPlanPrice(GetPlanPriceByUser param);

}
