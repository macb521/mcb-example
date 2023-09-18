package com.example.test.controller;

import cn.hutool.core.date.DatePattern;
import com.example.mcbcommon.result.RespResult;
import com.example.test.req.TestReq;
import com.example.test.resp.TestResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunbo.ma.o
 * @since 2023/7/4
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "hello测试接口")
public class TestController {

    @PostMapping("test")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public RespResult<TestResp> test (@RequestBody TestReq req){
        TestResp resp = new TestResp();
        resp.setName("张三");
        resp.setAge(19);
        resp.setBirthday(DateUtils.parseDate("1995-09-06", DatePattern.NORM_DATE_PATTERN));
        return RespResult.success(resp);
    }


    @PostMapping("test1")
    @ApiOperation(value = "测试接口")
    @SneakyThrows(Exception.class)
    public RespResult<Void> test1 (@RequestBody TestReq req){
        TestResp resp = new TestResp();
        resp.setName("张三");
        resp.setAge(19);
        resp.setBirthday(DateUtils.parseDate("1995-09-06", DatePattern.NORM_DATE_PATTERN));
        return RespResult.success();
    }


}
