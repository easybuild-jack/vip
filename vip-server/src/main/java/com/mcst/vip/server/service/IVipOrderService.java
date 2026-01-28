package com.mcst.vip.server.service;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.service.api.IBaseService;
import com.mcst.vip.api.request.SaveOrderReq;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.response.VipOrderResp;

/**
 * <p>
 * VIP订单 服务接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
public interface IVipOrderService extends IBaseService<VipOrderResp, String, VipOrderReq> {


    /**
     * 保存VIP订单
     * 支持幂等操作
     *
     * @param saveOrderReq 保存订单请求对象
     * @return BaseResult<?>
     */
    BaseResult<?> saveVipOrder(SaveOrderReq saveOrderReq);
}