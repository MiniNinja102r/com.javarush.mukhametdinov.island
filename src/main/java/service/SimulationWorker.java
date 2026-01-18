package service;

import config.list.SchedulerConfig;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class SimulationWorker  {

    final Island island = Island.getInstance();

    final ScheduledExecutorService ticker = Executors.newSingleThreadScheduledExecutor();

    final ExecutorService workers = Executors.newFixedThreadPool(SchedulerConfig.Scheduler.CORE_POOL_SIZE);

    public void start() {
        ticker.scheduleAtFixedRate(
                this::tick,
                SchedulerConfig.Scheduler.INITIAL_DELAY,
                SchedulerConfig.Scheduler.DELAY,
                SchedulerConfig.Scheduler.TIMEUNIT
        );
    }

    private void tick() {
        for (Location loc : island.getLocations()) {
            workers.submit(new LocationTask(loc));
        }
    }
}
