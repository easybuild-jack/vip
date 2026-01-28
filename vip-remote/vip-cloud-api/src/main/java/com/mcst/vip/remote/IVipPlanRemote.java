package com.mcst.vip.remote;

import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * VIP套餐 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
@FeignClient(value = "${easyfk.config.remote.vip.service-id:server}", path = "${easyfk.config.remote.vip.base-path:/remote}/vip/vipPlan")
public interface IVipPlanRemote extends IBaseRemote<VipPlanResp, String, VipPlanReq> {

    /**
     * 根据用户ID和套餐ID获取套餐价格
     *
     * @param getPlanPriceByUser 获取套餐价格请求对象
     * @return 获取套餐价格响应对象
     */
    @PostMapping("/getPlanPriceByUser")
    GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser);
}