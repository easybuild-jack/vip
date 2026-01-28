package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.server.service.IVipOrderService;
import com.mcst.vip.remote.IVipOrderRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* VIP订单 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class VipOrderRemoteImpl extends DubboBaseRemoteImpl<IVipOrderService, VipOrderResp,String,VipOrderReq> implements IVipOrderRemote {


}
