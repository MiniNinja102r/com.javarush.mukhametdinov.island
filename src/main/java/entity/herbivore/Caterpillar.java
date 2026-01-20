package entity.herbivore;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Caterpillar extends Herbivore {

    public Caterpillar(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.CATERPILLAR, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.CATERPILLAR, CreatureField.SATURATION).doubleValue(),
                CreatureType.CATERPILLAR
        );
    }
}
