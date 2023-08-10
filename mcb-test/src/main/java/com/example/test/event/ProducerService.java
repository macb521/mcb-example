package com.example.test.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ApplicationEventPublisher eventPublisher;

    public void objectSend (Integer age){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(age);

        System.out.println("推送User");
        eventPublisher.publishEvent(user);
    }

}
