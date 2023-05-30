package com.zhby.spring_test01.a01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Component1
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/29 16:04
 * @Version: 1.0
 */
@Component
public class Component1 {
    @Autowired
    private ApplicationEventPublisher context;
    public void register(){
        System.out.println("用户注册");
        context.publishEvent(new UserRegisteredEvent(this));
    }
}
