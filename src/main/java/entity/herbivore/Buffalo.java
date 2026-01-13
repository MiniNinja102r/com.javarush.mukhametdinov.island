package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Buffalo extends Herbivore {

    public Buffalo(Location location) {
        super(999, location, AnimalType.BUFFALO);
    }
}
