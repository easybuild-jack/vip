package com.mcst.vip.remote.provider.impl;

import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.remote.IVipPlanRemote;
import com.mcst.vip.server.service.IVipPlanService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * VIP套餐 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@ResponseBody
@RequestMapping("${easyfk.config.remote.vip.base-path:/remote}/vip/vipPlan")
public class VipPlanRemoteImpl extends BaseRemoteImpl<IVipPlanService, VipPlanResp, String, VipPlanReq> implements IVipPlanRemote {

    @Resource
    private IVipPlanService vipPlanService;

    @Override
    public GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser) {
        return this.vipPlanService.getPlanPriceByUser(getPlanPriceByUser);
    }
}
