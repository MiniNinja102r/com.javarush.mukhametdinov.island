package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Buffalo extends Herbivore {

    public Buffalo(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.BUFFALO, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.BUFFALO, CreatureField.SATURATION).doubleValue(),
                CreatureType.BUFFALO
        );
    }
}
