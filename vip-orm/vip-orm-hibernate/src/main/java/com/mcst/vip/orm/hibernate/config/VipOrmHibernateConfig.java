package com.mcst.vip.orm.hibernate.config;

import com.mcst.vip.orm.hibernate.repository.impl.VipInfoRepositoryImpl;
import com.mcst.vip.orm.hibernate.repository.impl.VipOrderRepositoryImpl;
import com.mcst.vip.orm.hibernate.repository.impl.VipPlanRepositoryImpl;
import com.mcst.vip.orm.repository.IVipInfoRepository;
import com.mcst.vip.orm.repository.IVipOrderRepository;
import com.mcst.vip.orm.repository.IVipPlanRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties
public class VipOrmHibernateConfig {

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoRepository vipInfoRepository() {
        return new VipInfoRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipOrderRepository vipOrderRepository() {
        return new VipOrderRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipPlanRepository vipPlanRepository() {
        return new VipPlanRepositoryImpl();
    }
}
