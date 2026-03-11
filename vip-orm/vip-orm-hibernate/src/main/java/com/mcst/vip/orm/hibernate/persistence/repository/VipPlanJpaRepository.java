package com.mcst.vip.orm.hibernate.persistence.repository;

import com.mcst.vip.orm.hibernate.persistence.model.VipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VipPlanJpaRepository extends JpaRepository<VipPlan, String>, JpaSpecificationExecutor<VipPlan> {
}
