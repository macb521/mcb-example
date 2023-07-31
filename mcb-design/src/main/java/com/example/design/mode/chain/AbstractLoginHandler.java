package com.example.design.mode.chain;

import lombok.Data;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.poi.ss.formula.functions.T;

import java.util.Objects;

/**
 * @author chunbo.ma.o
 * @since 2023/6/25
 */
@Data
public abstract class AbstractLoginHandler {

    protected AbstractLoginHandler nextHandler;

    abstract void process (Member member);

    public void execute (Member member){
        process(member);
        if (Objects.nonNull(nextHandler)){
            nextHandler.execute(member);
        }
    }

    /**
     * 建造者模式：可建造责任链的链路
     */
    public static class Builder {
        private AbstractLoginHandler head;
        private AbstractLoginHandler tail;

        public Builder addHandler(AbstractLoginHandler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.nextHandler = handler;
            this.tail = handler;
            return this;
        }

        public AbstractLoginHandler build() {
            return this.head;
        }
    }
}
