package com.mcst.vip.remote.impl;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.vip.api.IVipInfoApi;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.vip.remote.IVipInfoRemote;
import jakarta.annotation.Resource;
/**
* <p>
* VIP信息 Api接口Dubbo层实现
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
public class VipInfoApiDubboImpl extends DubboBaseApiRemoteImpl<IVipInfoRemote, VipInfoResp,String,VipInfoReq> implements IVipInfoApi {

}
