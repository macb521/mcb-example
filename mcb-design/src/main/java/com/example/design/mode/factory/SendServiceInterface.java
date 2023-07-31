package com.example.design.mode.factory;

import org.springframework.beans.factory.InitializingBean;

public interface SendServiceInterface extends InitializingBean {

    boolean send(String content);

    default void sendLog(String content, Boolean isSuccess) {
        System.out.printf("content :: %s,isSuccess :: %s%n", content, isSuccess);
    }
}
