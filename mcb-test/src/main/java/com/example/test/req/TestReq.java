package com.example.test.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@Data
@ApiModel("测试请求")
public class TestReq {

    @ApiModelProperty("主键id")
    private Long id;
}
