package com.example.test.event.test2;

import com.example.test.event.test1.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Service
@RequiredArgsConstructor
public class ConsumerService2 implements ApplicationListener<TestEvent> {




    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("xiaofei");
        try {
            System.out.println(Thread.currentThread().getName());
            List<Integer> list = event.getList();
            list.add(event.getAa());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
