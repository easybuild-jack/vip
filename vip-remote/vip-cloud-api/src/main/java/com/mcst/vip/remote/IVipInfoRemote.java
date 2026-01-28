package com.mcst.vip.remote;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* VIP信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
@FeignClient(value = "${easyfk.config.remote.vip.service-id:server}", path = "${easyfk.config.remote.vip.base-path:/remote}/vip/vipInfo")
public interface IVipInfoRemote extends IBaseRemote<VipInfoResp,String,VipInfoReq>{


}