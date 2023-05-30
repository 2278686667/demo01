package com.zhby.springboot_nacos_test;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: NacosConfig
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/30 15:05
 * @Version: 1.0
 */
@Configuration
@NacosPropertySource(dataId = "test03", groupId = "DEFAULT_GROUP", autoRefreshed = true,type = ConfigType.YAML)
public class NacosConfig2 {
}
