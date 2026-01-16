package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Deer extends Herbivore {

    public Deer(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.DEER, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.DEER, CreatureField.SATURATION).doubleValue(),
                CreatureType.DEER
        );
    }
}
