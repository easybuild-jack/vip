package com.mcst.vip.orm.flex.repository.impl;

import com.mcst.vip.api.dto.VipInfoDto;
import com.mcst.vip.orm.flex.persistence.mapper.VipInfoMapper;
import com.mcst.vip.orm.flex.persistence.model.VipInfo;
import com.mcst.vip.orm.repository.IVipInfoRepository;
import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;

public class VipInfoRepositoryImpl extends BaseFlexRepositoryImpl<VipInfoMapper, VipInfoDto, VipInfo, String> implements IVipInfoRepository {
}
