package com.mcst.vip.server.impl;

import com.mcst.easyfk.service.base.BaseApiServiceImpl;
import com.mcst.vip.api.IVipPlanApi;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.server.service.IVipPlanService;
import jakarta.annotation.Resource;

/**
 * <p>
 * VIP套餐!} Api接口Server层实现
 * </p>
 *
 * @author liu yijun
 */
public class VipPlanApiServerImpl extends BaseApiServiceImpl<IVipPlanService, VipPlanResp, String, VipPlanReq> implements IVipPlanApi {

    @Resource
    private IVipPlanService vipPlanService;

    @Override
    public GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser) {
        return this.vipPlanService.getPlanPriceByUser(getPlanPriceByUser);
    }
}
