package entity.herbivore;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Sheep extends Herbivore {

    public Sheep(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.SHEEP, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.SHEEP, CreatureField.SATURATION).doubleValue(),
                CreatureType.SHEEP
        );
    }
}
