package com.mcst.vip.server.repository.impl;

import com.mcst.orm.mybatis.core.BaseRepositoryImpl;
import com.mcst.vip.server.persistence.mapper.VipPlanMapper;
import com.mcst.vip.server.persistence.model.VipPlan;
import com.mcst.vip.server.repository.IVipPlanRepository;
import org.springframework.stereotype.Repository;

/**
 * VIP会员套餐 仓储实现
 *
 * @author easyfk
 */
@Repository
public class VipPlanRepositoryImpl extends BaseRepositoryImpl<VipPlanMapper, VipPlan> implements IVipPlanRepository {

}
