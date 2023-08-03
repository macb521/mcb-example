package com.example.mcbtest.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author chunbo.ma.o
 * @since 2023/8/3
 */
@Data
public class TestModel {
    @ExcelProperty(index = 0)
    private String transactionNo;
    @ExcelProperty(index = 1)
    @DateTimeFormat("yyyy/MM/dd HH:mm")
    private Date stopTime;

    @ExcelProperty(index = 2)
    private String commodityName;

    @ExcelProperty(index = 3)
    private Date testTime;
    @ExcelIgnore
    private String aaName;
}
