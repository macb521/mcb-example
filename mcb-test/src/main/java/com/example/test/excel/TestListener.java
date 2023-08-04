package com.example.test.excel;

import com.alibaba.excel.read.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author chunbo.ma.o
 * @since 2023/8/3
 */
@Slf4j
public class TestListener extends PageReadListener<TestModel> {
    public TestListener(Consumer<List<TestModel>> consumer) {
        super(consumer);
    }
}
