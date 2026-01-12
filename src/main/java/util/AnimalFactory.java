package util;

import entity.Animal;
import entity.AnimalType;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Wolf;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class AnimalFactory {

    private static final Island island = Island.getInstance();

    public static Animal createAnimal(AnimalType aType) {
        final Location loc = island.getRandomLocation();
        return switch (aType) {
            case WOLF -> new Wolf(loc);
        };
    }
}
