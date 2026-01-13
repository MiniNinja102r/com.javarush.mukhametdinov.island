package entity.predator;

import entity.CreatureType;
import entity.island.Location;

public final class Wolf extends Predator {

    public Wolf(Location location) {
        super(999, location, CreatureType.WOLF);
    }
}
