package entity.herbivore;

import config.list.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class Boar extends Herbivore {

    public Boar(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.BOAR, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.BOAR, CreatureField.SATURATION).doubleValue(),
                CreatureType.BOAR
        );
    }
}
