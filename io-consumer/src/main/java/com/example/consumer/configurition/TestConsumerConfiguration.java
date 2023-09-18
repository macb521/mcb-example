package com.example.consumer.configurition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@Configuration
public class TestConsumerConfiguration {
    @Bean
    public Consumer<String> test() {
        return (msg) -> {
            System.out.println("consumer:" + msg);
        };
    }
}
