package com.mcst.vip.server.service.impl;

import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.dto.VipOrderDto;
import com.mcst.vip.server.service.IVipOrderService;
import com.mcst.vip.server.repository.IVipOrderRepository;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.repository.util.ConditionUtil;
import java.util.List;
import jakarta.annotation.Resource;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.easyfk.core.utils.common.TransformUtil;
/**
* <p>
* VIP订单 服务实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/

public class VipOrderServiceImpl  implements IVipOrderService {
    @Resource
    private IVipOrderRepository vipOrderRepository;

    @Override
    public VipOrderResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.vipOrderRepository.queryById(id, selectColumns), VipOrderResp.class);
    }

    @Override
    public VipOrderResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.vipOrderRepository.queryOneByField(field, value, selectColumns), VipOrderResp.class);
    }

    @Override
    public List<VipOrderResp> queryList(SearchRequest<VipOrderReq> param) {
        return TransformUtil.transformList(this.vipOrderRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), VipOrderResp.class);
    }

    @Override
    public VipOrderResp queryOne(SearchRequest<VipOrderReq> param) {
        return TransformUtil.transformObj(this.vipOrderRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), VipOrderResp.class);
    }

    @Override
    public long count(SearchRequest<VipOrderReq> param) {
        return this.vipOrderRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<VipOrderReq> param) {
        return this.vipOrderRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<VipOrderResp> queryByPage(SearchRequest<VipOrderReq> param) {
        return TransformUtil.transformPageResult(this.vipOrderRepository.queryByPage(ConditionUtil.conditionByRequest(param)),VipOrderResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<VipOrderReq> param) {
        return ServiceUtil.save(param, vipOrderRepository, VipOrderDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<VipOrderReq> param) {
        return ServiceUtil.delete(param, vipOrderRepository, VipOrderDto.class);
    }

    @Override
    public String insertAndReturnId(VipOrderReq param) {
        return ServiceUtil.insertAndReturnId(param, vipOrderRepository, VipOrderDto.class);
    }

}
