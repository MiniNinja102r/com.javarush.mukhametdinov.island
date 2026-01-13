package entity;

import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Plant implements Creature {

    final double weight;

    final Location location;

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public void die(DeadReason reason) {
    }
}
