package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Caterpillar extends Herbivore {

    public Caterpillar(Location location) {
        super(999, location, AnimalType.CATERPILLAR);
    }
}
