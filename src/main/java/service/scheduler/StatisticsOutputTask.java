package service.scheduler;

import entity.Creature;
import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;

import java.util.Map;

public final class StatisticsOutputTask implements Runnable {

    private static final Island island = Island.getInstance();

    @Override
    public void run() {
        broadcastPopulation();
    }

    private void broadcastPopulation() {
        final Location[] locations = island.getLocations();
        for (Location location : locations) {
            final Map<Creature, Integer> creatures = location.getCreatures();
            for (CreatureType type : CreatureType.values()) {
                int count = 0;
                for (var entry : creatures.entrySet()) {
                    if (entry.getKey().type() == type)
                        count += entry.getValue();
                }
                System.out.printf("%s: %d, ", type.getEmoji(), count);
            }
        }
        System.out.printf("%n");
    }
}
