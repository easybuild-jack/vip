package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.server.service.IVipPlanService;
import com.mcst.vip.remote.IVipPlanRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* VIP套餐 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class VipPlanRemoteImpl extends DubboBaseRemoteImpl<IVipPlanService, VipPlanResp,String,VipPlanReq> implements IVipPlanRemote {


}
