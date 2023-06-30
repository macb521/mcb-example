package com.example.design.mode.chain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@Component
@Order(3)
public class AuthHandler extends AbstractLoginHandler {
    @Override
    void process(Member member) {
        if (!StringUtils.equals( "管理员",member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("您是管理员，允许操作");
    }
}
