package com.example.test.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author louis.ning
 * @since 2023/3/20
 */
@Slf4j
public class DownloadUtil {
    private DownloadUtil() {
    }

    public static final String RESPONSE_ATTACHMENT = "attachment; filename=\"";

    /**
     * 根据path获取resource
     *
     * @param path path
     * @return io
     */
    public static InputStreamSource getResource(String path) {
        return new DefaultResourceLoader().getResource(path);
    }


    public static void responseConfig(String filename, HttpServletResponse response) throws UnsupportedEncodingException {
        //创建流对象
        response.reset();
//        String newName = URLEncoder.encode(filename, "UTF-8");
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, RESPONSE_ATTACHMENT + filename + "\"");

        response.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    }
}
