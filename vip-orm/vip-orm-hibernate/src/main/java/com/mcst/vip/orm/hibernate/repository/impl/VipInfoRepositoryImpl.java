package com.mcst.vip.orm.hibernate.repository.impl;

import com.mcst.vip.api.dto.VipInfoDto;
import com.mcst.vip.orm.hibernate.persistence.model.VipInfo;
import com.mcst.vip.orm.hibernate.persistence.repository.VipInfoJpaRepository;
import com.mcst.vip.orm.repository.IVipInfoRepository;
import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;

public class VipInfoRepositoryImpl extends BaseHibernateRepositoryImpl<VipInfoJpaRepository, VipInfoDto, VipInfo, String> implements IVipInfoRepository {
}
