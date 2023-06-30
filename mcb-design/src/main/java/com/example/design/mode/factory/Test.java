package com.example.design.mode.factory;

import com.example.design.mode.factory.factoryabs.EmailFactory;
import com.example.design.mode.factory.factoryabs.SendFactory;
import com.example.design.mode.factory.factoryabs.SmsFactory;

public class Test {


    public static void main(String[] args) {
        //静态方法工厂模式
        SendFactory.email().send("发送邮件");
        SendFactory.sms().send("发送短信");

        //抽象工厂模式
        SmsFactory.getInstance()
                .product()
                .send("发送短信了");

        EmailFactory.getInstance()
                .product()
                .send("发送邮件了");

    }


}
