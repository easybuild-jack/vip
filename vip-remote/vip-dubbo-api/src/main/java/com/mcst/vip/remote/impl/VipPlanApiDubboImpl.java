package com.mcst.vip.remote.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.vip.api.IVipPlanApi;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.remote.IVipPlanRemote;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * <p>
 * VIP套餐 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
public class VipPlanApiDubboImpl extends DubboBaseApiRemoteImpl<IVipPlanRemote, VipPlanResp, String, VipPlanReq> implements IVipPlanApi {

    @DubboReference
    private IVipPlanRemote vipPlanRemote;

    @Override
    public GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser) {
        return this.vipPlanRemote.getPlanPriceByUser(getPlanPriceByUser);
    }
}
