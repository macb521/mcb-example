package com.example.test.event.test2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = {"c3.enabled"}, havingValue = "true", matchIfMissing = true)
public class ConsumerService3 extends BaseConsumer {

    @Override
    @Async
    public void onApplicationEvent(TestEvent event) {
        List<Integer> collect = event.getList().stream().filter(this::filter).collect(Collectors.toList());

        System.out.println("------------------cousumer3-------------------start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cousumer3" + Thread.currentThread().getName());
        System.out.println("cousumer3" + collect);
        System.out.println("cousumer3" + event.getAa());
        System.out.println("cousumer3" + test());
        System.out.println("------------------cousumer3-------------------end");

    }

    @Override
    public boolean filter(Integer integer) {
        return 6 < integer && integer <= 9;
    }
}
