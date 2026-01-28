package com.mcst.vip.server.repository.impl;

import com.mcst.vip.api.dto.VipOrderDto;
import com.mcst.vip.server.repository.IVipOrderRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.vip.server.persistence.mapper.VipOrderMapper;
import com.mcst.vip.server.persistence.model.VipOrder;
/**
* <p>
* VIP订单 Repository实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
public class VipOrderRepositoryImpl extends BaseMyBatisRepositoryImpl<VipOrderMapper,VipOrderDto, VipOrder,String> implements IVipOrderRepository {


}