package com.mcst.vip.server.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.service.base.BaseApiServiceImpl;
import com.mcst.vip.api.IVipOrderApi;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.server.service.IVipOrderService;
import jakarta.annotation.Resource;

/**
 * <p>
 * VIP订单!} Api接口Server层实现
 * </p>
 *
 * @author liu yijun
 */
public class VipOrderApiServerImpl extends BaseApiServiceImpl<IVipOrderService, VipOrderResp, String, VipOrderReq> implements IVipOrderApi {

    @Resource
    private IVipOrderService vipOrderService;

    @Override
    public BaseResult<?> saveVipOrder(SaveOrderReq saveOrderReq) {
        return this.vipOrderService.saveVipOrder(saveOrderReq);
    }
}
