package com.zhby.springboot_nacos_test;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootNacosTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNacosTestApplication.class, args);
    }

}
