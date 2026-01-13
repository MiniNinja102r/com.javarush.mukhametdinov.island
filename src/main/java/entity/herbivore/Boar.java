package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Boar extends Herbivore {

    public Boar(Location location) {
        super(999, location, AnimalType.BOAR);
    }
}
