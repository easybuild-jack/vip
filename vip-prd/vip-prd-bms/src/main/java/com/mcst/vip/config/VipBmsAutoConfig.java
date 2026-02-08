package com.mcst.vip.config;

import com.mcst.vip.controller.VipInfoBmsController;
import com.mcst.vip.controller.VipPlanBmsController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Vip BMS 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class VipBmsAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public VipInfoBmsController vipInfoBmsController() {
        return new VipInfoBmsController();
    }

    @Bean
    @ConditionalOnMissingBean
    public VipPlanBmsController vipPlanBmsController() {
        return new VipPlanBmsController();
    }
}