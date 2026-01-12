package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Horse extends Herbivore {

    public Horse(Location location) {
        super(999, location, AnimalType.HORSE);
    }
}
