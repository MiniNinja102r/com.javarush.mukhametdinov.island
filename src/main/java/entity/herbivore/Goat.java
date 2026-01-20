package entity.herbivore;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Goat extends Herbivore {

    public Goat(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.GOAT, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.GOAT, CreatureField.SATURATION).doubleValue(),
                CreatureType.GOAT
        );
    }
}
