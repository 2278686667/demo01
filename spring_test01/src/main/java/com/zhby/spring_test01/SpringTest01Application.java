package com.zhby.spring_test01;

import com.zhby.spring_test01.a01.Component1;
import com.zhby.spring_test01.a01.UserRegisteredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class SpringTest01Application implements CommandLineRunner {
    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringTest01Application.class, args);
        System.out.println(run);
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
        Map<String,Object> o = (Map<String, Object>) singletonObjects.get(beanFactory);
        o.forEach((k,v)->{
            System.out.println(k+"="+v);
        });
        System.out.println(run.getMessage("thanks", null, Locale.SIMPLIFIED_CHINESE));
        System.out.println(run.getMessage("thanks", null, Locale.ENGLISH));
        System.out.println(run.getMessage("thanks", null, Locale.TRADITIONAL_CHINESE));

        Resource[] resources = run.getResources("classpath*:/META-INF/spring.factories");
        for (Resource resource : resources) {
            System.out.println(resource);
        }
        String java_home = run.getEnvironment().getProperty("java_home");
        String property = run.getEnvironment().getProperty("server.port");
        System.out.println(java_home);
        System.out.println(property);

        run.publishEvent(new UserRegisteredEvent(run));
        run.getBean(Component1.class).register();


        run.close();
    }


    @Override
    public void run(String... args) throws Exception {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
