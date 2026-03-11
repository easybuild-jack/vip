package com.mcst.vip.orm.plus.repository.impl;

import com.mcst.vip.api.dto.VipInfoDto;
import com.mcst.vip.orm.repository.IVipInfoRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.vip.orm.plus.persistence.mapper.VipInfoMapper;
import com.mcst.vip.orm.plus.persistence.model.VipInfo;
/**
* <p>
* VIP信息 Repository实现类
* </p>
*
* @author liu yijun
* @since 2026-01-28
*/
public class VipInfoRepositoryImpl extends BaseMyBatisRepositoryImpl<VipInfoMapper,VipInfoDto, VipInfo,String> implements IVipInfoRepository {


}
