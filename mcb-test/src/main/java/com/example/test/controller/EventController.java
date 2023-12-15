package com.example.test.controller;

import com.example.mcbcommon.result.RespResult;
import com.example.test.event.test1.ProducerService;
import com.example.test.event.test2.ProductService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ProductService2 producerService2;

    @GetMapping("/test")
    public RespResult<Void> test(@RequestParam("age") Integer age) {
        producerService.objectSend(age);
        return RespResult.success();
    }

    @GetMapping("/test2")
    public RespResult<Void> test() {
        producerService2.send();
        return RespResult.success();
    }
}
