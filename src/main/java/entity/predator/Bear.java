package entity.predator;

import entity.CreatureType;
import entity.island.Location;

public final class Bear extends Predator {

    public Bear(Location location) {
        super(999, location, CreatureType.BEAR);
    }
}
