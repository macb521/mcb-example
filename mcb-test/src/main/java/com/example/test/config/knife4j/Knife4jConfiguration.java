package com.example.test.config.knife4j;

import com.example.mcbcommon.bo.Knife4jProperties;
import com.example.mcbcommon.config.BaseKnife4jConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author chunbo.ma.o
 * @since 2023/8/4
 */
@Configuration
@EnableOpenApi
public class Knife4jConfiguration extends BaseKnife4jConfig {

    @Override
    public Knife4jProperties knife4jProperties() {
        return Knife4jProperties.builder()
                .apiBasePackage("com.example.test")
                .title("Api接口文档")
                .description("Api接口文档")
                .contactName("chunbo.ma")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
