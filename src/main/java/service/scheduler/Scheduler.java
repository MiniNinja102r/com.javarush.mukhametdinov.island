package service.scheduler;

import config.list.SchedulerConfig;
import lombok.experimental.UtilityClass;

import java.util.concurrent.Executors;

@UtilityClass
public final class Scheduler {

    public static void startScheduleTask() {
        var executorService = Executors.newScheduledThreadPool(SchedulerConfig.Scheduler.CORE_POOL_SIZE);
        executorService.scheduleWithFixedDelay(
                new StatisticsOutputTask(),
                SchedulerConfig.Scheduler.INITIAL_DELAY,
                SchedulerConfig.Scheduler.DELAY,
                SchedulerConfig.Scheduler.TIMEUNIT
        );
    }
}
