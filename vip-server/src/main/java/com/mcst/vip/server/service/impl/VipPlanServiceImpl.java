package com.mcst.vip.server.service.impl;

import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.vip.api.dto.VipPlanResp;
import com.mcst.vip.api.param.VipPlanReq;
import com.mcst.vip.server.persistence.model.VipPlan;
import com.mcst.vip.server.repository.IVipPlanRepository;
import com.mcst.vip.server.service.IVipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * VIP会员套餐 业务实现
 *
 * @author easyfk
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VipPlanServiceImpl implements IVipPlanService {

    @Autowired
    private IVipPlanRepository vipPlanRepository;

    @Override
    public VipPlanResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.vipPlanRepository.queryById(id, selectColumns), VipPlanResp.class);
    }

    @Override
    public VipPlanResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.vipPlanRepository.queryOneByField(field, value, selectColumns),
                VipPlanResp.class);
    }

    @Override
    public List<VipPlanResp> queryList(SearchRequest<VipPlanReq> param) {
        return TransformUtil.transformList(
                this.vipPlanRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), VipPlanResp.class);
    }

    @Override
    public VipPlanResp queryOne(SearchRequest<VipPlanReq> param) {
        return TransformUtil.transformObj(
                this.vipPlanRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), VipPlanResp.class);
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
        return TransformUtil.transformPageResult(
                this.vipPlanRepository.queryByPage(ConditionUtil.conditionByRequest(param)), VipPlanResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<VipPlanReq> param) {
        return ServiceUtil.save(param, vipPlanRepository, VipPlan.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<VipPlanReq> param) {
        return ServiceUtil.delete(param, vipPlanRepository, VipPlan.class);
    }

    @Override
    public String insertAndReturnId(VipPlanReq param) {
        return ServiceUtil.insertAndReturnId(param, vipPlanRepository, VipPlanDto.class);
    }

    @Override
    public BigDecimal getVipPlanPrice(String planId) {
        return null;
    }
}
