package com.example.test.controller;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.example.mcbcommon.result.RespResult;
import com.example.test.excel.TestImportModel;
import com.example.test.excel.TestImportModel2;
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
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/7/4
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "hello测试接口")
@RequestMapping("/api/excel")
public class ExcelTestController {

    @PostMapping("test3")
    @ApiOperation(value = "根据模板写入")
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
    @ApiOperation(value = "根据模板写入")
    @SneakyThrows(Exception.class)
    public void test4(HttpServletResponse response) {
        InputStreamSource resource = DownloadUtil.getResource("classpath:template/test template-4.xlsx");

        InputStream inputStream = resource.getInputStream();
        //本地导出
        //excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        //流输出
        DownloadUtil.downloadConfig("test template-4.xlsx", response);
        EasyExcel.write(response.getOutputStream()).withTemplate(inputStream).sheet().doWrite(getData());
    }


    @PostMapping("test5")
    @ApiOperation(value = "多个sheet写入")
    @SneakyThrows(Exception.class)
    public void test5(HttpServletResponse response) {

        //本地导出
        //excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        //流输出
        try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).autoCloseStream(Boolean.FALSE)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                .registerWriteHandler(new SimpleRowHeightStyleStrategy((short) 35, (short) 17)).build()) {


            WriteSheet writeSheet = EasyExcel.writerSheet(0, "data").head(TestImportModel.class).build();

            excelWriter.write(getData(), writeSheet);

            WriteSheet writeSheet2 = EasyExcel.writerSheet(1, "error").head(TestImportModel2.class).build();
            excelWriter.write(getData2(), writeSheet2);

            DownloadUtil.downloadConfig("test template-sheets.xlsx", response);

            excelWriter.finish();
        }
    }

    @PostMapping("test6")
    @ApiOperation(value = "导出--合并单元格")
    @SneakyThrows(Exception.class)
    public void test6(HttpServletResponse response) {

        DownloadUtil.downloadConfig("test-merge.xlsx", response);

        //第二行的3-5列合并
        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(1, 1, 2, 4);
        EasyExcel.write(response.getOutputStream()).sheet("data").registerWriteHandler(onceAbsoluteMergeStrategy).head(getMergeHead()).doWrite(getMergeData());
    }


    private List<TestImportModel2> getData2() {
        List<TestImportModel2> list = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            TestImportModel2 testImportModel2 = new TestImportModel2();
            testImportModel2.setId("aa" + i);

            list.add(testImportModel2);
        }

        return list;
    }

    private List<List<String>> getMergeHead() {
        List<List<String>> list = Lists.newArrayList();
        list.add(Lists.newArrayList("AAA"));
        list.add(Lists.newArrayList("BBB"));
        list.add(Lists.newArrayList("CCC"));
        list.add(Lists.newArrayList("DDD"));
        list.add(Lists.newArrayList("EEE"));
        list.add(Lists.newArrayList("FFF"));

        return list;
    }

    private List<List<Object>> getMergeData() {
        List<List<Object>> list = Lists.newArrayList();

        list.add(Lists.newArrayList("说明1", "说明2", "说明3", "", "", "说明4"));
        list.add(Lists.newArrayList("011", "022", "033", "044", "055", "066"));
        list.add(Lists.newArrayList("011", "022", "033", "044", "055", "066"));


        return list;
    }

    private List<TestImportModel> getData() {
        List<TestImportModel> list = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            TestImportModel testImportModel = new TestImportModel();
            testImportModel.setAaa("a" + i);
            testImportModel.setBbb("b" + i);
            testImportModel.setCcc("c" + i);
            testImportModel.setDdd("d" + i);

            list.add(testImportModel);
        }

        return list;
    }
}
