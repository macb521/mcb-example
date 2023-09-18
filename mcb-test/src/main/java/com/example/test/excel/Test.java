package com.example.test.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/3
 */
public class Test {

    @SneakyThrows(Exception.class)
    public static void main(String[] args) {
        List<TestModel> testModels = test1("C:\\Users\\chunbo.ma.o\\Documents\\WeChat Files\\wxid_mpgcfm71ch9422\\FileStorage\\File\\2023-08\\20230727_暖哇核保风控反馈(1).csv");

        testModels.forEach(System.out::println);
    }

    public static List<TestModel> test1(String filePath) {
        List<TestModel> result = Lists.newArrayList();

        EasyExcel.read(filePath, TestModel.class, new PageReadListener<TestModel>(result::addAll))
                .sheet()
                .doRead();

        return result;

    }




}
