package com.example.design.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname TaskExecutorConfig
 * @Description TODO
 * @Date 2023/4/18 15:44
 * @Created by 马春波
 */
@Configuration
public class TaskExecutorConfig {

    private static final Logger log = LoggerFactory.getLogger(TaskExecutorConfig.class);

    @Value("${config.task.corePoolSize:5}")
    private int corePoolSize;

    @Value("${config.task.maxPoolSize:25}")
    private int maxPoolSize;

    @Value("${config.task.queueCapacity:20}")
    private int queueCapacity;

    @Value("${config.task.keepAliveSeconds:60}")
    private int keepAliveSeconds;

    @Bean
    public ThreadPoolTaskExecutor eventTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数,默认为1
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        // 最大线程数,默认为Integer.MAX_VALUE
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        // 队列最大长度,一般需要设置值>=notifyScheduledMainExecutor.maxNum;默认为Integer.MAX_VALUE
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        // 线程池维护线程所允许的空闲时间，默认为60s
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        // 线程池对拒绝任务（无线程可用）的处理策略
        // AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常
        // CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
        // DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行
        // DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待任务在关机时完成--表明等待所有线程执行完
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间(默认为0,此时立即停止),并没等待xx秒后强制停止
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60 * 5);
        //创建线程或线程池时请指定有意义的线程名称，方便出错时回溯
        threadPoolTaskExecutor.setThreadNamePrefix("服务名".concat("-TASK-"));
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
