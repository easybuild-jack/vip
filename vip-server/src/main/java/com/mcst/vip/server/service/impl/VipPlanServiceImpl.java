package com.mcst.vip.server.service.impl;

import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.dto.VipPlanDto;
import com.mcst.vip.server.service.IVipPlanService;
import com.mcst.vip.server.repository.IVipPlanRepository;
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
* VIP套餐 服务实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/

public class VipPlanServiceImpl  implements IVipPlanService {
    @Resource
    private IVipPlanRepository vipPlanRepository;

    @Override
    public VipPlanResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.vipPlanRepository.queryById(id, selectColumns), VipPlanResp.class);
    }

    @Override
    public VipPlanResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.vipPlanRepository.queryOneByField(field, value, selectColumns), VipPlanResp.class);
    }

    @Override
    public List<VipPlanResp> queryList(SearchRequest<VipPlanReq> param) {
        return TransformUtil.transformList(this.vipPlanRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), VipPlanResp.class);
    }

    @Override
    public VipPlanResp queryOne(SearchRequest<VipPlanReq> param) {
        return TransformUtil.transformObj(this.vipPlanRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), VipPlanResp.class);
    }

    @Override
    public long count(SearchRequest<VipPlanReq> param) {
        return this.vipPlanRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<VipPlanReq> param) {
        return this.vipPlanRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<VipPlanResp> queryByPage(SearchRequest<VipPlanReq> param) {
        return TransformUtil.transformPageResult(this.vipPlanRepository.queryByPage(ConditionUtil.conditionByRequest(param)),VipPlanResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<VipPlanReq> param) {
        return ServiceUtil.save(param, vipPlanRepository, VipPlanDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<VipPlanReq> param) {
        return ServiceUtil.delete(param, vipPlanRepository, VipPlanDto.class);
    }

    @Override
    public String insertAndReturnId(VipPlanReq param) {
        return ServiceUtil.insertAndReturnId(param, vipPlanRepository, VipPlanDto.class);
    }

}
