package com.mcst.vip.orm.hibernate.persistence.repository;

import com.mcst.vip.orm.hibernate.persistence.model.VipInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VipInfoJpaRepository extends JpaRepository<VipInfo, String>, JpaSpecificationExecutor<VipInfo> {
}
