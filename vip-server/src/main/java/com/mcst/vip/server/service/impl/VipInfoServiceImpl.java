package com.mcst.vip.server.service.impl;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.vip.api.dto.VipInfoDto;
import com.mcst.vip.server.service.IVipInfoService;
import com.mcst.vip.server.repository.IVipInfoRepository;
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
* VIP信息 服务实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/

public class VipInfoServiceImpl  implements IVipInfoService {
    @Resource
    private IVipInfoRepository vipInfoRepository;

    @Override
    public VipInfoResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.vipInfoRepository.queryById(id, selectColumns), VipInfoResp.class);
    }

    @Override
    public VipInfoResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.vipInfoRepository.queryOneByField(field, value, selectColumns), VipInfoResp.class);
    }

    @Override
    public List<VipInfoResp> queryList(SearchRequest<VipInfoReq> param) {
        return TransformUtil.transformList(this.vipInfoRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), VipInfoResp.class);
    }

    @Override
    public VipInfoResp queryOne(SearchRequest<VipInfoReq> param) {
        return TransformUtil.transformObj(this.vipInfoRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), VipInfoResp.class);
    }

    @Override
    public long count(SearchRequest<VipInfoReq> param) {
        return this.vipInfoRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<VipInfoReq> param) {
        return this.vipInfoRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<VipInfoResp> queryByPage(SearchRequest<VipInfoReq> param) {
        return TransformUtil.transformPageResult(this.vipInfoRepository.queryByPage(ConditionUtil.conditionByRequest(param)),VipInfoResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<VipInfoReq> param) {
        return ServiceUtil.save(param, vipInfoRepository, VipInfoDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<VipInfoReq> param) {
        return ServiceUtil.delete(param, vipInfoRepository, VipInfoDto.class);
    }

    @Override
    public String insertAndReturnId(VipInfoReq param) {
        return ServiceUtil.insertAndReturnId(param, vipInfoRepository, VipInfoDto.class);
    }

}
