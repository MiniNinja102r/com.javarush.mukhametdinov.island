package service;

import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class StatisticsService {

    final Island island = Island.getInstance();

    public void broadcastPopulation() {
        final Location[] locations = island.getLocations();
        for (Location location : locations) {
            for (CreatureType type : CreatureType.values()) {
                System.out.printf("%s: %d, ", type.getEmoji(), location.getCreatureCount(type));
            }
            System.out.println();
        }
    }
}
