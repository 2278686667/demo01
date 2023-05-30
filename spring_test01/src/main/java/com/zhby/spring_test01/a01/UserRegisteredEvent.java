package com.zhby.spring_test01.a01;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    private static final long serialVersionUID = 6319117283222183184L;

    public UserRegisteredEvent(Object source) {
        super(source);
    }
}