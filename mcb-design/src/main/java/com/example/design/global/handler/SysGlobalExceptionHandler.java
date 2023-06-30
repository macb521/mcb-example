package com.example.design.global.handler;

import com.example.design.global.RespResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 全局异常处理器
 *
 * @author dengcheng,kesheng
 */
@RestControllerAdvice
public class SysGlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(SysGlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public RespResult<Void> handleException (Exception e, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return RespResult.error( ExceptionUtils.getStackTrace(e));
    }
}
