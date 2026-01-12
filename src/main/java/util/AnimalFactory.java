package util;

import entity.Animal;
import entity.AnimalType;
import entity.herbivore.Horse;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Wolf;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class AnimalFactory {

    private static final Island island = Island.getInstance();

    public static Animal createAnimal(AnimalType aType) {
        final Location loc = island.getRandomLocation();
        final Animal animal = getAnimal(aType, loc);
        loc.addAnimal(animal);

        return animal;
    }

    private static Animal getAnimal(AnimalType aType, Location loc) {
        return switch (aType) {
            case WOLF -> new Wolf(loc);

            case HORSE -> new Horse(loc);
        };
    }
}
