package com.mcst.vip.server.service.impl;

import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.vip.api.dto.VipOrderResp;
import com.mcst.vip.api.param.VipOrderReq;
import com.mcst.vip.server.persistence.model.VipOrder;
import com.mcst.vip.server.repository.IVipOrderRepository;
import com.mcst.vip.server.service.IVipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * VIP购买订单 业务实现
 *
 * @author easyfk
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VipOrderServiceImpl implements IVipOrderService {

    @Autowired
    private IVipOrderRepository vipOrderRepository;

    @Override
    public VipOrderResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.vipOrderRepository.queryById(id, selectColumns), VipOrderResp.class);
    }

    @Override
    public VipOrderResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.vipOrderRepository.queryOneByField(field, value, selectColumns),
                VipOrderResp.class);
    }

    @Override
    public List<VipOrderResp> queryList(SearchRequest<VipOrderReq> param) {
        return TransformUtil.transformList(
                this.vipOrderRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), VipOrderResp.class);
    }

    @Override
    public VipOrderResp queryOne(SearchRequest<VipOrderReq> param) {
        return TransformUtil.transformObj(
                this.vipOrderRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)),
                VipOrderResp.class);
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
        return TransformUtil.transformPageResult(
                this.vipOrderRepository.queryByPage(ConditionUtil.conditionByRequest(param)), VipOrderResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<VipOrderReq> param) {
        return ServiceUtil.save(param, vipOrderRepository, VipOrder.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<VipOrderReq> param) {
        return ServiceUtil.delete(param, vipOrderRepository, VipOrder.class);
    }

    @Override
    public String insertAndReturnId(VipOrderReq param) {
        return ServiceUtil.insertAndReturnId(param, vipOrderRepository, VipOrder.class);
    }
}
