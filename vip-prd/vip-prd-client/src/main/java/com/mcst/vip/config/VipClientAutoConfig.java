package com.mcst.vip.config;

import com.mcst.vip.controller.VipOrderController;
import com.mcst.vip.controller.VipPlanController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Vip Client 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class VipClientAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public VipOrderController vipOrderController() {
        return new VipOrderController();
    }

    @Bean
    @ConditionalOnMissingBean
    public VipPlanController vipPlanController() {
        return new VipPlanController();
    }
}