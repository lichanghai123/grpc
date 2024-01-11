package com.telemetry;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.core.TelemetryMessageEventProcessor;
import com.util.GlobalExecutor;

import javax.annotation.PostConstruct;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author LiuCheng
 * @date 2021/6/24 11:44
 */
@Component
@Slf4j
public class TelemetryMessageDispatcher implements Runnable {
    private BlockingQueue<TelemetryGPBTableData> queue = new ArrayBlockingQueue<>(1024 * 1024);

    @PostConstruct
    public void init() {
    	 GlobalExecutor.TELEMETRY_MESSAGE_NOTIFIER_EXECUTOR.execute(this);
    }

    public void addTelemetryMessage(TelemetryGPBTableData telemetryMessage) {
        queue.offer(telemetryMessage);
    }

    @Override
    public void run() {
        log.info("Telemetry message dispatcher started.");

        for (; ; ) {
            try {
            	TelemetryGPBTableData telemetryMessage = queue.take();
                GlobalExecutor.TELEMETRY_MESSAGE_PROCESS_POOL.execute(new TelemetryMessageEventProcessor(telemetryMessage));
            } catch (InterruptedException e) {
                log.error("Error while handling telemetry message", e);
            }
        }
    }
}
