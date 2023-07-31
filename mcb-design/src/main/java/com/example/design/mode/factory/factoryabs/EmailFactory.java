package com.example.design.mode.factory.factoryabs;

import com.example.design.mode.factory.EmailU;
import com.example.design.mode.factory.SendServiceInterface;

public class EmailFactory implements Provider {

    //静态内部类实现单例模式：利用类加载机制，线程安全，避免同步锁带来的性能损耗
    static class LazyHolder {
        private static final EmailFactory INSTANCE = new EmailFactory();
    }

    public static EmailFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public SendServiceInterface product() {
        return new EmailU();
    }
}
