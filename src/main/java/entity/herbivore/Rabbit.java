package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Rabbit extends Herbivore {

    public Rabbit(Location location) {
        super(999, location, CreatureType.RABBIT);
    }
}
