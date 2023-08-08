package com.example.test.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author chunbo.ma.o
 * @since 2023/8/3
 */
@Data
public class TestModel {
    @ExcelProperty(index = 0)
    private String test1;
    @ExcelProperty(index = 1)
    private String test2;

    @ExcelProperty(index = 2)
    private String test3;

    @ExcelProperty(index = 3)
    private String test4;

    @ExcelProperty(index = 4)
    private Date test5;

    @ExcelProperty(index = 5)
    private Date test6;

    @ExcelProperty(index = 6)
    private Date test7;

    @ExcelProperty(index = 7)
    private Date test8;
    @ExcelIgnore
    private String aaName;
}
