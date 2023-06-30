package com.example.design.mode.factory;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SendTypeContext {

    public static Map<String, SendServiceInterface> handlerMap = new ConcurrentHashMap<>();

    public static void regist(String sendType, SendServiceInterface sendServiceInterface) {
        if (StringUtils.isBlank(sendType) || Objects.isNull(sendServiceInterface)) {
            return;
        }

        handlerMap.put(sendType, sendServiceInterface);
    }

    public static SendServiceInterface getHandler(String sendType) {
        return handlerMap.get(sendType);
    }

}
