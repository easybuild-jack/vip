package com.mcst.vip.server.repository.impl;

import com.mcst.orm.mybatis.core.BaseRepositoryImpl;
import com.mcst.vip.server.persistence.mapper.VipInfoMapper;
import com.mcst.vip.server.persistence.model.VipInfo;
import com.mcst.vip.server.repository.IVipInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * VIP会员 仓储实现
 *
 * @author easyfk
 */
@Repository
public class VipInfoRepositoryImpl extends BaseRepositoryImpl<VipInfoMapper, VipInfo> implements IVipInfoRepository {

    @Override
    public VipInfo findByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }
}
