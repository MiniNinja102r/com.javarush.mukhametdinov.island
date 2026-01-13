package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Sheep extends Herbivore {

    public Sheep(Location location) {
        super(999, location, CreatureType.SHEEP);
    }
}
