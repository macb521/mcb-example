package com.example.test.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@Data
@ApiModel("测试响应")
public class TestResp {

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("生日")
    private Date birthday;
}
