package com.example.test.event.test2;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chunbo.ma.o
 * @since 2023/8/29
 */
public abstract class BaseConsumer implements ConsumerInter {
    @Autowired
    private ExtraService extraService;


    protected String test (){
        return "as" + extraService.test();
    }
}
