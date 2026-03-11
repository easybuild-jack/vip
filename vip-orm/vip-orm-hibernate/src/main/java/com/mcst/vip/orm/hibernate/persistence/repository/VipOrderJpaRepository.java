package com.mcst.vip.orm.hibernate.persistence.repository;

import com.mcst.vip.orm.hibernate.persistence.model.VipOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VipOrderJpaRepository extends JpaRepository<VipOrder, String>, JpaSpecificationExecutor<VipOrder> {
}
