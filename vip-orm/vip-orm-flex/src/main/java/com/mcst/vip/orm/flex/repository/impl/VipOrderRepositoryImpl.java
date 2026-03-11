package com.mcst.vip.orm.flex.repository.impl;

import com.mcst.vip.api.dto.VipOrderDto;
import com.mcst.vip.orm.flex.persistence.mapper.VipOrderMapper;
import com.mcst.vip.orm.flex.persistence.model.VipOrder;
import com.mcst.vip.orm.repository.IVipOrderRepository;
import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;

public class VipOrderRepositoryImpl extends BaseFlexRepositoryImpl<VipOrderMapper, VipOrderDto, VipOrder, String> implements IVipOrderRepository {
}
