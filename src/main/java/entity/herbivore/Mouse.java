package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Mouse extends Herbivore {

    public Mouse(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.MOUSE, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.MOUSE, CreatureField.SATURATION).doubleValue(),
                CreatureType.MOUSE
        );
    }
}
