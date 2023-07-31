package com.example.design.mode.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class EmailU implements SendServiceInterface {


    @Override
    public boolean send(String content) {
        System.out.println("send Email ...");
        sendLog(content, false);
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SendTypeContext.regist(SendType.EMAIL.name(), this);
    }
}
