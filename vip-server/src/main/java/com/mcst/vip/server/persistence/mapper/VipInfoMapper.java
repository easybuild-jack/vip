package com.mcst.vip.server.persistence.mapper;

import com.mcst.orm.mybatis.core.BaseMapper;
import com.mcst.vip.server.persistence.model.VipInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * VIP会员 Mapper 接口
 *
 * @author easyfk
 */
@Mapper
public interface VipInfoMapper extends BaseMapper<VipInfo> {

    /**
     * 根据用户ID查询VIP信息
     *
     * @param userId 用户ID
     * @return VIP信息
     */
    VipInfo selectByUserId(@Param("userId") String userId);
}
