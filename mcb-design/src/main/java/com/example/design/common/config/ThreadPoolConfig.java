package com.example.design.common.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname ThreadPoolConfig
 * @Description TODO
 * @Date 2023/4/18 15:41
 * @Created by 马春波
 */
@Configuration
public class ThreadPoolConfig implements AsyncConfigurer {
    /**
     * 通过getAsyncExecutor方法配置ThreadPoolTaskExecutor,获得一个基于线程池TaskExecutor
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(5);//核心线程数
        pool.setMaxPoolSize(10);//最大线程数
        pool.setQueueCapacity(25);//线程队列
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.setThreadNamePrefix("服务名".concat("-ASYNC-"));
        pool.initialize();//线程初始化
        return pool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
