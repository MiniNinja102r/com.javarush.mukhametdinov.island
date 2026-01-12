package service.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Scheduler {

    public static void startScheduleTask() {
        var scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new SchedulerTask(), 1, 1, TimeUnit.SECONDS);
    }
}
