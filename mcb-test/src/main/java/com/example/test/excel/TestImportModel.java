package com.example.test.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;

/**
 * @author chunbo.ma.o
 * @since 2023/12/22
 */
@Data
public class TestImportModel {
    @ExcelProperty("AAA")
    private String aaa;
    @ExcelProperty("BBB")
    private String bbb;
    @ExcelProperty("CCC")
    private WriteCellData<String> ccc;
    @ExcelProperty("DDD")
    private String ddd;


}
