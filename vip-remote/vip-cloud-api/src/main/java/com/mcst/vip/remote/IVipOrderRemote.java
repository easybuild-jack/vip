package com.mcst.vip.remote;

import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* VIP订单 Remote接口类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@FeignClient(value = "${easyfk.config.remote.vip.service-id:server}", path = "${easyfk.config.remote.vip.base-path:/remote}/vip/vipOrder")
public interface IVipOrderRemote extends IBaseRemote<VipOrderResp,String,VipOrderReq>{


}