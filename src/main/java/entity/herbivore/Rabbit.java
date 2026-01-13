package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Rabbit extends Herbivore {

    public Rabbit(Location location) {
        super(999, location, AnimalType.RABBIT);
    }
}
