package com.mcst.vip.server.repository.impl;

import com.mcst.orm.mybatis.core.BaseRepositoryImpl;
import com.mcst.vip.server.persistence.mapper.VipOrderMapper;
import com.mcst.vip.server.persistence.model.VipOrder;
import com.mcst.vip.server.repository.IVipOrderRepository;
import org.springframework.stereotype.Repository;

/**
 * VIP购买订单 仓储实现
 *
 * @author easyfk
 */
@Repository
public class VipOrderRepositoryImpl extends BaseRepositoryImpl<VipOrderMapper, VipOrder>
        implements IVipOrderRepository {

}
