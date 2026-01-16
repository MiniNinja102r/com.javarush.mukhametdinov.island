package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Horse extends Herbivore {

    public Horse(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.HORSE, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.HORSE, CreatureField.SATURATION).doubleValue(),
                CreatureType.HORSE
        );
    }
}
