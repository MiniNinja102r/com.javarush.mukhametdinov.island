package entity.predator;

import entity.AnimalType;
import entity.island.Location;

public final class Eagle extends Predator {

    public Eagle(Location location) {
        super(999, location, AnimalType.EAGLE);
    }
}
