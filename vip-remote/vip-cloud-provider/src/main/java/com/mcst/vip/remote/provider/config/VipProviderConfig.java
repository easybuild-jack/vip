package com.mcst.vip.remote.provider.config;

import com.mcst.vip.remote.*;
import com.mcst.vip.remote.provider.impl.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

/**
*
* @author liu yijun
*/
@AutoConfiguration
public class VipProviderConfig {

    @Bean
    @ConditionalOnMissingBean
    public IVipOrderRemote vipOrderRemote() {
         return new VipOrderRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipPlanRemote vipPlanRemote() {
         return new VipPlanRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IVipInfoRemote vipInfoRemote() {
         return new VipInfoRemoteImpl();
    }


}
