package com.mcst.vip.remote.config;


import com.mcst.vip.api.*;
import com.mcst.vip.remote.impl.*;
import com.mcst.vip.remote.properties.VipApiProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
*
* @author liu yijun
*/
@AutoConfiguration
@EnableConfigurationProperties(VipApiProperties.class)
public class VipApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IVipOrderApi vipOrderApi() {
         return new VipOrderApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipPlanApi vipPlanApi() {
         return new VipPlanApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoApi vipInfoApi() {
         return new VipInfoApiScImpl();
    }


}
