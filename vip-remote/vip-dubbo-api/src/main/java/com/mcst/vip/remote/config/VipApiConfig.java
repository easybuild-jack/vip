package com.mcst.vip.remote.config;


import com.mcst.vip.api.*;
import com.mcst.vip.remote.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
*
* @author liu yijun
*/
@AutoConfiguration
public class VipApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IVipOrderApi vipOrderApi() {
         return new VipOrderApiDubboImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipPlanApi vipPlanApi() {
         return new VipPlanApiDubboImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoApi vipInfoApi() {
         return new VipInfoApiDubboImpl();
    }


}
