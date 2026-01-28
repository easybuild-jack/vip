package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.vip.server.service.IVipInfoService;
import com.mcst.vip.remote.IVipInfoRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* VIP信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class VipInfoRemoteImpl extends DubboBaseRemoteImpl<IVipInfoService, VipInfoResp,String,VipInfoReq> implements IVipInfoRemote {


}
