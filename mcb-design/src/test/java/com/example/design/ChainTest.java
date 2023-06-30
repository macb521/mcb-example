package com.example.design;

import com.example.design.mode.chain.ChainContext;
import com.example.design.mode.chain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@SpringBootTest
public class ChainTest {
    @SpyBean
    private ChainContext context;


    @Test
    public void login (){
        Member member = new Member();
        member.setLoginName("tom");
        member.setLoginPass("666");
        context.loginProcess(member);

    }
}
