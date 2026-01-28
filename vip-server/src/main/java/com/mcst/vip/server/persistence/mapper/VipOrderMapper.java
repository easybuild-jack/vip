package com.mcst.vip.server.persistence.mapper;

import com.mcst.orm.mybatis.core.BaseMapper;
import com.mcst.vip.server.persistence.model.VipOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * VIP购买订单 Mapper 接口
 *
 * @author easyfk
 */
@Mapper
public interface VipOrderMapper extends BaseMapper<VipOrder> {

}
