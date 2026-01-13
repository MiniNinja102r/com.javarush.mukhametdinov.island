package entity;

import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Plant implements Creature {

    final Location location;

    @Override
    public double weight() {
        return 1; // ВЗЯТЬ ИЗ КОНФИГА
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public void die(DeadReason reason) {
    }

    @Override
    public CreatureType type() {
        return CreatureType.PLANT;
    }
}
