package com.mcst.vip.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * VIP订单 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
@FeignClient(value = "${easyfk.config.remote.vip.service-id:server}", path = "${easyfk.config.remote.vip.base-path:/remote}/vip/vipOrder")
public interface IVipOrderRemote extends IBaseRemote<VipOrderResp, String, VipOrderReq> {


    /**
     * 保存VIP订单
     *
     * @param saveOrderReq 保存订单请求对象
     * @return BaseResult<?>
     */
    @PostMapping("/saveVipOrder")
    BaseResult<?> saveVipOrder(@RequestBody SaveOrderReq saveOrderReq);
}