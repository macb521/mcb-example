package com.example.test.event.test2;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/25
 */
@Service
public class ProductService2 {

    @Autowired
    private ApplicationContext applicationContext;



    public void send (){
        List<Integer> list = Lists.newArrayList(13,15);

        for (int i = 0; i < 10; i++) {
            applicationContext.publishEvent(new TestEvent(this,i,list));
            System.out.println("--------------------");
            System.out.println(list);
            System.out.println("--------------------");
        }

    }
}
