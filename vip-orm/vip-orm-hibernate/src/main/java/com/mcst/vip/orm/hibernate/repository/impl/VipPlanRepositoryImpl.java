package com.mcst.vip.orm.hibernate.repository.impl;

import com.mcst.vip.api.dto.VipPlanDto;
import com.mcst.vip.orm.hibernate.persistence.model.VipPlan;
import com.mcst.vip.orm.hibernate.persistence.mapper.VipPlanMapper;
import com.mcst.vip.orm.repository.IVipPlanRepository;
import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;

public class VipPlanRepositoryImpl extends BaseHibernateRepositoryImpl<VipPlanMapper, VipPlanDto, VipPlan, String> implements IVipPlanRepository {
}
