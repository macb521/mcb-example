package com.example.test.controller;

import com.example.mcbcommon.result.RespResult;
import com.example.test.event.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@RestController
public class EventController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/test")
    public RespResult<Void> test(@RequestParam("age") Integer age) {
        producerService.objectSend(age);
        return RespResult.success();
    }
}
