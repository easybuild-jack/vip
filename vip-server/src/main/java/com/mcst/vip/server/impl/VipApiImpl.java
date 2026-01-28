package com.mcst.vip.server.impl;

import com.mcst.service.core.impl.ApiServerImpl;
import com.mcst.vip.api.IVipApi;
import com.mcst.vip.api.dto.VipInfoResp;
import com.mcst.vip.api.param.VipInfoReq;
import com.mcst.vip.server.service.IVipInfoService;
import org.springframework.stereotype.Service;

/**
 * VIP API 实现
 *
 * @author easyfk
 */
@Service
public class VipApiImpl extends ApiServerImpl<IVipInfoService, VipInfoResp, String, VipInfoReq> implements IVipApi {

    @Override
    public VipInfoResp queryVipInfo(String vipId) {
        return this.service.queryVipInfo(vipId);
    }

    @Override
    public VipInfoResp queryByUserId(String userId) {
        return this.service.queryByUserId(userId);
    }
}
