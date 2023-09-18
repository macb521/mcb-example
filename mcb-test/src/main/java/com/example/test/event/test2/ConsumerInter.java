package com.example.test.event.test2;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/29
 */

public interface ConsumerInter  {


    /**
     * 数据过滤
     * @param integer integer
     * @return boolean
     */
     boolean filter(Integer integer);

    @EventListener
    void onApplicationEvent(TestEvent event);

}
