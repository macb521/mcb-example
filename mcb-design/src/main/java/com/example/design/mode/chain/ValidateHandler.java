package com.example.design.mode.chain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@Component
@Order(1)
@ConditionalOnProperty(value = "chain.login.enable", havingValue = "true")
public class ValidateHandler extends AbstractLoginHandler {
    @Override
    void process(Member member) {
        if (StringUtils.isEmpty(member.getLoginName()) || StringUtils.isEmpty(member.getLoginPass())) {
            System.out.println("用户名或者密码为空");
            return;
        }
        System.out.println("用户名和密码校验成功，可以往下执行");
    }

}

