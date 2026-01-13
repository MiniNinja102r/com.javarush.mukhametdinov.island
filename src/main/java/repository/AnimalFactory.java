package repository;

import entity.Animal;
import entity.AnimalType;
import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;
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
            case BOA_CONSTRICTOR -> new BoaConstrictor(loc);
            case FOX -> new Fox(loc);
            case BEAR -> new Bear(loc);
            case EAGLE -> new Eagle(loc);

            case HORSE -> new Horse(loc);
            case DEER -> new Deer(loc);
            case RABBIT -> new Rabbit(loc);
            case MOUSE -> new Mouse(loc);
            case GOAT -> new Goat(loc);
            case SHEEP -> new Sheep(loc);
            case BOAR -> new Boar(loc);
            case BUFFALO -> new Buffalo(loc);
            case DUCK -> new Duck(loc);
            case CATERPILLAR -> new Caterpillar(loc);
        };
    }
}
