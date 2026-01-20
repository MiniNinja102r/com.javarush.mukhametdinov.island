package entity.herbivore;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Rabbit extends Herbivore {

    public Rabbit(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.RABBIT, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.RABBIT, CreatureField.SATURATION).doubleValue(),
                CreatureType.RABBIT
        );
    }
}
