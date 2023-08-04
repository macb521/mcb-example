package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@RestController
public class CloudStreamController {

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/send")
    public void send (@RequestParam(value = "name") String name){
        System.out.println("param:" + name);
        streamBridge.send("test-topic",name);
    }
}
