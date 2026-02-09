package com.mcst.vip.server.config;

import com.mcst.vip.api.*;
import com.mcst.vip.server.service.*;
import com.mcst.vip.server.repository.*;
import com.mcst.vip.server.impl.*;
import com.mcst.vip.server.service.impl.*;
import com.mcst.vip.server.repository.impl.*;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
/**
*
* @author liu yijun
*/
@AutoConfiguration
@EnableConfigurationProperties
public class VipServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public IVipOrderApi vipOrderApi() {
        return new VipOrderApiServerImpl();
    }
    @Bean
    @ConditionalOnMissingBean
    public IVipPlanApi vipPlanApi() {
        return new VipPlanApiServerImpl();
    }
    @Bean
    @ConditionalOnMissingBean
    public IVipInfoApi vipInfoApi() {
        return new VipInfoApiServerImpl();
    }


    @Bean
    @ConditionalOnMissingBean
    public IVipOrderService vipOrderService() {
        return new VipOrderServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipPlanService vipPlanService() {
        return new VipPlanServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoService vipInfoService() {
        return new VipInfoServiceImpl();
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

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoRepository vipInfoRepository() {
        return new VipInfoRepositoryImpl();
    }


}
