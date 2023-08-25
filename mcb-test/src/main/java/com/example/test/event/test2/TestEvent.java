package com.example.test.event.test2;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/25
 */
@Getter
public class TestEvent extends ApplicationEvent {
    private final Integer aa;
    private final List<Integer> list;

    public TestEvent(Object source, Integer aa, List<Integer> list) {
        super(source);
        this.aa = aa;
        this.list = list;

    }
}
