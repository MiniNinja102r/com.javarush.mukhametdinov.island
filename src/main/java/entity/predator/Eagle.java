package entity.predator;

import entity.CreatureType;
import entity.island.Location;

public final class Eagle extends Predator {

    public Eagle(Location location) {
        super(999, location, CreatureType.EAGLE);
    }
}
