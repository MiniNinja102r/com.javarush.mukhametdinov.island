package entity.herbivore;

import entity.AnimalType;
import entity.island.Location;

public final class Mouse extends Herbivore {

    public Mouse(Location location) {
        super(999, location, AnimalType.MOUSE);
    }
}
