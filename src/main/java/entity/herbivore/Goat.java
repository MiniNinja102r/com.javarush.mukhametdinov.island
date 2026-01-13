package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Goat extends Herbivore {

    public Goat(Location location) {
        super(999, location, CreatureType.GOAT);
    }
}
