package com.example.gateway.filter;

import com.example.gateway.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author chunbo.ma.o
 * @since 2023/12/22
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("custom global filter");
        String cookie = exchange.getRequest().getHeaders().getFirst(CommonConstant.COOKIE);
        log.info("cookie:" + cookie);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
