package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Duck extends Herbivore {

    public Duck(Location location) {
        super(999, location, AnimalType.DUCK);
    }
}
