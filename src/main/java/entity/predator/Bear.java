package entity.predator;

import entity.AnimalType;
import entity.island.Location;

public final class Bear extends Predator {

    public Bear(Location location) {
        super(999, location, AnimalType.BEAR);
    }
}
