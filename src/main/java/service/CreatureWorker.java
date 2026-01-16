package service;

import entity.Creature;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class CreatureWorker implements Runnable {

    final Island island;
    final Queue<CreatureTask> tasks = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        final Location[] locations = island.getLocations();
        for (var loc : locations) {
            loc.getLock().lock();
            try {
                Map<Creature, Integer> creatures = loc.getCreatures();
                creatures.forEach((cr, a) -> {
                    for (int i = 0; i < a; i++) {
                        tasks.add(new CreatureTask(cr));
                    }
                });
            } finally {
                loc.getLock().unlock();
            }
        }
    }
}
