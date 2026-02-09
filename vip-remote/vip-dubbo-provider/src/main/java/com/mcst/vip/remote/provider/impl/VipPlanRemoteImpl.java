package com.mcst.vip.remote.provider.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.remote.IVipPlanRemote;
import com.mcst.vip.server.service.IVipPlanService;
import jakarta.annotation.Resource;

/**
 * <p>
 * VIP套餐 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
public class VipPlanRemoteImpl extends DubboBaseRemoteImpl<IVipPlanService, VipPlanResp, String, VipPlanReq> implements IVipPlanRemote {

    @Resource
    private IVipPlanService vipPlanService;

    @Override
    public GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser) {
        return this.vipPlanService.getPlanPriceByUser(getPlanPriceByUser);
    }
}
