package entity.predator;

import entity.AnimalType;
import entity.island.Location;

public final class BoaConstrictor extends Predator {

    public BoaConstrictor(Location location) {
        super(999, location, AnimalType.BOA_CONSTRICTOR);
    }
}
