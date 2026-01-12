package service.scheduler;

import config.list.SchedulerConfig;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Scheduler {

    public static void startScheduleTask() {
        var executorService = Executors.newScheduledThreadPool(SchedulerConfig.Scheduler.CORE_POOL_SIZE);
        executorService.scheduleWithFixedDelay(new StatisticsOutputTask(), 1, 1, TimeUnit.SECONDS);
    }
}
