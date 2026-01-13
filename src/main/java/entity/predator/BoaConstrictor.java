package entity.predator;

import entity.CreatureType;
import entity.island.Location;

public final class BoaConstrictor extends Predator {

    public BoaConstrictor(Location location) {
        super(999, location, CreatureType.BOA_CONSTRICTOR);
    }
}
