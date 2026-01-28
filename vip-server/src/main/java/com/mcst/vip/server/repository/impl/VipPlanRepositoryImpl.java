package com.mcst.vip.server.repository.impl;

import com.mcst.vip.api.dto.VipPlanDto;
import com.mcst.vip.server.repository.IVipPlanRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.vip.server.persistence.mapper.VipPlanMapper;
import com.mcst.vip.server.persistence.model.VipPlan;
/**
* <p>
* VIP套餐 Repository实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
public class VipPlanRepositoryImpl extends BaseMyBatisRepositoryImpl<VipPlanMapper,VipPlanDto, VipPlan,String> implements IVipPlanRepository {


}