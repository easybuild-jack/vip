package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.vip.server.service.IVipInfoService;
import com.mcst.vip.remote.IVipInfoRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* <p>
* VIP信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@ResponseBody
@RequestMapping("${easyfk.config.remote.vip.base-path:/remote}/vip/vipInfo")
public class VipInfoRemoteImpl extends BaseRemoteImpl<IVipInfoService, VipInfoResp,String,VipInfoReq> implements IVipInfoRemote {


}
