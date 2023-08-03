package com.example.mcbtest.util;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/3
 */
public class CsvUtils {


    @SneakyThrows(Exception.class)
    public static void main(String[] args) {
        test1("C:\\Users\\chunbo.ma.o\\Desktop\\副本测试2.csv");
/*        List<List<String>> listList = test2("C:\\Users\\chunbo.ma.o\\Desktop\\副本测试2.csv");
        listList.forEach(item -> item.forEach(System.out::println));*/

    }

    private static final String[] HEADER;
    private static final char DELIMITER;

    static {
        HEADER = new String[]{"transactionNo", "stopTime", "commodityName"};
        DELIMITER = ',';
    }

    public static CSVFormat readCustomCsvFormat() {
        return CSVFormat.DEFAULT
                .withHeader(HEADER)
                .withSkipHeaderRecord()
                // 设置分隔符
                .withDelimiter(DELIMITER)
                //跳过表头
                .withSkipHeaderRecord(true)
                ;
    }


    public static void test1(String path) {
        List<TestObj> list = Lists.newArrayList();
        try (FileReader fileReader = new FileReader(path);
             CSVParser csvParser = new CSVParser(fileReader, readCustomCsvFormat())) {
            csvParser.getRecords().forEach(csvRecord -> list.add(TestObj.builder()
                    .transactionNo(csvRecord.get("transactionNo"))
                    .stopTime(csvRecord.get("transactionNo"))
                    .commodityName(csvRecord.get("commodityName"))
                    .build()));
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Data
    @Builder
    public static class TestObj {
        private String transactionNo;
        private String stopTime;

        private String commodityName;

    }


    @SneakyThrows(Exception.class)
    public static List<List<String>> test2(String filePath) {

        FileReader fileReader = new FileReader(filePath);

        CSVParser parse = CSVFormat.DEFAULT.withDelimiter(DELIMITER).withQuoteMode(QuoteMode.ALL).withQuote('"').parse(fileReader);
        List<List<String>> data = new LinkedList<>();
        for (CSVRecord record : parse.getRecords()) {
            List<String> list = new ArrayList<>();
            for (String s : record) {
                list.add(s);
            }
            data.add(list);
        }
        fileReader.close();
        parse.close();
        return data;
    }
}
