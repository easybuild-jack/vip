package com.mcst.vip.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.vip.api.IVipOrderApi;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.remote.IVipOrderRemote;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * <p>
 * VIP订单 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
public class VipOrderApiDubboImpl extends DubboBaseApiRemoteImpl<IVipOrderRemote, VipOrderResp, String, VipOrderReq> implements IVipOrderApi {

    @DubboReference
    private IVipOrderRemote vipOrderRemote;

    @Override
    public BaseResult<?> saveVipOrder(SaveOrderReq saveOrderReq) {
        return vipOrderRemote.saveVipOrder(saveOrderReq);
    }

}
