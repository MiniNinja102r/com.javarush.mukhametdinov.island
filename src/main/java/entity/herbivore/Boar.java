package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Boar extends Herbivore {

    public Boar(Location location) {
        super(999, location, CreatureType.BOAR);
    }
}
