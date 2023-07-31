package com.example.design.mode.chain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@Component
@Order(2)
@ConditionalOnProperty(value = "chain.login.enable",havingValue = "false")
public class LoginHandler extends AbstractLoginHandler {
    @Override
    void process(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
    }
}
