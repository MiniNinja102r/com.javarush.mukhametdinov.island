package service;

import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.EnumMap;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class StatisticsService {

    final Island island = Island.getInstance();

    public void broadcastPopulation() {
        final Location[] locations = island.getLocations();
        final Map<CreatureType, Integer> creatures = new EnumMap<>(CreatureType.class);

        for (var loc : locations) {
            loc.getLock().lock();
            try {
                for (var type : CreatureType.values()) {
                    creatures.merge(type, loc.getCreatureCount(type), Integer::sum);
                }
            } finally {
                loc.getLock().unlock();
            }
        }

        for (var type : CreatureType.values()) {
            System.out.printf("%s: %d, ", type.getEmoji(), creatures.get(type));
        }
        System.out.println();
    }
}
