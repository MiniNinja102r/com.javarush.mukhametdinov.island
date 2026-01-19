package service;

import config.list.SchedulerConfig;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class SimulationWorker  {

    final StatisticsService statistics;
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
        final Location[] locations = island.getLocations();
        final CountDownLatch cdl = new CountDownLatch(locations.length);

        for (Location loc : locations) {
            workers.submit(() -> {
                try {
                    new LocationTask(loc, island).run();
                } finally {
                    cdl.countDown();
                }
            });
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.severe("Произошла ошибка в работе тикера: " + e);
        }

        statistics.broadcastPopulation();
    }
}
