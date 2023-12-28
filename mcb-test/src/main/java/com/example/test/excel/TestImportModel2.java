package com.example.test.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author chunbo.ma.o
 * @since 2023/12/22
 */
@Data
public class TestImportModel2 {
    @ExcelProperty("ID")
    private String id;


}
