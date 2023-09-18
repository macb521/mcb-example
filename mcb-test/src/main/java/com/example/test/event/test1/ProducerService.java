package com.example.test.event.test1;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ApplicationEventPublisher eventPublisher;

    public void objectSend (Integer age){

        List<Integer> integers = Lists.newArrayList(12,13);
        User user = new User();
        user.setName("zhangsan");
        user.setList(integers);
        for (int i = 0; i < 10; i++) {
            user.setAge(i);
            System.out.println("推送User");
            eventPublisher.publishEvent(user);
            System.out.println("----------------------------------------");
            System.out.println(integers);
            System.out.println("----------------------------------------");
        }


    }

}
