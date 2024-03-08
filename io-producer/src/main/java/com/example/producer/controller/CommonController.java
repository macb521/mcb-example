package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@RestController
public class CommonController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send/{topic}")
    public String send(@PathVariable("topic") String topic, @RequestParam(value = "msg") String msg) {
        System.out.println("param:" + topic + "::" + msg);

        kafkaTemplate.send(topic, msg);

        return "success";

    }
}
