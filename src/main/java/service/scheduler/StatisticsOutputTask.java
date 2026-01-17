package service.scheduler;

import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;

public final class StatisticsOutputTask implements Runnable {

    private static final Island island = Island.getInstance();

    @Override
    public void run() {
        broadcastPopulation();
    }

    private void broadcastPopulation() {
        final Location[] locations = island.getLocations();
        for (Location location : locations) {
            for (CreatureType type : CreatureType.values()) {
                System.out.printf("%s: %d, %n", type.getEmoji(), location.getCreatureCount(type));
            }
            System.out.println();
        }
    }
}
