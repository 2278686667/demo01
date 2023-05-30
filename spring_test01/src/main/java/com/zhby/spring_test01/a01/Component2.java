package com.zhby.spring_test01.a01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @ClassName: Component1
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/29 16:04
 * @Version: 1.0
 */
@Component
public class Component2 {
    //调试日志
    private final static Logger logger = LoggerFactory.getLogger(Component2.class);

    @EventListener
    public void aaa(UserRegisteredEvent event){
        logger.info("接受");
        logger.debug("{}",event);
    }
}
