package entity.predator;

import entity.AnimalType;
import entity.island.Location;

public final class Wolf extends Predator {

    public Wolf(Location location) {
        super(999, location, AnimalType.WOLF);
    }
}
