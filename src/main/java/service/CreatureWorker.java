package service;

import entity.Creature;
import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
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
                for (var type : CreatureType.values()) {
                    Map<CreatureType, List<Creature>> data = loc.getCreatures();
                    final List<Creature> creatures = data.get(type);
                    final int size = creatures.size();

                    for (var creature : creatures) {
                        for (int i = 0; i < size; i++) {
                            tasks.add(new CreatureTask(creature));
                        }
                    }
                }
            } finally {
                loc.getLock().unlock();
            }
        }
    }
}
