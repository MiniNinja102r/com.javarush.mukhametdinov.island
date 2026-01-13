package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Horse extends Herbivore {

    public Horse(Location location) {
        super(999, location, CreatureType.HORSE);
    }
}
