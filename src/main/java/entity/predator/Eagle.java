package entity.predator;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Eagle extends Predator {

    public Eagle(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.EAGLE, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.EAGLE, CreatureField.SATURATION).doubleValue(),
                CreatureType.EAGLE
        );
    }
}
