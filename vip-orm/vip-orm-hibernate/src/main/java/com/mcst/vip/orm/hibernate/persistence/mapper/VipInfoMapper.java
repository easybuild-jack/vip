package com.mcst.vip.orm.hibernate.persistence.mapper;

import com.mcst.vip.orm.hibernate.persistence.model.VipInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VipInfoMapper extends JpaRepository<VipInfo, String>, JpaSpecificationExecutor<VipInfo> {
}
