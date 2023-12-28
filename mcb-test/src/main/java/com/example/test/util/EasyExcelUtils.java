package com.example.test.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/12/26
 */
public class EasyExcelUtils {

    public static <T> List<T> simpleParseExcel(MultipartFile file, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        try {
            EasyExcel.read(file.getInputStream(), tClass, new PageReadListener<T>(result::addAll))
                    .sheet()
                    .doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
