package com.example.mcbcommon.handle;

import com.example.mcbcommon.result.RespResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author dengcheng, kesheng
 */
@RestControllerAdvice
public class SysGlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(SysGlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public RespResult<Void> handleException(Exception e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestUri, e);
        return RespResult.error(e.getMessage());
    }
}
