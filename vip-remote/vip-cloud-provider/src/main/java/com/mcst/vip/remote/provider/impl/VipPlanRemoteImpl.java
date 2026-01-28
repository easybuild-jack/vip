package com.mcst.vip.remote.provider.impl;

import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.server.service.IVipPlanService;
import com.mcst.vip.remote.IVipPlanRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* VIP套餐 RemoteImpl
* </p>
*
* @author liu yijun
*/
@RestController
@RequestMapping("${easyfk.config.remote.vip.base-path:/remote}/vip/vipPlan")
public class VipPlanRemoteImpl extends BaseRemoteImpl<IVipPlanService, VipPlanResp,String,VipPlanReq> implements IVipPlanRemote {


}
