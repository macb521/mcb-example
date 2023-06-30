package com.example.design.mode.factory.factoryabs;

import com.example.design.mode.factory.SendServiceInterface;
import com.example.design.mode.factory.SmsU;

public class SmsFactory implements Provider {

    //双重检查单例模式：线程安全，同步锁性能损耗，
    /**
     * volatile关键字 禁止new的时候重排序；
     * new 对象时，会有三条字节码指令：
     * 1，堆中创建对象；
     * 2，初始化堆中对象；
     * 3，将对象的地址赋值给变量。
     */
    private volatile static SmsFactory smsFactory;

    public static SmsFactory getInstance() {
        if (smsFactory == null) {
            synchronized (SmsFactory.class) {
                if (smsFactory == null) {
                    smsFactory = new SmsFactory();
                }
            }
        }

        return smsFactory;
    }

    @Override
    public SendServiceInterface product() {
        return new SmsU();
    }
}
