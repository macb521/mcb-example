package com.example.design.mode.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SmsU implements SendServiceInterface {
    @Override
    public boolean send(String content) {
        System.out.println("send Sms ...");
        sendLog(content, true);
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SendTypeContext.regist(SendType.SMS.name(), this);
    }
}
