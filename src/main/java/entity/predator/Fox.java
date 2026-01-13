package entity.predator;

import entity.CreatureType;
import entity.island.Location;

public final class Fox extends Predator {

    public Fox(Location location) {
        super(999, location, CreatureType.FOX);
    }
}
