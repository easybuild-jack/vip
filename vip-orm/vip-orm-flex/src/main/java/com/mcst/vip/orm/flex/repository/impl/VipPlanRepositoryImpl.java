package com.mcst.vip.orm.flex.repository.impl;

import com.mcst.vip.api.dto.VipPlanDto;
import com.mcst.vip.orm.flex.persistence.mapper.VipPlanMapper;
import com.mcst.vip.orm.flex.persistence.model.VipPlan;
import com.mcst.vip.orm.repository.IVipPlanRepository;
import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;

public class VipPlanRepositoryImpl extends BaseFlexRepositoryImpl<VipPlanMapper, VipPlanDto, VipPlan, String> implements IVipPlanRepository {
}
