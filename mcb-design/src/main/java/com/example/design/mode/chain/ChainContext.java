package com.example.design.mode.chain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@Component
@RequiredArgsConstructor
public class ChainContext {
    private final List<AbstractLoginHandler> loginHandlerList;

    @Setter
    private AbstractLoginHandler abstractLoginHandler;

    @PostConstruct
    private void init() {
        if (CollectionUtils.isEmpty(loginHandlerList)) {
            return;
        }
        abstractLoginHandler = loginHandlerList.get(0);
        int num = loginHandlerList.size() - 1;
        for (int i = 0; i < num; i++) {
            loginHandlerList.get(i).setNextHandler(loginHandlerList.get(i + 1));
        }
    }

    public void loginProcess (Member member){
        abstractLoginHandler.execute(member);
    }


}
