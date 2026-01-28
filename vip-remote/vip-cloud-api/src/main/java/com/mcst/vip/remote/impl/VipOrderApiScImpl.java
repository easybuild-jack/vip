package com.mcst.vip.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.vip.api.IVipOrderApi;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.remote.IVipOrderRemote;
import jakarta.annotation.Resource;

/**
 * <p>
 * VIP订单 Api接口SC层实现
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
public class VipOrderApiScImpl extends BaseApiRemoteImpl<IVipOrderRemote, VipOrderResp, String, VipOrderReq> implements IVipOrderApi {


    @Resource
    private IVipOrderRemote vipOrderRemote;

    @Override
    public BaseResult<?> saveVipOrder(SaveOrderReq saveOrderReq) {
        return this.vipOrderRemote.saveVipOrder(saveOrderReq);
    }
}
