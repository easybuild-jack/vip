package com.mcst.vip.orm.plus.config;

import com.mcst.vip.orm.plus.repository.impl.VipInfoRepositoryImpl;
import com.mcst.vip.orm.plus.repository.impl.VipOrderRepositoryImpl;
import com.mcst.vip.orm.plus.repository.impl.VipPlanRepositoryImpl;
import com.mcst.vip.orm.repository.IVipInfoRepository;
import com.mcst.vip.orm.repository.IVipOrderRepository;
import com.mcst.vip.orm.repository.IVipPlanRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties
public class VipOrmPlusConfig {

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
