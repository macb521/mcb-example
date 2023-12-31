package com.example.test.event.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Service
@RequiredArgsConstructor
public class ConsumerService {


    @EventListener
    public void consumerObject (User user){
        System.out.println("消费User");
        try {
            System.out.println(Thread.currentThread().getName());
            user.getList().add(user.getAge());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
    }
}
