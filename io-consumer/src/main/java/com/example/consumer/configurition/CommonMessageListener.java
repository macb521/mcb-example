package com.example.consumer.configurition;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Classname CommonMessageListener
 * @Description TODO
 * @Date 2024/3/6 15:10
 * @Created by 马春波
 */
@Component
public class CommonMessageListener {

    /**
     * 同一topic不同组,都会消费消息
     * @param record
     */
    @KafkaListener(topics = {"test1"},groupId = "testGroup1")
    public void listener(ConsumerRecord<String, String> record) {
        String message = record.value();
        long offset = record.offset();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1---testGroup1读取的消息：" + message + ";当前偏移量：" + offset);
    }

    /**
     * 同一topic相同组,只有一个会消费，且当多个消费者时，分区数应>=消费者数，不然部分消费者会一直消费不到消息
     * @param record
     */
    @KafkaListener(topics = {"test2"},groupId = "testGroup")
    public void listener2(ConsumerRecord<String, String> record) {
        String message = record.value();
        long offset = record.offset();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2---testGroup读取的消息：" + message + ";当前偏移量：" + offset);
    }
}
