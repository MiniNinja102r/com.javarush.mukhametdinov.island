package entity.predator;

import config.values.CreatureConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Location;

public final class BoaConstrictor extends Predator {

    public BoaConstrictor(Location location) {
        super(CreatureConfig.Creature.get(CreatureType.BOA_CONSTRICTOR, CreatureField.WEIGHT).doubleValue(),
                location,
                CreatureConfig.Creature.get(CreatureType.BOA_CONSTRICTOR, CreatureField.SATURATION).doubleValue(),
                CreatureType.BOA_CONSTRICTOR
        );
    }
}
