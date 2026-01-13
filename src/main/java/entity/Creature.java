package entity;

import entity.island.Location;

public interface Creature extends Eatable, CanDie {

    double weight();

    Location location();

    CreatureType type();
}
