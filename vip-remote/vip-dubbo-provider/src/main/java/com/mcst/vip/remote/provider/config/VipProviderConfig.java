package com.mcst.vip.remote.provider.config;

import com.mcst.vip.remote.IVipInfoRemote;
import com.mcst.vip.remote.IVipOrderRemote;
import com.mcst.vip.remote.IVipPlanRemote;
import com.mcst.vip.remote.provider.impl.VipInfoRemoteImpl;
import com.mcst.vip.remote.provider.impl.VipOrderRemoteImpl;
import com.mcst.vip.remote.provider.impl.VipPlanRemoteImpl;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
public class VipProviderConfig {

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IVipOrderRemote> orderContainerRemoteServiceConfig(VipOrderRemoteImpl vipOrderRemoteImpl) {
        ServiceConfig<IVipOrderRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IVipOrderRemote.class);
        serviceConfig.setRef(vipOrderRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IVipPlanRemote> planContainerRemoteServiceConfig(VipPlanRemoteImpl vipPlanRemoteImpl) {
        ServiceConfig<IVipPlanRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IVipPlanRemote.class);
        serviceConfig.setRef(vipPlanRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IVipInfoRemote> infoContainerRemoteServiceConfig(VipInfoRemoteImpl vipInfoRemoteImpl) {
        ServiceConfig<IVipInfoRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IVipInfoRemote.class);
        serviceConfig.setRef(vipInfoRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }
}
