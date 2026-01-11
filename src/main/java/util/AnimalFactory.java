package util;

import entity.Animal;
import entity.AnimalType;
import entity.predator.Wolf;

public final class AnimalFactory {

    public static Animal createAnimal(AnimalType aType) {
        return switch (aType) {
            case WOLF -> new Wolf();
        };
    }
}
