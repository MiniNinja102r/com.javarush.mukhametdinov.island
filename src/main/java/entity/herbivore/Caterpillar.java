package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Caterpillar extends Herbivore {

    public Caterpillar(Location location) {
        super(999, location, CreatureType.CATERPILLAR);
    }
}
