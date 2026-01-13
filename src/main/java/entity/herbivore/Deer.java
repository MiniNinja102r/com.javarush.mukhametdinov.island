package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Deer extends Herbivore {

    public Deer(Location location) {
        super(999, location, AnimalType.DEER);
    }
}
