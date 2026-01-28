package com.mcst.vip.api;

import com.mcst.easyfk.service.api.IBaseApi;
import com.mcst.vip.api.request.GetPlanPriceByUser;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.response.GetPlanPriceByUserResp;
import com.mcst.vip.api.response.VipPlanResp;

/**
 * <p>
 * VIP套餐 服务接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-28
 */
public interface IVipPlanApi extends IBaseApi<VipPlanResp, String, VipPlanReq> {


    /**
     * 根据用户ID和套餐ID获取套餐价格
     *
     * @param getPlanPriceByUser 获取套餐价格请求对象
     * @return 获取套餐价格响应对象
     */
    GetPlanPriceByUserResp getPlanPriceByUser(GetPlanPriceByUser getPlanPriceByUser);
}