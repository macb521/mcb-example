package com.example.test.config.thread;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
@Configuration
@EnableAsync
public class AsyncEventConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        //核心线程数
        pool.setCorePoolSize(5);
        //最大线程数
        pool.setMaxPoolSize(10);
        //线程队列
        pool.setQueueCapacity(25);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.setThreadNamePrefix("服务名".concat("-ASYNC-"));
        //线程初始化
        pool.initialize();
        return pool;
    }
}
