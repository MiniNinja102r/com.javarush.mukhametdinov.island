package entity.predator;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Fox extends Predator {

    public Fox(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.FOX, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.FOX, CreatureField.SATURATION).doubleValue(),
                CreatureType.FOX
        );
    }
}
