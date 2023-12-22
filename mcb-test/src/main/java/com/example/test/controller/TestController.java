package com.example.test.controller;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.mcbcommon.result.RespResult;
import com.example.test.excel.TestImportModel;
import com.example.test.req.TestReq;
import com.example.test.resp.TestResp;
import com.example.test.util.DownloadUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author chunbo.ma.o
 * @since 2023/7/4
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "hello测试接口")
@RequestMapping("/api/test")
public class TestController {

    @PostMapping("test")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public RespResult<TestResp> test(@RequestBody TestReq req) {
        TestResp resp = new TestResp();
        resp.setName("张三");
        resp.setAge(19);
        resp.setBirthday(DateUtils.parseDate("1995-09-06", DatePattern.NORM_DATE_PATTERN));
        return RespResult.success(resp);
    }


    @PostMapping("test1")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public RespResult<Void> test1(@RequestBody TestReq req) {
        TestResp resp = new TestResp();
        resp.setName("张三");
        resp.setAge(19);
        resp.setBirthday(DateUtils.parseDate("1995-09-06", DatePattern.NORM_DATE_PATTERN));
        return RespResult.success();
    }

    @PostMapping("test2")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public RespResult<Void> test2(@RequestBody TestReq req) {
        System.out.println("test22222222222222222222222222222222");
        return RespResult.success();
    }

    @PostMapping("test3")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public void test3(HttpServletResponse response) {
        InputStreamSource resource = DownloadUtil.getResource("classpath:template/test template-3.xlsx");
        XSSFWorkbook write = write(resource.getInputStream());
        DownloadUtil.downloadConfig("test template-3.xlsx", response);

        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        write.write(toClient);
        toClient.flush();
    }

    private XSSFWorkbook write(InputStream is) throws Exception {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);

        XSSFRow row = sheetAt.createRow(2);

        XSSFCell cell = row.createCell(2);

        cell.setCellValue("aaaaaaaa");

        return xssfWorkbook;
    }

    @PostMapping("test4")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public void test4(HttpServletResponse response) {
        InputStreamSource resource = DownloadUtil.getResource("classpath:template/test template-4.xlsx");

        InputStream inputStream = resource.getInputStream();
        //本地导出
        //excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        //流输出
        try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                .withTemplate(inputStream)
                .build()) {

            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            TestImportModel testImportModel = new TestImportModel();
            testImportModel.setBbb("12342414");
            excelWriter.fill(Lists.newArrayList(testImportModel), writeSheet);

            DownloadUtil.downloadConfig("test template-4.xlsx", response);
            excelWriter.finish();
        }
    }

}
