package com.zhby.spring_test01.a01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @ClassName: TestBeanFactory
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/30 15:50
 * @Version: 1.0
 */

public class TestBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        AbstractBeanDefinition bea = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config",bea);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        //获取多个bean
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().stream().forEach(beanFactoryPostProcessor ->
                beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        //给

    }

    @Configuration
    static class Config {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    @Slf4j
    static class Bean1 {
        public Bean1() {
            log.debug("构造 Bean1()");
        }

        @Autowired
        private Bean2 bean2;

        public Bean2 getBean2() {
            return bean2;
        }
    }

    @Slf4j
    static class Bean2 {
        public Bean2() {
            log.debug("构造 Bean2()");
        }
    }
}
