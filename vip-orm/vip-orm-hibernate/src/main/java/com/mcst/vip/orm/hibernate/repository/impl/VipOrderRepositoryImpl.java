package com.mcst.vip.orm.hibernate.repository.impl;

import com.mcst.vip.api.dto.VipOrderDto;
import com.mcst.vip.orm.hibernate.persistence.model.VipOrder;
import com.mcst.vip.orm.hibernate.persistence.repository.VipOrderJpaRepository;
import com.mcst.vip.orm.repository.IVipOrderRepository;
import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;

public class VipOrderRepositoryImpl extends BaseHibernateRepositoryImpl<VipOrderJpaRepository, VipOrderDto, VipOrder, String> implements IVipOrderRepository {
}
