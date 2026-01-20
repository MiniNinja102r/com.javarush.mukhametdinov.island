package entity.predator;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Bear extends Predator {

    public Bear(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.BEAR, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.BEAR, CreatureField.SATURATION).doubleValue(),
                CreatureType.BEAR
        );
    }
}
