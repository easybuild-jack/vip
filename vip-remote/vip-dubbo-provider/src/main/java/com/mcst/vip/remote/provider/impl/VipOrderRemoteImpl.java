package com.mcst.vip.remote.provider.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.remote.IVipOrderRemote;
import com.mcst.vip.server.service.IVipOrderService;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * VIP订单 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
public class VipOrderRemoteImpl extends DubboBaseRemoteImpl<IVipOrderService, VipOrderResp, String, VipOrderReq> implements IVipOrderRemote {

    @Resource
    private IVipOrderService vipOrderService;

    @Override
    public BaseResult<?> saveVipOrder(SaveOrderReq saveOrderReq) {
        return this.vipOrderService.saveVipOrder(saveOrderReq);
    }
}
