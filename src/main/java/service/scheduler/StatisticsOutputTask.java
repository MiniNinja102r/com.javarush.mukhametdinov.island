package service.scheduler;

import entity.Animal;
import entity.AnimalType;
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
            final Map<Animal, Integer> animals = location.getAnimals();
            for (AnimalType type : AnimalType.values()) {
                for (var entry : animals.entrySet()) {
                    if (entry.getKey().getType() == type)
                        System.out.printf("%s: %d, ", type.getTitle(), entry.getValue());
                }
            }
        }
        System.out.printf("%n");
    }
}
