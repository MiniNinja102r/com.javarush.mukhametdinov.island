package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Duck extends Herbivore {

    public Duck(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.DUCK, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.DUCK, CreatureField.SATURATION).doubleValue(),
                CreatureType.DUCK
        );
    }
}
