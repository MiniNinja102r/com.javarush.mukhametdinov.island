package entity.herbivore;

import entity.CreatureType;
import entity.island.Location;

public final class Mouse extends Herbivore {

    public Mouse(Location location) {
        super(999, location, CreatureType.MOUSE);
    }
}
