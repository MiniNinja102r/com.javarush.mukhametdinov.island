package entity.predator;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Wolf extends Predator {

    public Wolf(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.WOLF, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.WOLF, CreatureField.SATURATION).doubleValue(),
                CreatureType.WOLF
        );
    }
}
