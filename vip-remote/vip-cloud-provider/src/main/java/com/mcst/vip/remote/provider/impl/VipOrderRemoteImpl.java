package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.server.service.IVipOrderService;
import com.mcst.vip.remote.IVipOrderRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* VIP订单 RemoteImpl
* </p>
*
* @author liu yijun
*/
@RestController
@RequestMapping("${easyfk.config.remote.vip.base-path:/remote}/vip/vipOrder")
public class VipOrderRemoteImpl extends BaseRemoteImpl<IVipOrderService, VipOrderResp,String,VipOrderReq> implements IVipOrderRemote {


}
