package com.util;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuCheng
 * @date 2021/6/24 9:59
 */
public class GlobalExecutor {
    /**
     * Quartz定时任务使用的线程池，采集任务和归档任务都会使用到，所以线程设置比较大
     */
    public static final ThreadPoolExecutor QUARTZ_THREAD_POOL = new ThreadPoolExecutor(30, 30,
            0L, TimeUnit.SECONDS, new ArrayBlockingQueue(1024), new ThreadPoolExecutor.CallerRunsPolicy());

    public static final Executor GRPC_NOTIFIER_EXECUTOR = Executors.newSingleThreadExecutor(
            new NamedThreadFactory("com.genew.traffic.component.PublishDispatcher", false));

    public static final Executor TELEMETRY_MESSAGE_NOTIFIER_EXECUTOR = Executors.newSingleThreadExecutor(
            new NamedThreadFactory("com.genew.traffic.component.TelemetryMessageDispatcher", false));

    public static final ThreadPoolExecutor TELEMETRY_MESSAGE_PROCESS_POOL = new ThreadPoolExecutor(30, 30,
            0L, TimeUnit.SECONDS, new ArrayBlockingQueue(1024), new ThreadPoolExecutor.CallerRunsPolicy());

    public static final ThreadPoolExecutor UPDATE_TELEMETRY_BIND_PROCESS_POOL = new ThreadPoolExecutor(30, 30,
            0L, TimeUnit.SECONDS, new ArrayBlockingQueue(1024), new ThreadPoolExecutor.CallerRunsPolicy());
}
