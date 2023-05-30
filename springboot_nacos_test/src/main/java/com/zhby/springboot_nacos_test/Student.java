package com.zhby.springboot_nacos_test;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @ClassName: Student
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/30 14:15
 * @Version: 1.0
 */
@RestController
public class Student {

     @RequestMapping("/test")
    public void init(){
         String id = PropertyUtils.getProperty("id");
         System.out.println(id);
     }
}
